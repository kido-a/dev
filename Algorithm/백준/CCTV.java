package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CCTV {
	static int N, M;
	static int[][] room;
	static int[][] visit;
	static ArrayList<int[]> list;
	static int result = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		room = new int[N][M];
		visit = new int[N][M];
		list = new ArrayList();

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(s[j]);
				if (room[i][j] != 0 && room[i][j] != 6) {
					list.add(new int[] { i, j });
				}
			}
		}
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int cctv) {
		if (cctv == list.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (room[i][j] == 0) {
						cnt++;
					}
				}
			}
			result = Math.min(result, cnt);
//			for (int j1 = 0; j1 < N; j1++) {
//				System.out.println(Arrays.toString(room[j1]));
//			}
//			System.out.println();
//			for (int j1 = 0; j1 < N; j1++) {
//				System.out.println(Arrays.toString(visit[j1]));
//			}
//			System.out.println("====");
			return;
		}

		int x = list.get(cctv)[0];
		int y = list.get(cctv)[1];

		if (room[x][y] == 1) {
			for (int i = 0; i < 4; i++) {
				check(x, y, i, 9);
				dfs(cctv + 1);
				check(x, y, i, 0);
			}
		} else if (room[x][y] == 2) {
			for (int i = 0; i < 3; i = i + 2) {
				check2(x, y, i, 9);
				dfs(cctv + 1);
				check2(x, y, i, 0);
			}
		} else if (room[x][y] == 3) {
			for (int i = 0; i < 2; i++) {
				check3(x, y, i, 2, 9);
				dfs(cctv + 1);
				check3(x, y, i, 2, 0);
				check3(x, y, i, 3, 9);
				dfs(cctv + 1);
				check3(x, y, i, 3, 0);
			}
		} else if (room[x][y] == 4) {
			for (int i = 0; i < 4; i++) {
				check4(x, y, i, 9);
				dfs(cctv + 1);
				check4(x, y, i, 0);
			}
		} else if (room[x][y] == 5) {
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
					if (room[ax][ay] != 0 && room[ax][ay] != 6) {
						ax = ax + dx[i];
						ay = ay + dy[i];
						continue;
					}
					if (room[ax][ay] == 6)
						break;
					if (room[ax][ay] == 0) {
						visit[ax][ay]++;
						room[ax][ay] = 9;
					}

					ax = ax + dx[i];
					ay = ay + dy[i];
				}
			}
			dfs(cctv + 1);
		}

	}

	private static void check4(int x, int y, int i, int j) {
		for (int a = 0; a < 3; a++) {
			int k = i + a;
			if (k > 3)
				k = k - 4;
//			System.out.println("k값"+k);
			int ax = x + dx[k];
			int ay = y + dy[k];
			while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
				if (j == 9) {
					if (room[ax][ay] == 6)
						break;
					if (room[ax][ay] == 0 || room[ax][ay] == 9) {
						room[ax][ay] = j;
						visit[ax][ay]++;
					} else if (room[ax][ay] != 0 && room[ax][ay] != 6) {
						ax = ax + dx[k];
						ay = ay + dy[k];
						continue;
					}

				} else if (j == 0) {
					visit[ax][ay]--;
					if (room[ax][ay] != 9 && room[ax][ay] != 6) {
						ax = ax + dx[k];
						ay = ay + dy[k];
						continue;
					}
					if (room[ax][ay] == 6)
						break;
					if (room[ax][ay] == 9 && visit[ax][ay] == 0) {
						room[ax][ay] = j;
					}
				}
				ax = ax + dx[k];
				ay = ay + dy[k];
			}
		}
	}

	private static void check3(int x, int y, int i, int k, int j) {
		int ax = x + dx[i];
		int ay = y + dy[i];
		while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
			if (j == 0) {
				visit[ax][ay]--;
				if (room[ax][ay] != 9 && room[ax][ay] != 6) {
					ax = ax + dx[i];
					ay = ay + dy[i];
					continue;
				}
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 9 && visit[ax][ay] == 0) {
					room[ax][ay] = j;
				}
				ax = ax + dx[i];
				ay = ay + dy[i];
			} else {
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 0 || room[ax][ay] == 9) {
					room[ax][ay] = j;
					visit[ax][ay]++;
				} else if (room[ax][ay] != 0 && room[ax][ay] != 6) {
					ax = ax + dx[i];
					ay = ay + dy[i];
					continue;
				}
				ax = ax + dx[i];
				ay = ay + dy[i];
			}
		}

		ax = x + dx[k];
		ay = y + dy[k];

		while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
			if (j == 0) {
				visit[ax][ay]--;
				if (room[ax][ay] != 9 && room[ax][ay] != 6) {
					ax = ax + dx[k];
					ay = ay + dy[k];
					continue;
				}
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 9 && visit[ax][ay] == 0) {
					room[ax][ay] = j;
				}
				ax = ax + dx[k];
				ay = ay + dy[k];
			} else {
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 0 || room[ax][ay] == 9) {
					room[ax][ay] = 9;
					visit[ax][ay]++;
				} else if (room[ax][ay] != 0 && room[ax][ay] != 6) {
					ax = ax + dx[k];
					ay = ay + dy[k];
					continue;
				}

				ax = ax + dx[k];
				ay = ay + dy[k];
			}
		}

	}

	private static void check2(int x, int y, int i, int j) {

		int ax = x + dx[i];
		int ay = y + dy[i];

		while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
			if (j == 0) {
				visit[ax][ay]--;
				if (room[ax][ay] != 9 && room[ax][ay] != 6) {
					ax = ax + dx[i];
					ay = ay + dy[i];
					continue;
				}
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 9 && visit[ax][ay] == 0) {
					room[ax][ay] = j;
				}
				ax = ax + dx[i];
				ay = ay + dy[i];
			} else {
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 0 || room[ax][ay] == 9) {
					room[ax][ay] = j;
					visit[ax][ay]++;
				} else if (room[ax][ay] != 0 && room[ax][ay] != 6) {
					ax = ax + dx[i];
					ay = ay + dy[i];
					continue;
				}

				ax = ax + dx[i];
				ay = ay + dy[i];
			}
		}
		ax = x + dx[i + 1];
		ay = y + dy[i + 1];

		while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
			if (j == 0) {
				visit[ax][ay]--;
				if (room[ax][ay] != 9 && room[ax][ay] != 6) {
					ax = ax + dx[i + 1];
					ay = ay + dy[i + 1];
					continue;
				}
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 9 && visit[ax][ay] == 0) {
					room[ax][ay] = j;
				}
				ax = ax + dx[i + 1];
				ay = ay + dy[i + 1];
			} else {
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 0 || room[ax][ay] == 9) {
					visit[ax][ay]++;
					room[ax][ay] = 9;
				} else if (room[ax][ay] != 0 && room[ax][ay] != 6) {
					ax = ax + dx[i + 1];
					ay = ay + dy[i + 1];
					continue;
				}

				ax = ax + dx[i + 1];
				ay = ay + dy[i + 1];
			}
		}

	}

	private static void check(int x, int y, int i, int j) {
		int ax = x + dx[i];
		int ay = y + dy[i];
		while (ax >= 0 && ax < N && ay >= 0 && ay < M) {
			if (j == 9) {
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 0 || room[ax][ay] == 9) {
					room[ax][ay] = j;
					visit[ax][ay]++;
				} else if (room[ax][ay] != 0 && room[ax][ay] != 6) {
					ax = ax + dx[i];
					ay = ay + dy[i];
					continue;
				}

			} else if (j == 0) {
				visit[ax][ay]--;
				if (room[ax][ay] != 9 && room[ax][ay] != 6) {
					ax = ax + dx[i];
					ay = ay + dy[i];
					continue;
				}
				if (room[ax][ay] == 6)
					break;
				if (room[ax][ay] == 9 && visit[ax][ay] == 0) {
					room[ax][ay] = j;
				}
			}
			ax = ax + dx[i];
			ay = ay + dy[i];
		}
	}

}
