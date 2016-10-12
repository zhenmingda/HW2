/**
 * Created by dashu on 2016/10/1.
 * version 1.0
 * This class is to compare the time cost between linked list and array list
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class HW3 {

    public static void main(String[] args) {
// initialize two lists
        ArrayList<Integer> arrayList = new ArrayList(1000000);
        LinkedList<Integer> linkedList = new LinkedList();

        long beginTimeForArrayListAdd = System.nanoTime();//set begin time
        //Adding
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        double durationTimeForArrayListAdd = (System.nanoTime() - beginTimeForArrayListAdd) / Math.pow(10, 9);
        System.out.println("ArrayList add:" + durationTimeForArrayListAdd + " seconds");

        long beginTimeForLinkedListAdd = System.nanoTime();


        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        double durationTimeForLinkedListAdd = (System.nanoTime() - beginTimeForLinkedListAdd) / Math.pow(10, 9);
        System.out.println("LinkedList add:" + durationTimeForLinkedListAdd + " seconds");

//get
        long beginTimeForArrayListGet = System.nanoTime();//set begin time
        ListIterator<Integer> iterator1 = arrayList.listIterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        double durationTimeForArrayListGet = (System.nanoTime() - beginTimeForArrayListGet) / Math.pow(10, 9);
        System.out.println("ArrayList get: " + durationTimeForArrayListGet + " seconds");


        long beginTimeForLinkedListGet = System.nanoTime();//set begin time
        ListIterator<Integer> iterator2 = linkedList.listIterator();
        while (iterator2.hasNext()) {
            iterator2.next();
        }
        double durationTimeForLinkedListGet = (System.nanoTime() - beginTimeForLinkedListGet) / Math.pow(10, 9);
        System.out.println("LinkedList get: " + durationTimeForLinkedListGet + " seconds");

//remove
        long beginTimeForArrayListRemove = System.nanoTime();
        while (iterator1.hasPrevious()) {
            iterator1.previous();
            iterator1.remove();
        }
        double durationTimeForArrayListRemove = (System.nanoTime() - beginTimeForArrayListRemove) / Math.pow(10, 9);
        System.out.println("ArrayList remove: " + durationTimeForArrayListRemove + " seconds");

        long beginTimeForLinkedListRemove = System.nanoTime();
        while (iterator2.hasPrevious()) {
            iterator2.previous();
            iterator2.remove();
        }
        double durationTimeForLinkedListRemove = (System.nanoTime() - beginTimeForLinkedListRemove) / Math.pow(10, 9);
        System.out.println("LinkedList remove: " + durationTimeForLinkedListRemove + " seconds");

        
        
        

        
        
        
        
        




    }

}
