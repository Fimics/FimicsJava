package data3.structre.b链表;

public class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
	 @Override
	public String toString() {
		return val + " -> " + next;
	}
}
