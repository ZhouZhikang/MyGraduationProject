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

import com.zzk.bean.M01StStbprpB;


@Transactional
public class StationDAO extends HibernateDaoSupport{
	@Resource private SessionFactory sessionFactory;

	public List<M01StStbprpB> getStation(){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_station}");
		query.addEntity(M01StStbprpB.class);
		List<M01StStbprpB> list=  query.list();
		return  list;
	}
}
