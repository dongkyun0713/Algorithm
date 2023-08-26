package level_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2745 {
    // 10진수 변환 방법
    // 각 자리의 10진수 숫자 * 진수의 각 자리수 제곱을 모두 더한 값

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int i =0; i < n.length();i++) {
            int c = n.charAt(n.length()-1-i)-55;  //   아스키코드에서 A의 값은 65, 때문에 55를 빼주면 A가 10부터 시작함
            if(c < 10) c += 7;  // 10 미만의 자연수는 48을 빼줘야됨, 55를 이미 빼줬기 때문에 7 더하기

            result += (int) (c * Math.pow(b, i));
        }
        System.out.println(result);
    }
}
