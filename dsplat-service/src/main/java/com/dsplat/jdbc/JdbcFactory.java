/**   
 * 
 * @Title: JDBCFactory.java 
 * @Prject: springboot-dao
 * @Package: com.bimoom.springboot.dao.jdbc 
 * @author: Lmz
 * @date: 2017年12月11日 上午10:46:48 
 * @version: V1.0   
 */
package com.dsplat.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/** 
 * JDBC工厂
 * @ClassName: JDBCFactory 
 * @author: Lmz
 * @date: 2017年12月11日 上午10:46:48  
 */
public class JdbcFactory {
	private static ConcurrentHashMap<String, DataSource> map = new ConcurrentHashMap<String, DataSource>();

    /**
    * 根据jdbc参数获得数据源连接池dbcp，并放入ConcurrentHashMap
    * 
    * @param param
    */
    public static void initDataSource(List<JdbcConfig> mapList) {
        BasicDataSource ds = null;
        for (JdbcConfig config : mapList) {
            ds = new BasicDataSource();
            ds.setDriverClassName(config.getDriverClass().trim());
            ds.setUsername(config.getUsername().trim());
            ds.setPassword(config.getPassword().trim());
            ds.setUrl(config.getConnectUrl().trim());
            ds.setInitialSize(config.getInitialSize());
            ds.setMaxActive(config.getMaxActive());
            ds.setMaxIdle(config.getMaxIdle());
            ds.setMaxWait(config.getMaxWait());
            ds.setValidationQuery("select 1");//检查链接是否有效
            DataSource DS = ds;
            map.put(config.getDataSourceKey().trim(), DS);
        }

    }

    /**
     * 插入数据源连接池到缓存
     * 
     * @param config
     */
    public static void saveDataSource(JdbcConfig config) {
        if (config != null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(config.getDriverClass().trim());
            ds.setUsername(config.getUsername().trim());
            ds.setPassword(config.getPassword().trim());
            ds.setUrl(config.getConnectUrl().trim());
            ds.setInitialSize(config.getInitialSize());
            ds.setMaxActive(config.getMaxActive());
            ds.setMaxIdle(config.getMaxIdle());
            ds.setMaxWait(config.getMaxWait());
            ds.setValidationQuery("select 1");//检查链接是否有效
            DataSource DS = ds;
            map.put(config.getDataSourceKey().trim(), DS);
        }
    }

    /**
     * 从缓存里删除指定的数据源连接池
     * 
     * @param sourceKey
     * @throws Exception
     */
    public static void removeDataSource(String sourceKey) throws Exception {
        DataSource DS = map.get(sourceKey.trim());
        shutdownDataSource(DS);//先关闭
        map.remove(sourceKey.trim());
    }

    /**
     * 修改数据源连接池到缓存
     * 
     * @param config
     */
    public static void updateDataSource(JdbcConfig config) throws Exception {
        if (config != null) {
            removeDataSource(config.getDataSourceKey());//先将原有数据源连接池从缓存中删除
            /**
             * 重新新增
             */
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(config.getDriverClass().trim());
            ds.setUsername(config.getUsername().trim());
            ds.setPassword(config.getPassword().trim());
            ds.setUrl(config.getConnectUrl().trim());
            ds.setInitialSize(config.getInitialSize());
            ds.setMaxActive(config.getMaxActive());
            ds.setMaxIdle(config.getMaxIdle());
            ds.setMaxWait(config.getMaxWait());
            ds.setValidationQuery("select 1");//检查链接是否有效
            DataSource DS = ds;
            map.put(config.getDataSourceKey().trim(), DS);
        }
    }

    /**
     * 获得dbcp连接池
     * 
     * @param sourceKey
     * @return
     */
    public static DataSource getDataSource(String sourceKey) {
        DataSource DS = map.get(sourceKey.trim());
        return DS;
    }

    /**
     * 获得一个数据库连接  ，从dbcp连接池
     * 
     * @param source
     * @return
     */
    public static Connection getConnection(DataSource source) {
        Connection con = null;
        if (source != null) {
            try {
                con = source.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return con;
        }
        //回收数据库连接时，直接使用con.close()即可  
        return con;
    }
    /**
    * 
    * 
    * @param source
    * @throws SQLException
    */
    protected static void shutdownDataSource(DataSource source) throws SQLException {
        if (source != null) {
            BasicDataSource bds = (BasicDataSource) source;
            bds.close();//这个close其实是回收，并不是真正的关闭了connction链接
        }
    }
}
