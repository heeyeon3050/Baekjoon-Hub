import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new List[n];
        visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i != j && computers[i][j] == 1){
                    list[i].add(j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visit[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int num){
        visit[num] = true;
        
        for(int i=0; i<list[num].size(); i++){
            int x = list[num].get(i);
            
            if(!visit[x])
                dfs(x);
        }
    }
}