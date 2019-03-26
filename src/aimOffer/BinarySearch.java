package aimOffer;

public class BinarySearch {

    public int binarySearch(int[] input, int key) {
        return search(input, 0, input.length - 1, key);
    }
    private int search(int[] input, int start, int end, int key) {
        if(start == -1 || end == -1) return -1;
        if(start == end) {
            if(key == input[start]) return start;
            else return -1;
        }
        int mid = start + (end - start) / 2;
        if(input[mid] == key) return mid;
        if(input[mid] < key) return search(input, mid + 1, end, key);
        else return search(input, start, mid - 1, key);
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = new int[]{3,4,5,6,7,80,1,2};
        System.out.println(binarySearch.binarySearch(input, 6));
    }
}
