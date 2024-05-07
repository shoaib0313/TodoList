package com.in28minutes.myfirstwebapp.loginAuthentticationService.loginController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@GetMapping("/")
	public String gotowelcomePage(ModelMap model) {
		model.put("name","Shoaib");
		return "welcome";
	}
}