package com.zzk.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.zzk.bean.M02StPptnR0;
import com.zzk.bean.M02StRiverR0;
import com.zzk.bean.M02StRsvrR0;


public class InsertDataDAO extends HibernateDaoSupport{
	@Resource private SessionFactory sessionFactory;
	
	@Transactional
	public void addRiverData(String stationId,String time,double data) {
		try{
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call addRiverData(?,?,?)}");
		query.setString(0, stationId);
		query.setString(1, time);
		query.setDouble(2, data);
		query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Transactional
	public void addRsvrData(String stationId,String time,double data) {
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call addRsvrData(?,?,?)}");
		query.setString(0, stationId);
		query.setString(1, time);
		query.setDouble(2, data);
		query.executeUpdate();
	}
	@Transactional	
	public void addRainData(String stationId,String time,double data) {
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call addRainData(?,?,?)}");
		query.setString(0, stationId);
		query.setString(1, time);
		query.setDouble(2, data);
		query.executeUpdate();
	}

}
