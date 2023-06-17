package Practica3;

import java.util.ArrayList;

public class PriorityQueueHeap<E extends Comparable> {
    
    private TDAHeap<E> queue;
    
    public PriorityQueueHeap(int n) {
        this.queue = new TDAHeap<>(n);
    }
    
    public E deQueue() {
        if(!this.isEmpty()) {
            E elem = this.queue.delete();
            return elem;
        }
        return null;
    }

    public E back() {
        if( !this.isEmpty() ) {
            return this.queue.getArray().get(this.queue.getSize() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.queue.getSize() == 0;
    }
    
}
