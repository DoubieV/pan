package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LikaishangbaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LikaishangbaoView;


/**
 * 离开上报
 *
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface LikaishangbaoService extends IService<LikaishangbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LikaishangbaoView> selectListView(Wrapper<LikaishangbaoEntity> wrapper);
   	
   	LikaishangbaoView selectView(@Param("ew") Wrapper<LikaishangbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LikaishangbaoEntity> wrapper);
   	
   
}

