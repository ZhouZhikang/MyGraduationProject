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
	private double[] bpnn;
	

	public double[] getBpnn() {
		return bpnn;
	}



	public void setBpnn(double[] bpnn) {
		this.bpnn = bpnn;
	}



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
		String[] str3= data3.split(",");
		double[] dlist1 = new double[str.length];
		double[] dlist2 = new double[str2.length];
		double[] dlist3 = new double[str3.length];
		int count=0;
//		System.out.println(str.length);
//		System.out.println(str2.length);
//		System.out.println(str3.length);
		for(int i=0;i<str.length;i++){
			dlist1[i]=Double.parseDouble(str[i]);
			}
		for(int i=0;i<str2.length;i++){
			dlist2[i]=Double.parseDouble(str2[i]);
			}
		gm = new double[dlist2.length+499];
		for (int i = 0; i < dlist2.length; i++) {
			gm[i] = GreyModel.greyModel(dlist2, i);
		}
		for(int i=0;i<str3.length;i++){
			dlist3[i]=Double.parseDouble(str3[i]);
			}
		int len=dlist1.length-dlist3.length;
		double[] dlist4=new double[len];
		System.arraycopy(dlist1, dlist3.length, dlist4, 0, len);
		
		double[] g1=new double[dlist2.length];
		System.arraycopy(gm, 0, g1, 0, g1.length);
		
		if(dlist3.length>dlist2.length){
			count=dlist2.length;
			double[] test1=new double[count];
			System.arraycopy(dlist3, dlist3.length-count, test1, 0, test1.length);
			dlist3=test1;
		}
		else{
			count=dlist3.length;
			double[] test2=new double[count];
			System.arraycopy(dlist2, dlist2.length-count, test2, 0, test2.length);
			dlist2=test2;
		}
		
		int d2len=1000;
		int d3len=1000;
		int d4len=500;
		int glen=1000;
		double[] d2=new double[d2len];
		double[] d3=new double[d3len];
		double[] d4=new double[d4len];
		double[] g2=new double[glen];
		System.arraycopy(dlist2, dlist2.length-d2len, d2, 0, d2.length);
		System.arraycopy(dlist3, dlist3.length-d3len, d3, 0, d3.length);
		System.arraycopy(g1, g1.length-glen, g2, 0, g2.length);
		System.arraycopy(dlist4, 0, d4, 0, d4.length);
		dlist2=d2;
		dlist3=d3;
		dlist4=d4;
		
		double[] d5=new double[dlist3.length+dlist4.length];
		System.arraycopy(dlist3, 0, d5, 0, dlist3.length);
		System.arraycopy(dlist4, 0, d5, dlist3.length, dlist4.length);
		dlist1=d5;
		
		System.out.println(dlist1.length);
//		System.out.println(dlist2.length);
//		System.out.println(dlist3.length);
//		System.out.println(g2.length);
//		
//		for(int i=0;i<1000;i++){
//			System.out.print(dlist3[i]+",");
//		}
//		System.out.println("\n");
//		for(int i=0;i<1500;i++){
//			System.out.print(dlist1[i]+",");
//		}
//		System.out.println("\n");
//		for(int i=0;i<1000;i++){
//			System.out.print(dlist2[i]+",");
//		}
//		System.out.println("\n");
//		for(int i=0;i<1000;i++){
//			System.out.print(gm[i]+",");
//		}
		
		
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
		} while(bp.optErrSum > 0.0000001);
		
		System.out.println("训练完毕!!");
		System.out.println(min);
		System.out.println(max);
		
		List<Double> testdata =new ArrayList<Double>();
		double[] zzk=dlist2;
		for(int i=0;i<zzk.length;i++){
			testdata.add(zzk[i]);
		};
		int num=str2.length-1;
		double[][] test = new double[data.length-inputCount][zzk.length];
		bpnn = new double[data.length-inputCount];
		for (int i = 0; i < data.length-inputCount; i++) {
			for (int j = 0; j < inputCount; j++) {
				test[i][j] = transform(testdata.get(i + j), min, max);
//				System.out.println(testdata.get(i + j));	
			}
			double[] output = bp.test(test[i]);
			double f = untransform(output[outputCount - 1], min, max);
			testdata.add(f);
			System.out.println(f);
			bpnn[i]=f;
		}

		
		return SUCCESS;
	}
}
