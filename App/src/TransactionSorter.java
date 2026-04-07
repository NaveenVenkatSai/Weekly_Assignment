import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionSorter {
    public static void bubbleSortByFee(List<TransactionFee> list) {
        int n = list.size();
        int passes = 0, swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Bubble Sort Result: " + list);
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
    }
    public static void insertionSortByFeeAndTime(List<TransactionFee> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            TransactionFee key = list.get(i);
            int j = i - 1;
            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result: " + list);
    }
    public static void detectHighFeeOutliers(List<TransactionFee> list) {
        System.out.print("High-fee outliers (>50): ");
        boolean found = false;

        for (TransactionFee t : list) {
            if (t.fee > 50) {
                System.out.print(t + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("none");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<TransactionFee> transactions = new ArrayList<>();
        transactions.add(new TransactionFee("id1", 10.5, "10:00"));
        transactions.add(new TransactionFee("id2", 25.0, "09:30"));
        transactions.add(new TransactionFee("id3", 5.0, "10:15"));
        List<TransactionFee> bubbleList = new ArrayList<>(transactions);
        List<TransactionFee> insertionList = new ArrayList<>(transactions);
        bubbleSortByFee(bubbleList);
        insertionSortByFeeAndTime(insertionList);
        detectHighFeeOutliers(transactions);
    }
}