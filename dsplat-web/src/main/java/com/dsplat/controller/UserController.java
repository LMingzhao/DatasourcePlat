package com.dsplat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.dao.dbinc.CmsUserPOMapper;
import com.common.dao.dbinc.mybatis.CmsUserPO;
import com.dsplat.vo.reqVO.ReqVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户模块
 * @ClassName: UserController 
 * @author: Lmz
 * @date: 2018年1月4日 下午2:22:16
 */
@RestController
public class UserController {
	
	@Autowired
	private CmsUserPOMapper cmsUserPOMapper;

	@RequestMapping(value = "/datasource",method = RequestMethod.POST)
	public PageInfo<CmsUserPO> getHelloWorld(@RequestBody ReqVO req){
		Integer page = req.getPage() == null ? 1 : req.getPage();
		Integer rows = req.getRows() == null ? 10 : req.getRows();
		PageHelper.startPage(page, rows);
		List<CmsUserPO> users = this.cmsUserPOMapper.selectByExample(null);
		PageInfo<CmsUserPO> pageInfo = new PageInfo<CmsUserPO>(users);
		return pageInfo;
	}
}
