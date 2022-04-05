package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeABinaryTree {


	/*
	 * Problem statement
	 * 
	 * Serialization is the process of converting a data structure or object into a
	 * sequence of bits so that it can be stored in a file or memory buffer, or
	 * transmitted across a network connection link to be reconstructed later in the
	 * same or another computer environment.
	 * 
	 * Design an algorithm to serialize and deserialize a binary tree. There is no
	 * restriction on how your serialization/deserialization algorithm should work.
	 * You just need to ensure that a binary tree can be serialized to a string and
	 * this string can be deserialized to the original tree structure.
	 * 
	 * Clarification: The input/output format is the same as how LeetCode serializes
	 * a binary tree. You do not necessarily need to follow this format, so please
	 * be creative and come up with different approaches yourself.
	 */

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		SerializeAndDeserializeABinaryTree ser = new SerializeAndDeserializeABinaryTree();
		SerializeAndDeserializeABinaryTree deser = new SerializeAndDeserializeABinaryTree();
		TreeNode ans = deser.deserialize(ser.serialize(root));
		System.out.println(ans.val + " " + ans.left.val + " " + ans.right.val);

	}


	/* 
	 * The idea is simple: print the tree in pre-order traversal and use "X" to denote null node and split node with ",".
	 *  We can use a StringBuilder for building the string on the fly. For deserializing, we use a Queue to store 
	 *  the pre-order traversal and since we have "X" as null node, we know exactly how to where to end building subtrees.
	 */

	private static final String spliter = ",";
	private static final String NN = "X";

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private static void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		} else {
			sb.append(node.val).append(spliter);
			buildString(node.left, sb);
			buildString(node.right,sb);
		}
	}
	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}

	private static TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN)) return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}

}
