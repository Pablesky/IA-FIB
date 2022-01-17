package los_camioneros.implementation;

import IA.Gasolina.*;

import java.lang.Math;
import java.util.ArrayList;
import java.util.HashSet;

public class State {
	static ArrayList<Gasolinera> gasolineras;
	static ArrayList<Integer> minDistanceGas;
	static CentrosDistribucion distribucion;
	static int[][] gasToGas;
	static int[][] distrToGas;

	ArrayList<StateDistr> distrGasList;
	HashSet<Integer> unusedGas;
	double unusedCost;
	double cashToday;
	
	public double getCashToday() {return cashToday;}
	public double getUnusedCost() {return unusedCost;}
	public ArrayList<Integer> getMinDistanceGas() {return minDistanceGas;}
	public ArrayList<StateDistr> getDistrGasList() {return distrGasList;}
	public HashSet<Integer> getUnusedGas() {return unusedGas;}
	public ArrayList<Gasolinera> getGasolineras() {return gasolineras;}

	public int calcDistancia(Gasolinera i, Gasolinera j) {
		return Math.abs(i.getCoordX() - j.getCoordX()) + Math.abs(i.getCoordY() - j.getCoordY());
	}
	public int calcDistancia(Gasolinera i, Distribucion j) {
		return Math.abs(i.getCoordX() - j.getCoordX()) + Math.abs(i.getCoordY() - j.getCoordY());
	}
	public int calcDistancia(Distribucion i, Gasolinera j) {
		return Math.abs(i.getCoordX() - j.getCoordX()) + Math.abs(i.getCoordY() - j.getCoordY());
	}
	public int calcDistancia(Distribucion i, Distribucion j) {
		return Math.abs(i.getCoordX() - j.getCoordX()) + Math.abs(i.getCoordY() - j.getCoordY());
	}

	private String stringify(Gasolinera i) {
		return String.valueOf(i.getCoordX()) + "," + String.valueOf(i.getCoordY());
	}
	private String stringify(Distribucion i) {
		return String.valueOf(i.getCoordX()) + "," + String.valueOf(i.getCoordY());
	}

	public State(Gasolineras gasolineras, CentrosDistribucion distribucion) {
		int maxPetitionDay = -1;
		State.gasolineras = new ArrayList<Gasolinera>();
		for (Gasolinera gasolinera : gasolineras) {
			ArrayList<Integer> peticiones = gasolinera.getPeticiones();
			for (Integer peticion : peticiones) {
				ArrayList<Integer> copyPetition = new ArrayList<Integer>();
				maxPetitionDay = Math.max(maxPetitionDay, peticion);
				copyPetition.add(peticion);
				State.gasolineras.add(new Gasolinera(gasolinera.getCoordX(), gasolinera.getCoordY(), copyPetition));
			}
		}

		CamionesHeuristicFunction.prepareDays(maxPetitionDay);
		State.distribucion = distribucion;

		State.minDistanceGas = new ArrayList<Integer>();
		for (Gasolinera gasolinera : State.gasolineras) {
			int min = 0;
			boolean found = false;
			for (Distribucion distr : State.distribucion) {
				int dist = calcDistancia(gasolinera, distr);
				if (!found || dist < min) {
					min = dist;
					found = true;
				}
			}
			State.minDistanceGas.add(min);
		}

		gasToGas = new int[State.gasolineras.size()][State.gasolineras.size()];
		distrToGas = new int[State.distribucion.size()][State.gasolineras.size()];
		for (int i = 0; i < State.gasolineras.size(); ++i) {
			for (int j = 0; j < State.gasolineras.size(); ++j) {
				if (i == j) {
					gasToGas[i][i] = 0;
				}
				int dist = calcDistancia(State.gasolineras.get(i), State.gasolineras.get(j));
				gasToGas[i][j] = dist;
				gasToGas[j][i] = dist;
			}
			for (int j = 0; j < State.distribucion.size(); ++j) {
				int dist = calcDistancia(State.gasolineras.get(i), State.distribucion.get(j));
				distrToGas[j][i] = dist;
			}
		}

		distrGasList = new ArrayList<StateDistr>();
		for (int i = 0; i < State.distribucion.size(); ++i) distrGasList.add(new StateDistr());
		unusedGas = new HashSet<Integer>();
		unusedCost = 0.0;
		for (int i = 0; i < State.gasolineras.size(); ++i) {
			unusedGas.add(i);
			unusedCost += CamionesHeuristicFunction.preuDiposit(State.gasolineras.get(i).getPeticiones().get(0) + 1)  - Constants.PREU_KM*minDistanceGas.get(i)*2;
		}
	}

	private State(ArrayList<StateDistr> distribucionGasolineras, HashSet<Integer> unusedGas, double unusedCost, double cashToday) {
		this.distrGasList = distribucionGasolineras;
		this.unusedGas = unusedGas;
		this.unusedCost = unusedCost;
		this.cashToday = cashToday;
	}

	public String toString() {
		String result = "";
		/*
		for (int i = 0; i < distrGasList.size(); ++i) {
			result += "[" + stringify(distribucion.get(i)) + "]{";

			for (Integer gasIdx : distrGasList.get(i).gas) {
				result += "[" + stringify(gasolineras.get(gasIdx)) + "]";
			}

			result += "}";
		}

		result += "[UNUSED]{";
		for (Integer unused : unusedGas) {
			result += "[" + stringify(gasolineras.get(unused)) + "]";
		}
		result += "}";
		*/
		return result;
	}

	public State clone() {
		ArrayList<StateDistr> newState = new ArrayList<StateDistr>(distrGasList.size());
		for (StateDistr i : distrGasList)
			newState.add(i.clone());
		HashSet<Integer> unused = new HashSet<Integer>(unusedGas.size());
		for (int i : unusedGas)
			unused.add(i);
		return new State(newState, unused, unusedCost, cashToday);
	}

	public double moneyToday() {
		double value = cashToday;
		for (StateDistr gasolinera : distrGasList) {
			value -= gasolinera.getDist() * Constants.PREU_KM;
		}
		return value;
	}

	public boolean distrValidState(int i) {
		return (distrGasList.get(i).dist <= Constants.MAX_KM) && (distrGasList.get(i).gas.size() <= Constants.MAX_VIATGES);
	}
	
	private int calcDist(int distrIdx) {
		StateDistr distr = distrGasList.get(distrIdx);
		if (distr.gas.isEmpty())
			return 0;

		int total = 0;
		for (int i = 0; i < distr.gas.size(); ++i) {
			int gas0 = distr.gas.get(i);
			if (i == 0) {
				total += distrToGas[distrIdx][gas0];
			} else {
				int gas1 = distr.gas.get(i-1);
				if (i % 2 == 1) {
					total += gasToGas[gas1][gas0];
				}
				else {
					total += distrToGas[distrIdx][gas1];
					total += distrToGas[distrIdx][gas0];
				}
			}
		}
		int gas = distr.gas.get(distr.gas.size()-1);
		total += distrToGas[distrIdx][gas];
		return total;

	}
	
	public boolean swapIndexesSameDistr (int camion, int i, int j) {
		int gasolinera1 = distrGasList.get(camion).gas.get(i);
		int gasolinera2 = distrGasList.get(camion).gas.get(j);

		distrGasList.get(camion).gas.set(i, gasolinera2);
		distrGasList.get(camion).gas.set(j, gasolinera1);

		distrGasList.get(camion).dist = calcDist(camion);

		return distrValidState(camion);
	}

	public boolean swapIndexesBtwDistrs (int icamion1, int icamion2, int indexcamion1, int indexcamion2) {
		if (icamion1 == icamion2)
			return false;
		int gasolinera1 = distrGasList.get(icamion1).gas.get(indexcamion1);
		int gasolinera2 = distrGasList.get(icamion2).gas.get(indexcamion2);
		
		distrGasList.get(icamion1).gas.set(indexcamion1, gasolinera2);
		distrGasList.get(icamion2).gas.set(indexcamion2, gasolinera1);

		distrGasList.get(icamion1).dist = calcDist(icamion1);
		distrGasList.get(icamion2).dist = calcDist(icamion2);

		return distrValidState(icamion1) && distrValidState(icamion2);
	}

	public boolean rotarDistr(int i) {
		StateDistr distr = distrGasList.get(i);
		Integer gasol = distr.gas.get(0);
		distr.gas.remove(0);
		distr.gas.add(gasol);
		distr.dist = calcDist(i);
		return distrValidState(i);
	}

	public boolean moveOne(int distrFromIdx, int distrToIdx, int gasIdxFrom, int gasIdxTo) {

		StateDistr distrFrom = distrGasList.get(distrFromIdx);
		StateDistr distrTo = distrGasList.get(distrToIdx);

		int gas = distrFrom.gas.get(gasIdxFrom);

		distrFrom.gas.remove(gasIdxFrom);
		distrFrom.dist = calcDist(distrFromIdx);

		distrTo.gas.add(gasIdxTo, gas);
		distrTo.dist = calcDist(distrToIdx);

		return distrValidState(distrToIdx);
	}

	public boolean moveTwoAdjacents(int distrFromIdx, int distrToIdx, int gasIdxFrom, int gasIdxTo) {
		StateDistr distrFrom = distrGasList.get(distrFromIdx);
		StateDistr distrTo = distrGasList.get(distrToIdx);

		int gas1 = distrFrom.gas.get(gasIdxFrom);
		int gas2 = distrFrom.gas.get(gasIdxFrom+1);

		int distance = distrToGas[distrFromIdx][gas1] + gasToGas[gas1][gas2] + distrToGas[distrFromIdx][gas2];

		distrFrom.dist -= distance;
		distrFrom.gas.remove(gasIdxFrom);
		distrFrom.gas.remove(gasIdxFrom); // the second, gas2
		
		distrTo.gas.add(gasIdxTo, gas2);
		distrTo.gas.add(gasIdxTo, gas1);
		distrTo.dist += distance;


		return distrValidState(distrToIdx);
	}

	//pre: distGasList[centDistr].gas.size() < 10. centDistr no conte gasolinera
	//index <= 10
	//post: afegeix gaslin al primer espai buit de distGasList[centDistr].gas
	//i incrementa la distància (i els beneficis). elimina gasolin de unusedGas
	public boolean afegirGasolinera(int centDistr, int gasolin, int index){
		distrGasList.get(centDistr).gas.add(index, gasolin);
		double priceToday = CamionesHeuristicFunction.preuDiposit(gasolineras.get(gasolin).getPeticiones().get(0));
		double priceTomorrow = CamionesHeuristicFunction.preuDiposit(gasolineras.get(gasolin).getPeticiones().get(0)+1) - 2*Constants.PREU_KM*minDistanceGas.get(gasolin);

		unusedGas.remove(gasolin);
		unusedCost -= priceTomorrow;

		distrGasList.get(centDistr).dist = calcDist(centDistr);
		cashToday += priceToday;
		return distrValidState(centDistr);
	}

	//pre: existeix gasolin a distrGasList[centDistr].gas
	//post: s'elimina de gasolin i es reformen les parelles i es recalcula distancia i benefici
	public boolean eliminarGasolinera(int centDistr, int gasolinIdx){
		Integer gasolin = distrGasList.get(centDistr).gas.get(gasolinIdx);
		
		double priceToday = CamionesHeuristicFunction.preuDiposit(gasolineras.get(gasolin).getPeticiones().get(0));
		double priceTomorrow = CamionesHeuristicFunction.preuDiposit(gasolineras.get(gasolin).getPeticiones().get(0)+1) - 2*Constants.PREU_KM*minDistanceGas.get(gasolin);

		distrGasList.get(centDistr).gas.remove(gasolinIdx);
		unusedGas.add(gasolin);
		unusedCost += priceTomorrow;
		
		distrGasList.get(centDistr).dist = calcDist(centDistr);
		cashToday -= priceToday;
		return true;
	}

	public boolean inicialTantesComPugui() {
		boolean someFound = true;
		while(someFound) {
			someFound = false;
			int distrMin = -1;
			int gasMin = -1;
			for (int i = 0; i < distrGasList.size(); ++i) {
				//obtenim la distancia mes petita entre un centre de distribuicio i totes les gasolineres sense fer servir
				for(Integer j : unusedGas) {
					if (!someFound || distrToGas[i][j] < distrToGas[distrMin][gasMin]) {
						if (canPushBack(i, j)) {
							gasMin = j;
							distrMin = i;
							someFound = true;
						}
					}
				}
			}
			if (someFound) {
				afegirGasolinera(distrMin, gasMin, distrGasList.get(distrMin).gas.size());
			}
		}
		return true;
	}

	public boolean inicialMesPropera() {
		for (int totalIt = distrGasList.size(); totalIt != 0 && !unusedGas.isEmpty(); --totalIt) {
			int distrMin = -1;
			int gasMin = -1;
			boolean found = false;
			for (int i = 0; i < distrGasList.size(); ++i) {
				if (!distrGasList.get(i).gas.isEmpty())
					continue;
				//obtenim la distancia mes petita entre un centre de distribuicio i totes les gasolineres sense fer servir
				for(Integer j : unusedGas) {
					if (!found || distrToGas[i][j] < distrToGas[distrMin][gasMin]) {
						if (canPushBack(i, j)) {
							gasMin = j;
							distrMin = i;
							found = true;
						}
					}
				}
			}
			if (!found)
				return true;
			afegirGasolinera(distrMin, gasMin, distrGasList.get(distrMin).gas.size());
		}

		return true;
	}
	private boolean canPushBack(int i, int j) {
		StateDistr distr = distrGasList.get(i);
		if (distr.gas.isEmpty()) {
			return distr.dist + distrToGas[i][j] <= Constants.MAX_KM;
		} else if (distr.gas.size() == 10) {
			return false;
		} else if (distr.gas.size() % 2 == 0) {
			return distr.dist + distrToGas[i][j]*2 <= Constants.MAX_KM;
		} else {
			int j2 = distr.gas.get(distr.gas.size()-1);
			return distr.dist - distrToGas[i][j2] + gasToGas[j][j2] + distrToGas[i][j] <= Constants.MAX_KM;
		}
	}
	public boolean inicialBuida() {return true;}
}