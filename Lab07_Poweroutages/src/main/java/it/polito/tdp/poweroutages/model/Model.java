package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	List<PowerOutAges> poa;
	int bestCosto=0;
	List<PowerOutAges> p;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}

	public List<PowerOutAges> soluzione(Nerc nerc, int X, int Y) {
		bestCosto=0;
		p = podao.getPowerOutAgesList(nerc);
		List<PowerOutAges> parziale = new ArrayList<>();
		cerca (parziale, 0, X, Y, 0);
		
		return poa;
		
	}

	private void cerca(List<PowerOutAges> parziale, int livello, int X, int Y, int costo) {
		int dif = differenzaAnni (parziale);
		int ore = sommaOre (parziale);
		if (X<dif)
			return;
		if (Y<ore)
			return;
		if(costo>=bestCosto) {
			bestCosto=costo;
			poa=new ArrayList <>(parziale);
			}
		if (livello==p.size())
			return;
		parziale.add(p.get(livello));
		cerca(parziale, livello+1, X, Y, costo+p.get(livello).getColpiti());
		parziale.remove(parziale.size()-1);
		cerca(parziale, livello+1, X, Y, costo);
	}

	private int sommaOre(List<PowerOutAges> parziale) {
		int i = 0;
		for (PowerOutAges p : parziale)
			i+=p.getDatafine().minusHours(p.getDataInizio().getHour()).getHour();
		return i;
	}

	private int differenzaAnni(List<PowerOutAges> parziale) {
		if(parziale.size()>0)
			return parziale.get(parziale.size()-1).getDatafine().getYear()-parziale.get(0).getDataInizio().getYear() ;
		return -1;
	}

}
