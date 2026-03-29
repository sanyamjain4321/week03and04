import java.util.*;

class week03andweek04 {

    static class Client {
        String name;
        int risk;

        Client(String name, int risk) {
            this.name = name;
            this.risk = risk;
        }
    }

    public static void main(String[] args) {

        Client[] arr = {
                new Client("clientC", 80),
                new Client("clientA", 20),
                new Client("clientB", 50)
        };

        System.out.println("Input: [clientC:80, clientA:20, clientB:50]");

        // -------- Bubble Sort ASC --------
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.print("Bubble (asc): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(6) + ":" + arr[i].risk);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("] // Swaps: " + swaps);

        // -------- Insertion Sort DESC --------
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].risk < key.risk) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.print("Insertion (desc): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(6) + ":" + arr[i].risk);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Top 3 risks: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(6) + "(" + arr[i].risk + ")");
            if (i != arr.length - 1) System.out.print(", ");
        }
    }
}