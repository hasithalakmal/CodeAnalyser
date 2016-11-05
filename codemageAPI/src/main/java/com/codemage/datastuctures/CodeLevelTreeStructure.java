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
public interface CodeLevelTreeStructure {

    void addNode(Node item);

    Node deleteNode();

    Node getElement(int nodeID);

    LinkedList<Node> getElements(int level);

    int getMaxDepth();

    void print();

    void resetHierarchy();
    
    public LinkedList<Node> getList();
    
}
