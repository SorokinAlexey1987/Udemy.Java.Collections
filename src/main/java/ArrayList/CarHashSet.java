package ArrayList;

public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];



    @Override
    public boolean add(Car car) {
        int position = getElementPosition(car, array.length);
        if(array[position] == null) {
            Entry entry = new Entry(car, null);
            array[position] = entry;
            size++;
            return true;
        } else {
            Entry existedElement = array[position];
            while (true) {
                if (existedElement.value.equals(car)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    size++;
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if(array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;
        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
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
