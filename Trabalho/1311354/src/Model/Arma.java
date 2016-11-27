package Model;

import java.awt.Point;

public class Arma
{
	private int[][] pontos = new int[2][5]; // 0 = vazio, 1 = preenche
	private int[][] estado = new int[2][5]; // 0 = vazio, 1 = ok, 2 = destruido
	private TipoDeArma tipo;
	private Point posicao;
	private Boolean usada;
	
	public Arma (TipoDeArma tipo)
	{
		this.tipo = tipo;
		
		switch (tipo)
		{
			case Couracado:
				pontos[1][0] = 1;
				pontos[1][1] = 1;
				pontos[1][2] = 1;
				pontos[1][3] = 1;
				pontos[1][4] = 1;
				break;
			case Submarino:
				pontos[1][0] = 1;
				break;
			case Cruzador:
				pontos[1][0] = 1;
				pontos[1][1] = 1;
				pontos[1][2] = 1;
				pontos[1][3] = 1;
				break;
			case Hidroaviao:
				pontos[1][0] = 1;
				pontos[0][1] = 1;
				pontos[1][2] = 1;
				break;
			case Destroyer:
				pontos[1][0] = 1;
				pontos[1][1] = 1;
				break;
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 2; j++) {
				estado[j][i] = pontos[j][i];
			}
		}
	}
	
	public TipoDeArma getTipoDeArma ()
	{
		return tipo;
	}
	
	public int[][] getPontos ()
	{
		return pontos;
	}
	
	public int[][] getEstado ()
	{
		return estado;
	}
	
	public void setEstadoDestruido (int x, int y)
	{
		estado[x][y] = 2;
	}

	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}

	public Boolean getUsada() {
		return usada;
	}

	public void setUsada(Boolean usada) {
		this.usada = usada;
	}
}