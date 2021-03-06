package Model;

import java.awt.*;

public enum CoresMapa
{
	Vazio (new Color (177, 203, 255)),
	VazioAtingido (new Color (131, 128, 199)),
	Couracado (Color.orange),
	CouracadoSelecionado (new Color (250, 213, 147)),
	Submarino (Color.blue),
	SubmarinoSelecionado (new Color (168, 203, 255)),
	Cruzador (Color.green),
	CruzadorSelecionado (new Color (168, 255, 177)),
	Hidroaviao (Color.pink),
	HidroaviaoSelecionado (new Color (250, 196, 255)),
	Destroyer (Color.black),
	DestroyerSelecionado (new Color (88, 88, 88)),
	Destruida (Color.red),
	Bloqueado (Color.gray);
		
	private final Color cor;

    private CoresMapa (Color cor)
    {
        this.cor = cor;
    }
    
    public Color getColor ()
    {
    	return cor;
    }
}