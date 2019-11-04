package br.unitins.xadrez.model;

public class Rei extends Peca {

	public Rei(int linha, int coluna, Cor cor) {
		super(linha, coluna, cor);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Formas de movimenta��o: 1. Qualquer dire��o desde que seja um casa somente
	 * (+1, 0 / 0, +1 / -1, 0 / 0, -1 / +1, +1 / +1, -1 / -1, -1 / -1, +1);
	 * (COMPLETO) 2. N�o pode se movimentar em um local de amea�a; 3. Roque
	 * (Necess�rio a Torre);
	 */

	@Override
	public boolean mover(Posicao posicao) {

		if ((posicao.getColuna() == getPosicao().getColuna() + 1 && posicao.getLinha() == getPosicao().getLinha())
				|| (posicao.getColuna() == getPosicao().getColuna()
						&& posicao.getLinha() == getPosicao().getLinha() + 1)
				|| (posicao.getColuna() == getPosicao().getColuna() - 1
						&& posicao.getLinha() == getPosicao().getLinha())
				|| (posicao.getColuna() == getPosicao().getColuna()
						&& posicao.getLinha() == getPosicao().getLinha() - 1)
				|| (posicao.getColuna() == getPosicao().getColuna() + 1
						&& posicao.getLinha() == getPosicao().getLinha() + 1)
				|| (posicao.getColuna() == getPosicao().getColuna() + 1
						&& posicao.getLinha() == getPosicao().getLinha() - 1)
				|| (posicao.getColuna() == getPosicao().getColuna() - 1
						&& posicao.getLinha() == getPosicao().getLinha() - 1)
				|| (posicao.getColuna() == getPosicao().getColuna() - 1
						&& posicao.getLinha() == getPosicao().getLinha() + 1)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checarTrajetoria(Posicao posicao) {
		return true;
	}
}