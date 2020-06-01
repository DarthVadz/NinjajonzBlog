package com.nj.NinjajonzBlog.controller;

// import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// import com.nj.NinjajonzBlog.model.Article;
import com.nj.NinjajonzBlog.model.User;
// import com.nj.NinjajonzBlog.request.Request;
// import com.nj.NinjajonzBlog.service.ArticleService;
import com.nj.NinjajonzBlog.service.UserService;

@Controller
public class AuthorizationController {

	@Autowired
	private UserService userService;
	
	//@Autowired
	// private ArticleService articleService;

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/signup")
	public String registration(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}

	@PostMapping(value = "/signup")
	public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user", "Username is already taken");
		}
		if (!bindingResult.hasErrors()) {
			userService.saveNewUser(user);
			model.addAttribute("success", "Sign up successful! Now go log in.");
			model.addAttribute("user", new User());
		}
//		List<Article> articleList = articleService.findAll();
//		for(Article article : articleList) {
//			articleService.makePreview(article);
//		}
//		model.addAttribute("articleList", articleList);
//		model.addAttribute("request", new Request());
		return "signup";
	}

}
