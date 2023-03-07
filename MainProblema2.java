package problema2;

import java.util.concurrent.Semaphore;

public class MainProblema2 {
	
	public static final Semaphore Sem1 = new Semaphore(1);
	public static final Semaphore Sem23 = new Semaphore(2);
	public static final Semaphore Sem45 = new Semaphore(2);
	
	public static final Semaphore mutex1 = new Semaphore(1);
	public static final Semaphore mutex2 = new Semaphore(1);
	
	public static boolean P2ocupado = false;
	public static boolean P3ocupado = false;
	public static boolean P4ocupado = false;
	public static boolean P5ocupado = false;
	
	
	public static Panel panel1 = new Panel("Panel1",50,50);
	public static Panel panel2 = new Panel("Panel2",200,200);
	public static Panel panel3 = new Panel("Panel3",400,400);
	public static Panel panel4 = new Panel("Panel4",600,600);
	public static Panel panel5 = new Panel("Panel5",800,800);
	
	
	
	public static void main(String[] args) {
		
		
		Hilo a[] = new Hilo[50];
		for(int i=0;i<a.length;i++) {
			a[i] = new Hilo(i);					
		}
		
		for(int i=0;i<a.length;i++) {
			a[i].start();
		}
	
		
	}
	

}
