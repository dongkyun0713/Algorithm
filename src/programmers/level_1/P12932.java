package programmers.level_1;

public class P12932 {
    public int[] solution(long n) {
        String[] strArr = String.valueOf(n).split("");
        int[] answer = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            answer[i] = Integer.parseInt(strArr[strArr.length - 1 - i]);
        }

        return answer;
    }
}
