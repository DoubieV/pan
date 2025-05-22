package com.cl.dao;

import com.cl.entity.DiscussqingnianyizhanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussqingnianyizhanView;


/**
 * 青年驿站评论表
 * 
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface DiscussqingnianyizhanDao extends BaseMapper<DiscussqingnianyizhanEntity> {
	
	List<DiscussqingnianyizhanView> selectListView(@Param("ew") Wrapper<DiscussqingnianyizhanEntity> wrapper);

	List<DiscussqingnianyizhanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqingnianyizhanEntity> wrapper);
	
	DiscussqingnianyizhanView selectView(@Param("ew") Wrapper<DiscussqingnianyizhanEntity> wrapper);


}
