package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianlitoudiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianlitoudiView;


/**
 * 简历投递
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface JianlitoudiService extends IService<JianlitoudiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianlitoudiView> selectListView(Wrapper<JianlitoudiEntity> wrapper);
   	
   	JianlitoudiView selectView(@Param("ew") Wrapper<JianlitoudiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianlitoudiEntity> wrapper);
   	
   
}

