package chapter8;

import java.math.BigInteger;

// 문제 : 역순으로 저장된 연결리스트의 숫자를 더하라.
// 입력 : (2 -> 4 -> 3) + ( 5 -> 6 ->2)
// 출력 : 7 -> 0 -> 6
// 설명 : 342 + 265 = 607
public class AddTwoNumbers {


    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        int carry = 0;

        while (list1 != null || list2 != null) {
            int sum = carry;

            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            carry = sum / 10;
            sum %= 10;

            current.next = new ListNode(sum);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return listNode.next;
    }
}
