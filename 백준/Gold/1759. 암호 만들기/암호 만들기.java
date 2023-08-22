import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] m = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static char[] nums;
    static int l, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        nums = new char[l];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        combi(0, 0);

        System.out.println(sb);
    }

    static void combi(int depth, int start){
        if(depth == l){
            if(check(nums)){
                for(char c : nums){
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i < c; i++){
            nums[depth] = arr[i];
            combi(depth+1, i+1);
        }
    }

    static boolean check(char[] nums){
        int cnt = 0;
        for(int i=0; i<l; i++){
            for(int j=0; j<5; j++){
                if(nums[i] == m[j]){
                    cnt++;
                    break;
                }
            }
        }

        if(cnt >= 1 && (l-cnt) >= 2){ //모음이 1개 이상 && 자음이 2개 이상
            return true;
        }
        return false;
    }
}