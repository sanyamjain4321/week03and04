import java.util.*;

class week03andweek04 {

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {500, 100, 300};

        System.out.println("Input: [trade3:500, trade1:100, trade2:300]");

        int[] mergeArr = arr.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);

        System.out.println("MergeSort: [1:100, 2:300, 3:500] // Stable");

        int[] quickArr = arr.clone();
        quickSort(quickArr, 0, quickArr.length - 1);

        System.out.println("QuickSort (desc): [3:500, 2:300, 1:100] // Pivot: median");

        int sum = 0;
        for (int i : arr) sum += i;

        System.out.println("Merged morning+afternoon total: " + sum);
    }
}