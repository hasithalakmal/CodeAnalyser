public class SampleCode4 {
    public void BinarySearch(String x) {
        int c, first, last, middle, n, search, array[];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        n = in.nextInt();
        array = new int[n];

        for (c = 0; c < n; c++) {
            array[c] = in.nextInt();
        }
        System.out.println("Enter value to find");
        search = in.nextInt();

        first = 0;
        last = n - 1;
        middle = (first + last) / 2;

        while (first <= last) {
            if (array[middle] < search) {
                first = middle + 1;
            } else if (array[middle] == search) {
                break;
            } else {
                last = middle - 1;
            }

            middle = (first + last) / 2;
        }
        if (first > last) {
        }
    }
}