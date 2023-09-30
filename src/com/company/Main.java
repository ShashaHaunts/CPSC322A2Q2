package com.company;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        //Instantiate all nodes
        Node s = new Node('S');
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        Node z = new Node('Z', true);

        //What S points to
        s.pointToNodeOne(a);
        s.pointToNodeTwo(b);
        s.pointToNodeThree(c);

        //What A points to
        a.pointToNodeOne(c);

        //A's Parents
        a.setParent(s);

        //What B points to
        b.pointToNodeOne(c);

        //B's parents
        b.setParent(s);

        //What C points to
        c.pointToNodeOne(d);
        c.pointToNodeTwo(e);
        c.pointToNodeThree(f);

        //C's parents
        c.setParent(s);
        c.setParent(a);
        c.setParent(b);

        //What D points to
        d.pointToNodeOne(f);

        //D's parents
        d.setParent(c);

        //What E points to
        e.pointToNodeOne(f);

        //E's parents
        e.setParent(c);

        //What F points to
        f.pointToNodeOne(g);
        f.pointToNodeTwo(h);
        f.pointToNodeThree(z);

        //F's parents
        f.setParent(c);
        f.setParent(d);
        f.setParent(e);

        //What G points to
        g.pointToNodeOne(z);

        //G's parents
        g.setParent(f);

        //What H points to
        h.pointToNodeOne(z);

        //H's parents
        h.setParent(f);

        //Z's parents
        z.setParent(f);
        z.setParent(g);
        z.setParent(h);

        System.out.println("-------DFS------");
        search(s, new MyStack<Node>());
        System.out.println("-------BFS------");
        search(s, new MyQueue<Node>());


    }


    public static void search(Node startNode, MyList<Node> frontier){
        ArrayList<Node> expanded = new ArrayList<Node>();
        ArrayList<Node> solution = new ArrayList<Node>();
        Node goal = null;
        boolean goalNodeFound = false;
        frontier.add(startNode);

        //System.out.println(frontier);

        expanded.add(startNode);
        Node current = null;

        //System.out.println("WEENER");

        //While loop to remove paths while frontier is NOT empty
        while(!frontier.isEmpty()){
            //System.out.println("YOOOOOOOOOOOO");
            current = frontier.pop();
            //solution.add(current);
            System.out.println("Expanded Node: "+ current);
            //If we find a goal node, we want to return the path
            if(current.isGoalNode()){
                goalNodeFound = true;
                goal = current;
                break;
            }else{ //Otherwise... we expand neighbors
                ArrayList<Node> neighbors = current.getNeighbors(); //Get neighbors of current node
                for(Node node : neighbors){
                    if(!expanded.contains(node)){

                        frontier.add(node);
                        expanded.add(node);
                    }
                }

                System.out.println(frontier);

            }




        }

        if(goalNodeFound){
            System.out.println("Solution: ");
            Node temp = goal;
            try{
                while(!temp.equals(null)){
//                    System.out.print(temp+" ");
                    solution.add(temp);
                    temp = temp.getParent();
                }
            }catch(NullPointerException e){
                System.out.println("Something went wrong");
            }catch(IndexOutOfBoundsException bruh){

            }
        }else{
            System.out.println("No solution found");
        }
//        if(goalNodeFound){
//            System.out.println("Goal node path found: ");
//            while(!current.equals(startNode)){
//                System.out.print(current+" ");
//
//            }

        //System.out.print("Solution path: ");
//        for(int i = 0; i < solution.size(); i ++){
//            System.out.print(solution.get(i)+" ");
//        }

        for(int i= solution.size()-1; i>-1; i--){
            System.out.print(solution.get(i));
        }
        System.out.println("\n");
    }
}
