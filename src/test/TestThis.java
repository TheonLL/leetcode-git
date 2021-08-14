package test;

public class TestThis {
	public static void main(String[] args) {
		System.out.println("main");
		TestThis testThis=new TestThis();
		testThis.name1();
		
	}
	public void name1() {
		this.name();
	}
	public void name() {
		System.out.println("this");
	}

}
