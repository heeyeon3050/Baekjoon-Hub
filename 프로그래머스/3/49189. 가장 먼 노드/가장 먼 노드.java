import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visit = new boolean[n+1];
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {1, 0});
        visit[1] = true;
        int maxDepth = 0;
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int v = arr[0];
            int depth = arr[1];
            
            if(maxDepth == depth) answer++;
            else if(maxDepth < depth){
                maxDepth = depth;
                answer = 1;
            }
            
            int size = graph.get(v).size();
            for(int i=0; i<size; i++){
                int w = graph.get(v).get(i);
                if(!visit[w]){
                    queue.add(new int[] {w, depth+1});
                    visit[w] = true;
                }
            }
        }
        
        return answer;
    }
}