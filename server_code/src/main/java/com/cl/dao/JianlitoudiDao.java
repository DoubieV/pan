package com.cl.dao;

import com.cl.entity.JianlitoudiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianlitoudiView;


/**
 * 简历投递
 * 
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface JianlitoudiDao extends BaseMapper<JianlitoudiEntity> {
	
	List<JianlitoudiView> selectListView(@Param("ew") Wrapper<JianlitoudiEntity> wrapper);

	List<JianlitoudiView> selectListView(Pagination page,@Param("ew") Wrapper<JianlitoudiEntity> wrapper);
	
	JianlitoudiView selectView(@Param("ew") Wrapper<JianlitoudiEntity> wrapper);


}
