package vistaGame;

public class threadCronometro extends Thread {
	private int segundos;

	private boolean andar;
	private Edificio gui;

	public threadCronometro(Edificio gui,int tiempo) {

		segundos = tiempo;
		this.gui = gui;
		andar = true;
	}

	public void run() {
		while (andar) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
						if (segundos != 0)
							segundos--;
						else {
							detenerCronometro();
							gui.gameOver();	
							}
			}
			
			
		
	}

	public void detenerCronometro() {
		andar = false;
		
	}
}
