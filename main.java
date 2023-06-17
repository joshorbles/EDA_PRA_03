public class main {
    public static void main(String[] args) {
       
        TDAHeap<Integer> heap = new TDAHeap<>(10);

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(13);
        heap.insert(7);
        heap.insert(5);
        heap.insert(19);


        System.out.println("TDAHeap:");
        System.out.println("Array: " + heap.getArray());
        System.out.println("Tamaño: " + heap.getSize());

        Integer deletedElement = heap.delete();
        System.out.println("Elemento eliminado: " + deletedElement);
        System.out.println("Array después de la eliminación: " + heap.getArray());
        System.out.println("Tamaño después de la eliminación: " + heap.getSize());

        System.out.println();

        PriorityQueueHeap<String> priorityQueue = new PriorityQueueHeap<>(10);

        priorityQueue.enqueue("Elemento 1", 3);
        priorityQueue.enqueue("Elemento 2", 1);
        priorityQueue.enqueue("Elemento 3", 2);
        priorityQueue.enqueue("Elemento 4", 4);

        System.out.println("PriorityQueueHeap:");
        System.out.println("Elemento de mayor prioridad: " + priorityQueue.front());
        System.out.println("Elemento en el fondo: " + priorityQueue.back());
        System.out.println("¿La cola de prioridad está vacía? " + priorityQueue.isEmpty());

        String dequeuedElement = priorityQueue.deQueue();
        System.out.println("Elemento eliminado: " + dequeuedElement);
        System.out.println("Elemento de mayor prioridad después de la eliminación: " + priorityQueue.front());
        System.out.println("¿La cola de prioridad está vacía? " + priorityQueue.isEmpty());

    }
}
