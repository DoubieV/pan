package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuodongbaomingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongbaomingView;


/**
 * 活动报名
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface HuodongbaomingService extends IService<HuodongbaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongbaomingView> selectListView(Wrapper<HuodongbaomingEntity> wrapper);
   	
   	HuodongbaomingView selectView(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongbaomingEntity> wrapper);
   	
   
}

