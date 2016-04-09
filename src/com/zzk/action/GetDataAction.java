package com.zzk.action;

import java.text.ParseException;
import java.util.List;

import org.apache.struts2.components.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.zzk.DAO.GetDataDAO;
import com.zzk.DAO.StationDAO;
import com.zzk.bean.M01StStbprpB;
import com.zzk.bean.M02StRiverR0;
import com.zzk.bean.WaterData;


public class GetDataAction extends ActionSupport{
		private GetDataDAO dao = new GetDataDAO();
		private String startTime;
		private String endTime;
		private String station;
		private String flag;
		private List<WaterData> list;
		private List<WaterData> rainList;
		
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public List<WaterData> getRainList() {
			return rainList;
		}
		public void setRainList(List<WaterData> rainList) {
			this.rainList = rainList;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public String getStation() {
			return station;
		}
		public void setStation(String station) {
			this.station = station;
		}
		public List<WaterData> getList() {
			return list;
		}
		public void setList(List<WaterData> list) {
			this.list = list;
		}
		
		public String getData() throws ParseException {
			dao = (GetDataDAO)SpringContextUtil.getBean("getDataDAO");
			String stationId=dao.getStationId(station);
			flag=dao.getExists(stationId);
			if(flag.equals("1")){
				list=dao.get_riverData(startTime, endTime, stationId);
//				for(int i=0;i<list.size();i++){
//					System.out.println(list.get(i).getWaterLevel()+",");
//				}
			}
			else if(flag.equals("0"))
				list=dao.get_rsvrData(startTime, endTime, stationId);
			else if(flag.equals("2")){
				list=dao.get_rainData(startTime, endTime, stationId);
			}
			return SUCCESS;
		}
		
}
