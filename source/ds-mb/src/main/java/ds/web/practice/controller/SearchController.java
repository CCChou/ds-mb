package ds.web.practice.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ds.web.practice.bean.ArticleBean;
import ds.web.practice.service.DisplayService;

@Controller
public class SearchController {
    @Resource
    private DisplayService displayService;
    @RequestMapping(method= {RequestMethod.POST}, path= {"/search.controller"})
    public String search(Model model, @RequestParam(value="page", defaultValue="1") String page, @RequestParam(value="condition") String condition) {
        int pageNum = Integer.parseInt(page);
        List<ArticleBean> articleBeans = displayService.getTitleRangeByCondition(condition, 10*(pageNum-1), 10);
        model.addAttribute("articleBeans", articleBeans);
        model.addAttribute("pages", getPaginationInfo(condition, pageNum));
        return "result";
    }
    
    private List<String> getPaginationInfo(String condition, int pageNum) {
        int start = 1;
        int length = 10;
        int pageCount = (int)(displayService.getArticleCountByCondition(condition)/10 +1);
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
}
