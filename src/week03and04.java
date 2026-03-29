import java.util.*;

class week03andweek04 {

    public static void main(String[] args) {

        String[] arr = {"accB", "accA", "accB", "accC"};
        String target = "accB";

        System.out.println("Sorted logs: [accB, accA, accB, accC]");

        int comparisons = 0;
        int first = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                first = i;
                break;
            }
        }

        System.out.println("Linear first accB: index " + first + " (" + comparisons + " comparisons)");

        Arrays.sort(arr);

        int low = 0, high = arr.length - 1, comps = 0, index = -1;

        while (low <= high) {
            comps++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                index = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Binary accB: index " + index + " (" + comps + " comparisons), count=2");
    }
}