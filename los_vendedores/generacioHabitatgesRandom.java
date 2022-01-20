import java.util.Random;

public class generacioHabitatgesRandom {
    static double LATITUDE_MIN = 41.00;
    static double OFF_LATITUDE_MAX = 0.054;
    static double LONGITUDE_MIN = 2.10;
    static double OFF_LONGITUDE_MAX = 0.072;

    //variables habitatges

	static int INDEX;
	static String DISTRICTE;

	static String type;
    static Boolean ascensor;
	static Boolean atic;
	static int planta_MIN;
	static int planta_MAX;
	static Boolean acces_mobilitat_reduida;
	static Boolean aire_condicionat;
	static Boolean amb_mobles;
	static int any_construccio_MIN;
	static int any_construccio_MAX;
	static int area_MIN;
	static int area_MAX;
	static Boolean balco;
	static Boolean bones_vistes;
	static Boolean calefaccio;
	static Boolean electrodomestics;
	static Boolean jardi;
	static Boolean mascotes;
	static int numero_dormitoris_simples;
	static int numero_dormitoris_dobles;
	static int numero_lavabos;
	static Boolean parquet;
	static Boolean piscina_comunitaria;
	static Boolean plaça_garatge;
	static int preu_MIN;
	static int preu_MAX;
	static String solejat;
	static Boolean terrassa;
	static Double ubicacio_lat_MIN;
	static Double ubicacio_lat_MAX;
	static Double ubicacio_long_MIN;
	static Double ubicacio_long_MAX;

	static void printHouses(int times) {
		for (int i = 0; i < times; ++i) {

			System.out.println("	(Hab_"+INDEX+" of " + type);

			if (!type.equals("Unifamiliar")) {
				System.out.print("		(ascensor ");
				if(ascensor) System.out.print("TRUE)");
				else System.out.print("FALSE)");
				System.out.println();

				System.out.print("		(atic ");
				if(atic) System.out.print("TRUE)");
				else System.out.print("FALSE)");
				System.out.println();

				System.out.println("		(planta "+planta_MIN+")");
			}
			System.out.print("		(aire_condicionat ");
			if(aire_condicionat) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(amb_mobles ");
			if(amb_mobles) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.println("		(any_construccio "+any_construccio_MIN+")");

			System.out.println("		(area "+area_MIN+")");

			System.out.print("		(balco ");
			if(balco) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(bones_vistes ");
			if(bones_vistes) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(calefaccio ");
			if(calefaccio) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(electrodomestics ");
			if(electrodomestics) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(jardi ");
			if(jardi) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(mascotes ");
			if(mascotes) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.println("		(numero_dormitoris_simples " + numero_dormitoris_simples + ")");

			System.out.println("		(numero_dormitoris_dobles " + numero_dormitoris_dobles + ")");

			System.out.println("		(numero_lavabos " + numero_lavabos + ")");

			System.out.print("		(parquet ");
			if(parquet) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(piscina_comunitaria ");
			if(piscina_comunitaria) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.print("		(placa_garatge ");
			if(plaça_garatge) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.println("		(preu "+preu_MIN+"000)");

			System.out.println("		(solejat \""+solejat+"\")");

			System.out.print("		(terrassa ");
			if(terrassa) System.out.print("TRUE)");
			else System.out.print("FALSE)");
			System.out.println();

			System.out.println("		(ubicacio_x "+ubicacio_lat_MIN+")");

			System.out.println("		(ubicacio_y "+ubicacio_long_MIN+")");

			System.out.println("	)");

			System.out.println();

		}
	}


    public static void main(String[] args) {

		System.out.println("(definstances Habitatges");

		String[] type_array = {"Pis", "Duplex", "Unifamiliar"};
		String[] solejat_array = {"mati", "tarda", "ambdues", "cap"};
		Boolean[] bool_array = {true, false};

		for(int i = 0; i < 100; ++i) {
			Random r = new Random();
			INDEX = i;
			type = type_array[r.nextInt(3)];
			ascensor = bool_array[r.nextInt(2)];
			atic = bool_array[r.nextInt(2)];
			planta_MIN = r.nextInt(10);
			acces_mobilitat_reduida = bool_array[r.nextInt(2)];
			aire_condicionat = bool_array[r.nextInt(2)];
			amb_mobles = bool_array[r.nextInt(2)];
			any_construccio_MIN = r.nextInt(220)+1800;
			area_MIN = r.nextInt(350)+50;
			balco = bool_array[r.nextInt(2)];
			bones_vistes = bool_array[r.nextInt(2)];
			calefaccio = bool_array[r.nextInt(2)];
			electrodomestics = bool_array[r.nextInt(2)];
			jardi = bool_array[r.nextInt(2)];
			mascotes = bool_array[r.nextInt(2)];
			numero_dormitoris_simples = r.nextInt(4);
			numero_dormitoris_dobles = r.nextInt(4);
			if (numero_dormitoris_simples + numero_dormitoris_dobles == 0)
				++numero_dormitoris_simples;
			numero_lavabos = r.nextInt(3)+1;
			parquet = bool_array[r.nextInt(2)];
			piscina_comunitaria = bool_array[r.nextInt(2)];
			plaça_garatge = bool_array[r.nextInt(2)];
			preu_MIN = r.nextInt(700)+30;
			solejat = solejat_array[r.nextInt(4)];
			terrassa = bool_array[r.nextInt(2)];
			ubicacio_lat_MIN = r.nextDouble()*(41.4879186-41.3253385)+41.3253385;
			ubicacio_long_MIN = r.nextDouble()*(2.2694373-2.0445146)+2.0445146;
			printHouses(1);
		}

		System.out.println(")");
    }
}
