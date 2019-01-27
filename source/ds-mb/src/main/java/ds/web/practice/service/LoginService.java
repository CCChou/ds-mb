package ds.web.practice.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ds.web.practice.bean.UserBean;
import ds.web.practice.dao.UserDao;
import ds.web.practice.util.SecureUtil;

@Service
public class LoginService {
    @Resource
    private UserDao userDao;

    @Transactional
    public boolean verifyUser(String account, String password) {
        UserBean userBean = userDao.findUserByAccount(account);
        if (userBean == null) {
            return false;
        }

        String hashedPwd = null;
        try {
            hashedPwd = SecureUtil.hash("SHA-256", password);
        } catch (NoSuchAlgorithmException e) {
            // TODO use log replace this
            e.printStackTrace();
        }

        return account.equals(userBean.getAccount()) && hashedPwd.equals(userBean.getHashedPwd());
    }
}
