
import java.util.Scanner;

    public class  Qirui_Sequence<E>{
        protected Object[] data;
        protected int size;

        public Qirui_Sequence(int n) throws IllegalArgumentException{
            if(n<0){
                throw new IllegalArgumentException();}
            this.data=new Object[n];
            this.size=0;
        }

        public int size(){
            return this.size;
        }

        public void append(E element){
            if(this.size<this.data.length){
                this.data[this.size]=element;
            }
            else{
                Object[] temp=new Object[this.size+1];
                System.arraycopy(this.data, 0, temp, 0, this.size);
                this.data=temp;
                this.data[this.size]=element;
            }
            this.size++;
        }

        public Object get(int k) throws IndexOutOfBoundsException{
            if(k<0 || k>=this.size){
                throw new IndexOutOfBoundsException();}
            return this.data[k];
        }

        public void print(){
            System.out.print("\nCurrent Sequence: ");
            for(int i=0;i<this.size();i++){
                System.out.print(this.get(i)+" ");
            }
            System.out.println();
        }

        public void insert(int index, E newElement){
            Object[] temp = new Object[this.size+1];
            System.arraycopy(this.data, 0, temp, 0, this.size); //copy original array first
            temp[index] = newElement; //insert new element
            System.arraycopy(data, index, temp, index+1, data.length-index); //copy(add) the rest elements after the new element
            this.data = temp;
            this.size++; //display with one more object
        }
        public void delete(int index){
            Object[] temp = new Object[this.size-1];
            System.arraycopy(this.data, 0, temp, 0, this.size-1); //'this.size-1' in case it would be out of bound
            System.arraycopy(data, index+1, temp, index, data.length-index-1);
            data = temp;
            this.size--;
        }


        public static void main (String[] args) {
            Scanner in = new Scanner(System.in);
            Qirui_Sequence<Integer> s = new Qirui_Sequence<Integer>(5);
            s.append(1);
            s.append(2);
            s.append(3);
            s.append(4);
            s.append(5);
            s.print();


            while (true) {
                System.out.println("Please enter 1 o insert, 2 to delete, or 3 to quit.");
                int com = in.nextInt(); //get the input
                if (com == 1) {
                    System.out.println("Please enter the value to insert.");
                    int newElement = in.nextInt();
                    System.out.println("Please enter the index to insert.");
                    int num = in.nextInt();
                    s.insert(num, newElement);
                    s.print();
                } else if (com == 2) {
                    System.out.println("Please enter the index to delete.");
                    int num = in.nextInt();
                    s.delete(num);
                    s.print();
                } else if (com == 3) {
                    System.out.println("Goodbye");
                    break;//jump out of loop
                }
                else{
                    System.out.println("Invalid choice");
                }
            }

        }   //End main
    }   //End class

