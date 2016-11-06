public class SampleCode4 {

 public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public void print() {
        System.out.println("Hello");
    }

    public void printString(String code) {
        System.out.println(code);
    }

    public static void main(String [] args) {
        SampleCode6 sc = new SampleCode6();
        sc.add(0, 0);
        if(true){
            sc.print();
        }
        
        for (int i = 0; i < 10; i++) {
            sc.printString("hello");
        }
        
        sc.printString("hello");
        sc.concat("aaa", "www");
        int []a = {1,2,3};
        int []b = {1,2,3};
        sc.addArr(a, b);
        sc.methodOned(5, "aaaaa",1.23);

    }

    public String concat(String x, String y) {
        String newString = x + y;
        return newString;
    }

    public int[] addArr(int x[], int y[]) {
        int z[] = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            System.out.println("aaaa");
            z[i] = x[i] + y[i];
        }
        return z;
    }

    public int[] methodOned(int x, String y, double z) {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        int[] a = {1, 2, 3, 4, 5};
        return a;
    }
    
    public int[] methodOnedaa(int x [][], String y[], double z[][]) {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        int[] a = {1, 2, 3, 4, 5};
        return a;
    }

    
}