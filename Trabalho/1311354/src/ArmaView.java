import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class ArmaView extends JPanel{
	
	private static final long serialVersionUID = 7526472295622776147L;  // unique id
	private Arma arma;
	
	public ArmaView(Arma a) {
		this.arma = a;
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent (g);
		Graphics2D g2d = (Graphics2D) g;
	
		
		// Desenha arma
		double leftX = 0;
		double topY = 0;
		double larg = 15;
		double alt = 15;
		
		int[][] pontos = arma.getPontos();
		Color color = Color.white;
		
		switch(arma.getTipoDeArma()) {
			case Couracado:
				color = Color.red;
				break;
			case Submarino:
				color = Color.blue;
				break;
			case Cruzador:
				color = Color.green;
				break;
			case Hidroaviao:
				color = Color.CYAN;
				break;
			case Destroyer:
				color = Color.black;
				break;
		}
		
		for(int i = 0; i < pontos.length; i++) {
			
			leftX = 0;
			topY = i*alt;
			
			for(int j = 0; j < pontos[0].length; j++) {
				
				leftX = j*larg;
				
				if (pontos[i][j] == 1) {
					Rectangle2D rt = new Rectangle2D.Double (leftX, topY, larg, alt);
					g2d.setColor(color);
					g2d.fill(rt);
					g2d.draw (rt);
				}
			}
		}
	}
}
