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


import com.cl.dao.ZhaopinhuodongDao;
import com.cl.entity.ZhaopinhuodongEntity;
import com.cl.service.ZhaopinhuodongService;
import com.cl.entity.view.ZhaopinhuodongView;

@Service("zhaopinhuodongService")
public class ZhaopinhuodongServiceImpl extends ServiceImpl<ZhaopinhuodongDao, ZhaopinhuodongEntity> implements ZhaopinhuodongService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaopinhuodongEntity> page = this.selectPage(
                new Query<ZhaopinhuodongEntity>(params).getPage(),
                new EntityWrapper<ZhaopinhuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaopinhuodongEntity> wrapper) {
		  Page<ZhaopinhuodongView> page =new Query<ZhaopinhuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhaopinhuodongView> selectListView(Wrapper<ZhaopinhuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaopinhuodongView selectView(Wrapper<ZhaopinhuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ZhaopinhuodongEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ZhaopinhuodongEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ZhaopinhuodongEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
