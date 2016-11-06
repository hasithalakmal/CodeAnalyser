public class SampleCode4 {
    public void BinarySearch(String x) {
        int [] num = {1, 2, 3, 4, 5, 6};
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < num.length - 1; j++) {
                if (num [j] < num[j + 1]) {
                    temp = num[j];
                    num [j] = num[j + 1];
                    num [j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
}