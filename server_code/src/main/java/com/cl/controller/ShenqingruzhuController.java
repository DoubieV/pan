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

import com.cl.entity.ShenqingruzhuEntity;
import com.cl.entity.view.ShenqingruzhuView;

import com.cl.service.ShenqingruzhuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 申请入住
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
@RestController
@RequestMapping("/shenqingruzhu")
public class ShenqingruzhuController {
    @Autowired
    private ShenqingruzhuService shenqingruzhuService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingruzhuEntity shenqingruzhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shenqingruzhu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingruzhuEntity> ew = new EntityWrapper<ShenqingruzhuEntity>();

		PageUtils page = shenqingruzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingruzhu), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingruzhuEntity shenqingruzhu, 
		HttpServletRequest request){
        EntityWrapper<ShenqingruzhuEntity> ew = new EntityWrapper<ShenqingruzhuEntity>();

		PageUtils page = shenqingruzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingruzhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingruzhuEntity shenqingruzhu){
       	EntityWrapper<ShenqingruzhuEntity> ew = new EntityWrapper<ShenqingruzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingruzhu, "shenqingruzhu")); 
        return R.ok().put("data", shenqingruzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingruzhuEntity shenqingruzhu){
        EntityWrapper< ShenqingruzhuEntity> ew = new EntityWrapper< ShenqingruzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingruzhu, "shenqingruzhu")); 
		ShenqingruzhuView shenqingruzhuView =  shenqingruzhuService.selectView(ew);
		return R.ok("查询申请入住成功").put("data", shenqingruzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingruzhuEntity shenqingruzhu = shenqingruzhuService.selectById(id);
		shenqingruzhu = shenqingruzhuService.selectView(new EntityWrapper<ShenqingruzhuEntity>().eq("id", id));
        return R.ok().put("data", shenqingruzhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingruzhuEntity shenqingruzhu = shenqingruzhuService.selectById(id);
		shenqingruzhu = shenqingruzhuService.selectView(new EntityWrapper<ShenqingruzhuEntity>().eq("id", id));
        return R.ok().put("data", shenqingruzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingruzhuEntity shenqingruzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingruzhu);
        shenqingruzhuService.insert(shenqingruzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingruzhuEntity shenqingruzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingruzhu);
        shenqingruzhuService.insert(shenqingruzhu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenqingruzhuEntity shenqingruzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingruzhu);
        shenqingruzhuService.updateById(shenqingruzhu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenqingruzhuEntity> list = new ArrayList<ShenqingruzhuEntity>();
        for(Long id : ids) {
            ShenqingruzhuEntity shenqingruzhu = shenqingruzhuService.selectById(id);
            shenqingruzhu.setSfsh(sfsh);
            shenqingruzhu.setShhf(shhf);
            list.add(shenqingruzhu);
        }
        shenqingruzhuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenqingruzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
