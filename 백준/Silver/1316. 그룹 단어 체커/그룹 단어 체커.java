import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {  
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int cnt = 0;
    
    for(int i=0; i<N; i++){
      String str = br.readLine();
      if(fun(str))
        cnt++;
    }

    System.out.println(cnt);
  }

  public static boolean fun(String str){
    char now = str.charAt(0);
    boolean check[] = new boolean[26];
    check[str.charAt(0) - 'a'] = true;

    for(int i=0; i<str.length(); i++){
      if(str.charAt(i) != now){
        if(check[str.charAt(i) -'a'])
          return false;
        else{
          check[str.charAt(i) - 'a'] = true;
          now = str.charAt(i);
        }
      }
      else
        continue;
    }
    return true;
  }
}