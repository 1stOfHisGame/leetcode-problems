/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public ListNode add(ListNode a, ListNode b){
        if(a == null && b == null)
                return null;    
        
            int sum1 = 0;
            if(a != null){
                int aNum = a.val;
                sum1 += aNum;
                a = a.next;
            }
            if(b != null){
                int bNum = b.val;
                sum1 += bNum;
                b = b.next;
            }
            int extra = -1;
            if(sum1 / 10 != 0){
                    extra = sum1/10;
                    sum1 = sum1 % 10;
                }
            if(extra != -1){
                if(a == null)
                    a = new ListNode(extra);
                else a.val += extra;
            }
            ListNode sum = new ListNode(sum1);
            sum.next = add(a,b);
            
        
        return sum;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2);
    }
}
