package it.epicode.be.energy.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/admin")
	public String userAdmin() {
		return "Welcome Admin to Energy Services";
	}

	@GetMapping("/user")
	public String userUser() {
		return "Welcome User to Energy Services";
	}

	@GetMapping("/public")
	public String userPublic() {
		return "Welcome Everybody to Energy Services";
	}
}
