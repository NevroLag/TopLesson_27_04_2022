package Lesson_27_04_2022;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Filter stream
        Stream<Phone> phoneStream =
                Stream.of(new Phone("Iphone", 98000),
                        new Phone("123", 213124),
                        new Phone("dsgwery", 14156));
        phoneStream.filter(phone -> phone.getPrice() < 50000).forEach(phone -> System.out.println(phone.getName()));

        phoneStream.map(phone -> "model " + phone.getName() + " - price " + phone.getPrice()).
                forEach(System.out::println);

        Stream<Phone> phoneStream1 =
                Stream.of(new Phone("Iphone", 98000),
                        new Phone("123", 213124),
                        new Phone("dsgwery", 14156));

        phoneStream1.flatMap(phone -> Stream.of(
                String.format("model: %s price discount %d", phone.getName(), phone.getPrice()),
                String.format("model: %s price discount %d", phone.getName(), phone.getPrice() - (int) (phone.getPrice() * 0.1))
        ));

    }
}

class Phone {
    private String name;
    private int price;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
