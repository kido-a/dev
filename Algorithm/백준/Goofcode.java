package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Goofcode {
	static long O;
	static ArrayList<Long[]> seoul;
	static boolean[] visit;
	static long cnt=1;
	static long result=10000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		 seoul = new ArrayList();
		 visit = new boolean[N];
		 Queue<long[]> q = new LinkedList<>();
		 
		for(int i=0;i<N;i++)
		{
			String s[] = br.readLine().split(" ");
			Long[] a = new Long[s.length-1];
			for(int j=0;j<s.length-1;j++)
			{
				a[j] = Long.parseLong(s[j+1]);
			}
			seoul.add(a);
		}
		O = (long)Integer.parseInt(br.readLine());	//목적지
		for (int i = 0; i < seoul.size(); i++) {	// 0찾기
			if(check(seoul.get(i),0))	//0을 찾을 때 마다 bfs
			{
				long[] in = {0,i};
				q.add(in);
				long count = q.peek()[0];
				long search = q.peek()[1];
				visit[i] = true;	
				bfs(q);
			}
			for(int j=0;j<visit.length;j++) // 다음에 또 0이 나올수 있기 때문에 visit 초기화
			{
				visit[j] = false;
			}
			
		}
		
		if (result == 10000)	//못찾으면 -1
		{
			result = -1;
		}
		System.out.println(result);
	}	
	private static void bfs(Queue<long[]> q)
	{
		if(q.isEmpty())	//q가 비면 종료
		{
			return;
		}
		long count = q.peek()[0];	//q에는 [count,search] 배열이 들어감
		long search = q.peek()[1];	//count는 환승 횟수, search는 호선
		q.poll();
		if(check(seoul.get((int)search),O))	// 목표를 찾으면 최소환승횟수 구하기
		{
			if(count < result)
			{
				result = count;
			}
			return;
		}
		for(int i=0;i<seoul.get((int)search).length;i++)	// 현재 호선에서 환승할 수 있는 호선 q에 담기
		{
			for(int j =0;j<seoul.size();j++)
			{
				if(check(seoul.get(j),seoul.get((int)search)[i])&& !visit[j])
				{
					visit[(int) j] = true;
					long[] in = {count+1,j};
					q.add(in);
				}
			}
		}
		bfs(q);

	}
	private static boolean check(Long[] longs, long value)
	{
		for(int i=0;i<longs.length;i++)
		{
			if(value ==longs[i])	return true;
		}
		return false;
	}
}
