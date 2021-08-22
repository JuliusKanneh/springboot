package com.wisdom.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	@RequestMapping(value = "/")
	public String home() {
		return "Hello World";
	}
}
