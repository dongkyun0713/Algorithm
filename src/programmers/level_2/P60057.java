package programmers.level_2;

public class P60057 {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                String compare = s.substring(j, Math.min(i + j, s.length())); // 문자열 길이를 초과할 수 있기 때문에 min 사용

                if (prev.equals(compare)) {
                    ++count;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    count = 1;
                    prev = compare;

                }
            }
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
