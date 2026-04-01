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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) {
            return null;
        }
        return sort(lists, 0, lists.length-1);
    }

    private ListNode sort(ListNode[] lists, int s, int e) {
        if(s==e) {
            return lists[e];
        }
        int mid = s + (e-s)/2;
        ListNode left = sort(lists, s, mid);
        ListNode right = sort(lists, mid+1, e);
        return mergeLists(left, right);
    }

    private ListNode mergeLists(ListNode a, ListNode b) {
        if(a==null) {
            return b;
        }
        if(b==null) {
            return a;
        }
        if(a.val < b.val) {
            a.next = mergeLists(a.next, b);
            return a;
        }
        b.next = mergeLists(a, b.next);
        return b;
    }
}
