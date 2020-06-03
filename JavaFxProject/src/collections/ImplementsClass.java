package collections;

interface Runnable<T>{
	public void run(T t);
}

class Car implements Runnable<String>{

	@Override
	public void run(String str) {
		// TODO Auto-generated method stub
		System.out.println("자동차가 달립니다.");
	}
}

class Bus implements Runnable<String>{

	@Override
	public void run(String intVal) {
		// TODO Auto-generated method stub
		System.out.println("버스가 달립니다.");
	}
}

public class ImplementsClass {
	public static void callRun(Runnable<String> runnable) {
		runnable.run("Hello");
	}
	
	public static void main(String[] args) {
		Runnable runnable = new Car();
		runnable.run("Car");
		runnable = new Bus();
		runnable.run("Bus");
		
		runnable = (str) -> {
			System.out.println("람다 객체 달립니다.");
		};
		runnable.run("RRR");
		
		runnable = new Runnable<String>() {
			@Override
			public void run(String str) {
				// TODO Auto-generated method stub
				System.out.println("익명 객체 달립니다.");
			}			
		};
		/*
		runnable.run("CCC");
		
		
		runnable.run();
		
		callRun(new Car());
//		callRun(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("달리랏!!");
//			}
//		});
		callRun( ()->System.out.println("달린다") );
		*/
	}
}
