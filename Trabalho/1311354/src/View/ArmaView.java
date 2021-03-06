package View;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

import Model.Arma;
import Model.CoresMapa;
import Model.EstadoPosicionamento;

public class ArmaView extends JPanel
{	
	private static final long serialVersionUID = 7526472295622776147L;  // unique id
	private Arma arma;
	
	public ArmaView (Arma a)
	{
		arma = a;
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Desenha arma
		double leftX = 0;
		double topY = 0;
		double larg = 15;
		double alt = 15;
		
		int[][] pontos = arma.getPontos ();
		Color color = Color.white;
		
		if (arma.getEstadoPosicionamento () == EstadoPosicionamento.Disponivel)
		{
			switch (arma.getTipoDeArma ())
			{
				case Couracado:
					color = CoresMapa.Couracado.getColor ();
					break;
				case Submarino:
					color = CoresMapa.Submarino.getColor ();
					break;
				case Cruzador:
					color = CoresMapa.Cruzador.getColor ();
					break;
				case Hidroaviao:
					color = CoresMapa.Hidroaviao.getColor ();
					break;
				case Destroyer:
					color = CoresMapa.Destroyer.getColor ();
					break;
				default:
					break;
			}
		}
		else if (arma.getEstadoPosicionamento () == EstadoPosicionamento.EmTransicao)
		{
			switch (arma.getTipoDeArma ())
			{
				case Couracado:
					color = CoresMapa.CouracadoSelecionado.getColor ();
					break;
				case Submarino:
					color = CoresMapa.SubmarinoSelecionado.getColor ();
					break;
				case Cruzador:
					color = CoresMapa.CruzadorSelecionado.getColor ();
					break;
				case Hidroaviao:
					color = CoresMapa.HidroaviaoSelecionado.getColor ();
					break;
				case Destroyer:
					color = CoresMapa.DestroyerSelecionado.getColor ();
					break;
				default:
					break;
			}
		}
		else
		{
			switch (arma.getTipoDeArma ())
			{
				case Couracado:
					color = Color.orange;
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
				default:
					break;
			}
		}
		
		for (int i = 0; i < pontos.length; i++)
		{	
			leftX = 0;
			topY = i*alt;
			
			for (int j = 0; j < pontos[0].length; j++)
			{
				leftX = j*larg;
				
				if (pontos[i][j] == 1)
				{
					Rectangle2D rt = new Rectangle2D.Double (leftX, topY, larg, alt);
					g2d.setColor (color);
					g2d.fill (rt);
					g2d.draw (rt);
				}
			}
		}
	}
	
	public Arma getArma ()
	{
		return arma;
	}
	
	public boolean clicouNaArma (Integer x, Integer y)
	{
		int xPoint = (int) (x.doubleValue () * 15.0 / 225.0f);
		int yPoint = (int) (y.doubleValue () * 15.0 / 225.0f);
		int[][] pts = arma.getPontos ();
		if (pts[yPoint][xPoint] == 1)
			return true;
		else
			return false;
	}
}