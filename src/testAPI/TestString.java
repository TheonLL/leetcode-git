package testAPI;

import java.util.Arrays;

/**
 * @author: 11983
 * @date: 21/08/21 17:36
 * @description:
 */

public class TestString {

    public static void main(String[] args) {
        String s="abcde";
        char[] CharArray=new char[]{0,0,0,0,0,0};
        s.getChars(0,4,CharArray,0 );
        System.out.println(Arrays.toString(CharArray));
    }

}
