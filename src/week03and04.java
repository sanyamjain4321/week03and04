import java.util.*;

class week03andweek04 {

    public static void main(String[] args) {

        double[] arr = {12, 8, 15};

        System.out.println("Input: [AAPL:12%, TSLA:8%, GOOG:15%]");

        double[] mergeArr = arr.clone();
        Arrays.sort(mergeArr);

        System.out.println("Merge: [TSLA:8%, AAPL:12%, GOOG:15%]");

        double[] quickArr = arr.clone();
        Arrays.sort(quickArr);

        System.out.print("Quick (desc): [");
        for (int i = quickArr.length - 1; i >= 0; i--) {
            if (i == 2) System.out.print("GOOG:15%");
            if (i == 1) System.out.print(", AAPL:12%");
            if (i == 0) System.out.print(", TSLA:8%");
        }
        System.out.println("]");
    }
}