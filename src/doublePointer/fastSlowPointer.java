package doublePointer;
/*
 * 快慢指针类型问题
 */
public class fastSlowPointer {
	
	
	/*
	 * 1 判断链表中是否有环
	 */
	public static boolean detectCycle(ListNode head) {
		ListNode fastListNode=head;
		ListNode slowListNode=head;
		
		while (fastListNode!=null&&fastListNode.next!=null) {
			fastListNode=fastListNode.next.next;
			slowListNode=slowListNode.next;
			if (fastListNode==slowListNode) return true;			
		}
		return false;
	}
	
	
	/*
	 * 2、已知链表中含有环，返回这个环的起始位置
	 */
	public static ListNode findCycleFirstNode(ListNode head) {
		//创建一个快指针和慢指针
		ListNode fastListNode=head;
		ListNode slowListNode=head;
		//找到listnode中的环
		while (fastListNode!=null&&slowListNode.next!=null) {
			fastListNode=fastListNode.next.next;
			slowListNode=slowListNode.next;
			if (fastListNode==slowListNode) break;
			
		}
		//找到环之后寻找起点
		slowListNode=head;
		while (slowListNode!=fastListNode) {
			fastListNode=fastListNode.next;
			slowListNode=slowListNode.next;
		}
		return slowListNode;
	}
	
	
	/*
	 * 4、寻找链表的倒数第 k 个元素
	 */
	public static ListNode findKNode(ListNode head,int k) {
		ListNode fastListNode=head;
		ListNode slowListNode=head;
		//让fastNode先走k步
		while (k-->0) {
			fastListNode=fastListNode.next;			
		}
		//fastNode先走完k步之后 slowNode开始走
		while (fastListNode!=null) {
			slowListNode=slowListNode;
			fastListNode=fastListNode.next;
			
		}
		return slowListNode;
	}
	
	
	
	
	public static void main(String[] args) {
		
	}
}



class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}