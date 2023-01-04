import Collections.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Car car1 = new Car("BMW", 1);
        Car car2 = new Car("BMW", 1);
        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        */

        /*
        CarCollection cars = new CarArrayList();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car("Brand" + i, i));
        }
        for (Car car: cars) {
            System.out.println(car.getBrand() + " " + car.getNumber());
        }
         */

        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for (int i = 0; i < 100; i++) {
            numbers.add((int)(Math.random() * 10));
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}