package datastructure2021.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertSort {

    /**
     * 1、从数组第2个元素开始抽取元素。
     * <p>
     * 2、把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去，直到遇到不比它大的元素，然后插到这个元素的右边。
     * <p>
     * 3、继续选取第3，4，....n个元素,重复步骤 2 ，选择适当的位置插入。
     *
     * @param arr
     */
    public void solution(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > temp) {
                k--;
            }
            for (int j = i; j > k + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[k + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 4, 8, 2, 12, 1, 3};

        new InsertSort().solution(arr);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
