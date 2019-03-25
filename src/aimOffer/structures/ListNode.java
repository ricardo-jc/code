package aimOffer.structures;

public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        ListNode t = this.next;
        int depth = 1;
        while(t != null && depth <= 100) {
            sb.append(" -> ");
            sb.append(t.val);
            t = t.next;
            depth++;
        }
        return sb.toString();
    }
}
