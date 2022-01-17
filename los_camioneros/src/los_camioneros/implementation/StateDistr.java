package los_camioneros.implementation;

import java.util.ArrayList;

public class StateDistr {
	public StateDistr() {
		gas = new ArrayList<Integer>(10);
	}
	
	public ArrayList<Integer> gas;
	public int dist; //distancia recorreguda
	public StateDistr clone() {
		StateDistr entry = new StateDistr();
		entry.gas = new ArrayList<Integer>(10);
		for (Integer i : gas)
			entry.gas.add(i.intValue());
		entry.dist = dist;
		return entry;
	}
	public Integer getDist() {return dist;}
}