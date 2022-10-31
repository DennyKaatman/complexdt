package Case.Graph;

import java.util.ArrayList;

public class AdjacencyList {
    ArrayList<ArrayList> adj;

    AdjacencyList(int n){
        adj= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addNode(int s, int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
    }

    void print(){
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyList adj = new AdjacencyList(5);
        adj.addNode(1,4);
        adj.addNode(0,4);
        adj.addNode(2,3);
        adj.addNode(0,3);
        adj.print();
    }
}
