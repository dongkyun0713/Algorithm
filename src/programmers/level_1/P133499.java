package programmers.level_1;

public class P133499 { // "aya", "ye", "woo", "ma"
    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            s = s.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            s = s.replaceAll("aya|ye|woo|ma", "");
            if (s.equals(""))
                answer++;
        }
        return answer;
    }
}
