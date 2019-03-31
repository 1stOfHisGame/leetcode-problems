/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        // stack for remembering index of previous lesser nodes
        Stack<Integer> stackI = new Stack<Integer>();
        
        // array for inserting closest max
        int[] arr = new int[10000];
        
        // input list array for fast access
        int[] arrList = new int[10000];
        
        ListNode q = head;
        int count = 0;
        
        while(q != null){
            arrList[count] = q.val;
            if(stackI.empty()) { stackI.push(count);}
            else {
                while(!stackI.empty() && arrList[stackI.peek()] < q.val){
                    arr[stackI.pop()] = q.val;
                }
                stackI.push(count);
            }
            count++;
            q = q.next;
        }
        
        return Arrays.copyOfRange(arr,0,count);
    }
}
