package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        int oneCount = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                pos.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                hasZero = true;
            } else {
                neg.add(num);
            }
        }
        int answer = 0;
        for (int i = 0; i < oneCount; i++) {
            answer++;
        }
        pos.sort(Collections.reverseOrder());
        for (int i = 0; i + 1 < pos.size(); i += 2) {
            answer += pos.get(i) * pos.get(i+1);
        }
        if (pos.size() % 2 != 0) answer += pos.get(pos.size() - 1);

        Collections.sort(neg);

        for (int i = 0; i + 1 < neg.size(); i += 2) {
            answer += neg.get(i) * neg.get(i+1);
        }
        if (neg.size() % 2 != 0) {
            if (!hasZero) answer += neg.get(neg.size() - 1);
        }
        System.out.println(answer);

    }
}
