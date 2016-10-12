/**
 * Created by Mingda Zhen on 2016/9/17.
 * version 1.0
 * This class creates an array and append, insert delete numbers
 *
 */
import java.util.Scanner;

public class Sequence<E> {
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.data = new Object[n];
        this.size = 0;//the size of current array
    }

    public int size() {
        return this.size;
    }// return the size of current array

    //append the element
    public void append(E element) {
        if (this.size < this.data.length) {
            this.data[this.size] = element;
        } else {
            Object[] temp = new Object[this.size + 1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data = temp;
            this.data[this.size] = element;
        }
        this.size++;
    }
//return the element of array
    public Object get(int k) throws IndexOutOfBoundsException {
        if (k < 0 || k >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.data[k];
    }
//print array
    public void print() {
        System.out.print("\nCurrent Sequence: ");
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }
//insert element
    public void insert(int index, E newElement) {
        //IMPLEMENT ME
        Object[] temp = new Object[this.size + 1];
        System.arraycopy(this.data, 0, temp, 0, index);
        temp[index] = newElement;
        System.arraycopy(this.data, index, temp, index + 1, this.data.length - index);
        this.data = temp;
        this.size=this.data.length;
    }
//delete element
    public void delete(int index) {
        //IMPLEMENT ME
        Object[] temp = new Object[this.size-1];
        System.arraycopy(this.data, 0, temp, 0, index);
        System.arraycopy(this.data, index+1, temp, index, this.data.length - index-1);
        this.data = temp;
        this.size=this.data.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sequence<Integer> s = new Sequence<Integer>(5);
        s.append(1);
        s.append(2);
        s.append(3);
        s.append(4);
        s.append(5);
        s.print();
        while (true) {
            System.out.println("Please enter 1 to insert, 2 to delete, or 3 to quit");
            Scanner choice = new Scanner(System.in);
            int i = choice.nextInt();
            if (i == 1) {

                System.out.println("Please enter the value to insert");
                Scanner value = new Scanner(System.in);
                if (value.hasNext()) {
                    System.out.println("Please enter the index to insert");
                    Scanner index = new Scanner(System.in);
                    s.insert(index.nextInt(), value.nextInt());
                }

                s.print();
            } else if (i == 2) {
                System.out.println("Please enter the index to delete");
                Scanner index = new Scanner(System.in);
                s.delete(index.nextInt());
                s.print();
            } else if (i == 3) {
                break;
            } else
                System.out.println("Please input 1 or 2 or 3");
        }
        //INSERT CONTROL LOOP HERE

    }   //End main
} 