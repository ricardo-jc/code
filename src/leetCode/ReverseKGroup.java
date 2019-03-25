package leetCode;

import aimOffer.structures.ListNode;

//25 https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode tail = head;
        for(int i = 0; i < k; i++) {
            if(tail == null) return head;
            tail = tail.next;
        }
        ListNode p = pre.next;
        pre.next = tail;
        while(p != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        head.next = reverseKGroup(head.next, k);
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        System.out.println(reverseKGroup.reverseKGroup(head, 3));
    }
}
