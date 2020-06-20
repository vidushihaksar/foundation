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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode(0);
        ListNode answer = ans;
        int carry = 0, a= 0, b=0, s=0;
        
        while(l1 != null || l2 != null ){
            s = carry;
            
            if(l1 != null){
                  s += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null){
                s += l2.val;
                l2 = l2.next;
            }
            
            
            System.out.println(s);
            answer.next = new ListNode(s % 10);
            answer = answer.next;
            carry = s / 10;
            
        }
        
        if(carry == 1){
            answer.next = new ListNode(carry);
            answer = answer.next;
        }
        return ans.next;
        
    }
}