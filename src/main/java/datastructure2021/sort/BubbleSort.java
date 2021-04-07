package datastructure2021.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
    /**
     * 1、把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。
     * 2. 接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置....
     * 3. 如从开始的第一对到结尾的最后一对，相邻的元素之间都没有发生交换的操作，则数组有序，不必再排序
     *
     * @param arr
     */
    public void solution(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;

        // n-1趟
        for (int i = 0; i < n - 1; i++) {

            boolean isChanged = false;

            //每一趟把最大的沉到最下面
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isChanged = true;
                }
            }

            if (isChanged == false) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 4, 8, 2, 12, 1, 3};

        new BubbleSort().solution(arr);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
