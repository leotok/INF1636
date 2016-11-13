import javax.swing.*;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class PosicionarNavios extends JFrame
{
	private static final long serialVersionUID = 7526472295622776147L;  // unique id
	private final int LARG_DEFAULT = 900;
	private final int ALT_DEFAULT = 600;
	
	public PosicionarNavios (int numJogador)
	{
		setTitle ("Batalha Naval");
		Container c = getContentPane ();
		
		InformacoesGlobais inf = InformacoesGlobais.getInformacoesGlobais();
		Jogador jog = inf.getJogador(numJogador);
		
		JLabel label = new JLabel ();
		label.setText (jog.getNome());
		
		// Mapa para escolher as posicoes das armas
		Mapa mapa = new Mapa ();
	
		// Armas
		Arma couracado = new Arma(TipoDeArma.Couracado);
		ArmaView cv = new ArmaView(couracado);
		cv.setBounds(50, 100, 15 * 5, 15 * 2);
		c.add(cv);
		
		Arma submarino = new Arma(TipoDeArma.Submarino);
		for (int i = 0; i < 4; i++) {
			ArmaView sv = new ArmaView(submarino);
			sv.setBounds(50 + i * 25  ,180 , 15 , 15 * 2);
			c.add(sv);
		}
		
		Arma cruzador = new Arma(TipoDeArma.Cruzador);
		for (int i = 0; i < 2; i++) {
			ArmaView sv = new ArmaView(cruzador);
			sv.setBounds(50 + i * 25 * 4,260, 15 * 4, 15 * 2);
			c.add(sv);
		}
		
		Arma hidro = new Arma(TipoDeArma.Hidroaviao);
		for (int i = 0; i < 5; i++) {
			ArmaView hv = new ArmaView(hidro);
			hv.setBounds(50 + i * 25 * 3,340, 15 * 3, 15 * 2);
			c.add(hv);
		}
		
		Arma des = new Arma(TipoDeArma.Destroyer);
		for (int i = 0; i < 3; i++) {
			ArmaView dv = new ArmaView(des);
			dv.setBounds(50 + i * 25 * 2,420, 15 * 2, 15 * 2);
			c.add(dv);
		}
		
		
		
		JButton terminei = new JButton ("Terminei");
		terminei.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				if (numJogador == 1)
				{
					new PosicionarNavios (2);
					dispose ();
				}
			}
		});
		
		label.setBounds (410, 500, 100, 25);
		label.setSize (label.getPreferredSize ());
		label.setHorizontalAlignment (JLabel.CENTER);
		terminei.setBounds (410, 530, 100, 25);
		terminei.setSize (terminei.getPreferredSize ());
		terminei.setHorizontalAlignment (JButton.CENTER);
		
		c.add (label);
		c.add (terminei);
		c.add (mapa);
		

		mapa.addMouseListener (new MouseListener () {
			public void mousePressed (MouseEvent e) {}
			public void mouseReleased (MouseEvent e) {}
			public void mouseEntered (MouseEvent e) {}
			public void mouseExited (MouseEvent e) {}
			public void mousePressed () {}
			public void mouseClicked (MouseEvent e)
			{
				Point p = mapa.getPosicaoNoMapa(e.getX(), e.getY());
				jog.marcarMeuTabuleiro(p.x, p.y);
				mapa.pintaRetanguloNaPosicao(p, Color.red);
				System.out.println ("Posicao do mouse: (" + e.getX () + "," + e.getY () + ")");			
			}
		});
		
		Toolkit tk = Toolkit.getDefaultToolkit ();
		Dimension screenSize = tk.getScreenSize ();
		int sl = screenSize.width;
		int sa = screenSize.height;
		int x = sl/2 - LARG_DEFAULT/2;
		int y = sa/2 - ALT_DEFAULT/2;
		
		setBounds (x, y, LARG_DEFAULT, ALT_DEFAULT);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		setVisible (true);
	}
}