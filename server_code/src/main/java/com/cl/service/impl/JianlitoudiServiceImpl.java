package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JianlitoudiDao;
import com.cl.entity.JianlitoudiEntity;
import com.cl.service.JianlitoudiService;
import com.cl.entity.view.JianlitoudiView;

@Service("jianlitoudiService")
public class JianlitoudiServiceImpl extends ServiceImpl<JianlitoudiDao, JianlitoudiEntity> implements JianlitoudiService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianlitoudiEntity> page = this.selectPage(
                new Query<JianlitoudiEntity>(params).getPage(),
                new EntityWrapper<JianlitoudiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianlitoudiEntity> wrapper) {
		  Page<JianlitoudiView> page =new Query<JianlitoudiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianlitoudiView> selectListView(Wrapper<JianlitoudiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianlitoudiView selectView(Wrapper<JianlitoudiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
