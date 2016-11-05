
import com.codemage.metrix.FirstMetrix;
import com.codemage.metrix.SecondMetrix;
import com.codemage.metrix.TheirdMetric;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hasitha Lakmal
 */
public class Test1 {

    public static void main(String[] args) {

        String javaCode = "public class SampleCode5 {\n"
                + "\n"
                + "    int var1, var2, var3;\n"
                + "    String var4, var5, var6;\n"
                + "    int var7 = 5;\n"
                + "\n"
                + "    public void checkCC(String var10) {\n"
                + "        System.out.println(var10);\n"
                + "        int var8 = 9;\n"
                + "\n"
                + "        if (\"a\".equals(var10)) {\n"
                + "            String var9 = \"hasitha\";\n"
                + "            System.out.println();\n"
                + "            if (var10.length() == 5) {\n"
                + "                System.out.println(var10);\n"
                + "                System.out.println( var2 );\n"
                + "            } else {\n"
                + "                System.out.println(var10);\n"
                + "                System.out.println( var3);\n"
                + "            }\n"
                + "        } else if (\"b\".equals(var10)) {\n"
                + "            System.out.println(var10);\n"
                + "        } else {\n"
                + "            System.out.println(var10);\n"
                + "        }\n"
                + "\n"
                + "        System.out.println(\"jjjjj\");\n"
                + "\n"
                + "        for (int itt = 0; itt < 10; itt++) {\n"
                + "            System.out.println(itt);\n"
                + "            System.out.println(var4);\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "}\n"
                + "";

        String javaCode2 = "public class SampleCode2 {\n"
                + "\n"
                + "    public void checkCC(String x) {\n"
                + "        System.out.println(x);\n"
                + "        if (\"a\".equals(x)) {\n"
                + "            if (x.length() == 5) {\n"
                + "                System.out.println(x);\n"
                + "            }\n"
                + "            else {\n"
                + "                System.out.println(x);\n"
                + "                if (true) {\n"
                + "                    if (true) {\n"
                + "                        if (true) {\n"
                + "                            if (true) {\n"
                + "\n"
                + "                            } else {\n"
                + "                            }\n"
                + "                        } else {\n"
                + "                        }\n"
                + "                    } else {\n"
                + "                    }\n"
                + "                } else {\n"
                + "                }\n"
                + "            }\n"
                + "        }\n"
                + "        else if (\"b\".equals(x)) {\n"
                + "            System.out.println(x);\n"
                + "            if (true) {\n"
                + "                if (true) {\n"
                + "                    if (true) {\n"
                + "                        if (true) {\n"
                + "                            if (true) {\n"
                + "\n"
                + "                            } else {\n"
                + "                            }\n"
                + "                        } else if (true) {\n"
                + "\n"
                + "                        } else if (true) {\n"
                + "\n"
                + "                        } else if (true) {\n"
                + "\n"
                + "                        } else if (true) {\n"
                + "\n"
                + "                        } else {\n"
                + "                        }\n"
                + "                    } else {\n"
                + "                    }\n"
                + "                } else {\n"
                + "                }\n"
                + "            } else {\n"
                + "            }\n"
                + "        }\n"
                + "        else {\n"
                + "            System.out.println(x);\n"
                + "            if (true) {\n"
                + "\n"
                + "            } else {\n"
                + "            }\n"
                + "            if (true) {\n"
                + "\n"
                + "            } else {\n"
                + "            }\n"
                + "            if (true) {\n"
                + "\n"
                + "            } else {\n"
                + "            }\n"
                + "            if (true) {\n"
                + "\n"
                + "            } else {\n"
                + "            }\n"
                + "        }\n"
                + "\n"
                + "        if (true) {\n"
                + "\n"
                + "        } else {\n"
                + "        }\n"
                + "        if (true) {\n"
                + "\n"
                + "        } else {\n"
                + "        }\n"
                + "        if (true) {\n"
                + "\n"
                + "        } else {\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "}";

        String javaCode3 = "public class SampleCode3 {\n"
                + "    public void test(){\n"
                + "        System.out.println(\" Hello world \");\n"
                + "        System.out.println(\" Hello \");\n"
                + "        System.out.println(\" Hasitha Lakmal Gamage \");\n"
                + "    }\n"
                + "}";

        String met3TestCode = "public class SampleCode6 {\n"
                + "\n"
                + "    public int add(int a, int b) {\n"
                + "        int c = a + b;\n"
                + "        return c;\n"
                + "    }\n"
                + "\n"
                + "    public void print() {\n"
                + "        System.out.println(\"Hello\");\n"
                + "    }\n"
                + "\n"
                + "    public void printString(String code) {\n"
                + "        System.out.println(code);\n"
                + "    }\n"
                + "\n"
                + "    public static void main(String [] args) {\n"
                + "        SampleCode6 sc = new SampleCode6();\n"
                + "        sc.add(0, 0);\n"
                + "        if(true){\n"
                + "            sc.print();\n"
                + "        }\n"
                + "        \n"
                + "        for (int i = 0; i < 10; i++) {\n"
                + "            sc.printString(\"hello\");\n"
                + "        }\n"
                + "        \n"
                + "        sc.printString(\"hello\");\n"
                + "        sc.concat(\"aaa\", \"www\");\n"
                + "        int []a = {1,2,3};\n"
                + "        int []b = {1,2,3};\n"
                + "        sc.addArr(a, b);\n"
                + "        sc.methodOned(5, \"aaaaa\",1.23);\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "    public String concat(String x, String y) {\n"
                + "        String newString = x + y;\n"
                + "        return newString;\n"
                + "    }\n"
                + "\n"
                + "    public int[] addArr(int x[], int y[]) {\n"
                + "        int z[] = new int[x.length];\n"
                + "        for (int i = 0; i < x.length; i++) {\n"
                + "            System.out.println(\"aaaa\");\n"
                + "            z[i] = x[i] + y[i];\n"
                + "        }\n"
                + "        return z;\n"
                + "    }\n"
                + "\n"
                + "    public int[] methodOned(int x, String y, double z) {\n"
                + "        System.out.println(x);\n"
                + "        System.out.println(y);\n"
                + "        System.out.println(z);\n"
                + "        int[] a = {1, 2, 3, 4, 5};\n"
                + "        return a;\n"
                + "    }\n"
                + "    \n"
                + "    public int[] methodOnedaa(int x [][], String y[], double z[][]) {\n"
                + "        System.out.println(x);\n"
                + "        System.out.println(y);\n"
                + "        System.out.println(z);\n"
                + "        int[] a = {1, 2, 3, 4, 5};\n"
                + "        return a;\n"
                + "    }\n"
                + "}\n"
                + "";

        String testCode = "public class SampleCode4 {\n"
                + "\n"
                + "    public void checkCC(String x) {\n"
                + "        System.out.println(x);\n"
                + "        if (\"a\".equals(x)) {\n"
                + "            if (x.length() == 5) {\n"
                + "                System.out.println(x);\n"
                + "            } else {\n"
                + "                System.out.println(x);\n"
                + "            }\n"
                + "        } else if (\"b\".equals(x)) {\n"
                + "            System.out.println(x);\n"
                + "        } else {\n"
                + "            System.out.println(x);\n"
                + "        }\n"
                + "        \n"
                + "        System.out.println(\"jjjjj\");\n"
                + "        \n"
                + "        for (int i = 0; i < 10; i++) {\n"
                + "            System.out.println(i);\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "}";

        String test1 = "public class SampleCode4 {\n"
                + "\n"
                + "    public void checkCC(String x) {\n"
                + "        System.out.println(x);\n"
                + "        if (\"a\".equals(x)) {\n"
                + "            if (x.length() == 5) {\n"
                + "                System.out.println(x);\n"
                + "            } else {\n"
                + "                System.out.println(x);\n"
                + "            }\n"
                + "        } else if (\"b\".equals(x)) {\n"
                + "            System.out.println(x);\n"
                + "        } else {\n"
                + "            System.out.println(x);\n"
                + "        }\n"
                + "        \n"
                + "        System.out.println(\"jjjjj\");\n"
                + "        \n"
                + "        for (int i = 0; i < 10; i++) {\n"
                + "            System.out.println(i);\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "}";

//        SecondMetrix fm = new SecondMetrix(javaCode);
//        double res = fm.getResult();
//        System.out.println("********************************************************************");
//        System.out.println(res);
        FirstMetrix fm = new FirstMetrix(test1);
        fm.getLineValues();
        String file = fm.getFileAnalyse();
        int val = fm.getTotalValue();
        System.out.println(file);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("final result = " + val);

        System.out.println("\n\n\n-----------------------------------------------------\n\n\n");

        SecondMetrix fm2 = new SecondMetrix(test1);
        double res = fm2.getResult();
        System.out.println("********************************************************************");
        System.out.println(res);

        System.out.println("\n\n\n-----------------------------------------------------\n\n\n");

        TheirdMetric tm = new TheirdMetric(test1);
        int therdMetVal = tm.getResult();
        System.out.println("final result = " + therdMetVal);
        //   TokenCounter wc = new TokenCounter();
        // wc.counter(javaCode);
        // MethodIdentifier mi = new MethodIdentifier();
        //   mi.getMethodIndexes();
        //  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //mi.getCodeStructure(javaCode);
        // mi.getCodeStructure(javaCode2);
        /*TokenCounter wc = new TokenCounter();
        HashMap tokenlistbyLine = wc.counter(javaCode);
        for (int i=0;i<tokenlistbyLine.size();i++) {
        CodeLine codeline = (CodeLine) tokenlistbyLine.get(i);
        System.out.println(codeline.toString());
        }
        int TotalCharacters = wc.getCrunchifyTotalCharacters();
        int Totaltockens = wc.getCrunchifyTotalWords();
        int TotalLines = wc.getCrunchifyTotalLines();
        System.out.println(tokenlistbyLine.toString());
        System.out.println(TotalCharacters + " ----- " + Totaltockens + " ----- " + TotalLines);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //wc.printStringRemover(javaCode2);*/
        //first metrix
        /*    FirstMetrix fm = new FirstMetrix(javaCode);
        fm.getLineValues();
        String file = fm.getFileAnalyse();
        int val = fm.getTotalValue();
        System.out.println(file);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("final result = " + val);*/
        //Second metrix
        /* SecondMetrix fm = new SecondMetrix(javaCode);
        double res = fm.getResult();
        System.out.println("********************************************************************");
        System.out.println(res);*/
    }
}
