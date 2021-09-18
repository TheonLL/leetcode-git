package Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class scanner {
	public static void main(String[] args) throws Exception {
		TestScanner testScanner=new TestScanner();
		System.out.println(8888);
		testScanner.scanner01();
	}

}

class TestScanner{
	/*
	 * 输入：
	 * 1 5
	 * 10 20
	 * 输出：
	 * 6
	 * 30
	 */
	public void scanner01() throws Exception{
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		List<int[]> a=new ArrayList<>();
		while ((str=bReader.readLine())!=null) {
			 char[] chars=str.toCharArray();
			/*String[] strArrString=str.split(" ");*/
			if (chars.length==3) {
/*				int a=Integer.parseInt(strArrString[0]);
				int b=Integer.parseInt(strArrString[1]);*/
/*				int a=strArrString[0].toCharArray()[0];
				int b=strArrString[1].toCharArray()[0];*/
				int a =chars[0];
				int b=chars[2];
				System.out.println(a+b);
				
			}
			
		}
		
		
	}
	/*
	 * input
	 * 2
	 * 1 5
	 * 10 20
	 * output
	 * 6
	 * 30
	 */
	public void scanner02() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s;
        while(n > 0){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            System.out.println(a + b);
            n--;
        }
    }
	
	/*
	 * 输入：
	 * 1 5
	 * 10 20
	 * 0 0
	 * 输出：
	 * 6
	 * 30
	 */
	public void scanner03() throws Exception{
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		while ((str=bReader.readLine())!=null) {
			String[] strArrString=str.split(" ");
			if (strArrString.length==2) {
				int a=Integer.parseInt(strArrString[0]);
				int b=Integer.parseInt(strArrString[1]);
	            if (a==0&&b==0) {
					break;
				}else {
					System.out.println(a+b);		
				}			
			}			
		}				
	}
	/*
	 * 输入：
	 *4 1 2 3 4
	 *5 1 2 3 4 5
	 *0
	 * 输出：
	 * 14
	 * 15
	 */
	
	public void scanner04() throws Exception{
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		while ((str=bReader.readLine())!=null) {
			int sum=0;
			String[] strArrString=str.split(" ");
			if (strArrString.length==1&&(Integer.parseInt(strArrString[0])==0)) {
				break;
			}else {
				for (String string : strArrString) {
					int a=Integer.parseInt(string);
					sum+=a;
				}
				System.out.println(sum);
			}			
			}			
		}	
	
	
	
	
	/*
	 * 字符串
	 * 
	 */
	/*
	 * 输入有两行，第一行n,第二行是n个空格隔开的字符串
	 * input
	 * 5
	 *c d a bb e
	 *output
	 *a bb c d e
	 */
	public void scanner05() throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int len = Integer.parseInt(line);
        line = br.readLine();
        String[] arry = line.split(" ");
        Arrays.sort(arry);
        for(int i = 0;i<arry.length-1;i++){
           System.out.print(arry[i]+" ");
        }
         System.out.print(arry[arry.length-1]);
    }
		
	
		
}