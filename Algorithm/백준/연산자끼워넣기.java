package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class InterleaveOper {
	static int N,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		ArrayList<Integer> oper = new ArrayList();
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++)
			numbers[i] = Integer.parseInt(s[i]);
		s = br.readLine().split(" ");
		for(int i=0;i<4;i++)
		{
			int v = Integer.parseInt(s[i]);
			if(i==0)
			{
				for(int j=0;j<v;j++)
					oper.add(1);
			}
			else if(i==1)
			{
				for(int j=0;j<v;j++)
					oper.add(2);
			}
			else if(i==2)
			{
				for(int j=0;j<v;j++)
					oper.add(3);
			}
			else
			{
				for(int j=0;j<v;j++)
					oper.add(4);
			}
		}
		
		per(oper,new int[oper.size()],0,new boolean[oper.size()]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void per(ArrayList<Integer> oper, int[] sel, int k, boolean[] visit) {
		if(k==sel.length)
		{
//			System.out.println(Arrays.toString(sel));
			
			cul(sel);
			return;
		}
		
		for(int i=0;i<oper.size();i++)
		{
			if(!visit[i])
			{
				visit[i] = true;
				sel[k] = oper.get(i);
				per(oper,sel,k+1,visit);
				visit[i] = false;
			}
		}
	}
	private static void cul(int[] sel) {
//		System.out.println(Arrays.toString(sel));
		int[] copy = new int[N];
		
		arraycopy(copy);
		
		for(int i=0;i<N-1;i++)
		{
			if(sel[i]==1)
				copy[i+1]=copy[i]+copy[i+1];
			else if(sel[i]==2)
				copy[i+1]=copy[i]-copy[i+1];
			else if(sel[i]==3)
				copy[i+1]=copy[i]*copy[i+1];
			else
				copy[i+1]=copy[i]/copy[i+1];
		}
		int val = copy[N-1];
//		System.out.println("val = "+val);
		min = Integer.min(min, val);
		max = Integer.max(max, val);
	}
	private static void arraycopy(int[] copy) {
		for(int i=0;i<N;i++)
		{
			copy[i] = numbers[i];
		}
		
	}

}
