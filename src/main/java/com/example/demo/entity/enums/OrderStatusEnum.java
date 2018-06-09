package com.example.demo.entity.enums;

public enum OrderStatusEnum implements CodeEnum {
	NEW(0, "新订单"),
	FINISHED(1, "完结"),
	CANCEL(2, "已取消"),;
	
	private Integer code;
	
	private String message;
	
	
	OrderStatusEnum(Integer code, String message) {
	    this.code = code;
	    this.message = message;
	}


	@Override
	public Integer getCode() {
		// TODO Auto-generated method stub
		return this.code;
	}
}
