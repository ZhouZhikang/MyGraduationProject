package com.zzk.Algorithm;

import java.math.BigDecimal;

/**按照BP网络求解步骤来的，三层BP神经网络*/
/** 已做过归一化处理 */
public class MyBpnet {
	public static void main(String args[]) {
		double saminn[] = {5.887,5.893,5.561,5.839,5.569,5.881,6.284,5.576};// 神经元输入，输入神经元数目为8
		double maxmin[] = new double[2];// 求训练数据最大值和最小值
		maxmin = maxmin(saminn);

		double samin[] = preprocess(maxmin[0], maxmin[1], saminn);// 输入做归一化处理，归一化公式
																	// x'=(x-min)/(max-x)

		double samoutt[] = {5.887,5.893,5.561,5.839,5.569,5.881,6.284,5.576};// 用原输入数据作为神经元输出来训练网络
		double maxminout[] = maxmin(samoutt);
		double samout[] = preprocess(maxminout[0], maxminout[1], samoutt);// 输出做归一化处理

		int times = 10000;// 训练次数
		double rate = 0.5;// 学习率
		int in = samin.length;// 输入神经元个数
		int out = samout.length;// 输出神经元个数
		double h = Math.sqrt((0.43 * in * out) + 0.12 * out * out + 2.54 * in
				+ 0.77 * out + 0.35) + 0.51;// 按文献上公式求隐含层个数
		BigDecimal b = new BigDecimal(h).setScale(0, BigDecimal.ROUND_HALF_UP);
		int hidN = (int) b.intValue();

		BP bp = new BP(in, hidN, out, times, rate);// 创建BP神经网络
		bp.train(samin, samout);// 利用BP神经网络进行训练
//		for (int i = 0; i < hidN; i++) {// 输出训练后网络输入层到隐含层权值和阈值
//			for (int j = 0; j < in; j++) {
//				System.out.println("输入层到隐含层权值阈值：      " + bp.wyh[i][j] + "   ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < out; i++) {// 输出训练后隐含层到输出层权值和阈值
//			for (int j = 0; j < hidN; j++) {
//				System.out.println("隐含层到输出层权值阈值：      " + bp.wyo[i][j]);
//			}
//			System.out.println();
//		}
		double testinn[] = {5.887,5.893,5.561,5.839,5.569,5.881,6.284,5.576};// 测试数据
		double test[] = maxmin(testinn);
		double testin[] = preprocess(test[0], test[1], testinn);// 测试数据做归一化处理
		double testoutt[] = new double[testin.length];// 测试输入输出数据个数一样
		testoutt = bp.getResult(testin);
		double testout[] = revprocess(test[0], test[1], testoutt);// 网络输出结果做反归一化处理
		for (int i = 0; i < testout.length; i++) {
			System.out.println(testout[i]+",");
		}
		System.out.println();

	}

	/** 求最大值最小值 **/

	public static double[] maxmin(double[] saminn) {
		double a[] = new double[2];
		double max = saminn[0], min = saminn[0];
		for (int i = 1; i < saminn.length; i++) {
			if (max < saminn[i])
				max = saminn[i];
			if (min > saminn[i])
				min = saminn[i];
		}
		a[0] = max;
		a[1] = min;
		return a;

	}

	/** 归一化处理 **/

	public static double[] preprocess(double max, double min, double[] saminn) {
		// System.out.println(max+" "+min);
		double samin[] = new double[saminn.length];
		for (int i = 0; i < samin.length; i++) {
			samin[i] = (saminn[i] - min) / (max - min);
			// System.out.println(samin[i]);
		}
		return samin;

	}

	/** 反归一化处理 **/

	public static double[] revprocess(double max, double min, double[] testoutt) {
		double testout[] = new double[testoutt.length];
		for (int i = 0; i < testout.length; i++) {
			testout[i] = testoutt[i] * (max - min) + min;
		}
		return testout;
	}

}

// BP神经网络实现

class BP {
	double wyh[][], wyo[][];// 权值，最后一行为阈值
	int hidN;// 隐含层单元个数
	int inN;// 输入单元个数
	int outN;// 输出单元个数
	int times;// 迭代次数
	double rate;// 学习率
	boolean trained = false;// 保证测试前先训练

	BP(int inN, int hidN, int outN, int times, double rate) {// 构造函数
		this.inN = inN;
		this.outN = outN;
		this.hidN = hidN;
		this.rate = rate;
		this.times = times;
	}

	public void train(double inData[],double outData[]){//网络训练
double err=0;//总体误差
int count=times;
double temphid[]=new double[hidN];//保存隐含层输出
double tempout[]=new double[outN];//保存输出层输出
double errout[]=new double[outN];//输出层各神经元误差
double errhid[]=new double[hidN];//隐含层各神经元误差

wyh=new double[hidN][inN+1];//最后一行为隐含层阈值



for(int i=0;i<hidN;i++){
for(int j=0;j<=inN;j++){
wyh[i][j]=Math.random()-0.5;//初始化权值和阈值
//System.out.println(wyh[i][j]);
}
}
//System.out.println();
wyo=new double[outN][hidN+1];//最后一行为计算输出的阈值
for(int i=0;i<outN;i++){
for(int j=0;j<=hidN;j++){
wyo[i][j]=Math.random()-0.5;//初始化权值和阈值
//System.out.println(wyo[i][j]);
}
}
while((count--)>0){
for(int i=0;i<hidN;i++){//遍历每个隐含单元的结果
temphid[i]=0;
for(int j=0;j<inN;j++){
temphid[i]+=wyh[i][j]*inData[j];
} 
temphid[i]+=wyh[i][inN];
temphid[i]=1.0/(1+Math.exp(-temphid[i]));
//System.out.println(temphid[i]);
}

for(int i=0;i<outN;i++){//计算每个输出层单元的结果
tempout[i]=0;
for(int j=0;j<hidN;j++){
tempout[i]+=wyo[i][j]*temphid[j];
}
tempout[i]+=wyo[i][hidN];
tempout[i]=1.0/(1+Math.exp(-tempout[i]));
}
//每个输出单元的计算误差 

for(int i=0;i<outN;++i ){
errout[i]=tempout[i]*(1-tempout[i])*(outData[i]-tempout[i]);
err+=Math.pow((outData[i]-tempout[i]), 2);
}
err=err/2;//最终误差计算
//计算每个隐含层单元的误差
double errh=0;
for(int i=0;i<hidN;i++){
for(int j=0;j<outN;j++){
errh+=errout[j]*wyo[j][i];
}
errhid[i]=temphid[i]*(1-temphid[i])*errh;
}

//改变输出层权值
for(int i=0;i<outN;i++){
for(int j=0;j<hidN;j++){
wyo[i][j]+=rate*temphid[j]*errout[i];
}
wyo[i][hidN]+=rate*errout[i];//改变阈值
}

//改变隐含层权值和阈值
for(int i=0;i<hidN;i++){
for(int j=0;j<inN;j++){
wyh[i][j]+=rate*inData[j]*errhid[i];
}
wyh[i][inN]+=rate*errhid[i];
}
if(err<0.0001)
break;

}

System.out.println("训练次数："+count+"   ，训练误差"+err);

trained=true;
}

	public double[] getResult(double inData[]) {// 得到测试数据的输出
		double temphid[] = new double[hidN];// 隐含层个数暂时不变
		double tempout[] = new double[inData.length];// 测试数据输入多少个输出就多少个
		if (trained == false)
			return null;
		for (int i = 0; i < hidN; i++) {
			temphid[i] = 0;
			for (int j = 0; j < inData.length; j++) {
				temphid[i] += wyh[i][j] * inData[j];
			}
			temphid[i] += wyh[i][inData.length];
			temphid[i] = 1.0 / (1 + Math.exp(-temphid[i]));
		}
		for (int i = 0; i < tempout.length; i++) {
			tempout[i] = 0;
			for (int j = 0; j < hidN; j++) {
				tempout[i] += wyo[i][j] * temphid[j];
			}
			tempout[i] += wyo[i][hidN];
			tempout[i] = 1 / (1 + Math.exp(-tempout[i]));// 测试数据的输出
		}
		return tempout;// 返回测网络输出的测试结果
	}
}