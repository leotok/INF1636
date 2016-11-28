package View;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.*;

public class Mapa extends JPanel
{
	private static final long serialVersionUID = 7526472295622776147L;  // unique id
	private final int TXT_X = 300;
	private final int TXT_Y = 300;
	private int distanciaX = 500;
	private int distanciaY = 125;
	private int[][] retangulos = new int[15][15];
	private boolean bloqueado = false;
	
	public Mapa ()
	{
		
	}
	
	public Mapa (int x, int y)
	{
		distanciaX = x;
		distanciaY = y;
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		Graphics2D g2d = (Graphics2D) g;
		
		setBounds (distanciaX, distanciaY, TXT_X, TXT_Y);
		setBackground (Color.white);
		
		// Desenha retângulo
		double leftX = 0;
		double topY = 0;
		double larg = TXT_X/15;
		double alt = TXT_Y/15;
		
		for (int i = 0; i < 15; i++)
		{
			leftX = 0;
			topY = i*alt;
			
			for (int j = 0; j < 15; j++)
			{
				leftX = j*larg;
				Rectangle2D rt = new Rectangle2D.Double (leftX, topY, larg, alt);
				
				if (bloqueado)
					g2d.setColor (new Color (177, 203, 255));
				else {
					switch (retangulos[j][i])
					{
						case 0:
							g2d.setColor (Color.white);
							break;
						case 1:
							g2d.setColor (Color.orange);
							break;
						case 2:
							g2d.setColor (Color.blue);
							break;
						case 3:
							g2d.setColor (Color.green);
							break;
						case 4:
							g2d.setColor (Color.CYAN);
							break;
						case 5:
							g2d.setColor (Color.black);
							break;
						case 6:
							g2d.setColor (Color.gray);
							break;
						
					}
				}
				g2d.fill (rt);
				g2d.setColor (Color.black);
				g2d.draw (rt);
			}
		}
	}
	
	public void setBloqueado (boolean bloq)
	{
		bloqueado = bloq;
		repaint ();
	}
	
	public Point getPosicaoNoMapa (Integer x, Integer y)
	{
		Point p = new Point ();
		
		p.x = (int) (int) (x.doubleValue () * 15 / 300.0f);
		p.y = (int) (int) (y.doubleValue () * 15 / 300.0f);
		
		return p;
	}
	
	public void pintaRetanguloNaPosicao (Point p, Color c)
	{	
		System.out.println ("Posicao no mapa: (" + p.x + "," + p.y + ")");
		retangulos[p.x][p.y] = 1;
		repaint ();
	}
	
	public void marcaMapa (int[][] mapa)
	{
		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				retangulos[j][i] = mapa[j][i];
			}
		}
		repaint ();
	}
}