package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AC {
	static int error;
	static int Size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int T=0; T<test;T++)
		{
			Deque<String> dq = new ArrayDeque<>();
			error=0;
			boolean dis=true;
			String oper = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			String[] sArray = s.substring(1,s.length()-1).split(",");
			for(int i=0;i<N;i++)
			{
				dq.add(sArray[i]);
			}
			
//			System.out.println(Arrays.toString(sArray));
			for(int i=0;i<oper.length();i++)
			{				
				if(oper.charAt(i)=='R')
				{
					dis = reverse(dis);
				}
				else
				{
					delete(dq,dis);
				}
			}
			int Size = dq.size();
			if(error==1)
				System.out.println("error");
			else
			{
				System.out.print("[");
				for(int i=0;i<Size;i++)
				{
					if(i==Size-1)
					{
						System.out.print(dq.peek());
					}
					else
					{
						if(dis)
							System.out.print(dq.remove()+",");
						else
						{
							System.out.print(dq.removeLast()+",");					
						}
					}
				}
				System.out.println("]");
			}
		}

	}

	private static void delete(Deque<String> dq, boolean dis) {
		if(dq.size()==0)
		{
			error=1;
			return;
		}
		
		if(dis)
		{
			dq.remove();
//			System.out.println("처음 삭제");
		}
		else
		{
			dq.removeLast();
//			System.out.println("마지막 삭제");
		}
	}

	private static boolean reverse(boolean dis) {
		
		if(dis)
		{
			dis=false;
			return dis;
		}
		else
		{
			dis=true;
			return dis;
		}
	}

}
