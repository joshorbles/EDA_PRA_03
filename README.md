Práctica Nro. 3

Integrantes:
- Condori Pinto Juan José
- Orbegozo Lezcano Joshua Gilbert

Grupo: A

EJERCICIO 1:

- Implemente el TAD Heap genérico que este almacenado sobre un ArrayList con las operaciones de inserción y eliminación. Este TAD debe de ser un heap maximo

Para la clase TDAHeap se crearon dos métodos principales: insert y delete, así como dos métodos auxiliares para su posterior implementación, también el toString

Constructor: Se crea un nuevo objeto TDAHeap especificando la capacidad inicial del ArrayList que almacena los elementos del montículo.

`public TDAHeap(int n) {
        this.array = new ArrayList<>(n);
}`

getSize(): Devuelve el número de elementos actualmente almacenados en el montículo.

`
public int getSize() {
        return this.array.size();
}
`

getArray(): Devuelve una referencia al ArrayList que almacena los elementos del montículo (usado en la clase PriorityQueueheap para obtener elementos e insertarlos)

`
public ArrayList<E> getArray() {
        return this.array;
}
`

insert(E data): Inserta un nuevo elemento en el montículo. El nuevo elemento se agrega al final del ArrayList y luego se realiza un ajuste ascendente (up-heap) para mantener la propiedad del montículo.

`public void insert(E data) {
    this.array.add(data);
    int i = this.array.size();
    while (i > 1 && this.array.get(i - 1).compareTo(this.array.get(i / 2 - 1)) > 0) {
        E temp = this.array.get(i - 1);
        this.array.set(i - 1, this.array.get(i / 2 - 1));
        this.array.set(i / 2 - 1, temp);
        i /= 2;
    }
}`

delete(): Elimina y devuelve el elemento raíz del montículo. El elemento raíz se reemplaza por el último elemento del ArrayList y se realiza un ajuste descendente (down-heap) para restaurar la propiedad del montículo.

`
public E delete() {
        if (!this.array.isEmpty()) {
            int n = this.array.size();
            E m = this.array.get(0);
            this.array.set(0, this.array.get(n - 1));
            this.array.remove(--n);
            int j = 0;
            while (2 * j + 1 < n) {
                int k = 2 * j + 1;
                if (k + 1 < n && this.array.get(k + 1).compareTo(this.array.get(k)) > 0)
                    k++;
                if (this.array.get(j).compareTo(this.array.get(k)) > 0)
                    break;

                E temp = this.array.get(j);
                this.array.set(j, this.array.get(k));
                this.array.set(k, temp);
                j = k;
            }
            return m;
        }
        return null;
}
`

toString(): Devuelve una representación en cadena del montículo, que es simplemente la representación en cadena del ArrayList.

`
@Override
public String toString() {
    return this.array.toString();
}
`

Este heap es utilizado en la clase PriorityQueueHeap, ya que cada elemento estará ordenado según una prioridad

- Implemente la clase PriorityQueueHeap generica que utilice como estructura de datos el heap desarrollado en el punto anterior.

Para la resolución de esta parte se implementó una nueva clase utilizada por la clase de cola:

`
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
`

El constructor PriorityQueueHeap(int n) crea una instancia de la clase TDAHeap con una capacidad inicial especificada por el parámetro n. El TDAHeap se utiliza como base para implementar la cola de prioridad.

`
    public PriorityQueueHeap(int n) {
        this.queue = new TDAHeap<>(n);
    }

`

El método isEmpty() verifica si la cola de prioridad está vacía. Devuelve true si no hay elementos en la cola de prioridad, y false en caso contrario.

`
     public boolean isEmpty() {
        return this.queue.getSize() == 0;
    }
`

El método enqueue(E element, int priority) se utiliza para insertar un elemento en la cola de prioridad. Crea un objeto PriorityQueueElement con el elemento y la prioridad especificados, y luego lo inserta en el montículo (TDAHeap) utilizando su método insert().

`
    public void enqueue(E element, int priority) {
        PriorityQueueElement<E> priorityElement = new PriorityQueueElement<>(element, priority);
        this.queue.insert(priorityElement);
    }
`

El método deQueue() se utiliza para eliminar y devolver el elemento con la mayor prioridad en la cola de prioridad. Utiliza el método delete() del montículo (TDAHeap) para eliminar el elemento máximo y luego devuelve el elemento almacenado en el PriorityQueueElement.

`
    public E deQueue() {
        if (!this.isEmpty()) {
            PriorityQueueElement<E> elem = this.queue.delete();
            return elem != null ? elem.getElement() : null;
        }
        return null;
    }
`

El método front() devuelve el elemento con la mayor prioridad en la cola de prioridad sin eliminarlo. Obtiene el primer elemento del ArrayList subyacente del montículo utilizando el método get().

`
    public E front() {
        if (!isEmpty()) {
            return this.queue.getArray().get(0).getElement();
        }
        return null;
    }

`

El método back() devuelve el último elemento de la cola de prioridad, es decir, el elemento con la menor prioridad. Obtiene el último elemento del ArrayList subyacente del montículo utilizando el método get().

`
    public E back() {
        if (!this.isEmpty()) {
            return this.queue.getArray().get(this.queue.getSize() - 1).getElement();
        }
        return null;
    }
`

