package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Diet {
	static int mp, mf, ms, mv, N, min = Integer.MAX_VALUE;
	static int[][] pfsv;
	static boolean[] visit;
	static ArrayList<Integer> list;
	static ArrayList<int[]> resultList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		mp = Integer.parseInt(s[0]);
		mf = Integer.parseInt(s[1]);
		ms = Integer.parseInt(s[2]);
		mv = Integer.parseInt(s[3]);
		pfsv = new int[N][5];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				pfsv[i][j] = Integer.parseInt(s[j]);
			}
		}
//		for(int i=0;i<N;i++)
//		{
//			System.out.println(Arrays.toString(pfsv[i]));
//		}
		list = new ArrayList();
		resultList = new ArrayList();
		for (int i = 0; i < N; i++) {
			dfs(0, 0, 0, 0, 0, i);
			list.remove(Integer.valueOf(i));
		}
		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else {
			System.out.println(min);
			for (int i = 0; i < resultList.get(0).length; i++) {
				System.out.print(resultList.get(0)[i] + 1 + " ");
			}
		}
	}

	private static void dfs(int sp, int sf, int ss, int sv, int sprice, int idx) {
		if (idx >= N)
			return;

//		System.out.println(idx+"번 선택");
		sp += pfsv[idx][0];
		sf += pfsv[idx][1];
		ss += pfsv[idx][2];
		sv += pfsv[idx][3];
		sprice += pfsv[idx][4];
		list.add(idx);

		if (sp >= mp && sf >= mf && ss >= ms && sv >= mv) {
//			System.out.println("가격:"+sprice);
//			System.out.println("선택한 음식"+list);

			if (min > sprice) {
				resultList = new ArrayList();
				min = sprice;
				int[] temp = new int[list.size()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = list.get(i);
				}
				resultList.add(temp);
			} else if (min == sprice) {
				min = sprice;
				int[] temp = new int[list.size()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = list.get(i);
				}
				resultList.add(temp);
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			dfs(sp, sf, ss, sv, sprice, i + 1);
			list.remove(Integer.valueOf(i + 1));
		}
	}

}
