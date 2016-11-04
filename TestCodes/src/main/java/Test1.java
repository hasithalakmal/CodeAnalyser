/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasitha Lakmal
 */
public class Test1 { //3*(1+0+0) =3

    int z = 3; //3*(1+0+0) =3

    public static void main(String[] args) {
        int x = 5;
        System.out.println("hello");

        if (x == 5) { //4*(1+2+1) =16
            System.out.println("xxxx");
        } else {
            System.out.println("xxxx yyy zzzz");
        }

        System.out.println("sssss");

        if (x > 5) {
            System.out.println("aaaaa");
            if (x == 3) {
                System.out.println("xxxxx");
                if (x < 1) {
                    System.out.println("vvvvv");
                } else if (x < -2) {
                    System.out.println("vvvvvv");
                } else {
                    System.out.println("ccccc");
                }
            } else {
                System.out.println("yyyyy");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    if (i > 5) {
                        System.out.println("xxxxxx");
                        int y = 0;
                        while (y < i) {
                            System.out.println(y);
                        }
                    }
                }
            }
        }

      /*  switch (x) {
            case 5:
                System.out.println("aaa");
                break;
            case 3:
                System.out.println("aaa");
                break;
            case 2:
                System.out.println("aaa");
                if (x > 3) {
                    System.out.println("zzzzz");
                } else {
                    System.out.println("xxxxx");
                }
                break;
            case 1:
                System.out.println("aaa");
                break;
            default:
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
        }*/
    }
}
