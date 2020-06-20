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
    static int carry = 0;
    
     public ListNode helper(ListNode l1, int pvl1, ListNode l2, int pvl2){
        if( pvl1 == 0 && pvl2 == 0){
            ListNode ans = new ListNode(0);
            return ans;
        }
        
        if(pvl1 > pvl2){
            //list 1 contributes only
          ListNode ans = helper(l1.next, pvl1-1, l2, pvl2);
           int val = carry + l1.val;
           ListNode myans = new ListNode(val % 10);
           ListNode m = myans;
           myans.next = ans;
            
           carry =  val / 10;
            return m;
        
            
        }else if( pvl2 > pvl1){
            //list 2 contributes only
            ListNode ans = helper(l1, pvl1, l2.next, pvl2-1);
            int val = carry + l2.val;
            ListNode myans = new ListNode(val % 10);
            ListNode m = myans;
            myans.next = ans;
            
            carry =  val / 10;
            return m;
            
        }else{
            ListNode ans = helper(l1.next, pvl1-1, l2.next, pvl2-1);
            int val = carry + l1.val + l2.val;
            System.out.print(carry);
            ListNode myans = new ListNode(val % 10);
            ListNode m = myans;
            myans.next = ans;
            
            carry =  val / 10;
            return m;
        }
        
    }
    
    public int size(ListNode h){
       
        int count =0;
        while(h != null){
            count++;
            h = h.next;
        }
        return count;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        int size1 = size(l1);
        int size2 = size(l2);
        carry =0;
        ListNode ans  = helper(l1, size1, l2, size2);
        
        if(carry == 1){
            ListNode myans = new ListNode(carry);
            ListNode m = myans;
            myans.next = ans;
            ans = myans;
        }
        
       
        ListNode r = ans;
       
        
        while(ans.next.next !=null){
             
            //System.out.print(ans.val+" ");
            
             ans = ans.next;
            
            // System.out.print(ans.val+" ");
        }
       
        ans.next = null;
        return r;
        
    }
}