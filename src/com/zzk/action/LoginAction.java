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
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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

	public String checkLogin() {
		loginDAO = (LoginDAO)SpringContextUtil.getBean("loginDAO");
		String pwd=loginDAO.login(userName);
		if(pwd.equals("")){
			status="用户名错误";
		}
		else if (!pwd.equals(userPassword)) {
			status="密码错误";
		}
		else{
			status="验证通过";
		}
		return SUCCESS;
	}
	
	public String checkSame() {
		loginDAO = (LoginDAO)SpringContextUtil.getBean("loginDAO");
		String pwd=loginDAO.login(userName);
		if(pwd.equals("")){
			status="0";
		}
		else{
			status="1";
		}
		return SUCCESS;
	}
	
	public String signUp() {
		loginDAO = (LoginDAO)SpringContextUtil.getBean("loginDAO");
		loginDAO.signUp(userName, userPassword);
		return SUCCESS;
	}

}
