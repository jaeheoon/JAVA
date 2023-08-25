package com.ezen.springmvc.transaction;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	public void create(Order order);
	public void updatePayStatus(Order order);
}

