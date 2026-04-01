/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;

        if(head == null || head.next == null || k==1) {
            return head;
        }

        int i = 0;
        while(head!=null) {
            i++;
            if(i%k==0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head= head.next;
            }
        }

        return dummy.next;
        
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode next = null;
        ListNode first = begin.next;
        while(curr!=end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, next = null, prev = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
