package datastructure2021.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShellSort {

    /**
     * 插入排序的一种变种
     * 1. 先让数组中任意间隔为 h 的元素有序，刚开始 h 的大小可以是 h = n / 2,接着让 h = n / 4，让 h 一直缩小，
     * 2. 当 h = 1 时，也就是此时数组中任意间隔为1的元素有序，此时的数组就是有序的了。
     *
     * @param arr
     */
    public void solution(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int h = n / 2; h >= 1; h = h / 2) {
            // 分成h组
            for (int i = h; i < n; i++) {
                insertI(arr, h, i);
            }
        }
    }

    private void insertI(int[] arr, int h, int i) {
        int temp = arr[i];
        int k;
        for (k = i - h; k >= 0 && arr[k] > temp; k = k - h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 4, 8, 2, 12, 1, 3};

        new ShellSort().solution(arr);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
