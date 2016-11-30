package Model;

import java.util.ArrayList;
import java.util.List;

import Model.EstadoPosicionamento;
import Others.ObservadoIF;
import Others.ObservadorIF;

public class Jogador implements ObservadoIF
{
	private String nome;
	private int[][] meuTabuleiro = new int[15][15];
	private int[][] tabuleiroInimigo = new int[15][15];
	private List <ObservadorIF> observers = new ArrayList <ObservadorIF> ();
	private List<Arma> armas = new ArrayList <Arma> ();
	
	public String getNome ()
	{
		return nome;
	}

	public void setNome (String nome)
	{
		this.nome = nome;
	}

	public int[][] getTabuleiroInimigo ()
	{
		return tabuleiroInimigo;
	}

	public int[][] getMeuTabuleiro ()
	{
		return meuTabuleiro;
	}
	
	public void marcarMeuTabuleiro (int x, int y)
	{
		this.meuTabuleiro[x][y] = 1;
	}
	
	public void marcarTabuleiroInimigo (int x, int y)
	{
		this.tabuleiroInimigo[x][y] = 1;
	}
	
	public boolean posicionarArmaNoTabuleiro (int x, int y, Arma a)
	{
		int[][] pontosDaArma = a.getPontos ();
		int[][] tabuleiroAux = new int[15][15];

		for(int i=0; i< meuTabuleiro.length; i++)
			  for (int j=0; j< meuTabuleiro[i].length; j++)
				  tabuleiroAux[i][j] = meuTabuleiro[i][j];
		
		if (x + a.getLargura () - 1 > 14)
			return false;
		if (y - a.getAltura () < -1)
			return false;
		
		for (int i = 0; i < 5; i++ )
		{
			for (int j = 1; j >= 0; j-- )
			{
				if (pontosDaArma[j][i] == 1)
				{
					int posX = x + i, posY = y + j - 1;
					if (!testaPosicaoValida (posX, posY, a))
					{
						return false;
					}
					tabuleiroAux[posX][posY] = a.getTipoDeArma ().ordinal ();
				}
			}
		}
		meuTabuleiro = tabuleiroAux;
		return true;
	}
	
	public boolean testaPosicaoValida (int x, int y, Arma arma)
	{
		
		
		for (int i = -1; i < 2; i++)
		{
			for (int j = -1; j < 2; j++)
			{
				if (x + i >= 0 && x + i < 15 && y + j >= 0 && y + j < 15)
					if (meuTabuleiro[x + i][y + j] != 0)
						return false;
			}
		}
		
		return true;
	}
	
	public void verificaArmasUsadas ()
	{
		for (Arma arma: armas)
			if (arma.getEstadoPosicionamento() != EstadoPosicionamento.Posicionada)
				return;
//			if (!arma.getUsada ())
//				return;
		this.notifyObservers ();
	}
	
	public Arma getArmaSelecionada()
	{
		for (Arma a: armas)
		{
			if (a.getEstadoPosicionamento() == EstadoPosicionamento.EmTransicao)
				return a;
//			if (a.getSelecionada () == true)
//				return a;
		}
		return null;
	}
	
	public List <Arma> getListaArmas ()
	{
		return armas;
	}
	
	@Override
    public void registerObserver (ObservadorIF observer)
	{
         observers.add (observer);
    }

    @Override
    public void removeObserver (ObservadorIF observer)
    {
         observers.remove (observer);
    }

    @Override
    public void notifyObservers ()
    {
    	// Chama o método de atualização de todos os observers disponíveis
    	for (ObservadorIF ob : observers)
        {
    		if (ob == null)
    			return;
        	System.out.println ("Notificando observers!");
        	ob.update (true);
        }
    	
    	this.removeObserver (observers.get (0));
    }
}