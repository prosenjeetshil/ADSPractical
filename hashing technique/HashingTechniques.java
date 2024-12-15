import java.util.Scanner;

class Hashing {
    private static final int SIZE = 10; // Hash table size
    private int[] hashTable;

    public Hashing() {
        hashTable = new int[SIZE];
        // Initialize the hash table with -1 to represent empty slots
        for (int i = 0; i < SIZE; i++) {
            hashTable[i] = -1;
        }
    }

    // Direct Hashing
    public void directHashing(int[] keys) {
        resetHashTable();
        for (int key : keys) {
            if (key < SIZE) {
                hashTable[key] = key;
            } else {
                System.out.println("Key " + key + " exceeds hash table size.");
            }
        }
    }

    // Subtraction Hashing
    public void subtractionHashing(int[] keys, int subtractValue) {
        resetHashTable();
        for (int key : keys) {
            int index = key - subtractValue;
            if (index >= 0 && index < SIZE) {
                hashTable[index] = key;
            } else {
                System.out.println("Key " + key + " is out of range.");
            }
        }
    }

    // Modulo Division Hashing
    public void moduloDivisionHashing(int[] keys) {
        resetHashTable();
        for (int key : keys) {
            int index = key % SIZE;
            while (hashTable[index] != -1) {
                index = (index + 1) % SIZE; // Linear probing
            }
            hashTable[index] = key;
        }
    }

    // Digit Extraction Hashing
    public void digitExtractionHashing(int[] keys) {
        resetHashTable();
        for (int key : keys) {
            int index = extractDigits(key);
            while (hashTable[index] != -1) {
                index = (index + 1) % SIZE; // Linear probing
            }
            hashTable[index] = key;
        }
    }

    // Folding (Shift Method)
    public void foldShiftHashing(int[] keys) {
        resetHashTable();
        for (int key : keys) {
            int index = foldShift(key);
            while (hashTable[index] != -1) {
                index = (index + 1) % SIZE; // Linear probing
            }
            hashTable[index] = key;
        }
    }

    // Folding (Boundary Method)
    public void foldBoundaryHashing(int[] keys) {
        resetHashTable();
        for (int key : keys) {
            int index = foldBoundary(key);
            while (hashTable[index] != -1) {
                index = (index + 1) % SIZE; // Linear probing
            }
            hashTable[index] = key;
        }
    }

    // Display the hash table
    public void displayHashTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println("Index " + i + ": " + hashTable[i]);
        }
    }

    // Helper method to reset the hash table
    private void resetHashTable() {
        for (int i = 0; i < SIZE; i++) {
            hashTable[i] = -1;
        }
    }

    // Digit extraction example: extracts 1st, 3rd, and 5th digits of a number
    private int extractDigits(int key) {
        String keyStr = String.valueOf(key);
        int index = 0;
        if (keyStr.length() >= 5) {
            index = Character.getNumericValue(keyStr.charAt(0)) +
                    Character.getNumericValue(keyStr.charAt(2)) +
                    Character.getNumericValue(keyStr.charAt(4));
        }
        return index % SIZE;
    }

    // Folding Shift Method
    private int foldShift(int key) {
        String keyStr = String.valueOf(key);
        int mid = keyStr.length() / 2;
        String part1 = keyStr.substring(0, mid);
        String part2 = keyStr.substring(mid);
        int index = Integer.parseInt(part1) + Integer.parseInt(part2);
        return index % SIZE;
    }

    // Folding Boundary Method
    private int foldBoundary(int key) {
        String keyStr = String.valueOf(key);
        StringBuilder part1 = new StringBuilder(keyStr.substring(0, keyStr.length() / 2));
        String part2 = keyStr.substring(keyStr.length() / 2);
        int reversed1 = Integer.parseInt(part1.reverse().toString());
        int reversed2 = Integer.parseInt(new StringBuilder(part2).reverse().toString());
        int index = reversed1 + reversed2;
        return index % SIZE;
    }
}

public class HashingTechniques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hashing hashing = new Hashing();
        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Direct Hashing");
            System.out.println("2. Subtraction Hashing");
            System.out.println("3. Modulo Division Hashing");
            System.out.println("4. Digit Extraction Hashing");
            System.out.println("5. Folding (Shift Method)");
            System.out.println("6. Folding (Boundary Method)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    int[] directKeys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                    hashing.directHashing(directKeys);
                    hashing.displayHashTable();
                    break;
                case 2:
                    int[] subKeys = {1001, 1002, 1003, 1004, 1005};
                    hashing.subtractionHashing(subKeys, 1000);
                    hashing.displayHashTable();
                    break;
                case 3:
                    int[] modKeys = {23, 44, 12, 88, 43, 35};
                    hashing.moduloDivisionHashing(modKeys);
                    hashing.displayHashTable();
                    break;
                case 4:
                    int[] digitKeys = {123456, 654321, 789012, 345678};
                    hashing.digitExtractionHashing(digitKeys);
                    hashing.displayHashTable();
                    break;
                case 5:
                    int[] foldShiftKeys = {1234, 5678, 91011, 11213};
                    hashing.foldShiftHashing(foldShiftKeys);
                    hashing.displayHashTable();
                    break;
                case 6:
                    int[] foldBoundaryKeys = {1234, 5678, 91011, 11213};
                    hashing.foldBoundaryHashing(foldBoundaryKeys);
                    hashing.displayHashTable();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (option != 7);

        scanner.close();
    }
}