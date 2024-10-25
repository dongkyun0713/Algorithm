package leetcode;

// 연결리스트가 팰린드롬 구조인지 판별하는 클래스
// 입력 : 1 -> 2 -> 3 -> 2 -> 1
// 출력 : true
public class PalindromeLinkedList {

    // 주어진 연결리스트가 팰린드롬인지 여부를 판별하는 메소드
    public static boolean isPalindrome(ListNode head) {
        // 빈 연결리스트나 단일 노드일 경우 팰린드롬으로 간주
        if (head == null || head.next == null)
            return true;

        // 중간 지점을 찾기 위한 두 개의 포인터 설정
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 중간을 기준으로 뒷부분을 역순으로 만들기
        ListNode reversedHalf = ReverseLinkedList.reverseLinkedList(slow.next);

        // 원래 연결리스트의 앞부분과 역순으로 만든 뒷부분을 비교
        while (reversedHalf != null) {
            if (head.val != reversedHalf.val)
                return false;
            head = head.next;
            reversedHalf = reversedHalf.next;
        }
        return true;
    }
}