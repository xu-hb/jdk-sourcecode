package util.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {
    public static void main(String[]args){
        testToArray();
    }

    /**
     * 验证collection.contains对null处理：(o==null ? e==null : o.equals(e))
     * @see java.util.AbstractCollection#contains(Object)
     */
    public static void testContainsOfNull(){
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(null);

        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        //调用contains
        list1.removeAll(list2);

        //输出：1,null
        list1.forEach(System.out::println);
    }

    /**
     * 验证collection.toArray是否会使用参数数组空间
     * @see java.util.AbstractCollection#toArray(Object[])
     */
    public static void testToArray(){
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Integer[] arr = new Integer[2];
        arr[0]=9;
        arr[1]=8;
        Integer[] res = list.toArray(arr);
        //1.当arr.length>=list.size,返回true，表明是直接在arr上赋值
        //2.否则，返回false，res是新分配的空间
        System.out.println(arr==res);
    }

}
