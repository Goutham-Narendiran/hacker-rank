package com.interview.array;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinaryTreeDiameter {
	private static int height;
public static int diameterTree(Node root){
	int lh =0,rh=0,ldia=0,rdia =0;

	if(root == null){
		//height = 0;
		return 0;
	}

	lh = height(root.left);
	rh = height(root.right);
	ldia = diameterTree(root.left);
	rdia = diameterTree(root.right);
    	
	//height = Math.max(lh, rh) + 1;
	
	return Math.max(lh+rh+1,Math.max(ldia, rdia));
} 

public static int height(Node node){
	if(node == null)
		return 0;
	else
		return 1+Math.max(height(node.left),height(node.right));
}

public static void main(String...args){
	Node root = new Node(2);
	root.left = new Node(1);
	root.right = new Node(1);
	root.left.left = new Node(1);
	root.left.right = new Node(1);
	root.left.right.left = new Node(1);
	root.left.right.left.left = new Node(1);
	System.out.println(diameterTree(root));
}
}
