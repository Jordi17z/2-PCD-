package ej3;

public class Hilo1 implements Runnable{
	private Integer valor = null;
	
	public Hilo1(Integer val) {
		this.valor=val;
	}

	@Override
	public void run() {
		for(int i=0;i<1000;i++)
			this.valor+=1 ;
		
		System.out.println(valor);
		
		try {
			Thread.sleep(1000);
		}catch (Exception e) {}
		
	}
}
