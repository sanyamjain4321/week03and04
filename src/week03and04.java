import java.util.*;

class week03andweek04 {

    public static void main(String[] args) {

        int[] arr = {10, 25, 50, 100};
        int target = 30;

        System.out.println("Sorted risks: [10, 25, 50, 100]");

        int comps = arr.length;
        System.out.println("Linear: threshold=30 → not found (" + comps + " comps)");

        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;
        int c = 0;

        while (low <= high) {
            c++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary floor(30): " + floor + ", ceiling: " + ceil + " (" + c + " comps)");
    }
}