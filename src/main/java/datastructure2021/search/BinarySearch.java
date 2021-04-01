package datastructure2021.search;

public class BinarySearch {

    public int binarySearch1(int[] arr, int key) {
        if (arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle;

        if (low > high || key < arr[low] || key > arr[high]) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] == key) {
                return middle;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 9, 13, 57, 345};

        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.binarySearch1(arr, 57));

        System.out.println(binarySearch.binarySearch1(arr, 0));

        System.out.println(binarySearch.binarySearch1(arr, 888));
    }
}
