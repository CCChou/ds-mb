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
	
	@RequestMapping(method= {RequestMethod.GET}, path= {"/messageBoard/messageBoard.controller"})
	public String showByPage(Model model, @RequestParam(value="page", defaultValue="1") String page) {
		int currentPage = Integer.parseInt(page);
		int rows = 10; // TODO let user decide the rows
		List<ArticleBean> articleBeans = displayService.getTitleByRange(rows * (currentPage - 1), rows);
		model.addAttribute("articleBeans", articleBeans);
		model.addAttribute("pages", getPaginationInfo(currentPage, rows));
		model.addAttribute("currentPage", currentPage);
		return "messageBoard";
	}
	
	private List<String> getPaginationInfo(int currentPage, int rows) {
		int startPage;
		int endPage;
		int maxPage = (int)(displayService.getArticleCount() / rows + 1);
		List<String> pages = new LinkedList<>();
		
		startPage = Math.max(1, currentPage - 4);
		endPage = Math.min(maxPage, currentPage + 4);
		
		for(int i=startPage; i<=endPage; i++) {
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
