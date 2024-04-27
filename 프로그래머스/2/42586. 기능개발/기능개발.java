import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[100];
        int cnt = 0;
        int day = 0;
        
        for(int i=0; i<progresses.length; i++) {
        	while(progresses[i] + speeds[i]*day < 100) {
        		day++;
        	}
        	temp[day]++;
        }
        
        for(int n : temp) {
        	if(n != 0)
        		cnt++;
        }
        
        int[] answer = new int[cnt];
        
        cnt = 0;
        for(int n : temp) {
        	if(n != 0) {
        		answer[cnt++] = n;
        	}
        }
        
        return answer;
    }
}