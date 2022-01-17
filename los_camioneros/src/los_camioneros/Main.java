package los_camioneros;

import java.util.Iterator;
import java.util.Properties;
import java.util.List;

import IA.Gasolina.*;
import los_camioneros.implementation.*;
import aima.search.framework.*;
import aima.search.informed.*;
import java.time.Duration;
import java.time.Instant;

public final class Main {
	private static State createState() {
		int RAND_SEED = (int)Math.floor(Math.random()*(10000-0+1)+0);
		Gasolineras gasol = new Gasolineras(100, RAND_SEED);
		CentrosDistribucion centros = new CentrosDistribucion(10, 1, RAND_SEED);
		return new State(gasol, centros);
	}

	public static void main(String[] args) {
		System.out.println("Projecte camionero");

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 2; ++j) {
				Instant start = Instant.now();

				State state = createState();
				switch (i) {
					case 0: state.inicialBuida(); break;
					case 1: state.inicialMesPropera(); break;
					case 2: state.inicialTantesComPugui(); break;
				}

				Instant stateGenerated = Instant.now();

				Instant timeFinish = null;
				switch (j) {
					case 0: timeFinish = hillClimbingSearch(state); break;
					case 1: timeFinish = simulatedAnnealingSearch(state); break;
				}
				Duration timeElapsedState = Duration.between(start, stateGenerated);
				Duration timeElapsedSearch = Duration.between(stateGenerated, timeFinish);
				Duration timeElapsedTotal = Duration.between(start, timeFinish);
				System.out.println();
				System.out.println("Time state: " + timeElapsedState.toMillis());
				System.out.println("Time search: " + timeElapsedSearch.toMillis());
				System.out.println("Time total: " + timeElapsedTotal.toMillis());
			}
		}
	}
	

	public static Instant hillClimbingSearch(State state) {
		//System.out.println("\nTSP HillClimbing  -->");
		Instant computed = null;
		try {
			CamionesHeuristicFunction heuristic = new CamionesHeuristicFunction();
			Problem problem =  new Problem(state,new CamionesSuccessorFunction(), new CamionesGoalTest(),heuristic);
			Search search =  new HillClimbingSearch();
			SearchAgent agent = new SearchAgent(problem,search);
			computed = Instant.now();

			System.out.println();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			State result = (State) search.getGoalState();
			System.out.println("Cost: " + (-heuristic.getHeuristicValue(result)) + ", money today: " + result.moneyToday() + ", state: " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return computed;
	}

	private static Instant simulatedAnnealingSearch(State state) {
		System.out.println("\nTSP Simulated Annealing  -->");
		Instant computed = null;
		try {
			CamionesHeuristicFunction heuristic = new CamionesHeuristicFunction();
			Problem problem =  new Problem(state,new CamionesSuccessorFunctionSA(), new CamionesGoalTest(),heuristic);
			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(10000,100,25,0.01);
			SearchAgent agent = new SearchAgent(problem,search);
			computed = Instant.now();

			System.out.println();
			//printActionsAnealing(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			State result = (State) search.getGoalState();
			System.out.println("Cost: " + (-heuristic.getHeuristicValue(result)) + ", money today: " + result.moneyToday() + ", state: " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return computed;
	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = (String) actions.get(i);
			System.out.println(action);
		}
	}
	private static void printActionsAnealing(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			State action = (State) actions.get(i);
			System.out.println(action.toString());
		}
	}
}