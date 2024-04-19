package com.in28minutes.myfirstwebapp.loginAuthentticationService.loginController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.in28minutes.myfirstwebapp.loginAuthentticationService.authenticationService;

@Controller
@SessionAttributes("name")
public class loginController {
	private authenticationService authenticationService;
	
	
	
	public loginController(
			com.in28minutes.myfirstwebapp.loginAuthentticationService.authenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@GetMapping("login")
	public String gotoLoginPage() {
		return "login";
	}
	
	@PostMapping("login")
	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
		
		if(authenticationService.authenticate(name,password)) {	
	     	model.put("name",name);
//	    	model.put("password",password);
		    return "welcome";
		
	}	
		model.put("errorMessage", "invalid credentials! plz try again.");
		return "login";
	}
}
