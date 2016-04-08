package com.zzk.DAO;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.zzk.bean.M02StPptnR0;
import com.zzk.bean.M02StRiverR0;
import com.zzk.bean.M02StRsvrR0;


public class InsertDataDAO extends HibernateDaoSupport{
	@Resource private SessionFactory sessionFactory;
	
	public void addRiverData(M02StRiverR0 data) {
		@Transactional
		try{
			getHibernateTemplate().getSessionFactory().getCurrentSession().save(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addRsvrData(M02StRsvrR0 data) {
		@Transactional
		try{
			getHibernateTemplate().getSessionFactory().getCurrentSession().save(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addRainData(M02StPptnR0 data) {
		@Transactional
		try{
			getHibernateTemplate().getSessionFactory().getCurrentSession().save(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
