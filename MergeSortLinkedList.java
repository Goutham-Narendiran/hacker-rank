package com.interview.array;

class LLNode{
	int data;
	LLNode next;
	public LLNode(int data){
		this.data = data;
		this.next = null;
	}
}

class NodePair{
	LLNode a;
	LLNode b;

	public NodePair(){
		a = null;
		b = null;
	}
}
public class MergeSortLinkedList {
	public static void main(String[] args) {
		LLNode head = null;
		head = new LLNode(2);
		head.next = new LLNode(3);
		head.next.next = new LLNode(20);
		head.next.next.next = new LLNode(5);
		head.next.next.next.next = new LLNode(10);
		head.next.next.next.next.next = new LLNode(15);

		MergeSort(head);

		print(head);
	}

	private static void print(LLNode head) {
		// TODO Auto-generated method stub
		if(head == null)
		{
			System.out.println("Enpty List");
			return;
		}
		LLNode tem = head;
		while(tem!=null)
		{
			System.out.print(tem.data+"->");
			tem = tem.next;
		}

	}

	private static void MergeSort(LLNode head) {
		// TODO Auto-generated method stub
		LLNode headref = head;
		NodePair p = new NodePair();

		if(headref == null || headref.next == null)
			return;

		Split(headref,p);

		MergeSort(p.a);
		MergeSort(p.b);
		head = SortedMerge(p.a,p.b);
	}

	private static LLNode SortedMerge(LLNode a, LLNode b) {
		// TODO Auto-generated method stub
		LLNode result = null;
		if(a == null)
			return b;
		if(b == null)
			return a;

		if(a.data <= b.data){
			result = a;
			result.next = SortedMerge(a.next,b);
		}
		else{
			result = b;
			result.next = SortedMerge(a,b.next);
		}

		return result;
	}

	private static void Split(LLNode source,NodePair p) {
		// TODO Auto-generated method stub
		LLNode slow = null;
		LLNode fast = null;

		if(source == null || source.next == null){
			p.a = source;
			p.b = null;
		}

		else{
			slow = source;
			fast = source.next;

			while(fast!=null){
				fast = fast.next;
				if(fast!=null){
					slow = slow.next;
					fast = fast.next;
				}
			}

			p.a = source;
			p.b = slow.next;
			slow.next = null;
		}
	}
}
