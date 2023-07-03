package co.develhope.bugtracker.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.develhope.bugtracker.controller.dto.GetOrderDto;
import co.develhope.bugtracker.entity.Order;
import co.develhope.bugtracker.exception.NotFoundException;
import co.develhope.bugtracker.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public GetOrderDto getById(Integer id) {
		Optional<Order> oOrder = orderRepository.findById(id);
		if (oOrder.isPresent()) {
			Order o = oOrder.get();
			GetOrderDto dto = new GetOrderDto();
			dto.setCount(o.getCount());
			dto.setItem(o.getItem());
			dto.setUsername(o.getUser().getUsername());
			return dto;
		} else {
			throw new NotFoundException("NOT_FOUND");
		}
	}

}
