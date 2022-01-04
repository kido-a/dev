package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloWorld {

	static ArrayList<String> ans = new ArrayList();
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x,y,n;
		String s = br.readLine();
		
		String ss[] = s.split("");
		
		n = Integer.parseInt(br.readLine());
		x = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());

		PowerSet(0,ss,new boolean[s.length()],x,y,n);
		result = (int) (result%(Math.pow(10, 9)+7));
		System.out.println(result);
	}
	private static void PowerSet(int k, String[] s, boolean[] bs, int x, int y, int n) {
		if(k >= bs.length)
		{
			int start = x;
			String sub = "";
			for(int i=0;i<bs.length;i++)
			{
				if(bs[i])
				{
//					System.out.print(s[i]+" ");
					sub = sub + s[i];
					if(s[i].equals("r") && start+1<=n)
						start++;
					else if(s[i].equals("l") && start-1>=0)
						start--;
					else
					{
						break;
					}
					
				}
			}
			if(start == y && !ans.contains(sub) && sub.length()>0)
			{
//				System.out.println("★"+sub);
				ans.add(sub);
				result++;
			}
			return;
		}
		
		bs[k] = true;
		PowerSet(k+1,s,bs, x, y, n);
		bs[k] = false;
		PowerSet(k+1,s,bs, x, y, n);
		
	}

}
