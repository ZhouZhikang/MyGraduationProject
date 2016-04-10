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
	private BigDecimal data;
	
	
	
	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public BigDecimal getData() {
		return data;
	}



	public void setData(BigDecimal data) {
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
		System.out.println(insertFlag);
		System.out.println(insertStation);
		System.out.println(time);
		System.out.println(data);
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");                
//		 Date date = sdf.parse(time); 
//		System.out.println(date);
		dao = (GetDataDAO)SpringContextUtil.getBean("getDataDAO");
		String stationId=dao.getStationId(insertStation);
		idd = (InsertDataDAO)SpringContextUtil.getBean("getInsertDataDAO");
		if(insertFlag.equals("1")){
//			M02StRiverR0 obj=new M02StRiverR0();
//			obj.setStcd(stationId);
//			obj.setTm(date);
//			obj.setZ(data);
//			idd.addRiverData(obj);
			idd.addRiverData(stationId,time,data);
		}
		if(insertFlag.equals("0")){
//			M02StRsvrR0 obj = new M02StRsvrR0();
//			obj.setStcd(stationId);
//			obj.setTm(date);
//			obj.setRz(data);
//			idd.addRsvrData(obj);
			idd.addRsvrData(stationId,time,data);
		}
		if(insertFlag.equals("2")){
//			M02StPptnR0 obj = new M02StPptnR0();
//			obj.setStcd(stationId);
//			obj.setTm(date);
//			obj.setVal(data);
//			obj.setSubVal(data);
//			idd.addRainData(obj);
			idd.addRainData(stationId,time,data);
		}
		return SUCCESS;
	}
}
