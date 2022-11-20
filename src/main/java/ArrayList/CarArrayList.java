package ArrayList;

import java.util.Arrays;

public class CarArrayList implements CarList {

    private Car[] array = new Car[10];
    private int size = 0;
    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        increaseArray();
        /*
        for(int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        /*
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        */
        System.arraycopy(array, index + 1, array, index, size - 1- index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);

           /*Car[] newArray = new Car[array.length * 2];
            for(int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;*/
        }
    }
}
