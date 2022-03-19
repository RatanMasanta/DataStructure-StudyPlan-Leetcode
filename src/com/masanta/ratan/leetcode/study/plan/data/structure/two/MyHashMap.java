package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class MyHashMap {
	
	static class Node{
		final int key;
		int value;
		Node next;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
    
	private int capacity;
    private int size = 0;
	private Node[] array;
    
	public MyHashMap(int capacity) {
        this.capacity = capacity;
        size = 0;
		array = new Node[capacity];
	}

    public MyHashMap() {
        this(10001);
    }
    
    public void put(int key, int value) {
        int index = hash(key); 
        Node head = array[index];
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        // add to head.
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
    }
    
    public int get(int key) {
        int idx = hash(key);
        Node cur = array[idx];
        while (cur != null) {
            if (cur.key == key) return cur.value;
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node cur = array[index], prev = null;
        while (cur != null) {
            if (cur.key == key) {
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    array[index] = cur.next;
                }
                size--;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    
    private int hash(int key) {
        return Integer.hashCode(key) % capacity;
    }

}
