package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.LikaishangbaoEntity;
import com.cl.entity.view.LikaishangbaoView;

import com.cl.service.LikaishangbaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 离开上报
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
@RestController
@RequestMapping("/likaishangbao")
public class LikaishangbaoController {
    @Autowired
    private LikaishangbaoService likaishangbaoService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LikaishangbaoEntity likaishangbao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			likaishangbao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LikaishangbaoEntity> ew = new EntityWrapper<LikaishangbaoEntity>();

		PageUtils page = likaishangbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, likaishangbao), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LikaishangbaoEntity likaishangbao, 
		HttpServletRequest request){
        EntityWrapper<LikaishangbaoEntity> ew = new EntityWrapper<LikaishangbaoEntity>();

		PageUtils page = likaishangbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, likaishangbao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LikaishangbaoEntity likaishangbao){
       	EntityWrapper<LikaishangbaoEntity> ew = new EntityWrapper<LikaishangbaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( likaishangbao, "likaishangbao")); 
        return R.ok().put("data", likaishangbaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LikaishangbaoEntity likaishangbao){
        EntityWrapper< LikaishangbaoEntity> ew = new EntityWrapper< LikaishangbaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( likaishangbao, "likaishangbao")); 
		LikaishangbaoView likaishangbaoView =  likaishangbaoService.selectView(ew);
		return R.ok("查询离开上报成功").put("data", likaishangbaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LikaishangbaoEntity likaishangbao = likaishangbaoService.selectById(id);
		likaishangbao = likaishangbaoService.selectView(new EntityWrapper<LikaishangbaoEntity>().eq("id", id));
        return R.ok().put("data", likaishangbao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LikaishangbaoEntity likaishangbao = likaishangbaoService.selectById(id);
		likaishangbao = likaishangbaoService.selectView(new EntityWrapper<LikaishangbaoEntity>().eq("id", id));
        return R.ok().put("data", likaishangbao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LikaishangbaoEntity likaishangbao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(likaishangbao);
        likaishangbaoService.insert(likaishangbao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LikaishangbaoEntity likaishangbao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(likaishangbao);
        likaishangbaoService.insert(likaishangbao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LikaishangbaoEntity likaishangbao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(likaishangbao);
        likaishangbaoService.updateById(likaishangbao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        likaishangbaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
