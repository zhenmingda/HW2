import Huff.Heap;
import Huff.PurePriorityQueue;

import java.util.Scanner;

/**
 * Created by dashu on 2016-11-23.
 */
public class rewrew {
    protected static Entry[] leafEntries;  //Stores the chars in the Huffman tree.
    public final static int SIZE = 256; //The number of allowable chars, the ASCII set.
    //Also, we can store char information at the index relating to its decimal ASCII value.
    //E.g., "B" would be stored at index (int)'B' = 66 in leafEntries.

    protected PurePriorityQueue<Entry> pq;  //A PQ object for use in the Huffman algorithm.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a message to encode >");
        String message = s.nextLine();

        //Encode the message and print it out.
        rewrew h = new rewrew();
        h.updateFrequencies(message);
        for(int i=0;i<255;i++){
        System.out.print(leafEntries[i].freq);}
      //  h.createPQ();
    }


    public rewrew(){
        //Fill up the leafEntries arrays with empty Entries.
        Entry entry;
        leafEntries = new Entry[SIZE];  //The size of the array will never be modified because the character set is fixed length.
        for(int i=0;i<SIZE;i++){
            //At each index in the array,
            leafEntries[i] = new Entry();   //Create a new Entry object.
            //Then give that Entry some default data.
            entry=leafEntries[i];
            entry.freq=0;
            entry.left=null;
            entry.right=null;
            entry.parent=null;
        }
        //Then initialize the PQ.
        pq=new Heap<Entry>();
    }

    //Updates the frequencies of the characters in the message.
    public void updateFrequencies(String message){
        Entry entry;
        //Move through the message one character at a time.
        for(int j=0;j<message.length();j++){
            //Access the entry object in the array at index corresponding to the char's decimal ASCII value.
            entry=leafEntries[(int)(message.charAt(j))];
            //Increment that entry's frequency.

            entry.freq++;

        }
    }

}
class Entry implements Comparable{
    int freq;       //The frequency for this char in the message.
    String code;    //The Huffman encoding bit for this entry.
    char id;        //The char itself.
    Entry left,right,parent;

    public int compareTo(Object entry){
        return freq-((Entry)entry).freq;
    }
}