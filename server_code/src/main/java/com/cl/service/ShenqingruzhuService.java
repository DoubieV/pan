package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenqingruzhuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingruzhuView;


/**
 * 申请入住
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
public interface ShenqingruzhuService extends IService<ShenqingruzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingruzhuView> selectListView(Wrapper<ShenqingruzhuEntity> wrapper);
   	
   	ShenqingruzhuView selectView(@Param("ew") Wrapper<ShenqingruzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingruzhuEntity> wrapper);
   	
   
}

