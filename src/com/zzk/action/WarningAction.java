package com.zzk.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zzk.Algorithm.BackPropagationNeuralNetworks;
import com.zzk.Algorithm.GreyModel;

import com.opensymphony.xwork2.ActionSupport;

public class WarningAction extends ActionSupport{
	private String data1;
	private String data2;
	private String data3;
	private double[] gm;
	

	public String getData1() {
		return data1;
	}



	public void setData1(String data1) {
		this.data1 = data1;
	}



	public String getData2() {
		return data2;
	}



	public void setData2(String data2) {
		this.data2 = data2;
	}

	

	public double[] getGm() {
		return gm;
	}



	public void setGm(double[] gm) {
		this.gm = gm;
	}
	
	
	
	public String getData3() {
		return data3;
	}



	public void setData3(String data3) {
		this.data3 = data3;
	}



	public static double transform(double value, double min, double max) {
		double a = 0.9;
		double b = (1 - a) / 2;
		return (value - min) / (max - min) * a + b;
	}
	
	public static double untransform(double value, double min, double max) {
		double a = 0.9;
		double b = (1 - a) / 2;
		return (value - b) / a * (max - min) + min;
	}



	public String warningCalculate() throws ParseException{
		String[] str= data1.split(",");
		String[] str2= data2.split(",");
		String[] str3= data2.split(",");
		double[] dlist1 = new double[str.length];
		double[] dlist2 = new double[str.length];
		double[] dlist3 = new double[str3.length];
		gm = new double[str2.length];
		for(int i=0;i<str.length;i++){
			dlist1[i]=Double.parseDouble(str[i]);
			}
		for(int i=0;i<str2.length;i++){
			dlist2[i]=Double.parseDouble(str2[i]);
			}
		for (int i = 0; i < str2.length; i++) {
			gm[i] = GreyModel.greyModel(dlist2, i);
		}
		for(int i=0;i<str3.length;i++){
			dlist3[i]=Double.parseDouble(str3[i]);
			}
		
		double[] intputdata = dlist3;
		int inputCount = intputdata.length;
		int hiddenCount = 9;
		int outputCount = 1 ;
		BackPropagationNeuralNetworks bp = new BackPropagationNeuralNetworks(inputCount, hiddenCount, outputCount, 0.25, 0.9);
		double[] data = dlist1;
		double min = data[0];
		double max = data[0];
		for(int i = 1; i < data.length; i++) {
			if(min > data[i]) min = data[i];
			if(max < data[i]) max = data[i];
		}
		
		double[][] inputData = new double[data.length-inputCount+1][inputCount];
		double[][] outputData = new double[data.length-inputCount+1][1];
		
		for(int i = 0; i <data.length-inputCount; i++) {
			for(int j = 0; j < inputCount; j++){
				inputData[i][j] = transform(data[i+j], min, max);
			}
			outputData[i][0] = transform(data[i+inputCount], min, max);
		}
		
		Random random = new Random();
		int times = 0;

		do {
			int idx = random.nextInt(data.length-inputCount-1);
			bp.train(inputData[idx], outputData[idx]);
		} while(bp.optErrSum > 0.000001);
		
		System.out.println("训练完毕!!");
		
		List<Double> testdata =new ArrayList<Double>();
		double[] zzk=dlist2;
		for(int i=0;i<zzk.length;i++){
			testdata.add(zzk[i]);
		};
		System.out.println(data.length-inputCount);
		System.out.println(zzk.length);
		int num=str2.length-1;
		try{
		double[][] test = new double[data.length-inputCount][zzk.length];
		}catch(Exception e){
			e.printStackTrace();
		}
//		for (int i = 0; i < data.length-inputCount-1000; i++) {
//			System.out.println(inputCount);
//			for (int j = 0; j < inputCount; j++) {
//				test[i][j] = transform(testdata.get(i + j), min, max);
//				System.out.println(testdata.get(i + j));	
//			}
//			for(int m=0;m<test.length;m++){
//				for(int n=0;n<inputCount;i++){
//					System.out.println(test[m][n]);	
//				}
//			}
//			double[] output = bp.test(test[i]);
//			double f = untransform(output[outputCount - 1], min, max);
//			testdata.add(f);
//			gm[num] = f;
//			num++;
//		}

		
		return SUCCESS;
	}
}
