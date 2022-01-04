package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hw_20210316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int L = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		char[] arr = new char[C];
		
		s = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s[i].charAt(0);
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		permutation(arr,0,new char[L],new boolean[C]);
	}

	private static void permutation(char[] arr, int k, char[] sel, boolean[] visit) {
		if(k==sel.length)
		{
			int cnt=0;
			int cnt2=0;
			for(int i=0;i<sel.length;i++)
			{
				if(sel[i]=='a' || sel[i] == 'e' || sel[i]=='i' || sel[i]=='o' || sel[i]=='u')
				{
					cnt++;
				}
				if(sel[i]!='a' && sel[i] != 'e' && sel[i]!='i' && sel[i]!='o' && sel[i]!='u')
				{
					cnt2++;
				}
			}
			if(cnt==0)
			{
				return;
			}
			if(cnt2<2)
			{
				return;
			}
			
			if(sel.length==3)
			{
				cnt=0;
				
				for(int i=0;i<sel.length;i++)
				{
					if(sel[i]=='a' || sel[i] == 'e' || sel[i]=='i' || sel[i]=='o' || sel[i]=='u')
					{
						cnt++;
					}
				}
				if(cnt==2)
				{
					return;
				}
			}
			for(int i=0;i<sel.length;i++)
			{
				System.out.print(sel[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(!visit[i])
			{
				if(k>0)
				{
					if((int)sel[k-1] > (int)arr[i])
					{
						continue;
					}
				}
				visit[i]=true;
				sel[k] = arr[i];
				permutation(arr,k+1,sel,visit);
				visit[i]=false;
			}
		}
		
	}

}
