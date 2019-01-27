package ds.web.practice.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ds.web.practice.bean.UserBean;
import ds.web.practice.dao.UserDao;
import ds.web.practice.util.SecureUtil;

@Service
public class RegisterService {
    @Resource
    private UserDao userDao;

    @Transactional
    public boolean checkAccount(String account) {
        UserBean userBean = userDao.findUserByAccount(account);

        if (userBean == null) {
            return true;
        }

        return false;
    }

    @Transactional
    public void register(String account, String password) {
        UserBean userBean = null;
        try {
            userBean = new UserBean(account, SecureUtil.hash("SHA-256", password));
        } catch (NoSuchAlgorithmException e) {
            // TODO throw exception and handle the exception in controller (with log4j)
            e.printStackTrace();
        }

        userDao.create(userBean);
    }
}
