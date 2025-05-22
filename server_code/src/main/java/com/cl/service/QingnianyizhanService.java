package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QingnianyizhanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QingnianyizhanView;


/**
 * 青年驿站
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
public interface QingnianyizhanService extends IService<QingnianyizhanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QingnianyizhanView> selectListView(Wrapper<QingnianyizhanEntity> wrapper);
   	
   	QingnianyizhanView selectView(@Param("ew") Wrapper<QingnianyizhanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QingnianyizhanEntity> wrapper);
   	
   
}

