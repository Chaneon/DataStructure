package LatinMatrix;

import java.util.Scanner;

/*
 * 来自n个部队的n种军衔的n×n名军官，如果能排成一个正方形，每一行，每一列的n名军官来自不同的部队并且军衔各不相同，那么就称这个方阵叫正交拉丁方阵
 * 也就是方阵中有n个不同的元素，每种元素恰有n个，并且每种元素在一行和一列中恰好出现一次。
 * */
public class main {

	public static void main(String[] args) {
		//int n=4;
		System.out.print("请输入元素个数(大于0)：");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		CycleList cl=new CycleList();
		for(int i=1;i<n+1;i++){
			cl.add(i);
		}
		cl.LatinMetrix();
	}

}
