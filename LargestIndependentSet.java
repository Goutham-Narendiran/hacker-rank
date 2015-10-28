package com.interview.array;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	int liss;
	TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
		liss = 0;
	}
}
public class LargestIndependentSet {
	
	public static int Liss(TreeNode root){
		if(root==null)
			return 0;
		if(root.liss!=0)
			return root.liss;
		if(root.left==null && root.right==null)
			return (root.liss=1);
		
		//Calculating liss excluding the current node
		int liss_excl = Liss(root.left) + Liss(root.right);
		
		//Calculating the liss including the current node
		int liss_inc = 1;
		if(root.left!=null)
			liss_inc+= Liss(root.left.left) + Liss(root.left.right);
		if(root.right!=null)
			liss_inc+= Liss(root.right.left) + Liss(root.right.right);
		
		root.liss = Math.max(liss_excl, liss_inc);
		return root.liss;
	}
	
	public static void main(String...args){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(100);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(1);
		root.left.right.left.left = new TreeNode(6);
		System.out.println(Liss(root));
	}
}
