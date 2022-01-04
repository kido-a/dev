package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AtoB {
	public static class Node
	{
		long value;
		int cnt;
		public Node(long value, int cnt) {
			super();
			this.value = value;
			this.cnt = cnt;
		}
		
		
		@Override
		public String toString() {
			return "Node [value=" + value + ", cnt=" + cnt + "]";
		}

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		int cnt =0;
		Queue<Node> q = new LinkedList();
		
		q.add(new Node(A,cnt));
		boolean fail = false;
		while(!q.isEmpty())
		{
			Node x = q.poll();
//			System.out.println(x.toString());
			if(x.value ==B)
			{
				System.out.println(x.cnt+1);
				fail = true;
				break;
			}
			if(x.value*2 <= B)
				q.add(new Node((x.value*2),x.cnt+1));
			if(x.value*10+1 <= B)
				q.add(new Node((x.value*10+1),x.cnt+1));
		}
		if(!fail)
		{
			System.out.println("-1");
		}

	}

}
