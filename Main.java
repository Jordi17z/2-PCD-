package ej3;

public class Main {
	
	public static void main(String[] args) {
		
		Integer var = 5;
		
		Hilo1 a = new Hilo1(var);
		Hilo1 b = new Hilo1(var);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(var);
		
		System.out.println("FIN HILO PRINCIPAL");
	}

	
}
