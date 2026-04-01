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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode c;
        if(a==null) {
            return b;
        }
        if(b==null) {
            return a;
        }
        if(a.val < b.val) {
            c = a;
            c.next = merge(a.next, b);
        } else {
            c = b;
            c.next = merge(a,b.next);
        }
        return c;
    }
}