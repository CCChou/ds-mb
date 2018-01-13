package ds.web.practice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ds.web.practice.bean.ArticleBean;
import ds.web.practice.dao.ArticleDao;

@Service
public class DisplayService {
	@Resource
	private ArticleDao articleDao;
	
	public List<ArticleBean> getTitleByRange(int start, int limit) {
		return articleDao.findByRange(start, limit);
	}
	
	public long getArticleCount() {
		return articleDao.getCount();
	}
	
	public ArticleBean getArticleById(int id) {
		return articleDao.findById(id);
	}
	
	public List<ArticleBean> getTitleRangeByCondition(String condition, int start, int limit) {
        return articleDao.findTitleRangeByCondition(condition, start, limit);
    }
    
    public long getArticleCountByCondition(String condition) {
        return articleDao.getCountByTitleCondition(condition);
    }
}
