package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P72411 {
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 메뉴 조합을 카운트하는 Map
        Map<String, Integer> map = new HashMap<>();

        // 주문에 대해 조합을 구하고 카운트
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);  // 알파벳 순으로 정렬
            String sortedOrder = new String(chars);  // 정렬된 주문 문자열

            // 각 course 크기별로 가능한 모든 조합을 찾는다
            for (int size : course) {
                if (sortedOrder.length() < size) continue;  // 메뉴 조합이 너무 적으면 건너뛰기
                findCombinations(sortedOrder, size, 0, "", map);  // 조합 생성 후 카운팅
            }
        }

        // 각 course 크기별로 가장 많이 등장한 조합을 찾아서 리스트에 추가
        for (int size : course) {
            int maxCount = 0;
            for (String key : map.keySet()) {
                if (key.length() == size) {
                    maxCount = Math.max(maxCount, map.get(key));  // 최대 등장 횟수 찾기
                }
            }

            // 최대 등장 횟수와 일치하는 모든 조합을 answerList에 추가
            for (String key : map.keySet()) {
                if (key.length() == size && map.get(key) == maxCount && maxCount > 1) {
                    answerList.add(key);  // 1번 이하로 등장한 조합은 제외
                }
            }
        }

        // 결과를 알파벳 순으로 정렬하고 배열로 변환
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    // 조합을 구하는 재귀 함수
    private void findCombinations(String order, int size, int start, String current, Map<String, Integer> map) {
        if (current.length() == size) {  // 조합이 완료되면
            map.put(current, map.getOrDefault(current, 0) + 1);  // 등장 횟수 카운트
            return;
        }

        // 가능한 모든 조합을 만들기 위해 재귀 호출
        for (int i = start; i < order.length(); i++) {
            findCombinations(order, size, i + 1, current + order.charAt(i), map);
        }
    }
}

