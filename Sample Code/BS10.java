public class SampleCode4 {
    private static void swap(int[] a, int i, int j) {                   
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] selectionSort(int[] list) {                         
        for (int i = 0; i < list.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minPos]) {                                                                       //therefore CCC = 40+79 =119                
                    minPos = j;
                }
            }
            swap(list, minPos, i);
        }
        return list;
    }
    public void BinarySearch(String x) {
        
    }
}