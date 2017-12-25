package ds.web.practice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserBean {
    @Id
    private String account;
    @Column
    private String hashedPwd;
    
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getHashedPwd() {
        return hashedPwd;
    }
    public void setHashedPwd(String hashedPwd) {
        this.hashedPwd = hashedPwd;
    }
}
