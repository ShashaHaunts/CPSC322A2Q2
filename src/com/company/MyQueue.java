package com.company;

import java.util.*;

public class MyQueue<N> extends MyList<N>{
    private Queue<Node> nodeQueue;



    public MyQueue(){
            nodeQueue = new ArrayDeque<Node>();
    }


    @Override
    public Node pop() {
        return nodeQueue.poll();
    }

    @Override
    public void add(Node n) {
        nodeQueue.offer(n);
    }

    @Override
    public int size() {
        return nodeQueue.size();
    }

    @Override
    public boolean isEmpty() {
        if(nodeQueue.isEmpty())
            return true;
        else
            return false;
    }




    public String toString(){
        Iterator<Node> iterator = this.nodeQueue.iterator();


           String s = "";
           for(int i = 0; i < this.nodeQueue.size(); i++){
                s+=iterator.next().getNodeName()+" ";
           }
           return s;
    }

}
