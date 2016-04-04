package com.zzk.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zzk.DAO.StationDAO;
import com.zzk.bean.M01StStbprpB;

public class GetStationAction extends ActionSupport{
	private StationDAO stationDAO = new StationDAO();
	List<String> stationNameList=new ArrayList<String>();
	List<M01StStbprpB> stations =new ArrayList<M01StStbprpB>();
	private String stcd;//测站编号
	private String stnm;//测站名称
	private String rvnm;//河流名称
	private String hnnm;//水系名称
	private String bsnm;//流域名称
	private Double lgtd;//经度
	private Double lttd;//维度
	private String stlc;//站址
	private String addvcd;//行政区划码
	private BigDecimal mdbz;//
	private BigDecimal mdpr;//
	private String dtmnm;//基面名称
	private BigDecimal dtmel;//基面高程
	private String sttp;//站类
	private Byte dfrtms;//
	private String fritm;//
	private Character frgrd;//
	private String bgfrym;//始报年月
	private String edfrym;//
	private String admauth;//信息管理单位
	private Character stbk;//
	private Integer drna;//
	private String phcd;//
	private Short zhhsDisplayMap;//
	private Boolean isimportant;//
	private BigDecimal jgsw;//
	private BigDecimal bzsw;//

	
	public List<M01StStbprpB> getStations() {
		return stations;
	}

	public void setStations(List<M01StStbprpB> stations) {
		this.stations = stations;
	}

	public List<String> getStationNameList() {
		return stationNameList;
	}

	public void setStationNameList(List<String> stationNameList) {
		this.stationNameList = stationNameList;
	}


	
	public String getStation() {
		stationDAO = (StationDAO)SpringContextUtil.getBean("stationDAO");
		stations=stationDAO.getStation();
		for(int i=0;i<stations.size();i++){
			stationNameList.add(stations.get(i).getStnm());
		}
		return SUCCESS;
	}
}
