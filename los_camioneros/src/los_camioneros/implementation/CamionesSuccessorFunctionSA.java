package los_camioneros.implementation;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CamionesSuccessorFunctionSA  implements SuccessorFunction {
	static private CamionesHeuristicFunction TSPHF;
	public CamionesSuccessorFunctionSA() {
		if (TSPHF == null)
			TSPHF = new CamionesHeuristicFunction();
	}

	private Successor genSuccessor(String action, State state) {
		return new Successor(action, state);
		// expensive version for debugging.
		/*
		double v = TSPHF.getHeuristicValue(state);
		String S = action +  " Coste("+String.valueOf(v)+")->" + state.toString();
		return new Successor(S, state);
		*/
	}

	static private abstract class DoOp {
		State stateRes = null;
		protected static Random random;
		DoOp() {
			if (random == null)
				random = new Random();
		}
		abstract String getName();
		abstract boolean generate(State res);
		int randomSafeGasDistr(State state, int i) {
			return state.getDistrGasList().get(i).gas.isEmpty() ? 0 : random.nextInt(state.getDistrGasList().get(i).gas.size());
		}
		
		State getRes() {
			return stateRes;
		}
	}
	static private class DoRotar extends DoOp {
		String getName() {
			return "ROTAR";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.isEmpty())
				return false;
			if (newState.rotarDistr(i)) {
				stateRes = newState;
				return true;
			}
			return false;
		}
	}
	static private class DoEliminar extends DoOp {
		String getName() {
			return "ELIMINAR";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.isEmpty())
				return false;
			int j = random.nextInt(state.getDistrGasList().get(i).gas.size());
			if (newState.eliminarGasolinera(i, j)) {
				stateRes = newState;
				return true;
			}
			return false;
		}
	}
	static private class DoSwapSame extends DoOp {
		String getName() {
			return "SWAPSAME";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.size() < 2)
				return false;
			int j = random.nextInt(state.getDistrGasList().get(i).gas.size());
			int k;
			do{
				k=random.nextInt(state.getDistrGasList().get(i).gas.size());
			} while (k==j);

			if (newState.swapIndexesSameDistr(i, j, k)) {
				stateRes = newState;
				return true;
			}
			return false;
		}
	}
	static private class DoAdd extends DoOp {
		String getName() {
			return "ADD";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.size() < 10) {
				int j = random.nextInt(state.getUnusedGas().size());
				int k = randomSafeGasDistr(state, i);
				if (newState.afegirGasolinera(i, j, k)) {
					stateRes = newState;
					return true;
				}
			}
			return false;
		}
		
		
	}
	static private class DoSwapOther extends DoOp {
		String getName() {
			return "SWAPOTHER";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.isEmpty())
				return false;
			int j;
			do{
				j=random.nextInt(state.getDistrGasList().size());
			} while (i==j);
			if (state.getDistrGasList().get(j).gas.isEmpty())
				return false;
			int ij = random.nextInt(state.getDistrGasList().get(i).gas.size());
			int jj = random.nextInt(state.getDistrGasList().get(j).gas.size());

			if (newState.swapIndexesBtwDistrs(i, j, ij, jj)) {
				stateRes = newState;
				return true;
			}
			return false;
		}
	}
	static private class DoMoveOther extends DoOp {
		String getName() {
			return "MOVEOTHER";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.isEmpty())
				return false;
			int j;
			do{
				j=random.nextInt(state.getDistrGasList().size());
			} while (i==j);
			int ij = random.nextInt(state.getDistrGasList().get(i).gas.size());
			int jj = randomSafeGasDistr(state, j);

			if (newState.moveOne(i, j, ij, jj)) {
				stateRes = newState;
				return true;
			}
			return false;
		}
	}
	/*
	static private class DoDoubleSwap extends DoOp {
		String getName() {
			return "DOUBLESWAP";
		}
		boolean generate(State state) {
			State newState = state.clone();
			int i = random.nextInt(state.getDistrGasList().size());
			if (state.getDistrGasList().get(i).gas.size() < 2)
				return false;

			int j;
			do{
				j=random.nextInt(state.getDistrGasList().size());
			} while (i==j);
			if (state.getDistrGasList().get(j).gas.size() < 2)
				return false;

			int ij = random.nextInt(state.getDistrGasList().get(i).gas.size()-1);
			ij -= ij % 2;
			int jj = state.getDistrGasList().get(j).gas.size() < 2 ? 0 : random.nextInt(state.getDistrGasList().get(j).gas.size()-1);
			jj -= jj % 2;

			if (newState.moveTwoAdjacents(i, j, ij, jj)) {
				stateRes = newState;
				return true;
			}
			return false;
		}
	}*/
	static private class PairOp {
		public PairOp(int prob, DoOp op) {
			this.prob = prob;
			this.op = op;
		}
		int prob;
		DoOp op;
	}

	public List<Successor> getSuccessors(Object aState) {
		Random myRandom=new Random();

		ArrayList<Successor> ret = new ArrayList<Successor>();
		State state  = (State) aState;

		int distrSize = state.getDistrGasList().size();
		int unusedSize = state.getUnusedGas().size();

		ArrayList<PairOp> operations = new ArrayList<PairOp>();

		operations.add(new PairOp(distrSize, new DoRotar()));
		operations.add(new PairOp(distrSize*10, new DoEliminar()));
		operations.add(new PairOp(distrSize*10*9, new DoSwapSame()));
		operations.add(new PairOp(distrSize*unusedSize*10, new DoAdd()));
		operations.add(new PairOp(distrSize*(distrSize-1)*10*10, new DoSwapOther()));
		operations.add(new PairOp(distrSize*(distrSize-1)*10*10, new DoMoveOther()));
		//operations.add(new PairOp(distrSize*(distrSize-1)*5*5, new DoDoubleSwap()));
		int totalProb = 0;
		for (PairOp i : operations)
			totalProb += i.prob;

		while(ret.isEmpty() && totalProb > 0) {
			int opChosen = myRandom.nextInt(totalProb);
			for (PairOp i : operations) {
				if (opChosen < i.prob) {
					if (i.op.generate(state)) {
						ret.add(genSuccessor(i.op.getName(), i.op.getRes()));
						//System.out.println(i.op.getName());
						break;
					} else {
						--i.prob;
						--totalProb;
						break;
					}
				} else {
					opChosen -= i.prob;
				}
			}
		}

		CamionesHeuristicFunction heur = new CamionesHeuristicFunction();
		/*System.out.print(ret.size());
		if (!ret.isEmpty()) {
			System.out.print(", " + heur.getHeuristicValue(ret.get(0).getState()));
		}
		System.out.println();*/
		return ret;
	}
}
