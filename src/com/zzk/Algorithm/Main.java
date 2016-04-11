package com.zzk.Algorithm;
import java.util.*;

public class Main
{
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
	
	public static void main(String[] args)
	{
		double[] intputdata = {2222.7,2378.9, 2476.8, 2706.5, 2413.3};
		double[] outputdata = { 2585.6, 2637.2, 2596.3, 2784.5, 2618.4, 2896.7, 3035.3, 3266.3};
		int inputCount = intputdata.length;
		int hiddenCount = 9;
		int outputCount = 1 ;
		BackPropagationNeuralNetworks bp = new BackPropagationNeuralNetworks(inputCount, hiddenCount, outputCount, 0.25, 0.9);
		double[] data = {2222.7,2378.9, 2476.8, 2706.5, 2413.3, 2585.6, 2637.2, 2596.3, 2784.5, 2618.4, 2896.7, 3035.3, 3266.3};
		double min = data[0];
		double max = data[0];
		for(int i = 1; i < data.length; i++) {
			if(min > data[i]) min = data[i];
			if(max < data[i]) max = data[i];
		}
		
		double[][] inputData = new double[outputdata.length+1][inputCount];
		double[][] outputData = new double[outputdata.length+1][1];
		
		for(int i = 0; i <outputdata.length; i++) {
			for(int j = 0; j < inputCount; j++){
				inputData[i][j] = transform(data[i+j], min, max);
				System.out.println("1 "+data[i+j]);
//				System.out.println(inputData[i][j]);
			}
			System.out.println("\n");
//			for(int j = 0; j <= outputCount-inputCount; j++){
//				outputData[i][j] = transform(data[i+j+1], min, max);
//				System.out.println("2 "+data[i+j+1]);
//			}
			outputData[i][0] = transform(outputdata[i], min, max);
			System.out.println("2 "+outputdata[i]);
			System.out.println("\n");
		}
		
		Random random = new Random();
		int times = 0;

		do {
			int idx = random.nextInt(outputdata.length-1);
			bp.train(inputData[idx], outputData[idx]);
			System.out.format("第%d次训练: %f\n", ++times, bp.optErrSum);
		} while(bp.optErrSum > 0.00000001);
		
		System.out.println("训练完毕!!");
		
		List<Double> testdata =new ArrayList<Double>();
		double[] zzk={2222.7,2378.9, 2476.8, 2706.5, 2413.3};
		for(int i=0;i<zzk.length;i++){
			testdata.add(zzk[i]);
		};
		double[][] test = new double[outputdata.length][zzk.length];
		for (int i = 0; i < outputdata.length; i++) {
			for (int j = 0; j < inputCount; j++) {
				test[i][j] = transform(testdata.get(i + j), min, max);
			}
			double[] output = bp.test(test[i]);
			double f = untransform(output[outputCount - 1], min, max);
			testdata.add(f);
			System.out.println(f);
		}
		
		
//		for(int i = 0; i < outputdata.length; i++) {
//			System.out.println(i);
//			for(int j = 0; j < inputCount; j++){
//				test[i][j] = transform(testdata[i+j], min, max);
//				System.out.println(j);
//			}
//		}
//		for(int i = 0; i < outputdata.length; i++) {
//			double[] output = bp.test(inputData[i]);
//			System.out.println(i);
//			double f = untransform(output[outputCount - 1], min, max);
//			double a = data[i + inputCount];
//			System.out.format("第%d个测试样例：\n", i+1);
//			System.out.println("预测值: " + f);
//			System.out.println("实际值: " + a);
//		}
	}
}