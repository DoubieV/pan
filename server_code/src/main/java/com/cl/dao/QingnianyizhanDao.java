package com.cl.dao;

import com.cl.entity.QingnianyizhanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QingnianyizhanView;


/**
 * 青年驿站
 * 
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
public interface QingnianyizhanDao extends BaseMapper<QingnianyizhanEntity> {
	
	List<QingnianyizhanView> selectListView(@Param("ew") Wrapper<QingnianyizhanEntity> wrapper);

	List<QingnianyizhanView> selectListView(Pagination page,@Param("ew") Wrapper<QingnianyizhanEntity> wrapper);
	
	QingnianyizhanView selectView(@Param("ew") Wrapper<QingnianyizhanEntity> wrapper);


}
