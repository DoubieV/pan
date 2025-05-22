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


import com.cl.dao.LikaishangbaoDao;
import com.cl.entity.LikaishangbaoEntity;
import com.cl.service.LikaishangbaoService;
import com.cl.entity.view.LikaishangbaoView;

@Service("likaishangbaoService")
public class LikaishangbaoServiceImpl extends ServiceImpl<LikaishangbaoDao, LikaishangbaoEntity> implements LikaishangbaoService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LikaishangbaoEntity> page = this.selectPage(
                new Query<LikaishangbaoEntity>(params).getPage(),
                new EntityWrapper<LikaishangbaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LikaishangbaoEntity> wrapper) {
		  Page<LikaishangbaoView> page =new Query<LikaishangbaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LikaishangbaoView> selectListView(Wrapper<LikaishangbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LikaishangbaoView selectView(Wrapper<LikaishangbaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
