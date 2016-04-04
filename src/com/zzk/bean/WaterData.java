package com.zzk.bean;

import java.math.BigDecimal;
import java.util.Date;

public class WaterData {
	private Date time;
	private BigDecimal waterLevel;
	
	public WaterData() {
		// TODO Auto-generated constructor stub
	}

	public WaterData(Date time,BigDecimal waterLevel){
		this.time=time;
		this.waterLevel=waterLevel;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public BigDecimal getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(BigDecimal waterLevel) {
		this.waterLevel = waterLevel;
	}
	
	
}
