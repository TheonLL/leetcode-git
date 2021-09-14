package test;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: 11983
 * @date: 21/09/06 10:24
 * @description:
 */

public class Ipfind {
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int R = 0;
        int P = 0;
        while ((s = bf.readLine()) != null) {
            String[] sarr = s.split("~");
            String[] sbarr = sarr[0].split("\\.");
            String[] sbarr1 = sarr[1].split("\\.");
            if (sbarr.length!=4){
                R++;
                continue;
            }else if(sbarr[0]==null||sbarr[1]==null||sbarr[2]==null||sbarr[3]==null){
                R++;
                continue;
            }
            int a = Integer.parseInt(sbarr[0]);
            int b = Integer.parseInt(sbarr[1]);
            int c = Integer.parseInt(sbarr[2]);
            int d = Integer.parseInt(sbarr[3]);
            if (sbarr1.length!=4){
                R++;
                continue;
            }else if(sbarr1[0]==null||sbarr1[1]==null||sbarr1[2]==null||sbarr1[3]==null){
                R++;
                continue;
            }
            boolean isvaliue=false;
            for (int i = 0; i <sbarr1.length-1 ; i++) {
                if (Integer.parseInt(sbarr1[i])<Integer.parseInt(sbarr1[i+1])){
                    R++;
                    isvaliue=true;
                }else  if (Integer.parseInt(sbarr1[i])!=255){
                    if (Integer.parseInt(sbarr1[i+1])!=0){
                        R++;
                        isvaliue=true;
                    }
                }
            }
            if (isvaliue) continue;
            if (1 <= a && a <= 126) {
                if ((0 <= b && b <= 255) && (0 <= c && c <= 255) && (0 <= d && d <= 255)) {
                    if (a == 10) {
                        P++;
                    }
                    A++;
                } else {
                    R++;
                }
            } else if (128 <= a && a <= 191) {
                if ((0 <= b && b <= 255) && (0 <= c && c <= 255) && (0 <= d && d <= 255)) {
                    if (a == 172 && 16 <= b && b <= 31) {
                        P++;
                    }
                    B++;
                } else {
                    R++;
                }
            } else if (192 <= a && a <= 223) {
                if ((0 <= b && b <= 255) && (0 <= c && c <= 255) && (0 <= d && d <= 255)) {
                    if (a == 192 && b == 168) {
                        P++;
                    }
                    C++;
                } else {
                    R++;
                }
            } else if (224 <= a && a <= 239) {
                if ((0 <= b && b <= 255) && (0 <= c && c <= 255) && (0 <= d && d <= 255)) {
                    D++;
                } else {
                    R++;
                }
            } else if (240 <= a && a <= 255) {
                if ((0 <= b && b <= 255) && (0 <= c && c <= 255) && (0 <= d && d <= 255)) {
                    E++;
                } else {
                    R++;
                }
            }
        }
        System.out.print(A+" "+B+" "+C+" "+D+" "+E+" "+R+" "+P);
    }
}
