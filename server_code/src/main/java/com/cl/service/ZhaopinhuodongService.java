package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaopinhuodongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaopinhuodongView;


/**
 * 招聘活动
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface ZhaopinhuodongService extends IService<ZhaopinhuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaopinhuodongView> selectListView(Wrapper<ZhaopinhuodongEntity> wrapper);
   	
   	ZhaopinhuodongView selectView(@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaopinhuodongEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhaopinhuodongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhaopinhuodongEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhaopinhuodongEntity> wrapper);



}

