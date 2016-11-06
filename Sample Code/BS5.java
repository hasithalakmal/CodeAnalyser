public class SampleCode4 {
    public void BinarySearch(String x) {
        int[] num = {1, 2, 3, 4, 5, 6};
        int ccc = 0;
        int j;  int key;     
        int i;

        for (j = 1; j < num.length; j++){
            key = num[j];
            for (i = j - 1; (i >= 0) && (num[i] < key); i--){
                num[i + 1] = num[i];
            }
            num[i + 1] = key;    
        }
    }
}