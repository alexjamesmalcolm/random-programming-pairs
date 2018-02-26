package com.alexjamesmalcolm.randomprogrammingpairs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandomProgrammingPairsController {
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
}
