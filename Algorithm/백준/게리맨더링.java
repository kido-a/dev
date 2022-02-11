package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Gerrymandering {
	static int N,max = Integer.MAX_VALUE;
	static ArrayList<int[]> adj;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] people = new int[N+1];
		arr = new int[N];
		
		String[] s = br.readLine().split(" ");
		for(int i=1;i<=N;i++)
		{
			people[i] = Integer.parseInt(s[i-1]);
			arr[i-1] = i;
		}
		
//		System.out.println(Arrays.toString(people));
		
		adj = new ArrayList();
		
		for(int i=0;i<N;i++)
		{
			s = br.readLine().split(" ");
			int[] temp = new int[Integer.parseInt(s[0])];
			for(int j=0;j<temp.length;j++)
			{
				temp[j] = Integer.parseInt(s[j+1]);
			}
			adj.add(temp);			
		}
		for(int i=1;i<=(N+1)/2;i++)
		{
			dfs(0,0,arr,new int[i],people);
		}
		if(max==Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(max);
	}
	private static void dfs(int k, int idx, int[] arr, int[] sel, int[] people) {
		if(k==sel.length)
		{
//			System.out.println(Arrays.toString(sel));
			boolean[] visit = new boolean[N+1];
			boolean[] check = new boolean[N+1];
			
			for(int i=0;i<k;i++)
			{
				visit[sel[i]] = true;
			}
			if(bfs(visit,check))
			{
//				System.out.println(Arrays.toString(visit));
				int tsum=0;
				int fsum=0;
				for(int i=1;i<=N;i++)
				{
					if(visit[i])
						tsum += people[i];
					else
						fsum += people[i];
				}
				max = Integer.min(max, Math.abs(tsum-fsum));
			}
			
			return;
		}
		for(int i=idx;i<arr.length;i++)
		{
			sel[k] = arr[i];
			dfs(k+1,i+1,arr,sel,people);
		}
	}
	private static boolean bfs(boolean[] visit, boolean[] check) {
		ArrayList<Integer> tlist = new ArrayList();
		ArrayList<Integer> flist = new ArrayList();
		for(int i=1;i<=N;i++)
		{
			if(visit[i])
				tlist.add(i);
			else
				flist.add(i);
		}
		Queue<Integer> q = new LinkedList();
		boolean[] v = new boolean[N+1];
		v[0] = true;
		
		if(tlist.size()>0)
		{
			v[tlist.get(0)] = true;
			q.add(tlist.get(0));			
		}
		while(!q.isEmpty())
		{
			int val = q.poll();
			for(int i=0;i<adj.get(val-1).length;i++)
			{
				if(tlist.contains(adj.get(val-1)[i]) && !v[adj.get(val-1)[i]])
				{
					v[adj.get(val-1)[i]] = true;
					q.add(adj.get(val-1)[i]);
				}
			}
		}
		
		q = new LinkedList();
		if(flist.size()>0)
		{
			v[flist.get(0)] = true;
			q.add(flist.get(0));			
		}
		while(!q.isEmpty())
		{
			int val = q.poll();
			for(int i=0;i<adj.get(val-1).length;i++)
			{
				if(flist.contains(adj.get(val-1)[i]) && !v[adj.get(val-1)[i]])
				{
					v[adj.get(val-1)[i]] = true;
					q.add(adj.get(val-1)[i]);
				}
			}
		}
		for (int i = 0; i < v.length; i++) {
			if(!v[i])
				return false;
		}
		return true;
	}

}
