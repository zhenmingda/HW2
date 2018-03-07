package Carwash;

public interface PureQueue<E>{
    int size();
    boolean isEmpty();
    void enqueue(E element);
    E dequeue();
    E front();
}

