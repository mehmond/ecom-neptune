package com.app.NeptuneDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.OrderDetail;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	public List<OrderDetail> index(User user){
		return orderDetailRepository.findByUser(user);
	}
}
