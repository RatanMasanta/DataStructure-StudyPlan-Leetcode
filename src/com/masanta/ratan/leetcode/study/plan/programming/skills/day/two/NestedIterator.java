package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        for(int i = 0; i < nestedList.size(); i++){
            addInteger(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void addInteger(NestedInteger nestedInteger){
        if(nestedInteger.isInteger()){
            queue.add(nestedInteger.getInteger());
        }else{
            List<NestedInteger> temp = nestedInteger.getList();
            for(int i = 0; i < temp.size(); i++){
                addInteger(temp.get(i));
            }
        }
    }

}