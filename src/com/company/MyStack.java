package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack<N> extends MyList<N> {

    private Stack<Node> nodeStack;


    public MyStack(){
        nodeStack = new Stack<Node>();
    }


    @Override
    public Node pop() {
        return nodeStack.pop();
    }

    @Override
    public void add(Node n) {
        nodeStack.push(n);
    }

    @Override
    public int size() {
        return nodeStack.size();
    }

    @Override
    public boolean isEmpty() {
        if(nodeStack.isEmpty())
            return true;
        else
            return false;
    }



    public String toString(){
        String s = "";
        for(int i = 0; i < this.nodeStack.size(); i++){
            s+=nodeStack.get(i).getNodeName()+" ";
        }
        return s;
    }

}
