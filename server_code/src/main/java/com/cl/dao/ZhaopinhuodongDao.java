package com.cl.dao;

import com.cl.entity.ZhaopinhuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaopinhuodongView;


/**
 * 招聘活动
 * 
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface ZhaopinhuodongDao extends BaseMapper<ZhaopinhuodongEntity> {
	
	List<ZhaopinhuodongView> selectListView(@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);

	List<ZhaopinhuodongView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);
	
	ZhaopinhuodongView selectView(@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhaopinhuodongEntity> wrapper);



}
