package leetcode;
// 정렬되어 있는 두 연결리스트를 합쳐라.
//입력 :  1 -> 2 -> 5
//       1 -> 3 -> 4
// 출력 : 1 -> 1 -> 2 -> 3 -> 4 -> 5
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;

        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
