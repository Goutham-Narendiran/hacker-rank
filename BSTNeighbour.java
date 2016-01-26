package com.interview.array;


class NodeBinaryTree{
	char id;
	char neighbour;
	NodeBinaryTree left;
	NodeBinaryTree right;
	
	public NodeBinaryTree(char id){
		this.id = id;
		left = null;
		right = null;
	}
}
public class BSTNeighbour {
	public static void main(String[] args) {
       NodeBinaryTree root = new NodeBinaryTree('A');
       root.left = new NodeBinaryTree('B');
       root.right = new NodeBinaryTree('C');
       root.left.left = new NodeBinaryTree('D');
       root.left.right = new NodeBinaryTree('E');
       root.right.right = new NodeBinaryTree('F');
       
       root.neighbour = '0';
       assignNeighbour(root);
       print(root);
	}

	private static void print(NodeBinaryTree root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		print(root.left);
		System.out.println("Id "+root.id + " Neighbour "+root.neighbour);
		print(root.right);
	}

	private static void assignNeighbour(NodeBinaryTree root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(root.left==null && root.right == null)
			return;
		if(root.left!=null && root.right!=null){
			root.left.neighbour = root.right.id;
			root.right.neighbour = root.left.id;
			assignNeighbour(root.left);
			assignNeighbour(root.right);
		}
		
		else if(root.left!=null){
			root.left.neighbour = '0';
			assignNeighbour(root.left);
		}
		else{
			root.right.neighbour= '0';
			assignNeighbour(root.right);
		}
	}
}
