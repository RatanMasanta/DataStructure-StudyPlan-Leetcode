package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

class Node1 {
    int val;
    String token;
    Node1 next;
    Node1(int val,String token, Node1 next){
        this.val = val;
        this.token = token;
        this.next = next;
    }
}

public class AuthenticationManager {
    
    /*
        -------------------------------
        The basic idea is :
        - head will point to lastest generated token and val = time till it valid
        - and will replace head with newly generated token and place previous head as it next 
        - and at time of renew will be remove the expired nodes
        (//since nodes after an expired node are all expired )
        also if contain the current token remove it from list;
        and add renewed as newly generated node
        
        - same for count unexpired but no token will be there and then count
        - 
        ---------------------------
    */
    
    private Node1 head;
    
    private int timeToLive;
    
    private boolean renewFlag;
    
    public AuthenticationManager(int timeToLive) {
        
        this.head = null;
        this.timeToLive = timeToLive ;
        
    }
    
    public void generate(String tokenId, int currentTime) {
        
    	Node1 n = new Node1(currentTime+timeToLive,tokenId,head);
        head = n;
        
    }
    private void removingExpire(String tokenId,int currentTime){
        renewFlag = false;
        if(head==null)return;
        if(head.val <= currentTime){
            head = null;
            return;
        }
        if(head.token.equals(tokenId)){
            head = head.next;
            renewFlag = true;
            return;
        }
        
        Node1 it = head;
        
        while(it!=null&&it.next!=null){
            if(it.next.val<=currentTime)it.next = null;
            else if( it.next.token.equals(tokenId) ){
                it.next = it.next.next;
                renewFlag = true;
            }
            if(it.next!=null&&it.next.val<=currentTime)it.next = null;
            
            it = it.next;
        }
            
    }
    public void renew(String tokenId, int currentTime) {
            
        removingExpire(tokenId,currentTime);
        
        if(!renewFlag)return;
        
        Node1 n = new Node1(currentTime+timeToLive,tokenId,head);
        head = n;
    }
    
    public int countUnexpiredTokens(int currentTime) {
        // removingExpire("",currentTime);
        int i = 0;
        Node1 it = head;
        while(it!=null && it.val>currentTime){
            i++;
            it = it.next;
        }
        return i;
    }
}

