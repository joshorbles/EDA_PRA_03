import java.util.ArrayList;

public class TDAHeap<E extends Comparable<E>> {
    private ArrayList<E> array;

    public TDAHeap(int n) {
        this.array = new ArrayList<>(n);
    }

     public int getSize() {
        return this.array.size();
    }

    public ArrayList<E> getArray() {
        return this.array;
    }

    public void insert(E data) {
        this.array.add(data);
        int i = this.array.size();
        while (i > 1 && this.array.get(i - 1).compareTo(this.array.get(i / 2 - 1)) > 0) {
            E temp = this.array.get(i - 1);
            this.array.set(i - 1, this.array.get(i / 2 - 1));
            this.array.set(i / 2 - 1, temp);
            i /= 2;
        }
    }

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

    @Override
    public String toString() {
        return this.array.toString();
    }
}

