package level_1;
    /* import java.util.*;
    public static int solution(int[] ingredient) {   //처음 풀었던 코드.. 시간 초과로 오류남
        String str = Arrays.toString(ingredient);
        str = str.substring(1, str.length() - 1).replace(", ", "");  //  정수형 배열을 문자열로 변환

        int count = 0;
        while (str.contains("1231")) {
            count++;
            str = str.replaceFirst("1231", "");
            }

        return count;
    } */

import java.util.Arrays;

public class P133502 {

    public static int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);

            if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) { // sb가 1231이면
                answer++;
                sb.delete(sb.length() - 4, sb.length()); // 햄버거 잘라내기
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(arr));
    }
}