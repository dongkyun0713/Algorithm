package leetcode;

// 문제 : 연결리스트를뒤집어라.
// 입력 : 1 -> 2 -> 3 -> 4 -> 5 -> 6
// 출력 : 6 -> 5 -> 4 -> 3 -> 2 -> 1
public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
