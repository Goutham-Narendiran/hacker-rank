package com.interview.array;

class Height{
	int height;
	public Height(int h){
		this.height = h;
	}
}
public class isHeightBalancedBinaryTree {
public static void main(String...args){
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.left.right.left = new Node(6);
	root.left.right.left.left = new Node(7);
	System.out.println(isBalanced(root,new Height(0)));
}
private static boolean isBalanced(Node root,Height h) {
	// TODO Auto-generated method stub
	Height lh = new Height(0);
	Height rh = new Height(0);
	boolean l = false;
	boolean r = false;
	
	if(root==null){
		h.height =0;
		return true;
	}
	l = isBalanced(root.left,lh);
	r = isBalanced(root.right,rh);
	
	h.height = 1+ Math.max(lh.height,rh.height);
	
	if(Math.abs(lh.height-rh.height)>2)
		return false;
	
	else
		return l&&r;
}
}
