public class Quick3way {
    public static void main(String[] args) {
        int[] myArray6 = {3, 1, 5, 8, 9, 10, 12, 14, 5, 13};
        sort(myArray6, 0, myArray6.length - 1);
        printArray(myArray6);
    }

    public static void printArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ", ");
        }
        System.out.println();
    }

    private static void sort(int[] x, int low, int high) {

        int lt = low, gt = high;//start and end
        int pivot = x[low];
        int i = low;
        while (i <= gt) {
            if (x[i] < pivot) {
                swap(x, lt, i);
                lt++;
                i++;
            } else if (x[i] > pivot) {
                swap(x, i, gt);
                gt--;
            } else i++;
        }
        if (low < lt - 1) {
            sort(x, low, lt - 1);
        }
        if (gt + 1 < high)
            sort(x, gt + 1, high);
    }

    public static void swap(int[] x, int a, int b) {
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}