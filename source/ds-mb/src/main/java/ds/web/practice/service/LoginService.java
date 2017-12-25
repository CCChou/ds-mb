package ds.web.practice.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ds.web.practice.dao.UserDao;

@Service
public class LoginService {
    @Resource
    private UserDao userDao;
    
    @Transactional
    public boolean verifyPwd(String account, String password) {
        System.out.println(userDao.getUserInfo(account));
        return true;
    }
}
