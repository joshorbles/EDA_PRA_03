<<<<<<< HEAD


public class PriorityQueueHeap<E extends Comparable<E>> {

    private TDAHeap<PriorityQueueElement<E>> queue;

    public PriorityQueueHeap(int n) {
        this.queue = new TDAHeap<>(n);
    }

    private class PriorityQueueElement<T> implements Comparable<PriorityQueueElement<T>> {
        private T element;
        private int priority;

        public PriorityQueueElement(T element, int priority) {
            this.element = element;
            this.priority = priority;
        }

        @Override
        public int compareTo(PriorityQueueElement<T> other) {
            return Integer.compare(this.priority, other.priority);
        }

        public T getElement() {
            return element;
        }
    }
    
     public boolean isEmpty() {
        return this.queue.getSize() == 0;
    }

    public void enqueue(E element, int priority) {
        PriorityQueueElement<E> priorityElement = new PriorityQueueElement<>(element, priority);
        this.queue.insert(priorityElement);
    }

    public E deQueue() {
        if (!this.isEmpty()) {
            PriorityQueueElement<E> elem = this.queue.delete();
            return elem != null ? elem.getElement() : null;
        }
        return null;
    }

     public E front() {
        if (!isEmpty()) {
            return this.queue.getArray().get(0).getElement();
=======
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
>>>>>>> 3123a80d819315ca8c336f558eb5d414d9901a13
        }
        return null;
    }

    public E back() {
<<<<<<< HEAD
        if (!this.isEmpty()) {
            return this.queue.getArray().get(this.queue.getSize() - 1).getElement();
=======
        if( !this.isEmpty() ) {
            return this.queue.getArray().get(this.queue.getSize() - 1);
>>>>>>> 3123a80d819315ca8c336f558eb5d414d9901a13
        }
        return null;
    }

<<<<<<< HEAD
   

    

    

   
}
=======
    public boolean isEmpty() {
        return this.queue.getSize() == 0;
    }
    
}
>>>>>>> 3123a80d819315ca8c336f558eb5d414d9901a13
