package com.zzk.Algorithm;
public class GreyModel {

	public static double greyModel(double[] x0, int num) {
		int pre_num = 10;
		int n = x0.length;
		int m = n - 1;
		double[] x1 = new double[n];// 经过一次累加所得数据
		double sum = 0;
		/*
		 * 进行累加
		 */
		for (int i = 0; i < n; i++) {
			sum += x0[i];
			x1[i] = sum;
		}
		double[] z1 = new double[m];// x1序列邻均值等权生成序列
		/*
		 * 进行 z1序列的生成，z1(n)=(x1(n)+x1(n+1))/2
		 */
		for (int i = 0; i < m; i++) {
			z1[i] = (x1[i] + x1[i + 1]) / 2;
		}
		/*
		 * 下面建立向量B, B是5行2列的矩阵， 相当于一个二维数组。
		 */
		double[][] B = new double[m][2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 1)
					B[i][j] = 1;
				else
					B[i][j] = -z1[i];
			}

		}
		/*
		 * 下面建立向量YN
		 */
		double[][] YN = new double[m][1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 1; j++) {
				YN[i][j] = x0[i + 1];
			}
		}
		/*
		 * B的转置矩阵BT,2行5列的矩阵
		 */
		double[][] BT = new double[2][m];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < m; j++) {
				BT[i][j] = B[j][i];
			}
		}
		/*
		 * 将BT和B的乘积所得到的结果记为数组B2T,则B2T是一个2*2的矩阵，即BT*B
		 */
		double[][] B2T = new double[2][2];
		for (int i = 0; i < 2; i++) {// rows of BT
			{
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < m; k++) {
						B2T[i][j] = B2T[i][j] + BT[i][k] * B[k][j];
					}
				}

			}
		}
		/*
		 * B2T求逆,即(BtB)^-1
		 */
		double[][] B_2T = new double[2][2];
		B_2T[0][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
				* B2T[1][1];
		B_2T[0][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
				* (-B2T[0][1]);
		B_2T[1][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
				* (-B2T[1][0]);
		B_2T[1][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
				* B2T[0][0];
		/*
		 * B2T*BT，即(BtB)^-1*BT
		 */
		double[][] A = new double[2][m];
		for (int i = 0; i < 2; i++) {
			{
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < 2; k++) {
						A[i][j] = A[i][j] + B_2T[i][k] * BT[k][j];
					}
				}

			}
		}
		/*
		 * 下面求A和YN矩阵的乘积，即(BtB)^-1*BT*YN，令乘积为C矩阵，则C就是一个2*1的矩阵,结果为a/u
		 */
		double[][] C = new double[2][1];
		for (int i = 0; i < 2; i++) {

			{
				for (int j = 0; j < 1; j++) {
					for (int k = 0; k < m; k++) {
						C[i][j] = C[i][j] + A[i][k] * YN[k][j];
					}
				}

			}
		}
		/*
		 * 下面求A和YN矩阵的乘积，即(BtB)^-1*BT*YN，令乘积为C矩阵，则C就是一个2*1的矩阵,结果为a/u
		 */
		double u = C[0][0], a = C[1][0];
		int i = num;
		double Y = (x0[0] - a / u) * Math.exp(-u * (i + 1)) - (x0[0] - a / u)
				* Math.exp(-u * i);

		return Y;
	}

	public static void main(String[] args) {
		double[] data = new double[] { 0.0217, 0.0645, 0.0267, 0.0052, 0.2626,
				0.3850, -0.6515, 0.4909, 0.1326 };
		for (int i = 0; i < data.length; i++) {
			System.out.println(greyModel(data, i)+",");
		}
	}
}
