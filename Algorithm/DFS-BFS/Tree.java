package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tree {
	static int N, D, result = 0;
	static int[] Nodes;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Nodes = new int[N];
		visit = new boolean[N];

		String s[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			Nodes[i] = Integer.parseInt(s[i]);
		}
		D = Integer.parseInt(br.readLine());
		visit[D] = true;
		dfs(D);
		for (int i = 0; i < N; i++) {
			if (!visit[i]) // 살아있는 노드
			{
				check(i);
			}
		}
		System.out.println(result);
	}
	private static void check(int v) {
		for (int j = 0; j < N; j++) {
			if (!visit[j] && v == Nodes[j]) {
				return;
			}
		}
		result++;
	}
	private static void dfs(int v) {

		for (int i = 0; i < N; i++) {
			if (Nodes[i] == v && !visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}

}
