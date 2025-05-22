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

import com.cl.entity.JianlitoudiEntity;
import com.cl.entity.view.JianlitoudiView;

import com.cl.service.JianlitoudiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 简历投递
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
@RestController
@RequestMapping("/jianlitoudi")
public class JianlitoudiController {
    @Autowired
    private JianlitoudiService jianlitoudiService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianlitoudiEntity jianlitoudi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			jianlitoudi.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			jianlitoudi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianlitoudiEntity> ew = new EntityWrapper<JianlitoudiEntity>();

		PageUtils page = jianlitoudiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlitoudi), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianlitoudiEntity jianlitoudi, 
		HttpServletRequest request){
        EntityWrapper<JianlitoudiEntity> ew = new EntityWrapper<JianlitoudiEntity>();

		PageUtils page = jianlitoudiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlitoudi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianlitoudiEntity jianlitoudi){
       	EntityWrapper<JianlitoudiEntity> ew = new EntityWrapper<JianlitoudiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianlitoudi, "jianlitoudi")); 
        return R.ok().put("data", jianlitoudiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianlitoudiEntity jianlitoudi){
        EntityWrapper< JianlitoudiEntity> ew = new EntityWrapper< JianlitoudiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianlitoudi, "jianlitoudi")); 
		JianlitoudiView jianlitoudiView =  jianlitoudiService.selectView(ew);
		return R.ok("查询简历投递成功").put("data", jianlitoudiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianlitoudiEntity jianlitoudi = jianlitoudiService.selectById(id);
		jianlitoudi = jianlitoudiService.selectView(new EntityWrapper<JianlitoudiEntity>().eq("id", id));
        return R.ok().put("data", jianlitoudi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianlitoudiEntity jianlitoudi = jianlitoudiService.selectById(id);
		jianlitoudi = jianlitoudiService.selectView(new EntityWrapper<JianlitoudiEntity>().eq("id", id));
        return R.ok().put("data", jianlitoudi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianlitoudiEntity jianlitoudi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianlitoudi);
        jianlitoudiService.insert(jianlitoudi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianlitoudiEntity jianlitoudi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianlitoudi);
        jianlitoudiService.insert(jianlitoudi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianlitoudiEntity jianlitoudi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianlitoudi);
        jianlitoudiService.updateById(jianlitoudi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JianlitoudiEntity> list = new ArrayList<JianlitoudiEntity>();
        for(Long id : ids) {
            JianlitoudiEntity jianlitoudi = jianlitoudiService.selectById(id);
            jianlitoudi.setSfsh(sfsh);
            jianlitoudi.setShhf(shhf);
            list.add(jianlitoudi);
        }
        jianlitoudiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianlitoudiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JianlitoudiEntity jianlitoudi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            jianlitoudi.setQiyezhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            jianlitoudi.setZhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<JianlitoudiEntity> ew = new EntityWrapper<JianlitoudiEntity>();
        int count = jianlitoudiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlitoudi), params), params));
        return R.ok().put("data", count);
    }



}
