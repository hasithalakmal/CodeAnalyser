
import com.codemage.datastuctures.Student;
import com.codemage.datastuctures.CodeLevelTreeStructureImpl;
import com.codemage.datastuctures.GenQueue;
import com.codemage.datastuctures.Node;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hasitha Lakmal
 */
public class MethodIdentifier1 {

    public void getMethodIndexes() {
        Student s = new Student();
        Class<? extends Student> cl = s.getClass();
        Method[] meth = cl.getMethods();

        for (Method m : meth) {
            System.out.println(m);
        }
    }

    public void getMethodIndexes(String code) {
        //stack and que
        Stack openIndex = new Stack();
        GenQueue<Integer> closeIndex = new GenQueue<Integer>();

        //read words
        String[] arr = code.split("\\s+");
        for (String ss : arr) {
            // System.out.println(ss);
        }

        //read indexces of given thing
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        int initial_method_index = code.indexOf("(");
        //System.out.println(initial_method_index);
        //System.out.println(code.indexOf("(", initial_method_index + 1));
        //System.out.println(code.indexOf("jhgfvjjhj", initial_method_index + 1));
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>");

        //get all indexses of given value
        ArrayList al = new ArrayList();
        int current_index = -1;
        int new_index = 0;
        while (new_index != -1 && current_index != new_index) {
            current_index = new_index;
            new_index = code.indexOf("(", current_index + 1);
            al.add(new_index);
            openIndex.push(new_index);
        }
        openIndex.pop();
        //System.out.println(al);
        System.out.println(openIndex);

        //get all indexses of given value
        ArrayList al2 = new ArrayList();
        int current_index2 = -1;
        int new_index2 = 0;
        while (current_index2 != new_index2) {
            current_index2 = new_index2;
            new_index2 = code.indexOf(")", current_index2 + 1);
            al2.add(new_index2);
            if (new_index2 == -1) {
                break;
            }
            closeIndex.enqueue(new_index2);
        }
        //System.out.println(al2);
        closeIndex.printItems();

        //identify method initial index and end index
        ArrayList al3 = new ArrayList();
        int nodeid = 0;
        while (closeIndex.hasItems()) {
            nodeid++;
            Node n = new Node();

            int in = (int) openIndex.pop();
            int out = closeIndex.dequeue();
            System.out.println(in + "-----" + out);
            //fill node
            n.setNodeID(nodeid);
            n.setInIndex(in);
            n.setOutIndex(out);

            al3.add(n);
        }

        System.out.println(al3.toString());
    }

    public void getCodeStructure(String code) {
        Stack openIndex = new Stack();
        CodeLevelTreeStructureImpl ts = new CodeLevelTreeStructureImpl();
        
        int currentOpen = -1;
        int currentClose = -1;
        int in = 0;
        int out = 0;
        int nodeID = 1;
        while (currentOpen != in && in != -2) {
            currentOpen = in;
            in = code.indexOf("{", currentOpen + 1);
            
            out = code.indexOf("}", currentClose + 1);
            while (out < in || in == -1) {
                if(openIndex.empty()){
                    in = -2;
                    break;
                }
                currentClose = out;
                Node n = new Node();
                n.setInIndex((int) openIndex.pop());
                n.setNodeID(nodeID);
                n.setOutIndex(out);
                n.setComplexityLevel(openIndex.size());

                ts.addNode(n);
                //System.out.println(n.getNodeID()+" ----------- "+n.getInIndex() + " ----- " + n.getOutIndex() + " ------ " + n.getComplexityLevel());

                out = code.indexOf("}", currentClose + 1);
                nodeID++;
            }
            openIndex.push(in);
        }
        ts.resetHierarchy();
        ts.print();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}
