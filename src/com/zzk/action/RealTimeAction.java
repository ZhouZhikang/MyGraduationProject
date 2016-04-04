package com.zzk.action;

import java.text.ParseException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zzk.DAO.GetDataDAO;
import com.zzk.DAO.RealTimeDAO;
import com.zzk.bean.WaterData;

public class RealTimeAction extends ActionSupport{
	private RealTimeDAO dao = new RealTimeDAO();
	private GetDataDAO dao2 = new GetDataDAO();
	private String station;
	private String typeflag;
	private List<WaterData> realTimeDataList;
	
	

	public String getStation() {
		return station;
	}



	public void setStation(String station) {
		this.station = station;
	}



	public String getTypeflag() {
		return typeflag;
	}



	public void setTypeflag(String typeflag) {
		this.typeflag = typeflag;
	}


	public List<WaterData> getRealTimeDataList() {
		return realTimeDataList;
	}



	public void setRealTimeDataList(List<WaterData> realTimeDataList) {
		this.realTimeDataList = realTimeDataList;
	}



	public String getRealTimeData() throws ParseException{
		dao = (RealTimeDAO)SpringContextUtil.getBean("getRealTimeDataDAO");
		dao2 = (GetDataDAO)SpringContextUtil.getBean("getDataDAO");
		String stationId=dao2.getStationId(station);
		typeflag=dao2.getExists(stationId);
		System.out.println(typeflag+"  "+station+"  "+stationId);
		if((typeflag.equals("3"))){
			//	TODO noting
		}
		else if(typeflag.equals("1"))
			realTimeDataList=dao.get_realTimeRiverData(stationId);
		else if(typeflag.equals("0"))
			realTimeDataList=dao.get_realTimeRsvrData(stationId);
		else if(typeflag.equals("2")){
			realTimeDataList=dao.get_realTimeRainData(stationId);
		}
		return SUCCESS;
	}

}
