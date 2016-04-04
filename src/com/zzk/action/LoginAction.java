package com.zzk.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zzk.DAO.LoginDAO;

public class LoginAction extends ActionSupport {
	private LoginDAO loginDAO = new LoginDAO();
	private Integer userId;
	private String userName;
	private String userPassword;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String execute() {
//		try {
//		      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		      loginDAO = (LoginDAO)applicationContext.getBean("loginDAO");
//		    } catch (RuntimeException e) {
//		      e.printStackTrace();
//		    }
		loginDAO = (LoginDAO)SpringContextUtil.getBean("loginDAO");
		String pwd=loginDAO.login(userName);
		if(pwd==null){
			super.addFieldError("userName", "用户名错误!");
			return ERROR;
		}
		if (!pwd.equals(userPassword)) {
			super.addFieldError("userPassword", "密码错误!");
			return ERROR;
		}
		return SUCCESS;
	}

}
