package los_camioneros.implementation;

public class Constants {
	public static int NUM_GAS = 100; //Nombre de gasolineres
	public static int NUM_CEN = 10; //Nombre de centres de distribuició o camions
	public static int MULT = 1; //Multiplicidad en la misma posicion.  Si multiplicidad es diferente de 1 genera varios centros en la misma posicion para simular tener mas de un camion en un centro.
	public static int PREU_KM = 2; //Diners que descompta que un camió avançi un KM
	public static int MAX_KM = 80*8; //Km que pot moure's un camió en un dia. Correspon a les hores de treball*velocitat
	public static int MAX_VIATGES = 10; //Viatges que pot fer com a màxim
	public static int VALOR_DIPOSIT = 1000; //Valor que cobra una distribuidora al omplir un dipòsit
	public static int RAND_SEED = (int)Math.floor(Math.random()*(10000-0+1)+0); //Genera una llavor aleatori
}
