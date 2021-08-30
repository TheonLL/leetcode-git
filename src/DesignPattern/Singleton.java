package DesignPattern;

import sun.security.mscapi.PRNG;

import java.awt.print.Printable;
import java.io.BufferedReader;

/**
 * @author: 11983
 * @date: 21/08/30 12:19
 * @description:
 */

public class Singleton {
    public static void main(String[] args) {
    LazySingleton instance=LazySingleton.getLazySingleton();
    LazySingleton instance1=LazySingleton.getLazySingleton();
        System.out.println(instance==instance1);
    }
}
//懒汉式-线程不安全 调用的时候再实例化
class  LazySingleton{
    private  static  LazySingleton instance;
    private LazySingleton()
    {

    }
    public static LazySingleton getLazySingleton(){
        if (instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }
}
//懒汉式-线程安全加synchronized锁
class  LazySingletonSyc{
    private  static  LazySingletonSyc instanceSyc;
    private LazySingletonSyc(){
    }
    public static LazySingletonSyc getLazySingletonSyc(){
        if (instanceSyc==null){
            synchronized (LazySingleton.class){
                if (instanceSyc==null){
                    instanceSyc=new LazySingletonSyc();
                }
            }
        }
        return  instanceSyc;
    }
}
//饿汉式-线程安全 类加载的时候就实例化-造成内存浪费
class  HungrySingleton{
    private static HungrySingleton instanceH=new HungrySingleton();
    private HungrySingleton(){};
    public  HungrySingleton getInstanceH(){
        return  instanceH;
    }
}

// 双重校验锁
class  DubbleSynSingleton{
    private volatile DubbleSynSingleton instanceDubb;
    private DubbleSynSingleton(){};
    public DubbleSynSingleton getInstanceDubb(){
        if (instanceDubb==null){
            synchronized (DubbleSynSingleton.class){
                if (instanceDubb==null)
                    instanceDubb=new DubbleSynSingleton();
            }
        }
        return instanceDubb;
    }
}