public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
        System.out.println(larger(32, arr));
        System.out.println(larger(60, arr));
    }

    public static int larger(int newBook, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if(arr[middle] <= newBook && arr[middle +1] > newBook) {
                index = middle + 1;
                break;
            }
            if (arr[middle] > newBook && arr[middle - 1] <= newBook) {
                index = middle;
                break;

            } else if (arr[middle] == newBook) {
                left = middle + 1;
            } else if (arr[middle] < newBook) {
                left = middle + 1;
            } else if (arr[middle] > newBook) {
                right = middle - 1;
            }
        }
        return arr.length - index;
    }
}