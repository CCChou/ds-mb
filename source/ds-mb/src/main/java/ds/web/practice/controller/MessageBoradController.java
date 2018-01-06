package ds.web.practice.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ds.web.practice.service.DisplayService;
import ds.web.practice.service.PostService;

@Controller
@SessionAttributes("loginedAccount")
public class MessageBoradController {
	@Resource
	private PostService postService; 
	@Resource
	private DisplayService displayService;
	
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard"})
	public String showAll(Model model) {
		return "";
	}
	
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard/{id}"})
	public String showArticleById(Model model) {
		return "";
	}
	
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard/post.controller"})
	public String postNewArticle(Model model, @ModelAttribute("loginedAccount") String loginedAccount, String title, String content) {
		// TODO prevent XSS
		postService.postNewArticle(loginedAccount, title, content);
		return "messageBoard";
	}
}
