package programmers.level_2;

public class P42860 {
    public static int solution(String name) {
        int answer = 0;
        int length = name.length() -1;
        int count = 0;  //연속되는 A의 개수
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c < 'N') answer += c - 'A';
            else answer += 'Z' - c + 1;

            count = i+1;
            while (count < name.length() && name.charAt(count) == 'A') count++;
            // 순서대로 가는 것과 뒤로 돌아가는 것 비교
            // 현제 온 인덱스로부터 다시 돌아가야 하기 때문에 *2하고 가야할 총 길이 - A의 연속개수를 더해줌
            length = Math.min(length, i * 2 + name.length() - count);
            // 처음부터 뒷부분 먼저 입력하는 것과 비교
            length = Math.min(length, (name.length() - count) * 2 + i);

        }
        return answer + length;
    }

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }
}
