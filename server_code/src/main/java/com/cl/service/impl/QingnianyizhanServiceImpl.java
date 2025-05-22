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


import com.cl.dao.QingnianyizhanDao;
import com.cl.entity.QingnianyizhanEntity;
import com.cl.service.QingnianyizhanService;
import com.cl.entity.view.QingnianyizhanView;

@Service("qingnianyizhanService")
public class QingnianyizhanServiceImpl extends ServiceImpl<QingnianyizhanDao, QingnianyizhanEntity> implements QingnianyizhanService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QingnianyizhanEntity> page = this.selectPage(
                new Query<QingnianyizhanEntity>(params).getPage(),
                new EntityWrapper<QingnianyizhanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QingnianyizhanEntity> wrapper) {
		  Page<QingnianyizhanView> page =new Query<QingnianyizhanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QingnianyizhanView> selectListView(Wrapper<QingnianyizhanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QingnianyizhanView selectView(Wrapper<QingnianyizhanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
