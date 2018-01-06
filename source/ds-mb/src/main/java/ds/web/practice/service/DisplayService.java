package ds.web.practice.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ds.web.practice.dao.ArticleDao;

@Service
public class DisplayService {
	@Resource
	private ArticleDao articleDao;

}
