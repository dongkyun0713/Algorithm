package programmers.level_0;

public class P181938 {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        int answer = Integer.parseInt(sb.toString());
        if(answer >= 2 * a * b) return answer;
        else return 2 * a * b;
    }
}
