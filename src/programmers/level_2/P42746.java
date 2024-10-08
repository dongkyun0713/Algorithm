package level_2;

import java.util.Arrays;
import java.util.Comparator;

public class P42746 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};

        System.out.println(solution(arr));
    }

    public static class digitComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);  // ex) 3과 34가 있을 때, 334와 343을 비교
        }
    }
        public static String solution(int[] numbers) {
            StringBuilder answer = new StringBuilder();

            String[] s = new String[numbers.length];

            for (int i = 0; i < s.length; i++) {
                s[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(s, new digitComparator());

            if (s[0].equals("0")) {  // [0,0,0...] 일 경우 0 반환
                return "0";
            }

            for (String str : s) {
                answer.append(str);
            }

            return answer.toString();
        }
}
