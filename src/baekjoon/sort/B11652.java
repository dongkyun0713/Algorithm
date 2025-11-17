package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list);

        long bestNum = list.get(0);
        int bestCnt = 1;

        long curNum = list.get(0);
        int curCnt = 1;

        for (int i = 1; i < N; i++) {
            if (list.get(i) == curNum) {
                ++curCnt;
            } else {
                if (curCnt > bestCnt) {
                    bestCnt = curCnt;
                    bestNum = curNum;
                }
                curNum = list.get(i);
                curCnt = 1;
            }
        }
        if (curCnt > bestCnt) {
            bestNum = curNum;
        }
        System.out.println(bestNum);
    }
}
