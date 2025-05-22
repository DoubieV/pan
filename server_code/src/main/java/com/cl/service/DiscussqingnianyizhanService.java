package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussqingnianyizhanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussqingnianyizhanView;


/**
 * 青年驿站评论表
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface DiscussqingnianyizhanService extends IService<DiscussqingnianyizhanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqingnianyizhanView> selectListView(Wrapper<DiscussqingnianyizhanEntity> wrapper);
   	
   	DiscussqingnianyizhanView selectView(@Param("ew") Wrapper<DiscussqingnianyizhanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqingnianyizhanEntity> wrapper);
   	
   
}

