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


import com.cl.dao.ShenqingruzhuDao;
import com.cl.entity.ShenqingruzhuEntity;
import com.cl.service.ShenqingruzhuService;
import com.cl.entity.view.ShenqingruzhuView;

@Service("shenqingruzhuService")
public class ShenqingruzhuServiceImpl extends ServiceImpl<ShenqingruzhuDao, ShenqingruzhuEntity> implements ShenqingruzhuService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingruzhuEntity> page = this.selectPage(
                new Query<ShenqingruzhuEntity>(params).getPage(),
                new EntityWrapper<ShenqingruzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingruzhuEntity> wrapper) {
		  Page<ShenqingruzhuView> page =new Query<ShenqingruzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShenqingruzhuView> selectListView(Wrapper<ShenqingruzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingruzhuView selectView(Wrapper<ShenqingruzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
