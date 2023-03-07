package problema2;
import problema2.MainProblema2;

public class Hilo extends Thread{
	
	private int c;
	private int id;
	private int a;
	private int b;
	
	public Hilo(int identificador) {
		this.id = identificador;
	}
	
	protected int generaNum() {
		return (int) (Math.random() * 40) + 1;
	}
	
	
	@Override 
	public void run() {
		
		for(int i=0;i<30;i++) {
			
			a = generaNum();
			b = generaNum();
			c = a+b;
			
			if(c%5 == 0) {
				try {
					MainProblema2.Sem1.acquire();
				}catch (Exception e) {}
				//Panel escribir
					MainProblema2.panel1.escribir_mensaje("“Hilo con ID " + this.id+ "\n"
							+ "Números generados: "+ this.a +" "+this.b+ "\n"
							+ "Operación a realizar: '+' \r\n"
							+ "Resultado: "+ this.c+ "\n"
							+ "Fin hilo ID "+ this.id 
							+ "");
					MainProblema2.Sem1.release();	
			}else if((c%5 != 0 )&&(c%2 == 1)){
					try {
						MainProblema2.Sem23.acquire();
					} catch (InterruptedException e) {}
					
							if(MainProblema2.P2ocupado == false) {
								try {
									MainProblema2.mutex1.acquire();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								MainProblema2.P2ocupado = true;
								//Panel 2 escribir
								MainProblema2.panel2.escribir_mensaje("“Hilo con ID " + this.id+ "\n"
										+ "Números generados: "+ this.a +" "+this.b+ "\n"
										+ "Operación a realizar: '+' \r\n"
										+ "Resultado: "+ this.c+ "\n"
										+ "Fin hilo ID "+ this.id 
										+ "");
								MainProblema2.P2ocupado = false;
								MainProblema2.mutex1.release();
							}
							else {
								try {
									MainProblema2.mutex1.acquire();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								MainProblema2.P3ocupado=true;
								MainProblema2.panel3.escribir_mensaje("“Hilo con ID " + this.id+ "\n"
										+ "Números generados: "+ this.a +" "+this.b+ "\n"
										+ "Operación a realizar: '+' \r\n"
										+ "Resultado: "+ this.c+ "\n"
										+ "Fin hilo ID "+ this.id 
										+ "");
								MainProblema2.P3ocupado=false;
								MainProblema2.mutex1.release();
							}
										
							MainProblema2.Sem23.release();
			}else if((c%5 != 0 )&&(c%2 == 0)){
				try {
					MainProblema2.Sem45.acquire();
				} catch (InterruptedException e) {}
				
						if(MainProblema2.P4ocupado == false) {
							try {
								MainProblema2.mutex2.acquire();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							MainProblema2.P4ocupado = true;
							//Panel 2 escribir
							MainProblema2.panel4.escribir_mensaje("“Hilo con ID " + this.id+ "\n"
									+ "Números generados: "+ this.a +" "+this.b+ "\n"
									+ "Operación a realizar: '+' \r\n"
									+ "Resultado: "+ this.c+ "\n"
									+ "Fin hilo ID "+ this.id 
									+ "");
							MainProblema2.P4ocupado = false;
							MainProblema2.mutex2.release();
						}
						else {
							try {
								MainProblema2.mutex2.acquire();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							MainProblema2.P5ocupado=true;
							MainProblema2.panel5.escribir_mensaje("“Hilo con ID " + this.id+ "\n"
									+ "Números generados: "+ this.a +" "+this.b+ "\n"
									+ "Operación a realizar: '+' \r\n"
									+ "Resultado: "+ this.c+ "\n"
									+ "Fin hilo ID "+ this.id 
									+ "");
							MainProblema2.P5ocupado=false;
							MainProblema2.mutex2.release();
						}
									
						MainProblema2.Sem45.release();
			
		}
		
	}
	
	
	}	
}


