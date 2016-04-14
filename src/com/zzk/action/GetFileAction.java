package com.zzk.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zzk.DAO.GetDataDAO;
import com.zzk.DAO.InsertDataDAO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class GetFileAction extends ActionSupport {
	private String username;
	private GetDataDAO dao = new GetDataDAO();
	private InsertDataDAO idd = new InsertDataDAO();
	private String insertStation;
	private String insertFlag ;
	private Double data;
	private String time ;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String execute() throws Exception {
		dao = (GetDataDAO) SpringContextUtil.getBean("getDataDAO");
		idd = (InsertDataDAO) SpringContextUtil.getBean("getInsertDataDAO");
		try {
			FileInputStream fis = new FileInputStream(file);
			jxl.Workbook rwb = Workbook.getWorkbook(fis);
			Sheet[] sheet = rwb.getSheets();
			for (int i = 0; i < sheet.length; i++) {
				Sheet rs = rwb.getSheet(i);
				for (int j = 1; j < rs.getRows(); j++) {
					Cell[] cells = rs.getRow(j);
					insertStation = cells[0].getContents();
					String stationId = dao.getStationId(insertStation);
					time = cells[1].getContents();
					data = Double.parseDouble(cells[2].getContents());
					stationId = dao.getStationId(insertStation);
					insertFlag = dao.getExists(stationId);
					System.out.println(insertFlag);
					System.out.println(stationId);
					System.out.println(time);
					System.out.println(data);
					 if(insertFlag.equals("1")){
					 idd.addRiverData(stationId,time,data);
					 }
					 if(insertFlag.equals("0")){
					 idd.addRsvrData(stationId,time,data);
					 }
					 if(insertFlag.equals("2")){
					 idd.addRainData(stationId,time,data);
					 }
				}
			}
			fis.close();
		} catch (Exception e) {
			this.addFieldError("errormsg", "文件内容错误");
			return ERROR;
		}
		return SUCCESS;
	}
}
