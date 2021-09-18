package test;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Test
{
    public static void main(String[] args)
    {
        int a[] =
        {
                1, -1, 2, -3, 4, -5, 6, -7
        };
        find1(a);
    }
 
    public static void find1(int[] a)
    {
        int length = a.length;
        for (int i = 0; i < length; i++)
        {
            list[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (a[j] < a[i] && list[j] + 1 > list[i])
                {
                    list[i] = list[j] + 1;
                    if (result.isEmpty())
                    {
                        result.add(list[j]);
                    }
                    if (!result.contains(list[i]))
                    {
                        result.add(list[i]);
                    }
                }
            }
        }
        System.out.println("第i个元素时最长递增序列：" + Arrays.toString(list));
        int max = list[0];
        for (int i = 0; i < length; i++)
        {
            if (list[i] > max)
            {
                max = list[i];
            }
        }
        System.out.println("最长递增序列长度：" + max);
        System.out.println("最长递增序列：" + result);
    }
}
 
                                
                        
                                
输出结果：
                                
                        
                                
 
第i个元素时最长递增序列：[1, 1, 2, 1, 3, 1, 4, 1]
最长递增序列长度：4
最长递增序列：[1, 2, 3, 4]        复制代码