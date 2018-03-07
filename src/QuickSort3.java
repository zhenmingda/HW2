public class QuickSort3 {
    static final int CUTOFF = 7;

    public static void quickSort3 (int[]a) {
        quickSort3(a, 0, a.length-1);
    }

    private static void quickSort3 (int[] a, int left, int right) {
        while (true) {
            if (right-left <= CUTOFF) {            // small subarray
                insertionSort(a, left, right);
                return;
            }
            int pivot = median3(a, left, right); // does a lot
            int i = left, j = right-1;            // subtle
            while (true) {
                while (a[++i] < pivot) ;
                while (a[--j] > pivot) ;
                if (i >= j
                        )
                    break;
                else {
                    // swapElements (a, i, j);
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            // swapElements (a, i, right-1);
            int tmp = a[i];
            a[i] = a[right-1];
            a[right-1] = tmp;
            // quickSort3 (a, left, i-1);
            // quickSort3 (a, i+1, right);
            if ((i-1)-left < right-(i+1)) {
                quickSort3 (a, left, i-1);
                left = i+1;
            } else {
                quickSort3 (a, i+1, right);
                right = i-1;
            }
        }
    }

    private static int median3 (int[]a, int left, int right) {
        int center = (left+right) / 2;
        if (a[center] < a[left]) {
            // swapElements (a, left, center);
            int tmp = a[center];
            a[center] = a[left];
            a[left] = tmp;
        }
        if (a[right] < a[left]) {
            // swapElements (a, left, right);
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        if (a[right] < a[center]) {
            // swapElements (a, center, right);
            int tmp = a[center];
            a[center] = a[right];
            a[right] = tmp;
        }
        // swapElements (a, center, right-1); // move pivot out
        int tmp = a[center];
        a[center] = a[right-1];
        a[right-1] = tmp;
        return a[right-1];
    }

    //     private final static void swapElements (long[] a, int i, int j) {
    //     long tmp = a[i];
    //     a[i] = a[j];
    //     a[j] = tmp;
    // }

    private static void insertionSort (int[] a, int left, int right) {
        int j;
        for (int i=left+1; i<=right; i++) {
            int tmp = a[i];
            for (j=i; j>left && tmp<a[j-1]; j--)
                a[j] = a[j-1];
            a[j] = tmp;
        }
    }

    public static void main(String[]args) {
     //   final int n=50000000, p=37;
        int [] a = new int[10];
      //  int val = p;
        for(int i=0; i<10; i++)
            a[i] = 10-i;
        quickSort3(a);
        System.out.println();
        for(int i=0; i<10; i++)
            if (a[i] != i)
                System.out.println(i + " != " + a[i]);
    }
}
// Local Variables:
// c-basic-offset: 4
// compile-command: "javac -Xlint:unchecked QuickSort3.java && java QuickSort3"
// End:

        