package com.ezen.springmvc.transaction;

public interface OrderService {
	public void order(Order order) throws NotEnoughMoneyException;
}




