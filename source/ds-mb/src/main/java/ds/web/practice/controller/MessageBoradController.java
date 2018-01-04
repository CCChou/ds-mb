package ds.web.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageBoradController {
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard"})
	public String showAll(Model model) {
		return "";
	}
	
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard/{id}"})
	public String showArticleById(Model model) {
		return "";
	}
	
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard/post.controller"})
	public String postNewArticle() {
		return "";
	}
}
