package com.zzk.DAO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzk.action.SpringContextUtil;
import com.zzk.bean.M01StStbprpB;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		GetDataDAO dao = new GetDataDAO();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm");//小写的mm表示的是分钟  
		String startTime="2011-07-21 21:53";
		String endTime="2011-07-22 21:53";
		String station= "1101";
		java.util.Date date1=sdf.parse(startTime);
		java.util.Date date2=sdf.parse(endTime);
		dao = (GetDataDAO)SpringContextUtil.getBean("getDataDAO");
//		List<BigDecimal> list=dao.getWaterData(date1, date2, station);
//		for(BigDecimal data:list){
//			System.out.println(date1);
//		}
	}

}
