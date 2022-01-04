package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class StartTaxi {
	static int N, M;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<int[]> q;
	static ArrayList<int[]> q2;
	static int[][] cxy;
	static boolean[][] visit;
	static boolean[][] visit2;
	static boolean pos = true;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 목적지에 손님이 있을경우 문제
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		arr = new int[N][N];
		q = new ArrayList();
		q2 = new ArrayList();
		visit = new boolean[N][N];
		visit2 = new boolean[N][N];
		cxy = new int[M][4];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		s = br.readLine().split(" ");
		arr[Integer.parseInt(s[0]) - 1][Integer.parseInt(s[1]) - 1] = 2;
		q.add(new int[] { Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1, K });
		visit[Integer.parseInt(s[0]) - 1][Integer.parseInt(s[1]) - 1] = true;
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			arr[Integer.parseInt(s[0]) - 1][Integer.parseInt(s[1]) - 1] = i + 3;
//			arr[Integer.parseInt(s[2]) - 1][Integer.parseInt(s[3]) - 1] = (i + 3) * -1;
			for (int j = 0; j < 4; j++) {
				cxy[i][j] = Integer.parseInt(s[j]);
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		bfs(0);
		if (!pos) {
			System.out.println("-1");
		} else
			System.out.println(result);
	}

	private static void bfs(int o) {
		if (q.isEmpty()) {
//			System.out.println("모든 맵 탐색");
			pos = false;
			return;
		}
		if (q.get(0)[2] < 0) {
//			System.out.println("연료바닥");
			pos = false;
			return;
		}

		if (arr[q.get(0)[0]][q.get(0)[1]] > 2) {
			for (int i = 1; i < q.size(); i++) {
				if (arr[q.get(i)[0]][q.get(i)[1]] > 2 && q.get(0)[2] == q.get(i)[2]) {
					if (q.get(0)[0] > q.get(i)[0]) {
						Collections.swap(q, 0, i);
					} else if (q.get(i)[0] == q.get(0)[0]) {
						if (q.get(0)[1] > q.get(i)[1]) {
							Collections.swap(q, 0, i);
						}
					}
				}
			}
		}

		int x = q.get(0)[0];
		int y = q.get(0)[1];
		int k = q.get(0)[2];

//		for (int i = 0; i < q.size(); i++) {
//			System.out.print(Arrays.toString(q.get(i)) + " ");
//		}
//		System.out.println("");

		q.remove(0);

		if (arr[x][y] > 2) {
			while (arr[x][y] > 2) {
//				System.out.println(x + "," + y + "에서 손님탑승");
				q2.add(new int[] { x, y, k, 0 });

				int ox = 0, oy = 0;
				for (int i = 0; i < M; i++) {
					if (x == cxy[i][0] - 1 && y == cxy[i][1] - 1) {
						ox = cxy[i][2] - 1;
						oy = cxy[i][3] - 1;
					}
				}
//				System.out.println("ox,oy = " + ox + "," + oy);
				bfs2(ox, oy);

				arr[x][y] = 0;
				visit = new boolean[N][N];
				visit2 = new boolean[N][N];
				q.clear();
				if (q2.isEmpty()) {
					pos = false;
					return;
				}
				x = q2.get(0)[0];
				y = q2.get(0)[1];
				k = q2.get(0)[2];

				if (k == 0) {
//					System.out.println("연료바닥");
					pos = false;
					return;
				}
				q2.clear();
				visit[x][y] = true;
//				System.out.println("다시 택시 출발 " + x + "," + y);
				o++;
				if (o == M) {
//					System.out.println("모든 손님을 태웠습니다.");
//					System.out.println(k);
					result = k;
					return;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
				if (arr[ax][ay] != 1 && !visit[ax][ay]) {
					visit[ax][ay] = true;
					q.add(new int[] { ax, ay, k - 1 });
				}
			}
		}
		bfs(o);
	}

	private static void bfs2(int ox, int oy) {
		if (q2.isEmpty()) {
//			System.out.println("모든 맵 탐색");
			pos = false;
			return;
		}
		if (q2.get(0)[2] < 0) {
//			System.out.println("연료바닥");
			pos = false;
			return;
		}
		int x = q2.get(0)[0];
		int y = q2.get(0)[1];
		int k = q2.get(0)[2];
		int c = q2.get(0)[3];
//		System.out.print("택시태움" + Arrays.toString(q2.get(0)));
//		System.out.println("");

		if (x == ox && y == oy) {
//			System.out.println("목적지 도착 " + x + "," + y);
			k = k + (2 * c);
//			System.out.println("연료충전" + k);
			q2.clear();
			q2.add(new int[] { x, y, k });
			return;
		}
		q2.remove(0);

		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
				if (arr[ax][ay] != 1 && !visit2[ax][ay]) {
					visit2[ax][ay] = true;
					q2.add(new int[] { ax, ay, k - 1, c + 1 });
				}
			}
		}
		bfs2(ox, oy);
	}
}
