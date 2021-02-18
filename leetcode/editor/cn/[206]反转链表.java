//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode last = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
        ListNode pre;
        ListNode cur;
        ListNode next;
        cur = next = head;
        pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode temp;

    public ListNode reverseN(ListNode head, int m) {
        if (m == 1) {
            temp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, m - 1);
        head.next.next = head;
        head.next = temp;
        return last;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
