package com.lk.oa.action.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class classT;
	private T t;
	//在构造函数中获得泛型的实际类型并赋值给classT,并由于该类实现了ModelDriven接口,所以用classT.newInstance()实例化t
	public BaseAction() {
		ParameterizedType type =  (ParameterizedType) this.getClass().getGenericSuperclass();
		classT = (Class) type.getActualTypeArguments()[0];
		try {
			t = (T) classT.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static final String LISTACITON = "listAction";
	public String listAction = LISTACITON;  //跳转到查询页面
	
	public static final String ADDUI = "addUI";
	public String addUI = ADDUI;  //跳转到添加页面
	
	public static final String UPDATEUI = "updateUI";
	public String updateUI = UPDATEUI;  //跳转到更新页面
	
	public static final String ACTION2ACTION = "action2action";
	public String action2action = ACTION2ACTION;  //action跳转到action
	
	@Override
	public T getModel() {
		return t;
	}

}
