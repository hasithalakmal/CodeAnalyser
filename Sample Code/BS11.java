public class SampleCode4 {
     public static void running() {
      int nDisks = 3;
      doTowers(nDisks, 'A', 'B', 'C');
   }

    public static void doTowers(int topN, char from, char inter, char to) {               
      if (topN == 1){
         System.out.println("Disk 1 from "
         + from + " to " + to);
      }else {
         doTowers(topN - 1, from, to, inter);
         System.out.println("Disk "
         + topN + " from " + from + " to " + to);
         doTowers(topN - 1, inter, from, to);
      }
   }

    public void solve(int n, String start, String auxiliary, String end) {  
      if (n == 1) {          
           System.out.println(start + " -> " + end);
       } else {
           solve(n - 1, start, end, auxiliary);
           System.out.println(start + " -> " + end);
           solve(n - 1, auxiliary, start, end);
       }
   }

   public static void Testing( ) {
       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
       System.out.print("Enter number of discs: ");
       Scanner scanner = new Scanner(System.in);
       int discs = scanner.nextInt();
       towersOfHanoi.solve(discs, "A", "B", "C");
   }
}