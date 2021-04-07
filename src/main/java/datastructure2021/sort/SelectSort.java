package datastructure2021.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
首先，找到数组中最小的那个元素；
其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
如此往复，直到将整个数组排序。
 */
public class SelectSort {
    public void solution(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 4, 8, 2, 12, 1, 3};
        new SelectSort().solution(arr);
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

}
