package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private char nodeName;
    private boolean goalNode;
    private Node [] pointingTo = new Node[3];
    ArrayList<Node> parents = new ArrayList<Node>();


    public Node(char name){
        this.nodeName = name;
        this.goalNode = false;

    }

    public char getNodeName(){
        return nodeName;
    }

    public Node(char name, boolean isGoalNode){
        this.nodeName = name;
        this.goalNode = isGoalNode;
    }

    public void pointToNodeOne(Node one){
        this.pointingTo[0] = one;
    }

    public void pointToNodeTwo(Node two){
        this.pointingTo[1] = two;
    }

    public void pointToNodeThree(Node three){
        this.pointingTo[2] = three;
    }

    public boolean doesPointTo(Node otherNode){
        if(this.pointingTo[0].equals(otherNode) || this.pointingTo[1].equals(otherNode) || this.pointingTo[2].equals(otherNode)){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Node> getNeighbors(){
        ArrayList<Node> neighbors = new ArrayList<Node>();
        for(int i = 0; i < this.pointingTo.length; i++){
            try{
                if(!pointingTo[i].equals(null))
                    neighbors.add(pointingTo[i]);
            }catch (NullPointerException e){

            }

        }

        return neighbors;
    }

    public void setParent(Node parent){
        this.parents.add(parent);
    }

    public Node getParent(){
        return this.parents.get(0);
    }



    public boolean isGoalNode(){
        return this.goalNode;
    }

    public String toString(){
        String s = "["+nodeName+"]";
        return s;
    }




}
