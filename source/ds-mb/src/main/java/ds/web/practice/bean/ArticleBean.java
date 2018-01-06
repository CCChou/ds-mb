package ds.web.practice.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class ArticleBean {
	@Id
    private int id;
	@Column
    private String title;
	@Column
	private String content;
	@Column
	private String account;
	@Column(insertable=false)
	private Date date;
    
	public ArticleBean() {}
	
	public ArticleBean(String account, String title, String content) {
		this.account = account;
		this.title = title;
		this.content = content;
	}
	
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}
