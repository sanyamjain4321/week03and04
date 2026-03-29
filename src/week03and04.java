import java.util.*;

class week03andweek04 {

    static class Transaction {
        String id;
        double fee;
        String ts;

        Transaction(String id, double fee, String ts) {
            this.id = id;
            this.fee = fee;
            this.ts = ts;
        }
    }

    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        // -------- Input --------
        System.out.println("Input transactions:");
        for (Transaction t : list) {
            System.out.println(t.id + ", fee=" + t.fee + ", ts=" + t.ts);
        }

        // -------- Bubble Sort (by fee) --------
        ArrayList<Transaction> bubble = new ArrayList<>(list);
        int passes = 0, swaps = 0;

        for (int i = 0; i < bubble.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < bubble.size() - i - 1; j++) {
                if (bubble.get(j).fee > bubble.get(j + 1).fee) {
                    Collections.swap(bubble, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }
            passes++;
            if (!swapped) break;
        }

        System.out.print("BubbleSort (fees): [");
        for (int i = 0; i < bubble.size(); i++) {
            Transaction t = bubble.get(i);
            System.out.print(t.id + ":" + t.fee);
            if (i != bubble.size() - 1) System.out.print(", ");
        }
        System.out.println("] // " + passes + " passes, " + swaps + " swaps");

        // -------- Insertion Sort (fee + timestamp) --------
        ArrayList<Transaction> insertion = new ArrayList<>(list);

        for (int i = 1; i < insertion.size(); i++) {
            Transaction key = insertion.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (insertion.get(j).fee > key.fee ||
                            (insertion.get(j).fee == key.fee &&
                                    insertion.get(j).ts.compareTo(key.ts) > 0))) {

                insertion.set(j + 1, insertion.get(j));
                j--;
            }
            insertion.set(j + 1, key);
        }

        System.out.print("InsertionSort (fee+ts): [");
        for (int i = 0; i < insertion.size(); i++) {
            Transaction t = insertion.get(i);
            System.out.print(t.id + ":" + t.fee + "@" + t.ts);
            if (i != insertion.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        // -------- High Fee --------
        boolean found = false;
        for (Transaction t : list) {
            if (t.fee > 50) {
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("High-fee outliers: none");
        else
            System.out.println("High-fee outliers: present");
    }
}