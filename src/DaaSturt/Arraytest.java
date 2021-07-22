package DaaSturt;
import java.util.Arrays;
import java.util.List;

public class Arraytest {
	public static void main(String[] args) {
		
	}
}
class ArrayTest01{
	public  void Arr() {
		int[][] arr=new int[][] {{1,2,5},{1,3,5},{4,2,10},{2,5,5},{3,4,10},{3,7,10},{4,7,5},{5,6,5},{6,7,5}};
		System.out.println(Arrays.deepToString(arr));
		//二维数组，按第一列排序
		Arrays.sort(arr,(o1,o2)->Integer.compare(o1[0], o2[0]));
		System.out.println(Arrays.deepToString(arr));
		//一维数组求最大值 求和
		int maxInt=Arrays.stream(arr[0]).max().getAsInt();
		int sumInt=Arrays.stream(arr[0]).sum();
		
		// array 变list
		Integer[] array = { 1, 2, 3 };
		List<Integer> list = Arrays.asList(array);
		//list 变array
		Integer[] array1 = list.toArray(new Integer[3]);
	}
}