package Model;

import java.util.ArrayList;
import java.util.List;

import Others.ObservadoIF;
import Others.ObservadorIF;

public class Jogador implements ObservadoIF
{
	private String nome;
	private int[][] meuTabuleiro = new int[15][15];
	private int[][] tabuleiroInimigo = new int[15][15];
	private boolean[] armasPosicionadas = new boolean[15];
	private List <ObservadorIF> observers = new ArrayList <ObservadorIF> ();
	
	public List armas = new ArrayList <Arma> ();
	
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
	
	public void atualizaArmasPosicionadas (int pos, boolean estado)
	{
		armasPosicionadas[pos] = estado;
		for (boolean b: armasPosicionadas)
			if (!b)
				return;
		this.notifyObservers ();
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
        	System.out.println ("Notificando observers!");
        	ob.update (true);
         }
    }
}