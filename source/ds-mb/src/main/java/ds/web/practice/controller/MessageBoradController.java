package ds.web.practice.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ds.web.practice.bean.ArticleBean;
import ds.web.practice.service.DisplayService;
import ds.web.practice.service.PostService;

@Controller
@SessionAttributes("loginedAccount")
public class MessageBoradController {
	@Resource
	private PostService postService; 
	@Resource
	private DisplayService displayService;
	
	@RequestMapping(method= {RequestMethod.GET}, path= {"/messageBoard.controller"})
	public String showByPage(Model model, @RequestParam(value="page", defaultValue="1") String page) {
		int pageNum = Integer.parseInt(page);
		List<ArticleBean> articleBeans = displayService.getTitleByRange(10*(pageNum-1), 10);
		model.addAttribute("articleBeans", articleBeans);
		model.addAttribute("pages", getPaginationInfo(pageNum));
		return "messageBoard";
	}
	
	private List<String> getPaginationInfo(int pageNum) {
		int start = 1;
		int length = 10;
		int pageCount = (int)(displayService.getArticleCount()/10 +1);
		List<String> pages = new LinkedList<>();
		
		if(pageNum > 6) {
			start = pageNum - 5;
		}
		
		if(pageCount <= 10) {
			length = pageCount;
		} else if (pageCount == 0) {
			length = 1;
		}
		
		for(int i=start; i<=length; i++) {
			pages.add(String.valueOf(i));
		}
		
		return pages;
	}
	
	@RequestMapping(method= {RequestMethod.GET}, path= {"/messageBoard/article.controller"})
	public String showArticleById(Model model, String id) {
		ArticleBean articleBean = displayService.getArticleById(Integer.parseInt(id));
		model.addAttribute("articleBean", articleBean);
		return "article";
	}
	
	@RequestMapping(method= {RequestMethod.POST}, path= {"/messageBoard/post.controller"})
	public String postNewArticle(Model model, @ModelAttribute("loginedAccount") String loginedAccount, String title, String content) throws UnsupportedEncodingException {
		// TODO prevent XSS
		postService.postNewArticle(loginedAccount, title, content);
		return "redirectMessageBoard";
	}
}
