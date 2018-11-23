package aimOffer;

public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(this.val));
        ListNode t = this.next;
        while(t != null) {
            sb.append(" -> ");
            sb.append(String.valueOf(t.val));
            t = t.next;
        }
        return sb.toString();
    }
}
