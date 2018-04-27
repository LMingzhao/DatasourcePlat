/**   
 * 
 * @Title: JDBCUtils.java 
 * @Prject: springboot-dao
 * @Package: com.bimoom.springboot.dao.jdbc 
 * @author: Lmz
 * @date: 2017年12月13日 上午10:09:00 
 * @version: V1.0   
 */
package com.dsplat.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;

/** 
 *
 * @ClassName: JDBCUtils 
 * @author: Lmz
 * @date: 2017年12月13日 上午10:09:00  
 */
public class JdbcUtils {

	 /**
     * 新增，修改，删除 数据
     * 
     * @param sourceKey
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static int updateByPreparedStatement(String sourceKey, String sql, List<Object> params) {
        DataSource source = JdbcFactory.getDataSource(sourceKey);//通过数据连接池标识sourceKey，从缓存里获得一个数据连接池
        Connection connection = JdbcFactory.getConnection(source);//从数据连接池里获得数据库连接
        int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            int index = 1;
            // 填充sql语句中的占位符
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(index++, params.get(i));
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseConn(null, pstmt, connection);//用完后，执行此操作回收连接
        }
        return result;
    }

    /**
     * 查询单条记录
     * 
     * @param sourceKey
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static JSONObject findSimpleResult(String sourceKey, String sql, List<Object> params) {
        DataSource source = JdbcFactory.getDataSource(sourceKey);
        Connection connection = JdbcFactory.getConnection(source);
        JSONObject json = null;
        int index = 1;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            pstmt = connection.prepareStatement(sql);
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(index++, params.get(i));
                }
            }
            resultSet = pstmt.executeQuery();// 返回查询结果
            // 获取此 ResultSet 对象的列的编号、类型和属性。
            ResultSetMetaData metaData = resultSet.getMetaData();
            int col_len = metaData.getColumnCount();// 获取列的长度
            String cols_name;
            Object cols_value;
            if (resultSet.next())// 获得列的名称
            {
                json = new JSONObject();
                for (int i = 0; i < col_len; i++) {
                    cols_name = metaData.getColumnLabel(i + 1);
                    cols_value = resultSet.getObject(cols_name);
                    if (cols_value == null)// 列的值没有时，设置列值为“”
                    {
                        cols_value = "";
                    }
                    json.put(cols_name, cols_value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseConn(resultSet, pstmt, connection);
        }
        return json;
    }

    /**
     * 查询记录列表
     * 
     * @param sourceKey
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static JSONArray findMoreResult(String sourceKey, String sql, List<Object> params) {
        DataSource source = JdbcFactory.getDataSource(sourceKey);
        Connection connection = JdbcFactory.getConnection(source);
        JSONArray list = new JSONArray();
        int index = 1;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            pstmt = connection.prepareStatement(sql);
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(index++, params.get(i));
                }
            }
            resultSet = pstmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int cols_len = metaData.getColumnCount();
            String cols_name;
            Object cols_value;
            while (resultSet.next()) {
                JSONObject json = new JSONObject();
                for (int i = 0; i < cols_len; i++) {
                    cols_name = metaData.getColumnLabel(i + 1);
                    cols_value = resultSet.getObject(cols_name);
                    if (cols_value == null) {
                        cols_value = "";
                    }
                    json.put(cols_name, cols_value);
                }
                list.put(json);
                //list.add(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseConn(resultSet, pstmt, connection);
        }
        return list;
    }

    /**
    * 通过count(1)获取记录总数 
    * 写法： select count(1) from tabl_name;
     *     select count(1) from tabl_nameA a left join tabl_nameB b on a.rowid=b.rowid;
    * @param sourceKey
    * @param sql
    * @param params
    * @return
    * @throws SQLException
    */
    public static long getCount(String sourceKey, String sql, List<Object> params) {

        DataSource source = JdbcFactory.getDataSource(sourceKey);
        Connection connection = JdbcFactory.getConnection(source);
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        long count = 0L;
        try {
            pstmt = connection.prepareStatement(sql);
            int index = 1;
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(index++, params.get(i));
                }
            }
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseConn(resultSet, pstmt, connection);
        }
        return count;
    }

    /**
     * 回收链接
     * 
     * @param resultSet
     * @param pstmt
     * @param source
     */
    public static void releaseConn(ResultSet resultSet, PreparedStatement pstmt,
                                   Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 测试
     * 
     * @param args
     *//*
    public static void main(String[] args) {
        List<JDBCConfig> mapList = new ArrayList<JDBCConfig>();
        JDBCConfig jdbcConfig = new JDBCConfig();
        jdbcConfig.setId(1);
        jdbcConfig.setConnectUrl("jdbc:mysql://10.1.21.3:3306/dbinc?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull");
		jdbcConfig.setUsername("insurance");
		jdbcConfig.setPassword("bGDdW8yyuLD0");
		jdbcConfig.setDataSourceKey("dbinc");
		mapList.add(jdbcConfig);
        List<Object> params = new ArrayList<Object>();
        params.add("testName");
        params.add(1);
    	JDBCFactory.initDataSource(mapList);
        String sql = "select * from cms_user limit 1,10";
        String dbSourceKey = "dbinc";
        *//**
         * 调用jdbc工具类执行sql
         *//*
        JSONArray result = JDBCUtils.findMoreResult(dbSourceKey, sql, null);
        System.out.println(result.toString());
        //JDBCUtils.updateByPreparedStatement(dbSourceKey, sql.toString(), null);
    }*/
}
