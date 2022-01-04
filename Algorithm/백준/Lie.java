package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lie {
	static int[] group;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int T;
		boolean[] know = new boolean[N+1];
		ArrayList<int[]> party = new ArrayList();
		ArrayList<Integer> know_people = new ArrayList();
		
		
		group = new int[N+1];
		boolean visit[] = new boolean[N+1];
		for (int i = 0; i < group.length; i++) {
			group[i]=i;
		}
		
		String s2 = br.readLine();
		if(s2.length()>1)
		{
			s = s2.split(" ");
			for(int i=1;i<s.length;i++)
			{
				know[Integer.parseInt(s[i])] = true;
				know_people.add(Integer.parseInt(s[i]));
			}
			
			for(int i=0;i<M;i++)
			{
				s = br.readLine().split(" ");
				party.add(Arrays.stream(s).mapToInt(Integer::parseInt).toArray());
				if(s.length>2)
				{
					for(int j=2;j<s.length;j++)
					{
						union(Integer.parseInt(s[1]),Integer.parseInt(s[j]));
					}
				}
			}
			for(int i=0;i<know_people.size();i++)
			{
				Queue<Integer> q = new LinkedList();
				q.add(know_people.get(i));
				q.add(group[know_people.get(i)]);
				visit[know_people.get(i)] = true;
				while(!q.isEmpty())
				{
					int value = q.poll();
					for(int j=0;j<group.length;j++)
					{
						if(group[j]== value && !visit[j])
						{
							visit[j] = true;
							know[j] = true;
							q.add(j);
						}
					}
				}
			}
			int cnt =0;
			for(int i=0;i<party.size();i++)
			{
				for(int j=1;j<party.get(i).length;j++)
				{
					if(know[party.get(i)[j]])
					{
						cnt++;
//						System.out.println(Arrays.toString(party.get(i)));
						break;
					}
				}
			}
			System.out.println(M-cnt);
			
		}
		else if(s2.length()==1)
		{
			for(int i=0;i<M;i++)
			{
				s = br.readLine().split(" ");
			}
			System.out.println(M);
		}
		System.out.println(Arrays.toString(know));
		System.out.println(Arrays.toString(group));
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y)
		{
			group[x] = y;
		}
		else if(x<y)
		{
			group[y] =x;
		}
		else if( x==y)
			return;
	}

	private static int find(int x) {
		if(x == group[x])
			return x;
		else
		{
			int y = find(group[x]);
			group[x] = y;
			return y;
		}
	}

}
