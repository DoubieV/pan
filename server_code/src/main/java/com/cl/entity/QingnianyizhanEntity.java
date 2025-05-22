package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 青年驿站
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
@TableName("qingnianyizhan")
public class QingnianyizhanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QingnianyizhanEntity() {
		
	}
	
	public QingnianyizhanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 驿站名称
	 */
					
	private String yizhanmingcheng;
	
	/**
	 * 门店图
	 */
					
	private String mendiantu;
	
	/**
	 * 入住详情
	 */
					
	private String ruzhuxiangqing;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupNumber;
	
	/**
	 * 评论数
	 */
					
	private Integer discussNumber;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：驿站名称
	 */
	public void setYizhanmingcheng(String yizhanmingcheng) {
		this.yizhanmingcheng = yizhanmingcheng;
	}
	/**
	 * 获取：驿站名称
	 */
	public String getYizhanmingcheng() {
		return yizhanmingcheng;
	}
	/**
	 * 设置：门店图
	 */
	public void setMendiantu(String mendiantu) {
		this.mendiantu = mendiantu;
	}
	/**
	 * 获取：门店图
	 */
	public String getMendiantu() {
		return mendiantu;
	}
	/**
	 * 设置：入住详情
	 */
	public void setRuzhuxiangqing(String ruzhuxiangqing) {
		this.ruzhuxiangqing = ruzhuxiangqing;
	}
	/**
	 * 获取：入住详情
	 */
	public String getRuzhuxiangqing() {
		return ruzhuxiangqing;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupNumber(Integer storeupNumber) {
		this.storeupNumber = storeupNumber;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupNumber() {
		return storeupNumber;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussNumber(Integer discussNumber) {
		this.discussNumber = discussNumber;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussNumber() {
		return discussNumber;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
