package test;

import java.nio.channels.NonWritableChannelException;
import java.text.BreakIterator;

//public class testThread extends Thread{
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < 20; i++) {
//			System.out.println("线程1=="+i);
//		}
//		super.run();
//	}
//	public static void main(String[] args) {		
//		testThread thread=new testThread();
//		thread.start();
////		thread.run();
//		for (int i = 0; i < 20; i++) {
//			System.out.println("主——————————线程"+i);
//		}
//	}
//	
//
//}
class lock{
	
}

public class testThread {

	public static void main(String[] args) {
		lock lock1=new lock();
		
		buyTicket t=new buyTicket(100);
//		buyTicket t1=new buyTicket(10);
//		buyTicket t2=new buyTicket(10);
		new Thread(()->{t.buy();},"小明").start();
		System.out.println("=============");
		new Thread(()->{t.buy();},"张三").start();
		System.out.println("++++++++++++");
		new Thread(()->{t.buy();},"李氏").start();
		System.out.println("0000000000000");
	}
}

class buyTicket{
	private  Integer ticketNums;
	lock lock1= new lock();	
	public  void buy() {

		while (true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		synchronized(ticketNums) {
			if (ticketNums<=0) {
				break;
				
			}else {

				System.out.println(Thread.currentThread().getName()+"购买了第"+ticketNums+"张票！");
			}
			ticketNums--;
		}
	}
	}
	public  void buy1() {		
		while (true) {

			if (ticketNums<=0) {
				break;
				
			}else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"购买了第"+ticketNums+"张票！");
			}
			ticketNums--;
		}
	
	}
	public buyTicket(int ticketNums) {
		// TODO Auto-generated constructor stub
		this.ticketNums=ticketNums;
	}
	
}
