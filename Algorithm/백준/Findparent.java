package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Findparent {
	static int N;
	static ArrayList<Integer>[] info;
	static boolean[] visit;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		info = new ArrayList[N+1];
		visit = new boolean[N+1];
		parents = new int[N+1];
		
		for (int i = 1; i <= N; i++)
		{			
			info[i] =new ArrayList(); 
		}
		
		for (int i = 1; i < N; i++) {
			String[] s = br.readLine().split(" ");
			info[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
			info[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
		}
		
		for (int i = 1; i <= N; i++)
		{
			if(!visit[i])
			{
				dfs(i);
			}
		}
		
		for(int i=2;i<N+1;i++)
		{
			System.out.println(parents[i]);
		}
		
	}
	private static void dfs(int v) {
		if(visit[v])
			return;
		visit[v] = true;
		
		for(int val : info[v])
		{
			if(!visit[val])
			{
				parents[val] =v;
				dfs(val);
			}
		}
//		
//		for (int i = 0; i <= info[v].size(); i++) {
//			if(!visit[info[v].get(i)])
//			{
//				parents[info[v].get(i)] = v;
//				dfs(info[v].get(i));
//			}
//		}
		
	}

}
