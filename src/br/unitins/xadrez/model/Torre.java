package br.unitins.xadrez.model;

import br.unitins.xadrez.base.Tabuleiro;

public class Torre extends Peca {

	public Torre(int linha, int coluna, Cor cor) {
		super(linha, coluna, cor);
	}

	@Override
	public boolean mover(Posicao posicao) {
		// Movimento para frente
		if (posicao.getLinha() == getPosicao().getLinha() + 1 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() + 2 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() + 3 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() + 4 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() + 5 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() + 6 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() + 7 && posicao.getColuna() == getPosicao().getColuna()
				||
				// Movimento para tr�s
				posicao.getLinha() == getPosicao().getLinha() - 1 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() - 2 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() - 3 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() - 4 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() - 5 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() - 6 && posicao.getColuna() == getPosicao().getColuna()
				|| posicao.getLinha() == getPosicao().getLinha() - 7 && posicao.getColuna() == getPosicao().getColuna()
				||
				// Movimento em coluna
				posicao.getColuna() == getPosicao().getColuna() + 1 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() + 2 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() + 3 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() + 4 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() + 5 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() + 6 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() + 7 && posicao.getLinha() == getPosicao().getLinha()
				||
				// Movimento em coluna voltando
				posicao.getColuna() == getPosicao().getColuna() - 1 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() - 2 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() - 3 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() - 4 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() - 5 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() - 6 && posicao.getLinha() == getPosicao().getLinha()
				|| posicao.getColuna() == getPosicao().getColuna() - 7
						&& posicao.getLinha() == getPosicao().getLinha()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checarTrajetoria(Posicao posicao) {
		int i = getPosicao().getLinha();
		int j = getPosicao().getColuna();
		
		// Verifica��o de trajet�ria no sentido: (+)Linha ou (+)Coluna	
		if(posicao.getLinha() - getPosicao().getLinha() > 0 || posicao.getColuna() - getPosicao().getColuna() > 0) {
			while(i != posicao.getLinha() || j != posicao.getColuna()) {
				if(getPosicao().getLinha() == posicao.getLinha()) {
					j++;
				}else if(getPosicao().getColuna() == posicao.getColuna()){
					i++;
				}
				// Verifica�ao especial para evitar a 
				// verifica��o de nulo da ultima posi��o
				if (i == posicao.getLinha() && j == posicao.getColuna())
					return true;
				// Verifica��o de nulo cada posi��o da trajet�ria
				else if(Tabuleiro.verificadorNulo(i, j) == false)
					return false;
			}
			// Verifica��o de trajet�ria no sentido: (-)Linha ou (-)Coluna	
		}else if(posicao.getLinha() - getPosicao().getLinha() < 0 || posicao.getColuna() - getPosicao().getColuna() < 0) {
			while(i != posicao.getLinha() || j != posicao.getColuna()) {
				if(getPosicao().getLinha() == posicao.getLinha()) {
					j--;
				}else if(getPosicao().getColuna() == posicao.getColuna()){
					i--;
				}
				// Verifica�ao especial para evitar a 
				// verifica��o de nulo da ultima posi��o
				if (i == posicao.getLinha() && j == posicao.getColuna())
					return true;
				// Verifica��o de nulo cada posi��o da trajet�ria
				else if(Tabuleiro.verificadorNulo(i, j) == false)
					return false;
			}
		}
		
		return true;
	}
}
