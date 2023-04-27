package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	//Add mapping for leaders.
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	//Add mapping for admins.
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
