package com.example.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class BeanUtilsCopy {
	private static Logger log = LoggerFactory.getLogger(BeanUtilsCopy.class);
	public static void copyProperties(Object source, Object target) {
        try {
            BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            log.error("CopyProperties 异常：" + e);
        }

    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> CopyList(Collection sourceList, 
			 Class<T> destinationClass)  {  
		DozerBeanMapper dozer=new DozerBeanMapper();
		List destinationList = Lists.newArrayList();  
		for (Iterator  i$ = sourceList.iterator(); i$.hasNext(); ) { 
			Object sourceObject = i$.next();  
			Object destinationObject = dozer.map(sourceObject, destinationClass);  
			destinationList.add(destinationObject);  
		}  
		return destinationList;  
	} 
	/**
	   * 拷贝source不为空的属性到target,更新常用
	   * @param sour
	   * @param obje
	   * @return
	   */
	  public static void copyNotNull(Object source, Object target) {
		    Field[] fields = source.getClass().getDeclaredFields();
		    for (int i = 0, j = fields.length; i < j; i++) {
		      String propertyName = fields[i].getName();
		      Object propertyValue = getProperty(source, propertyName);
		      if(propertyValue!=null) {
		    	  setProperty(target, propertyName, propertyValue);
		      }
		    }
	  }
	  
	  /**
	   * 给bean赋值
	   * 
	   * @param bean
	   * @param propertyName
	   * @param value
	   * @return
	   */
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object setProperty(Object bean, String propertyName, Object value) {
	    Class clazz = bean.getClass();
	    try {
	      Field field = clazz.getDeclaredField(propertyName);
	      Method method =
	          clazz.getDeclaredMethod(getSetterName(field.getName()), new Class[] {field.getType()});
	      return method.invoke(bean, new Object[] {value});
	    } catch (Exception e) {
	    }
	    return null;
	  }
	  /**
	   * 得到值
	   * 
	   * @param bean
	   * @param propertyName
	   * @return
	   */
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object getProperty(Object bean, String propertyName) {
	    Class clazz = bean.getClass();
	    try {
	      Field field = clazz.getDeclaredField(propertyName);
	      Method method = clazz.getDeclaredMethod(getGetterName(field.getName()), new Class[] {});
	      return method.invoke(bean, new Object[] {});
	    } catch (Exception e) {
	    }
	    return null;
	  }
	  
	  /**
	   * 根据变量名得到get方法
	   * 
	   * @param propertyName
	   * @return
	   */
	  private static String getGetterName(String propertyName) {
	    String method = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
	    return method;
	  }
	  
	  /**
	   * 得到setter方法
	   * 
	   * @param propertyName 变量名
	   * @return
	   */
	  private static String getSetterName(String propertyName) {
	    String method = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
	    return method;
	  }

}
