import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 배열의 요소 개수
    static int K; // 허용된 홀수의 최대 개수
    static int arr[]; // 입력 정수를 저장하는 배열
    static int max = Integer.MIN_VALUE; // 최대 부분 배열 길이를 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K를 입력으로 받음
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 요소를 입력으로 받음
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; // 현재 부분 배열의 시작 인덱스
        int end = 0;   // 현재 부분 배열의 끝 인덱스
        int odd = 0;   // 현재 부분 배열에 포함된 홀수의 개수

        // 최대 부분 배열 길이를 찾기 위한 슬라이딩 윈도우 알고리즘
        while (start < N) {
            while (end < N && odd <= K) {
                if (arr[end] % 2 != 0) {
                    odd++; // 홀수를 만나면 홀수 개수 증가
                }
                end++;
            }

            // 최대 부분 배열 길이 업데이트
            max = Math.max(max, end - start - odd);

            // 윈도우를 이동하여 시작 인덱스 증가
            if (arr[start] % 2 != 0) {
                odd--; // 현재 부분 배열에서 홀수를 제거하므로 홀수 개수 감소
            }
            start++;
        }

        // 최대 부분 배열 길이 출력
        System.out.println(max);
    }
}