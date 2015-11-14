package com.interview.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class QEle{
	Node node;
	int hd;
	QEle(Node node,int hd){
		this.node = node;
		this.hd = hd;
	}
}
public class TopBottomViewBinaryTree {
	static TreeMap<Integer,Integer> map;
	public static void main(String...args){
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		//root.left.right.left.left = new Node(6);
		root.right.right = new Node(25);
		//root.left.left.right = new Node(8);
		map = new TreeMap<>();
		bottomViewBinaryTree(root);
		System.out.println(map.entrySet());
		map = new TreeMap<>();
		topViewBinaryTree(root,0);
		System.out.println(map.entrySet());
	}

	private static void topViewBinaryTree(Node root, int d) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		topViewBinaryTree(root.left,d-1);
		topViewBinaryTree(root.right,d+1);
		map.put(d,root.data);
	}

	private static void bottomViewBinaryTree(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;

		Queue<QEle> q = new LinkedList<>();
		q.add(new QEle(root,0));
		while(!q.isEmpty()){
			QEle ele = q.remove();
			map.put(ele.hd,ele.node.data);
			if(ele.node.left!=null)
				q.add(new QEle(ele.node.left,ele.hd-1));
			if(ele.node.right!=null)
				q.add(new QEle(ele.node.right,ele.hd+1));
		}

	}

}
