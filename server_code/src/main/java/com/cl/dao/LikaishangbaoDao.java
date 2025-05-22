package com.cl.dao;

import com.cl.entity.LikaishangbaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LikaishangbaoView;


/**
 * 离开上报
 * 
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
public interface LikaishangbaoDao extends BaseMapper<LikaishangbaoEntity> {
	
	List<LikaishangbaoView> selectListView(@Param("ew") Wrapper<LikaishangbaoEntity> wrapper);

	List<LikaishangbaoView> selectListView(Pagination page,@Param("ew") Wrapper<LikaishangbaoEntity> wrapper);
	
	LikaishangbaoView selectView(@Param("ew") Wrapper<LikaishangbaoEntity> wrapper);


}
