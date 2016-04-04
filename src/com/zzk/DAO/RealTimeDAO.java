package com.zzk.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.zzk.bean.M01StStbprpB;
import com.zzk.bean.WaterData;


	public class RealTimeDAO extends HibernateDaoSupport{
		@Resource private SessionFactory sessionFactory;

		public List<WaterData> get_realTimeRiverData(String station){
			SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_realTimeRiverData(?)}");
			query.setString(0, station);
			List<WaterData> list=  query.list();
			return  list;
		}
		
		public List<WaterData> get_realTimeRainData(String station){
			SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_realTimeRainData(?)}");
			query.setString(0, station);
			List<WaterData> list=  query.list();
			return  list;
		}
		
		public List<WaterData> get_realTimeRsvrData(String station){
			SQLQuery query  = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("{call get_realTimeRsvrData(?)}");
			query.setString(0, station);
			List<WaterData> list=  query.list();
			return  list;
		}
	}
