package com.bat.algorithmTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class quicksortTest {

    public ArrayList quickTest(ArrayList<Integer> array){

        ArrayList<Integer> front_arr = new ArrayList<Integer>();
        ArrayList<Integer> behind_arr = new ArrayList<Integer>();
        Integer temp = array.get(0);
        for (int i = 1; i < array.size(); i++){
            if (array.get(0) < array.get(i)){
                behind_arr.add(array.get(i));
            }else{
                front_arr.add(array.get(i));
            }
        }
        if(front_arr.size() > 1){
            quickTest(front_arr);
        }
        if(behind_arr.size() > 1){
            quickTest(behind_arr);
        }
        array.clear();
        for (int i = 0; i < front_arr.size(); i++){
            array.add(front_arr.get(i));
        }
        array.add(temp);
        for (int i = 0; i < behind_arr.size(); i++) {
            array.add(behind_arr.get(i));
        }
        return array;
    }
    public int[] productArr(){
        Random random = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
    @Test
    public void test(){
        int[] array = productArr();
        testQuick(array);
        arrayListSort(array);
    }

    public void testQuick(int[] array){
        long time = System.currentTimeMillis();
        ArrayList<Integer> arr = new ArrayList<Integer> ();
        for (int i = 0; i < array.length; i++) {
            arr.add(array[i]);
        }
        quickTest(arr);
        long time1 = System.currentTimeMillis();
        System.out.println(time1 - time);
    }

    public void arrayListSort(int[] array){
        long time = System.currentTimeMillis();
        ArrayList<Integer> arr = new ArrayList<Integer> ();
        for (int i = 0; i < array.length; i++) {
            arr.add(array[i]);
        }
        Collections.sort(arr);
//        arr.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1.intValue() > o2.intValue()){
//                    return 1;
//                }else{
//                    return 0;
//                }
//            }
//        });
        long time1 = System.currentTimeMillis();
        System.out.println(time1 - time);
    }
}
