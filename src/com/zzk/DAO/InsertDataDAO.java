package com.zzk.DAO;

import javax.annotation.Resource;

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
	public void addRiverData(M02StRiverR0 data) {
		try{
			getHibernateTemplate().getSessionFactory().getCurrentSession().save(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Transactional
	public void addRsvrData(M02StRsvrR0 data) {
		try{
			getHibernateTemplate().getSessionFactory().getCurrentSession().save(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Transactional	
	public void addRainData(M02StPptnR0 data) {
		try{
			getHibernateTemplate().getSessionFactory().getCurrentSession().save(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
