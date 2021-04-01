package datastructure2021.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BubbleSort {
    public void commonBubbleSort(int[] arr, int n){
        if(n<=1){
            return;
        }
        boolean hasChanged;
        for(int i=0; i<n-1; i++){
            hasChanged = false;
            for(int j = 0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    hasChanged = true;
                }
            }
            if(hasChanged == false){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,3,4,8,2,12,1,3};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.commonBubbleSort(arr, arr.length);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
