import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int m = Integer.parseInt(br.readLine());  // 연산 수
      Set<Integer> set = new HashSet<>(); // 중복 허용 X
      
      for (int i = 0; i < m; i++) {
    	 StringTokenizer st = new StringTokenizer(br.readLine());
         String cal = st.nextToken();
         int x = 0;
         
         switch (cal) {
            case "add" :
               x = Integer.parseInt(st.nextToken());
               set.add(x);
               break;   
            case "remove" :
               x = Integer.parseInt(st.nextToken());
               set.remove(x);
               break;
            case "check" :
               x = Integer.parseInt(st.nextToken());
               if (set.contains(x))
                  sb.append("1\n");
               else
                  sb.append("0\n");
               break;
            case "toggle" :
               x = Integer.parseInt(st.nextToken());
               if (set.contains(x))
                  set.remove(x);
               else
                  set.add(x);
               break;   
            case "all" :
               for (int k = 0; k < 20; k++) {
                  set.add(k + 1);
               }
               break;
            case "empty" :
               set.clear();
               break;               
         }
      }

      System.out.print(sb);
      }
}