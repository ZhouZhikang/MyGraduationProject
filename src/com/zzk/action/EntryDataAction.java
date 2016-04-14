package com.zzk.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.zzk.DAO.GetDataDAO;
import com.zzk.DAO.InsertDataDAO;
import com.zzk.bean.M02StPptnR0;
import com.zzk.bean.M02StRiverR0;
import com.zzk.bean.M02StRsvrR0;

public class EntryDataAction extends ActionSupport{
	private GetDataDAO dao = new GetDataDAO();
	private InsertDataDAO idd= new InsertDataDAO();
	private String insertStation;
	private String insertFlag;
	private String time;
	private double data;
	
	
	
	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public double getData() {
		return data;
	}



	public void setData(double data) {
		this.data = data;
	}



	public String getInsertStation() {
		return insertStation;
	}



	public void setInsertStation(String insertStation) {
		this.insertStation = insertStation;
	}



	public String getInsertFlag() {
		return insertFlag;
	}



	public void setInsertFlag(String insertFlag) {
		this.insertFlag = insertFlag;
	}



	public String getInsertType() throws ParseException {
		dao = (GetDataDAO)SpringContextUtil.getBean("getDataDAO");
		String stationId=dao.getStationId(insertStation);
		insertFlag=dao.getExists(stationId);
		System.out.println(insertFlag);
		return SUCCESS;
	}
	
	public String insertData() throws ParseException {
		dao = (GetDataDAO)SpringContextUtil.getBean("getDataDAO");
		String stationId=dao.getStationId(insertStation);
		idd = (InsertDataDAO)SpringContextUtil.getBean("getInsertDataDAO");
		if(insertFlag.equals("1")){
			idd.addRiverData(stationId,time,data);
		}
		if(insertFlag.equals("0")){
			idd.addRsvrData(stationId,time,data);
		}
		if(insertFlag.equals("2")){
			idd.addRainData(stationId,time,data);
		}
		return SUCCESS;
	}
}
