/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.datastuctures;

import java.util.LinkedList;

/**
 *
 * @author Hasitha Lakmal
 */
public class CodeLevelTreeStructureImpl implements CodeLevelTreeStructure {

    private LinkedList<Node> list = new LinkedList<Node>();
    

    @Override
    public void addNode(Node item) {
        list.addLast(item);
    }

    @Override
    public Node deleteNode() {
        return list.poll();
    }

    @Override
    public void print() {
        for (Node item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public LinkedList<Node> getElements(int level) {
        LinkedList<Node> list2 = new LinkedList<Node>();
        for (Node item : list) {
            if (item.getComplexityLevel() == level) {
                list2.addLast(item);
            }
        }

        return list2;
    }

    @Override
    public Node getElement(int nodeID) {
        Node n = new Node();
        for (Node item : list) {
            if (item.getNodeID() == nodeID) {
                n = item;
                break;
            }
        }

        return n;
    }

    @Override
    public void resetHierarchy() {
        for (Node item : list) {
            int cl = item.getComplexityLevel();
            int in = item.getInIndex();
            int out = item.getOutIndex();

            LinkedList<Node> al = this.getElements(cl - 1);
            for (int i = 0; i < al.size(); i++) {
                Node node = (Node) al.get(i);
                int parentIn = node.getInIndex();
                int parentout = node.getOutIndex();
                int parentid = node.getNodeID();

                if (parentIn < in && parentout > out) {
                    item.setParentElement(parentid);
                    break;
                }
            }
        }
    }
    
    @Override
    public int getMaxDepth(){
        int maxDepth=0;
        for(Node item : list){
            if(maxDepth < item.getComplexityLevel()){
                maxDepth = item.getComplexityLevel();
            }
        }
        return maxDepth;
    }

    public LinkedList<Node> getList() {
        return list;
    }

    public void setList(LinkedList<Node> list) {
        this.list = list;
    }
    
    

}
