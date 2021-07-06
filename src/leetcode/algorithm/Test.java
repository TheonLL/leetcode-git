package leetcode.algorithm;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("00100");
		Person person=new Person("ruan");
		System.out.println(person.getName());
	}

}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 18); // 调用另一个构造方法Person(String, int)
    }

    public Person() {
        this("Unnamed"); // 调用另一个构造方法Person(String)
    }
    public String getName() {
    	return this.name;
		
	}
}