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

import com.cl.entity.ZhaopinhuodongEntity;
import com.cl.entity.view.ZhaopinhuodongView;

import com.cl.service.ZhaopinhuodongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 招聘活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-12 20:04:13
 */
@RestController
@RequestMapping("/zhaopinhuodong")
public class ZhaopinhuodongController {
    @Autowired
    private ZhaopinhuodongService zhaopinhuodongService;

    @Autowired
    private StoreupService storeupService;






    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaopinhuodongEntity zhaopinhuodong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			zhaopinhuodong.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();

		PageUtils page = zhaopinhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinhuodong), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaopinhuodongEntity zhaopinhuodong, 
		HttpServletRequest request){
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();

		PageUtils page = zhaopinhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinhuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaopinhuodongEntity zhaopinhuodong){
       	EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaopinhuodong, "zhaopinhuodong")); 
        return R.ok().put("data", zhaopinhuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaopinhuodongEntity zhaopinhuodong){
        EntityWrapper< ZhaopinhuodongEntity> ew = new EntityWrapper< ZhaopinhuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaopinhuodong, "zhaopinhuodong")); 
		ZhaopinhuodongView zhaopinhuodongView =  zhaopinhuodongService.selectView(ew);
		return R.ok("查询招聘活动成功").put("data", zhaopinhuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaopinhuodongEntity zhaopinhuodong = zhaopinhuodongService.selectById(id);
		zhaopinhuodong.setClicktime(new Date());
		zhaopinhuodongService.updateById(zhaopinhuodong);
		zhaopinhuodong = zhaopinhuodongService.selectView(new EntityWrapper<ZhaopinhuodongEntity>().eq("id", id));
        return R.ok().put("data", zhaopinhuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaopinhuodongEntity zhaopinhuodong = zhaopinhuodongService.selectById(id);
		zhaopinhuodong.setClicktime(new Date());
		zhaopinhuodongService.updateById(zhaopinhuodong);
		zhaopinhuodong = zhaopinhuodongService.selectView(new EntityWrapper<ZhaopinhuodongEntity>().eq("id", id));
        return R.ok().put("data", zhaopinhuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaopinhuodongEntity zhaopinhuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhaopinhuodong);
        zhaopinhuodongService.insert(zhaopinhuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaopinhuodongEntity zhaopinhuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhaopinhuodong);
        zhaopinhuodongService.insert(zhaopinhuodong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaopinhuodongEntity zhaopinhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaopinhuodong);
        zhaopinhuodongService.updateById(zhaopinhuodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaopinhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhaopinhuodongEntity zhaopinhuodong, HttpServletRequest request,String pre){
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
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
		PageUtils page = zhaopinhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinhuodong), params), params));
        return R.ok().put("data", page);
    }





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = zhaopinhuodongService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhaopinhuodongService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhaopinhuodongService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhaopinhuodongService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhaopinhuodongService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZhaopinhuodongEntity zhaopinhuodong, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            zhaopinhuodong.setQiyezhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhaopinhuodongEntity> ew = new EntityWrapper<ZhaopinhuodongEntity>();
        int count = zhaopinhuodongService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinhuodong), params), params));
        return R.ok().put("data", count);
    }



}
