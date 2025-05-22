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
import com.cl.utils.UserBasedCollaborativeFiltering;

import com.cl.entity.QingnianyizhanEntity;
import com.cl.entity.view.QingnianyizhanView;

import com.cl.service.QingnianyizhanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 青年驿站
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
@RestController
@RequestMapping("/qingnianyizhan")
public class QingnianyizhanController {
    @Autowired
    private QingnianyizhanService qingnianyizhanService;

    @Autowired
    private StoreupService storeupService;






    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QingnianyizhanEntity qingnianyizhan,
		HttpServletRequest request){
        EntityWrapper<QingnianyizhanEntity> ew = new EntityWrapper<QingnianyizhanEntity>();

		PageUtils page = qingnianyizhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingnianyizhan), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QingnianyizhanEntity qingnianyizhan, 
		HttpServletRequest request){
        EntityWrapper<QingnianyizhanEntity> ew = new EntityWrapper<QingnianyizhanEntity>();

		PageUtils page = qingnianyizhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingnianyizhan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QingnianyizhanEntity qingnianyizhan){
       	EntityWrapper<QingnianyizhanEntity> ew = new EntityWrapper<QingnianyizhanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qingnianyizhan, "qingnianyizhan")); 
        return R.ok().put("data", qingnianyizhanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QingnianyizhanEntity qingnianyizhan){
        EntityWrapper< QingnianyizhanEntity> ew = new EntityWrapper< QingnianyizhanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qingnianyizhan, "qingnianyizhan")); 
		QingnianyizhanView qingnianyizhanView =  qingnianyizhanService.selectView(ew);
		return R.ok("查询青年驿站成功").put("data", qingnianyizhanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QingnianyizhanEntity qingnianyizhan = qingnianyizhanService.selectById(id);
		qingnianyizhan = qingnianyizhanService.selectView(new EntityWrapper<QingnianyizhanEntity>().eq("id", id));
        return R.ok().put("data", qingnianyizhan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QingnianyizhanEntity qingnianyizhan = qingnianyizhanService.selectById(id);
		qingnianyizhan = qingnianyizhanService.selectView(new EntityWrapper<QingnianyizhanEntity>().eq("id", id));
        return R.ok().put("data", qingnianyizhan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QingnianyizhanEntity qingnianyizhan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qingnianyizhan);
        qingnianyizhanService.insert(qingnianyizhan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QingnianyizhanEntity qingnianyizhan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qingnianyizhan);
        qingnianyizhanService.insert(qingnianyizhan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QingnianyizhanEntity qingnianyizhan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qingnianyizhan);
        qingnianyizhanService.updateById(qingnianyizhan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qingnianyizhanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,QingnianyizhanEntity qingnianyizhan, HttpServletRequest request,String pre){
        EntityWrapper<QingnianyizhanEntity> ew = new EntityWrapper<QingnianyizhanEntity>();
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
		PageUtils page = qingnianyizhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingnianyizhan), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,QingnianyizhanEntity qingnianyizhan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "qingnianyizhan"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity storeup : storeups) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(storeup.getUserid().toString())) {
                    userRatings = ratings.get(storeup.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(storeup.getUserid().toString(), userRatings);
                }

                if(userRatings.containsKey(storeup.getRefid().toString())) {
                    userRatings.put(storeup.getRefid().toString(), userRatings.get(storeup.getRefid().toString())+1.0);
                } else {
                    userRatings.put(storeup.getRefid().toString(), 1.0);
                }
            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<QingnianyizhanEntity> ew = new EntityWrapper<QingnianyizhanEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = qingnianyizhanService.queryPage(params, ew);
        List<QingnianyizhanEntity> pageList = (List<QingnianyizhanEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<QingnianyizhanEntity>();
            if(recommendations.size()>0){
                ew.notIn("id", recommendations);
            }
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(qingnianyizhanService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }








}
