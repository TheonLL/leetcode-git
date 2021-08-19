package testAPI;

/**
 * @author: 11983
 * @date: 21/08/18 11:05
 * @description:
 */

public class TestThis {

    private int id;
    private static int d;
    public static void  run(int i){
        System.out.println(i);
    }
    public void  test(int i){
        this.id = i;
        this.run(i);
        System.out.println("test");
    }

    public void  test1(int i){
        this.id = i;
        this.test(i);
        System.out.println("test");
    }

    public static void main(String[] args) {

    }
}
