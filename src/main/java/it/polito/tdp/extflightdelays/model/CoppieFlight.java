package it.polito.tdp.extflightdelays.model;

public class CoppieFlight {
	private Airport partenza;
	private Airport arrivo;
	private int distanza;

	public CoppieFlight(Airport partenza, Airport arrivo, int distanza) {
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.distanza = distanza;
	}

	public Airport getPartenza() {
		return partenza;
	}

	public void setPartenza(Airport partenza) {
		this.partenza = partenza;
	}

	public Airport getArrivo() {
		return arrivo;
	}

	public void setArrivo(Airport arrivo) {
		this.arrivo = arrivo;
	}

	public int getDistanza() {
		return distanza;
	}

	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}

	@Override
	public String toString() {
		return partenza + ", " + arrivo + ", " + distanza;
	}

}
