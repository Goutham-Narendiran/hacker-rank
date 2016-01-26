package com.interview.array;


public class LCABinaryTree {
	private static boolean v1 = false;
	private static boolean v2 = false;
static Node findLCA(Node root,int n1,int n2){
	
	Node LCA = findLCAUtil(root,n1,n2);
	if(v1&&v2||(v1&&find(root,n2))||(v2&&find(root,n1))){
		return LCA;
	}
	return null;
	
}
private static boolean find(Node root, int data) {
	// TODO Auto-generated method stub
	if(root == null)
		return false;
	if(root.data==data || find(root.left,data)||find(root.right,data))
		return true;
	return false;
}

private static Node findLCAUtil(Node root, int n1, int n2) {
	// TODO Auto-generated method stub
	if(root==null)
		return null;
	if(root.data == n1){
		v1= true;
		return root;
	}
	if(root.data == n2){
		v2= true;
		return root;
	}
	
	Node left_lca = findLCAUtil(root.left,n1,n2);
	Node right_lca = findLCAUtil(root.right,n1,n2);
	
	if(left_lca!=null&&right_lca!=null)
		return root;
	return (left_lca!=null)?left_lca:right_lca;
}

public static void main(String...args){
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.left.right.left = new Node(6);
	root.left.right.left.left = new Node(7);
	Node LCA = findLCA(root,4,5);
	if(LCA!=null)
	System.out.println(LCA.data);
	else
		System.out.println("Nodes not found");
}

}
