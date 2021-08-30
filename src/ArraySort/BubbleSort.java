package ArraySort;

import java.util.Arrays;

/**
 * @author: 11983
 * @date: 21/08/28 14:56
 * @description:
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{3,5,4,2,1};
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public void  bubblesort(int[] arr){
        int len=arr.length;
        for (int i=0;i<len-1;i++){
            for (int j=0;j<len-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //插入排序
    public void  insertSort(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            int red=i;
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j]>arr[red]){
                    int temp=arr[red];
                    arr[red]=arr[j];
                    arr[j]=temp;
                    red=j;
                }else {

                    break;
                }

            }

        }
    }
    //shell排序
    public void  shellSort(int[] arr){
        for (int d = arr.length/2; d >0; d/=2) {
            //insert sort
            for (int i = 0; i <arr.length ; i++) {
                int red=i;
                for (int j = i-d; j >=0; j-=d) {
                    if (arr[j]>arr[red]){
                        int temp=arr[red];
                        arr[red]=arr[j];
                        arr[j]=temp;
                        red=j;
                    }else{
                        break;
                    }
                }

            }

        }
    }

}
