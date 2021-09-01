package testAPI;
import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author: 11983
 * @date: 21/08/21 17:36
 * @description:
 */

public class TestString {

    public static void main(String[] args) {
/*        String s="0123456789";
        System.out.println(s.substring(1));*/
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(s);
        String[] sArr=s.split("\\.");
        System.out.println(Arrays.toString(sArr));

    }

}
