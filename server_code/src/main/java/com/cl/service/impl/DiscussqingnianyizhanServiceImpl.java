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


import com.cl.dao.DiscussqingnianyizhanDao;
import com.cl.entity.DiscussqingnianyizhanEntity;
import com.cl.service.DiscussqingnianyizhanService;
import com.cl.entity.view.DiscussqingnianyizhanView;

@Service("discussqingnianyizhanService")
public class DiscussqingnianyizhanServiceImpl extends ServiceImpl<DiscussqingnianyizhanDao, DiscussqingnianyizhanEntity> implements DiscussqingnianyizhanService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqingnianyizhanEntity> page = this.selectPage(
                new Query<DiscussqingnianyizhanEntity>(params).getPage(),
                new EntityWrapper<DiscussqingnianyizhanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqingnianyizhanEntity> wrapper) {
		  Page<DiscussqingnianyizhanView> page =new Query<DiscussqingnianyizhanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussqingnianyizhanView> selectListView(Wrapper<DiscussqingnianyizhanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqingnianyizhanView selectView(Wrapper<DiscussqingnianyizhanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
