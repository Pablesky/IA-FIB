package los_camioneros.implementation;

import java.util.ArrayList;

import aima.search.framework.HeuristicFunction;

public class CamionesHeuristicFunction implements HeuristicFunction {
	static private ArrayList<Double> lookupData;
	static private int currentLookup = 0;
	static public void prepareDays(int max) {
		++max;
		if (currentLookup < max) {
			lookupData = new ArrayList<Double>(max+1);
			for (int i = 0; i <= max; ++i) {
				lookupData.add(preuDipositImpl(i));
			}
			currentLookup = max;
		}
	}

	public double getHeuristicValue(Object actualRaw) {
		State actual = (State)actualRaw;
		double value = actual.getCashToday();

		for (StateDistr gasolinera : actual.getDistrGasList()) {
			value -= gasolinera.getDist() * Constants.PREU_KM;
		}
		// Comentar en cas que es vulgui obtenir el major rendiment nomes avui, i no en total.
		value += actual.getUnusedCost();
		return -value;
	}

	static public double preuDiposit(int diesPendent) {
		return lookupData.get(diesPendent);
	}

	static public double preuDipositImpl(int diesPendent) {
		return Constants.VALOR_DIPOSIT*((diesPendent == 0) ? 102.0 : (100 - Math.pow(2, diesPendent)))/100;
	}
}
