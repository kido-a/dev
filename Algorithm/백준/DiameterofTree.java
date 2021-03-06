package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;;
class PNode{
	int child;
	int value;
	public PNode(int child, int value) {
		this.child = child;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Nodel [child=" + child + ", value=" + value + "]";
	}
}
class CNode{
	int parent;
	int value;
	public CNode(int parent, int value) {
		this.parent = parent;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Nodel [parent=" + parent + ", value=" + value + "]";
	}
}
public class DiameterofTree {
	static ArrayList<PNode>[] adj;
	static CNode[] parent;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		parent = new CNode[N+1];
		for(int i=0;i<N+1;i++)
		{
			adj[i] = new ArrayList();
		}
		for(int i=0;i<N-1;i++)
		{
			String[] s = br.readLine().split(" ");
			int p = Integer.parseInt(s[0]);
			int c =Integer.parseInt(s[1]);
			int v = Integer.parseInt(s[2]);
			adj[p].add(new PNode(c,v));
			parent[c] = new CNode(p,v);
		}
//		for(int i=0;i<N;i++)
//		{
//			System.out.println(adj[i].toString());
//		}
//		System.out.println("=");
//		for(int i=0;i<N;i++)
//		{
//			if(parent[i] !=null)
//				System.out.println(parent[i].toString());
//		}
		
		for(int i=N;i>0;i--)
			dfs(i,0,new boolean[N+1]);
		
		System.out.println(max);
	}
	private static void dfs(int n,int cnt, boolean[] visit) {
		visit[n] = true;
		max = Integer.max(max, cnt);
		for(int i=0;i<adj[n].size();i++)
		{
			PNode node = adj[n].get(i);
			if(!visit[node.child])
				dfs(node.child,cnt+node.value,visit);
		}
		if(parent[n]!=null && !visit[parent[n].parent])
		{
			dfs(parent[n].parent,cnt+parent[n].value,visit);
		}
	}

}
