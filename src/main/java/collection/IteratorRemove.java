package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IteratorRemove {
    public static void main(String[] args) {

        int[] myList = new int[]{1,2,3,4,5,6,5,8};
        List<Integer> list = Arrays.stream(myList).boxed().collect(Collectors.toList());
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int tmp = iterator.next();
            if(tmp == 5){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
