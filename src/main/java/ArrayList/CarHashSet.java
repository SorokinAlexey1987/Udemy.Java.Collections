package ArrayList;

public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];



    @Override
    public boolean add(Car car) {
        int position = getElementPosition(car, array.length);

        return false;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode()) % arrayLength;
    }

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
