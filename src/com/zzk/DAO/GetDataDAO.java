package com.zzk.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.zzk.bean.M01StStbprpB;
import com.zzk.bean.M02StRiverR0;
import com.zzk.bean.WaterData;

public class GetDataDAO extends HibernateDaoSupport{
	@Resource private SessionFactory sessionFactory;

	
	public String getStationId(String stationName){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_stationId(?)}");
		query.setString(0, stationName);
		List<String> list=  query.list();
		return list.get(0);
	}
	
	public String getExists(String stationName){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_ifExists(?)}");
		query.setString(0, stationName);
		List<String> list=  query.list();
		return list.get(0);
	}
	
	public List<WaterData> get_riverData(String startTime,String endTime,String station){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_riverData(?,?,?)}");
		query.setString(0, startTime);
		query.setString(1, endTime);
		query.setString(2, station);
		List<WaterData> list=  query.list();
		return  list;
	}
	
	public List<WaterData> get_rsvrData(String startTime,String endTime,String station){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_rsvrData(?,?,?)}");
		query.setString(0, startTime);
		query.setString(1, endTime);
		query.setString(2, station);
		List<WaterData> list=  query.list();
		return  list;
	}
	
	public List<WaterData> get_rainData(String startTime,String endTime,String station){
		SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_rainData(?,?,?)}");
		query.setString(0, startTime);
		query.setString(1, endTime);
		query.setString(2, station);
		List<WaterData> list=  query.list();
		return  list;
	}
}
