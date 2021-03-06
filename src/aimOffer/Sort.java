package aimOffer;

import java.util.Arrays;

//排序算法
public class Sort {
    //快速排序
    public void quickSort(int[] input) {
        if(input == null || input.length <= 1) return;
        partition2(input, 0, input.length - 1);
    }
    private void partition(int[] input, int start, int end) {
        if(start >= end) return;
        int i = start + 1, j = end;
        while(i <= j) {
            if(input[i] < input[start]) {
                i++;
            }
            else {
                if(input[j] < input[start]) {
                    swap(input, i, j);
                    i++;j--;
                }
                else j--;
            }
        }
        swap(input, start, j);
        partition(input, start, j);
        partition(input, i, end);
    }
    //简洁写法
    private void partition2(int[] input, int start, int end) {
        if(start >= end) return;
        int partition = input[start];
        int i = start;
        int j = end + 1;
        while(true) {
            while(i < end && input[++i] <= partition) ;
            while(j > start && input[--j] >= partition) ;
            if(i >= j) break;
            swap(input, i, j);
        }
        swap(input, start, j);
        partition2(input, start, j - 1);
        partition2(input, i, end);
    }

    //冒泡排序
    public void bubbleSort(int[] input) {
        if(input == null || input.length <= 1) return;
        for(int i = 0; i < input.length; i++)
            for(int j = i + 1; j < input.length; j++) {
                if(input[i] > input[j])
                    swap(input, i, j);
            }
    }

    //插入排序
    public void insertionSort(int[] input) {
        for(int i = 0; i < input.length - 1; i++) {
            if(input[i] > input[i + 1]) {
                int j = i + 1;
                while(j > 0 && input[j] < input[j - 1]) {
                    swap(input, j ,j - 1);
                    j--;
                }
            }
        }
    }

    //选择排序
    public void selectionSort(int[] input) {
        if(input == null || input.length <= 1) return;
        for(int i = 0; i < input.length; i++) {
            int min = i;
            for(int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min]) min = j;
            }
            swap(input, i, min);
        }
    }

    //归并排序
    public int[] mergeSort(int[] input) {
        if(input == null || input.length <= 1) return input;
        int[] a = Arrays.copyOf(input, input.length / 2);
        int[] b = Arrays.copyOfRange(input, input.length / 2, input.length);
        return merge(mergeSort(a), mergeSort(b));
    }
    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int index = 0;
        int i = 0, j = 0;
        for(; i < a.length && j < b.length; ) {
            if(a[i] < b[j]) {
                res[index++] = a[i];
                i++;
            }
            else {
                res[index++] = b[j];
                j++;
            }
        }
        for(; i < a.length; i++) res[index++] = a[i];
        for(; j < b.length; j++) res[index++] = b[j];
        for(Integer val : res) System.out.print(val + " ");
        System.out.println();
        return res;
    }

    //希尔排序
    public void shellSort(int[] input) {
        if(input == null || input.length <= 1) return;
        int gap = input.length / 2;
        for(; gap > 0; gap = gap / 2) {
            for(int j = 0; j < gap; j++) {
                for(int i = j; i + gap < input.length; i += gap) {
                    if(input[i] > input[i + gap]) {
                        int k = i + gap;
                        while(k - gap >= 0 && input[k - gap] > input[k]) {
                            System.out.print(gap + ": ");
                            swap(input, k - gap ,k);
                            k -= gap;
                        }
                    }
                }
            }
        }
    }

    //堆排序
    public void heapSort(int[] input) {
        adjust(input, 0, input.length - 1);
    }
    private void adjust(int[] input, int start, int end) {
        if(input == null || start >= end) return;
        for(int parent = (end + 1) / 2 - 1; parent >= start; parent--){
            int left = 2 * (parent + 1) - 1;
            int right = left + 1 > end ? -1 : left + 1;
            if(right == -1 && input[left] > input[parent]){
                swap(input, left, parent);
            }
            if(right != -1) {
                int max = input[left] > input[right] ? left : right;
                if(input[max] > input[parent])
                    swap(input, max,parent);
            }
        }
        swap(input, start, end);
        adjust(input, start, end - 1);
    }

    private void swap(int[] input, int i, int j) {
        if(i == j) return;
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        for(Integer a : input) System.out.print(a + " ");
        System.out.println();
    }
    public static void main(String[] args) {
//        int n = 5;
//        int[] a = new int[n];
//        for(int i = 0; i < n;i++) {
//            a[i] = (int) (Math.random() * 100);
//        }
        int[] a = new int[]{5, 4, 3, 6, 2};
        for(Integer i : a) System.out.print(i + " ");
        System.out.println();
        new Sort().quickSort(a);
//        new Sort().bubbleSort(a);
//        new Sort().insertionSort(a);
//        new Sort().selectionSort(a);
//        new Sort().mergeSort(a);
//        new Sort().shellSort(a);
//        new Sort().heapSort(a);
    }

}
