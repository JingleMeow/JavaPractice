public class Solution {
  public ListNode quickSort(ListNode head) {
    return quickSort(head, null);
  }

  public ListNode quickSort(ListNode head, ListNode head2) {
    if (head == null)
      return head2;
    
    ListNode dummyHead = new ListNode(0);
    ListNode smallTail = dummyHead;
    ListNode pivot = head;
    ListNode prev = pivot, curr = prev.next;
    while (curr != null) {
      if (curr.value < pivot.value) {
        prev.next = curr.next;
        curr.next = null;
        smallTail.next = curr;
        smallTail = curr;
        curr = prev.next;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }

    pivot.next = quickSort(pivot.next, head2);
    return quickSort(dummyHead.next, pivot);
  }
}
