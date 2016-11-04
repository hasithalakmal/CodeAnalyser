
import com.codemage.datastuctures.MethodIdentifier;
import com.codemage.datastuctures.TokenCounter;
import com.codemage.metrix.FirstMetrix;
import com.codemage.metrix.SecondMetrix;

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

        //Second metrix
        SecondMetrix fm = new SecondMetrix(javaCode);
        double res = fm.getResult();
        System.out.println("********************************************************************");
        System.out.println(res);
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
    }
}
