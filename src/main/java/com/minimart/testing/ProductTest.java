package com.minimart.testing;

import com.minimart.domain.Product;
import com.minimart.repository.OrderRepository;
import com.minimart.repository.Repository;

public class ProductTest {

	public static void main(String[] args) {
	 Repository repo = new Repository();
//	 System.out.println(repo.edit("0010").getName());
	 
	 OrderRepository order = new OrderRepository();
	 
	 System.out.println(order.orderSave(100000));
	}

}
