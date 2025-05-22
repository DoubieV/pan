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

import com.cl.entity.DiscussqingnianyizhanEntity;
import com.cl.entity.view.DiscussqingnianyizhanView;

import com.cl.service.DiscussqingnianyizhanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 青年驿站评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
@RestController
@RequestMapping("/discussqingnianyizhan")
public class DiscussqingnianyizhanController {
    @Autowired
    private DiscussqingnianyizhanService discussqingnianyizhanService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussqingnianyizhanEntity discussqingnianyizhan,
		HttpServletRequest request){
        EntityWrapper<DiscussqingnianyizhanEntity> ew = new EntityWrapper<DiscussqingnianyizhanEntity>();

		PageUtils page = discussqingnianyizhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqingnianyizhan), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussqingnianyizhanEntity discussqingnianyizhan, 
		HttpServletRequest request){
        EntityWrapper<DiscussqingnianyizhanEntity> ew = new EntityWrapper<DiscussqingnianyizhanEntity>();

		PageUtils page = discussqingnianyizhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqingnianyizhan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussqingnianyizhanEntity discussqingnianyizhan){
       	EntityWrapper<DiscussqingnianyizhanEntity> ew = new EntityWrapper<DiscussqingnianyizhanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussqingnianyizhan, "discussqingnianyizhan")); 
        return R.ok().put("data", discussqingnianyizhanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussqingnianyizhanEntity discussqingnianyizhan){
        EntityWrapper< DiscussqingnianyizhanEntity> ew = new EntityWrapper< DiscussqingnianyizhanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussqingnianyizhan, "discussqingnianyizhan")); 
		DiscussqingnianyizhanView discussqingnianyizhanView =  discussqingnianyizhanService.selectView(ew);
		return R.ok("查询青年驿站评论表成功").put("data", discussqingnianyizhanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussqingnianyizhanEntity discussqingnianyizhan = discussqingnianyizhanService.selectById(id);
		discussqingnianyizhan = discussqingnianyizhanService.selectView(new EntityWrapper<DiscussqingnianyizhanEntity>().eq("id", id));
        return R.ok().put("data", discussqingnianyizhan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussqingnianyizhanEntity discussqingnianyizhan = discussqingnianyizhanService.selectById(id);
		discussqingnianyizhan = discussqingnianyizhanService.selectView(new EntityWrapper<DiscussqingnianyizhanEntity>().eq("id", id));
        return R.ok().put("data", discussqingnianyizhan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussqingnianyizhanEntity discussqingnianyizhan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussqingnianyizhan);
        discussqingnianyizhanService.insert(discussqingnianyizhan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussqingnianyizhanEntity discussqingnianyizhan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussqingnianyizhan);
        discussqingnianyizhanService.insert(discussqingnianyizhan);
        return R.ok();
    }

     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussqingnianyizhanEntity discussqingnianyizhan = discussqingnianyizhanService.selectOne(new EntityWrapper<DiscussqingnianyizhanEntity>().eq("", username));
        return R.ok().put("data", discussqingnianyizhan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussqingnianyizhanEntity discussqingnianyizhan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussqingnianyizhan);
        discussqingnianyizhanService.updateById(discussqingnianyizhan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussqingnianyizhanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussqingnianyizhanEntity discussqingnianyizhan, HttpServletRequest request,String pre){
        EntityWrapper<DiscussqingnianyizhanEntity> ew = new EntityWrapper<DiscussqingnianyizhanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussqingnianyizhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqingnianyizhan), params), params));
        return R.ok().put("data", page);
    }









}
