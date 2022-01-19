package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Node implements Comparable<Node>{
	int x;
	int y;
	int v;
	public Node(int x, int y, int v) {
		super();
		this.x = x;
		this.y = y;
		this.v = v;
	}
	@Override
	public int compareTo(Node o) {
		return this.v - o.v;
	}
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", v=" + v + "]";
	}
	
}
public class BuildCity {
	static int[] parents;
	static Node[] nodes;
	static ArrayList<Node> check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		long cost=0;
		parents = new int[N+1]; 
		nodes = new Node[M]; 
		check = new ArrayList();
		long Allcost =0;
		for(int i=0;i<N+1;i++) 
		{
			parents[i]=i;
		}
		for(int i=0;i<M;i++) 
		{
			s = br.readLine().split(" ");
			nodes[i] = new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			Allcost = Allcost + Integer.parseInt(s[2]);
		}
		Arrays.sort(nodes);
		
		for(int i=0;i<M;i++)
		{
			int x = nodes[i].x;
			int y = nodes[i].y;
			int v = nodes[i].v;
			
			int a = find(x);
			int b = find(y);?
			if(a==b) 
				continue;
			System.out.println(nodes[i].toString());
			union(x,y); 
			cost = cost+v;
			check.add(nodes[i]); 
		}
		Collections.sort(check, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.x - o2.x;
			}
		});
		
		for(int i=0;i<check.size();i++) 
		{
			int x = check.get(i).x;
			int y = check.get(i).y;
//			System.out.println(check.get(i).toString());
			int a = find(x);
			int b = find(y);
			if(a==b)
				continue;
			
			union(x,y); 
		}
		if(connect(N))
			System.out.println(Allcost-cost);
		else
			System.out.println("-1");
		System.out.println(Arrays.toString(parents));
	}
	private static boolean connect(int n) {
		int a = parents[1];
		for(int i=1;i<n+1;i++)
		{
			if(a != parents[i])
				return false;
		}
		return true;
	}
	private static void union(int x, int y) { 
		int a = find(x);
		int b = find(y);
		if(a<b) 
			parents[b]=parents[a];
		else if(a>b)
			parents[a]=parents[b];
		else
			return;
	}
	private static int find(int x) { 
		if(parents[x]==x)  
			return x;
		else
		{
			parents[x] = find(parents[x]);
			return parents[x];
		}
	}

}
