package com.interview.array;

import java.util.Stack;

public class isPairPresentBST {
	public static void main(String...args){
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		System.out.println(isPairPresentUtil(root,40));
	}

	private static boolean isPairPresentUtil(Node root, int target) {
		// TODO Auto-generated method stub
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		boolean done1 = false, done2 = false;
		int val1 = 0,val2 = 0;
		Node curr1 = root;
		Node curr2 = root;

		// The loop will break when we either find a pair or one of the two
		// traversals is complete
		while (true)
		{
			// Find next node in normal Inorder traversal.
			while (done1 == false)
			{
				if (curr1 != null)
				{
					s1.add(curr1);
					curr1 = curr1.left;
				}
				else
				{
					if (s1.isEmpty())
						done1 = true;
					else
					{
						curr1 = s1.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						done1 = true;
					}
				}
			}

			// Find next node in REVERSE Inorder traversal. The only
			// difference between above and below loop is, in below loop
			// right subtree is traversed before left subtree
			while (done2 == false)
			{
				if (curr2 != null)
				{
					s2.add(curr2);
					curr2 = curr2.right;
				}
				else
				{
					if (s2.isEmpty())
						done2 = true;
					else
					{
						curr2 = s2.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						done2 = true;
					}
				}
			}

			// If we find a pair, then print the pair and return. The first
			// condition makes sure that two same values are not added
			if ((val1 != val2) && (val1 + val2) == target){
				System.out.println("Pair Found "+val1+" "+val2+" "+target);
				return true;
			}
			// If sum of current values is smaller, then move to next node in
			// normal inorder traversal
			else if ((val1 + val2) < target)
				done1 = false;

			// If sum of current values is greater, then move to next node in
			// reverse inorder traversal
			else if ((val1 + val2) > target)
				done2 = false;

			// If any of the inorder traversals is over, then there is no pair
			// so return false
			if (val1 >= val2)
				return false;
		}


	}
}
