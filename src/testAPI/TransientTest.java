package testAPI;

import java.io.*;

/**
 * @author: 11983
 * @date: 21/08/18 16:14
 * @description:
 */
class Person implements Serializable {
    private  String name;
    private static int  age;
    private transient int height;

    public void  run(){
        System.out.println("实例方法");

    }
    public static void run1(){
        System.out.println("类方法");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
public class TransientTest {
    public static void main(String[] args) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
             ObjectInputStream ios = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person person = new Person("9龙", 23);
            person.setHeight(185);
            System.out.println(person.toString());
            oos.writeObject(person);
            Person p1 = (Person)ios.readObject();
            p1.run();
            p1.run1();
            System.out.println(p1.toString());
        }
    }
}