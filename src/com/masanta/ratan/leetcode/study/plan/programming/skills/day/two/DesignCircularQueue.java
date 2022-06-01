package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

/*
  Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
	
	One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
	
	Implementation the MyCircularQueue class:
	
	MyCircularQueue(k) Initializes the object with the size of the queue to be k.
	int Front() Gets the front item from the queue. If the queue is empty, return -1.
	int Rear() Gets the last item from the queue. If the queue is empty, return -1.
	boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
	boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
	boolean isEmpty() Checks whether the circular queue is empty or not.
	boolean isFull() Checks whether the circular queue is full or not.
	You must solve the problem without using the built-in queue data structure in your programming language. 
	
	 
	
	Example 1:
	
	Input
	["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
	[[3], [1], [2], [3], [4], [], [], [], [4], []]
	Output
	[null, true, true, true, false, 3, true, true, true, 4]
	
	Explanation
	MyCircularQueue myCircularQueue = new MyCircularQueue(3);
	myCircularQueue.enQueue(1); // return True
	myCircularQueue.enQueue(2); // return True
	myCircularQueue.enQueue(3); // return True
	myCircularQueue.enQueue(4); // return False
	myCircularQueue.Rear();     // return 3
	myCircularQueue.isFull();   // return True
	myCircularQueue.deQueue();  // return True
	myCircularQueue.enQueue(4); // return True
	myCircularQueue.Rear();     // return 4
 */

public class DesignCircularQueue {


    //FOR STORING THE VAL
    int a[];
    //LENGTH OF THE ARRAY
    int n;
    //FRONT AND REAR POINTER INDEX 
    int front = -1, rear = -1;
    
    //INITIALIZATION OF THE ARRAY
    public DesignCircularQueue(int k) {
        n = k;
        a= new int[k];    
    }
    
    //ADDING THE ELEMENT IN THE QUEUE
    public boolean enQueue(int value) {
        
        //BASE CASE 
        //IF ARRAY IF FULL RETURN FASLE
        if(isFull()){
            return false;
        }
        
        //ADDING THE VAL IN THE ARRAY
        if(front == -1)
        {
            front = 0;
        }
        //CHECKING IF ARRAY IS AT THE END INDEX 
        //IF IT IS ME DO 
        //LET REAR = 3 //(at last index of the array)
        //n = 4;(SIZE OF THE ARRAY)
        //WE DO (rear+1)%n;
        //  (3+1)%4 => 4%4 =>0
        //SO WE ARE AT THE 0TH INDEX
        rear = (rear+1)%n;
        a[rear] = value;
        
        
        return true;
    }
    
    public boolean deQueue() {
        
        //CHECKING IF THE ARRAY IS EMPTY
        if(isEmpty())
        {
            return false;
        }
        
        //SOTING THE VAL 
        //WE ARE DEQUEUE-ING 
        //IF WE WANT TO RETURN IT
        int result = a[front];
        
        //CHECKING IF FRONT = REAR 
        //MEANS LAST ELEMENT IN THE ARRY
        //WE REMOVES IT THE INDEX BECOMES -1
        if(front == rear)
        {
            front = rear= -1;
        }else{
            //LAST INDEX CONDITION
            //SAME PROCESS AS ABOVE WE SEEN IN THE REAR
            front = (front+1)%n;
        }
        
        return true;
    }
    
    
    //RETUNING THE FRONT POSITION OF QUEUE IN THE ARRAY
    public int Front() {
        
        if(front == -1)
        {
            return -1;
        }
        
        return a[front];
    }
    
     //RETUNING THE REAR POSITION OF QUEUE IN THE ARRAY
    public int Rear() {
        
         if(rear == -1)
        {
            return -1;
        }
        
        return a[rear];
    }
    
    //CHECKING IF THE ARRAY IS EMPTY
    public boolean isEmpty() {
        if(front == -1)
        {
            return true;
        }
        
        return false;
    }
    
    //CHECKING IF THE ARRAY IS FULL
    public boolean isFull() {
        if((rear+1)%n == front)
        {
            return true;
        }
        
        return false;
    }
	
	
}
