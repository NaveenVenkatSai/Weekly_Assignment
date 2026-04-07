public class TransactionSorter {
    static class Client {
        String name;
        int riskScore;
        double accountBalance;
        Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }
    }
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                    swapped = true;
                    System.out.println("Swap: " + arr[j].name + " <-> " + arr[j + 1].name);
                }
            }

            if (!swapped) break;
        }
        System.out.println("Total Swaps: " + swapCount);
    }
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void printTopN(Client[] arr, int n) {
        System.out.println("\nTop " + n + " High Risk Clients:");
        for (int i = 0; i < Math.min(n, arr.length); i++) {
            System.out.println(arr[i].name + " (" + arr[i].riskScore + ")");
        }
    }
    public static void printClients(Client[] arr) {
        for (Client c : arr) {
            System.out.println(c.name + ":" + c.riskScore + ", Balance=" + c.accountBalance);
        }
    }
    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 3000),
                new Client("clientB", 50, 4000)
        };
        System.out.println("Bubble Sort (Ascending):");
        bubbleSort(clients);
        System.out.println("\nAfter Bubble Sort:");
        printClients(clients);
        System.out.println("\nInsertion Sort (Descending):");
        insertionSort(clients);
        System.out.println("\nAfter Insertion Sort:");
        printClients(clients);
        printTopN(clients, 3);
    }
}