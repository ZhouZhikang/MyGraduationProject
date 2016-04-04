package com.zzk.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.util.ServerInfo;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class LoginDAO extends HibernateDaoSupport{
	@Resource private SessionFactory sessionFactory;

	public String login(String userName){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_user(?)}");
		query.setString(0, userName);
		List<String> list=  query.list();
		return list.get(0);
	}
}


