package com.cl.entity.view;

import com.cl.entity.QingnianyizhanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 青年驿站
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-11-12 20:04:12
 */
@TableName("qingnianyizhan")
public class QingnianyizhanView  extends QingnianyizhanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QingnianyizhanView(){
	}
 
 	public QingnianyizhanView(QingnianyizhanEntity qingnianyizhanEntity){
 	try {
			BeanUtils.copyProperties(this, qingnianyizhanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
