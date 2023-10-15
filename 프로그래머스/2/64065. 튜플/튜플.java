import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

class Solution {
    public int[] solution(String s) {
		int[] answer = {};
		ArrayList<Integer> arr = new ArrayList<>();
        s = s.substring(2, s.length()-2);
        String[] str = s.split("\\},\\{");
        
        Arrays.sort(str, (o1, o2) -> {
            return Integer.compare(o1.length(), o2.length());
        });
        
        // Arrays.sort(str, new Comparator<String>(){
        // 	public int compare(String o1, String o2) {
        // 		return Integer.compare(o1.length(), o2.length());
        // 	}
        // });
        
        for(String x : str) {
        	String[] temp = x.split(",");
        	for(int i=0; i<temp.length; i++) {
        		int n = Integer.parseInt(temp[i]);
        		if(!arr.contains(n))
        			arr.add(n);
        	}
        }
        answer = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++) {
        	answer[i] = arr.get(i);
        }
        
        return answer;
    }
}