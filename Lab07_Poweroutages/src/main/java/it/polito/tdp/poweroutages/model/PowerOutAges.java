package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;

public class PowerOutAges {

	private int id;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private int colpiti;
	/**
	 * @param id
	 * @param dataInizio
	 * @param datafine
	 * @param colpiti
	 */
	public PowerOutAges(int id, LocalDateTime dataInizio, LocalDateTime dataFine, int colpiti) {
		super();
		this.id = id;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.colpiti = colpiti;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the dataInizio
	 */
	public LocalDateTime getDataInizio() {
		return dataInizio;
	}
	/**
	 * @param dataInizio the dataInizio to set
	 */
	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**
	 * @return the datafine
	 */
	public LocalDateTime getDatafine() {
		return dataFine;
	}
	/**
	 * @param datafine the datafine to set
	 */
	public void setDatafine(LocalDateTime datafine) {
		this.dataFine = datafine;
	}
	/**
	 * @return the colpiti
	 */
	public int getColpiti() {
		return colpiti;
	}
	/**
	 * @param colpiti the colpiti to set
	 */
	public void setColpiti(int colpiti) {
		this.colpiti = colpiti;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutAges other = (PowerOutAges) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return dataInizio + " " + dataFine + " " + (dataFine.minusHours(dataInizio.getHour()).getHour()) + " "+ colpiti + "\n";
	}
	
	
	
	
}
