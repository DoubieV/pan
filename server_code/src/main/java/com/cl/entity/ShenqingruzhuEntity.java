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
 * 申请入住
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
@TableName("shenqingruzhu")
public class ShenqingruzhuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenqingruzhuEntity() {
		
	}
	
	public ShenqingruzhuEntity(T t) {
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
	 * 入住时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date ruzhushijian;
	
	/**
	 * 预计离开时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date likaishijian;
	
	/**
	 * 证件
	 */
					
	private String zhengjian;
	
	/**
	 * 个人简介
	 */
					
	private String gerenjianjie;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	

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
	 * 设置：入住时间
	 */
	public void setRuzhushijian(Date ruzhushijian) {
		this.ruzhushijian = ruzhushijian;
	}
	/**
	 * 获取：入住时间
	 */
	public Date getRuzhushijian() {
		return ruzhushijian;
	}
	/**
	 * 设置：预计离开时间
	 */
	public void setLikaishijian(Date likaishijian) {
		this.likaishijian = likaishijian;
	}
	/**
	 * 获取：预计离开时间
	 */
	public Date getLikaishijian() {
		return likaishijian;
	}
	/**
	 * 设置：证件
	 */
	public void setZhengjian(String zhengjian) {
		this.zhengjian = zhengjian;
	}
	/**
	 * 获取：证件
	 */
	public String getZhengjian() {
		return zhengjian;
	}
	/**
	 * 设置：个人简介
	 */
	public void setGerenjianjie(String gerenjianjie) {
		this.gerenjianjie = gerenjianjie;
	}
	/**
	 * 获取：个人简介
	 */
	public String getGerenjianjie() {
		return gerenjianjie;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
