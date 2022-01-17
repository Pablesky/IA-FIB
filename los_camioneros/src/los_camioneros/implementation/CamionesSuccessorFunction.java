package los_camioneros.implementation;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class CamionesSuccessorFunction  implements SuccessorFunction {
	static private CamionesHeuristicFunction TSPHF;
	public CamionesSuccessorFunction() {
		if (TSPHF == null)
			TSPHF = new CamionesHeuristicFunction();
	}

	private Successor genSuccessor(String action, State state) {
		return new Successor(action, state);
		// expensive version for debugging.
		/*
		double v = TSPHF.getHeuristicValue(state);
		String S = action + " Coste("+String.valueOf(v)+")->" + state.toString();
		return new Successor(S, state);
		*/
	}

	public List<Successor> getSuccessors(Object aState) {
		ArrayList<Successor> ret = new ArrayList<Successor>();
		State state  = (State) aState;

		for (int i = 0; i < state.getDistrGasList().size(); i++) {
			if (!state.getDistrGasList().get(i).gas.isEmpty()) {
				State newState = state.clone();
				if (newState.rotarDistr(i)) ret.add(genSuccessor("ROTAR", newState));
			}
			for (int j = 0; j < state.getDistrGasList().get(i).gas.size(); j++) {
				{
					State newState = state.clone();
					if (newState.eliminarGasolinera(i, j)) ret.add(genSuccessor("ELIMINAR", newState));
				}
				for (int k = j+1; k < state.getDistrGasList().get(i).gas.size(); k++) {
					State newState = state.clone();
					if (newState.swapIndexesSameDistr(i, j, k)) ret.add(genSuccessor("INTERCANVIARPROPI", newState));
				}
			}

			if (state.getDistrGasList().get(i).gas.size() < 10) {
				for (int j : state.getUnusedGas()) {
					for (int k = 0; k <= state.getDistrGasList().get(i).gas.size(); k++) {
						State newState = state.clone();
						if (newState.afegirGasolinera(i, j, k)) ret.add(genSuccessor("AFEGIR", newState));
					}
				}
			}

			for (int j = i+1; j < state.getDistrGasList().size(); j++) {
				for (int ij = 0; ij < state.getDistrGasList().get(i).gas.size(); ij++) {
					for (int jj = 0; jj < state.getDistrGasList().get(j).gas.size(); jj++) {
						{
							State newState = state.clone();
							if (newState.swapIndexesBtwDistrs(i, j, ij, jj)) ret.add(genSuccessor("INTERCANVIARALTRE", newState));
						}
							State newState = state.clone();
							if (newState.moveOne(i, j, ij, jj)) ret.add(genSuccessor("MOVEOVER", newState));

						if (ij % 2 == 0 && jj % 2 == 0 &&
								ij+1 < state.getDistrGasList().get(i).gas.size()) {
							newState = state.clone();
							if (newState.moveTwoAdjacents(i, j, ij, jj)) ret.add(genSuccessor("DOUBLESWAP", newState));
						}

					}
				}
			}
		}

		return ret;
	}
}
