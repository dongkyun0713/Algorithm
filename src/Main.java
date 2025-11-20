import java.io.*;
import java.util.*;

public class Main {
    static int N, R;
    static char[] A;
    static List<Character> selected = new ArrayList<>();
    static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static void DFS() throws IOException {
        if (selected.size() == R) {        // R개의 항목을 선택했으면
            for (char ch : selected) wr.write(ch); // 선택한 조합을 출력하고
            wr.write(' ');                           // 리턴
            return;
        }
        for (char ch : A) // 주어진 알파벳 각각에 대해서 반복
            if (!selected.contains(ch)) { // 이 알파벳을 아직 선택하지 않았다면
                selected.add(ch); // 이 알파벳을 선택하고
                DFS();             // 재귀호출
                selected.remove(selected.size() - 1);    // ch를 selected 목록에서 제거
            }
    }

    public static void main(String[] args) throws IOException {
        N = 4; R = 3;
        A = new char[] {'A', 'B', 'C', 'D'};
        DFS();
        wr.close();
    }
}
