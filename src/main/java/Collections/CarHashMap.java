package Collections;

import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class CarHashMap implements CarMap {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];


    @Override
    public void put(CarOwner key, Car value) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];
        if (existedElement == null) {
            Entry entry = new Entry(key, value, null);
            array[position] = entry;
            size++;
        } else {
            while(true) {
                if(existedElement.key.equals(key)) {
                    existedElement.value = value;
                    return;
                }
                if (existedElement.next == null) {
                    existedElement.next = new Entry(key, value, null);
                    size++;
                    return;
                }
                existedElement = existedElement.next;
            }
        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        return null;
    }

    @Override
    public List<Car> values() {
        return null;
    }

    @Override
    public boolean remove(CarOwner key) {
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

    private int getElementPosition(CarOwner carOwner, int arrayLength) {
        return Math.abs(carOwner.hashCode()) % arrayLength;
    }

    private static class Entry {
        private CarOwner key;
        private Car value;
        private Entry next;

        public Entry(CarOwner key, Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
