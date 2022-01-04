package BaekJun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class delivery {
	static boolean answer;
	public static void main(String[] args)  {
        System.out.println(Solution(new int[] {1,2,3,4,5},new int[] {5,4,3,2,1}));
        
	}
   public static Boolean Solution(int[] A, int[] B) {
	      
	      List<Integer>[] graph = new ArrayList[A.length+1];
	      boolean[] isVisit = new boolean[A.length+1];
	      isVisit[0] = true;
	      isVisit[1] = true;
	      
	      for(int i = 0 ; i<A.length+1; i++) {
	         graph[i] = new ArrayList<>();
	      }
	      
	      for(int i = 0;i<A.length;i++) {
	         graph[A[i]].add(B[i]);
	      }
	      
	      dfs(graph, isVisit, 1, 1);
	   
	      return answer;
	      
	   }
   public static void dfs(List<Integer>[] graph, boolean[] isVisit, int now,int start) {
	      if(answer) {
	         return;
	      }
	      for(int next : graph[now]) {
	         
	         if(next == start) {
	            if(checkIsVisit(isVisit)) {
	               answer = true;
	               return;
	            }
	         }
	         
	         if(!isVisit[next]) {
	            isVisit[next] = true;
	            dfs(graph, isVisit, next, start);
	            isVisit[next] = false;
	         }
	         else {
	            continue;
	         }
	      }
	      
	   }
   private static boolean checkIsVisit(boolean[] isVisit) {
	      
	      for(boolean check : isVisit) {
	         if(!check) {
	            return false;
	         }
	      }
	      return true;
	   }
}
