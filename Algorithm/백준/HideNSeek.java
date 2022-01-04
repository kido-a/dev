package BaekJun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class HideNSeek {
	static int X,K,res=0;
	static Queue<int[]> q;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		K = sc.nextInt();
		q = new LinkedList();
		boolean[] visit = new boolean[1000001];
		
		q.add(new int[] {X,0});
		visit[X] = true;
		
		while(!q.isEmpty())
		{
			int[] temp = q.poll();
			int subin = temp[0];
			int cnt = temp[1];
			
//			System.out.println(subin+" "+cnt);
			visit[subin] = true;
			
			if(cnt>max && max !=0)
			{
				System.out.println(max);
				System.out.println(res-1);
				break;
			}
			if(X>=K)
			{
				System.out.println(X-K);
				System.out.println("1");
				break;
			}
			
			if(subin == K && max == 0)
			{
				res++;
				max = cnt;
			}
			if(subin == K && cnt == max)
			{
				res++;
			}
				
				
			if(!visit[subin+1] && subin+1<100001)
			{
				q.add(new int[] {subin+1,cnt+1});
			}
			if(subin-1>=0 && !visit[subin-1])
			{
				q.add(new int[] {subin-1,cnt+1});
			}
			if(!visit[subin*2] && subin*2<100001)
			{
				q.add(new int[] {subin*2,cnt+1});
			}
				
		}
		
	}

}
