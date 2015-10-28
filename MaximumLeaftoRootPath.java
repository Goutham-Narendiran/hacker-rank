package com.interview.array;

public class MaximumLeaftoRootPath {
	
	static Node targetLeaf;
	static int maxSum = 0;
	public static void getTargetLeaf(Node node,int currSum){
		if(node == null)
			return;
		currSum+= node.data;
		//leafCondition
		if(node.left==null&&node.right==null){
			if(currSum>=maxSum){
				targetLeaf = node;
				maxSum = currSum;
			}
		}
		
		getTargetLeaf(node.left,currSum);
		getTargetLeaf(node.right,currSum);
	}
	
	public static boolean printPath(Node node){
		if(node == null) return false;
		if(node == targetLeaf || printPath(node.left)||printPath(node.right))
		{
			System.out.print(node.data+" ");
			return true;
		}
		return false;
	}
	public static void main(String...args){
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(100);
		root.left.left = new Node(1);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.left.right.left.left = new Node(6);
		getTargetLeaf(root,0);
		printPath(root);
	}
}
