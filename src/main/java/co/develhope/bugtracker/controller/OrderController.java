package co.develhope.bugtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.develhope.bugtracker.controller.dto.GetOrderDto;
import co.develhope.bugtracker.repository.OrderRepository;
import co.develhope.bugtracker.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/get-by-id")
	public GetOrderDto getById(@RequestParam Integer id) {
		return orderService.getById(id);
	}
	
	
}
