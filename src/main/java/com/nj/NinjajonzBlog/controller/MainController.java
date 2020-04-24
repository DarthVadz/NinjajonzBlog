package com.nj.NinjajonzBlog.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nj.NinjajonzBlog.model.Article;
import com.nj.NinjajonzBlog.model.Comment;
import com.nj.NinjajonzBlog.model.User;
import com.nj.NinjajonzBlog.request.Request;
import com.nj.NinjajonzBlog.response.Response;
import com.nj.NinjajonzBlog.service.ArticleService;
import com.nj.NinjajonzBlog.service.UserService;
import com.nj.NinjajonzBlog.service.WeatherService;

@Controller
public class MainController {

	@Autowired
	public ArticleService articleService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/")
	private String main(Model model) {
		List<Article> articleList = articleService.findAll();
		for(Article article : articleList) {
			articleService.makePreview(article);
		}
		model.addAttribute("articleList", articleList);
		model.addAttribute("request", new Request());
		return "main";
	}
	
	@GetMapping(value = "/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/newArticle")
	private String getArticleForm(Model model) {
		model.addAttribute("article", new Article());
		return "newArticle";
	}
	
	@GetMapping("/showArticle/{article_id}")
	private String getArticle(@PathVariable Long id, Model model) {
		Optional<Article> article = articleService.findById(id);
		List<Comment> comments = articleService.getComments();
		model.addAttribute("article", article);
		model.addAttribute("comments", comments);
		return "showArticle";
	}
	
	@PostMapping("/newArticle")
	private String submitArticleForm(@Valid Article article, Model model) {
		User user = userService.getLoggedInUser();
		article.setAuthor(user);
		model.addAttribute("successMessage", "Tweet successfully created!");
		model.addAttribute("article", new Article());
		articleService.saveNewArticle(article);
		return "showArticle";
	}
	
	@PostMapping("/comment")
	private String submitCommentForm(@Valid Comment comment, Model model) {
		return "showArticle";
	}
	
	@PostMapping("/forcast")
	public String postWeather(Request request, Model model, HttpServletRequest pageRequest) {
		Response data = weatherService.getForcast(request.getZipCode());
		List<Article> articleList = articleService.findAll();
		model.addAttribute("articleList", articleList);
		model.addAttribute("data", data);
		return "main";
	}
	
}
