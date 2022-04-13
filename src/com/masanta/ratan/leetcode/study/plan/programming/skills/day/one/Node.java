package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.List;

public class Node {

	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}


}
