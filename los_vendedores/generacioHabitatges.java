import java.util.Arrays;
import java.util.Random;

public class generacioHabitatges {
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
			Random r = new Random();

			System.out.println("(definstances Habitatges");
			System.out.println("	(Hab_"+DISTRICTE+"_"+INDEX+"_"+i+" of " + type);

			System.out.print("		(ascensor ");
			if(ascensor) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(atic ");
			if(atic) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			if (planta_MAX == planta_MIN) System.out.println("		(planta "+planta_MAX+")");
			else System.out.println("		(planta "+(r.nextInt(planta_MAX-planta_MIN)+planta_MIN)+")");

			System.out.print("		(acces_mobilitat_reuida ");
			if(acces_mobilitat_reduida) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(aire_condicionat ");
			if(aire_condicionat) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(amb_mobles ");
			if(amb_mobles) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.println("		(any_construccio "+(r.nextInt(any_construccio_MAX-any_construccio_MIN)+any_construccio_MIN)+")");

			System.out.println("		(area "+(r.nextInt(area_MAX-area_MIN)+area_MIN)+")");

			System.out.print("		(balco ");
			if(balco) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(bones_vistes ");
			if(bones_vistes) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(calefaccio ");
			if(calefaccio) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(electrodomestics ");
			if(electrodomestics) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(jardi ");
			if(jardi) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(mascotes ");
			if(mascotes) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.println("		(numero_dormitoris_simples " + numero_dormitoris_simples + ")");

			System.out.println("		(numero_dormitoris_dobles " + numero_dormitoris_dobles + ")");

			System.out.println("		(numero_lavabos " + numero_lavabos + ")");

			System.out.print("		(parquet ");
			if(parquet) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(piscina_comunitaria ");
			if(piscina_comunitaria) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.print("		(placa_garatge ");
			if(plaça_garatge) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.println("		(preu "+(r.nextInt(preu_MAX-preu_MIN)+preu_MIN)+"000)");

			System.out.println("		(solejat \""+solejat+"\")");

			System.out.print("		(terrassa ");
			if(terrassa) System.out.print("True)");
			else System.out.print("False)");
			System.out.println();

			System.out.println("		(ubicacio_x "+(r.nextDouble(ubicacio_lat_MAX-ubicacio_lat_MIN)+ubicacio_lat_MIN)+")");

			System.out.println("		(ubicacio_y "+(r.nextDouble(ubicacio_long_MAX-ubicacio_long_MIN)+ubicacio_long_MIN)+")");

			System.out.println("	)");

			System.out.println(")");

		}
	}


    public static void main(String[] args) {

		//districte A: districte mega ric. Cap transport públic, però cases de molta alta qualitat i preu.
        //Pocs serveis, només alguna zona verda.
		DISTRICTE = "A";
		INDEX = 1;
		type = "Unifamiliar";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 0;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 1700;
		any_construccio_MAX = 1950;
		area_MIN = 460;
		area_MAX = 740;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = true;
		mascotes = true;
		numero_dormitoris_simples = 4;
		numero_dormitoris_dobles = 2;
		numero_lavabos = 3;
		parquet = true;
		piscina_comunitaria = true;
		plaça_garatge = true;
		preu_MIN = 1000;
		preu_MAX = 4000;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		printHouses(4);

		DISTRICTE = "A";
		INDEX = 2;
		type = "Unifamiliar";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 0;
		acces_mobilitat_reduida = true;
		aire_condicionat = false;
		amb_mobles = false;
		any_construccio_MIN = 1700;
		any_construccio_MAX = 1950;
		area_MIN = 460;
		area_MAX = 740;
		balco = true;
		bones_vistes = true;
		calefaccio = false;
		electrodomestics = false;
		jardi = true;
		mascotes = true;
		numero_dormitoris_simples = 3;
		numero_dormitoris_dobles = 3;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = true;
		plaça_garatge = true;
		preu_MIN = 700;
		preu_MAX = 3000;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		printHouses(4);

		INDEX = 3;
		type = "Unifamiliar";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 0;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 1700;
		any_construccio_MAX = 1950;
		area_MIN = 460;
		area_MAX = 740;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = true;
		mascotes = true;
		numero_dormitoris_simples = 3;
		numero_dormitoris_dobles = 2;
		numero_lavabos = 2;
		parquet = false;
		piscina_comunitaria = false;
		plaça_garatge = true;
		preu_MIN = 800;
		preu_MAX = 2500;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		printHouses(4);

		//districte B: districte ric. Un unic bus de transport públic, però cases d'alta qualitat i preu.
        //Una escola, una biblioteca, un gimnas, una zona verda, un lloc emblematic, un CAP i un Super (carillo).
		DISTRICTE = "B";
		INDEX = 1;
		type = "Unifamiliar";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 0;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 1900;
		any_construccio_MAX = 2000;
		area_MIN = 120;
		area_MAX = 300;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = true;
		mascotes = true;
		numero_dormitoris_simples = 3;
		numero_dormitoris_dobles = 2;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = false;
		plaça_garatge = true;
		preu_MIN = 600;
		preu_MAX = 1000;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
		printHouses(4);

		DISTRICTE = "B";
		INDEX = 2;
		type = "Unifamiliar";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 0;
		acces_mobilitat_reduida = true;
		aire_condicionat = false;
		amb_mobles = false;
		any_construccio_MIN = 1900;
		any_construccio_MAX = 2000;
		area_MIN = 120;
		area_MAX = 300;
		balco = true;
		bones_vistes = true;
		calefaccio = false;
		electrodomestics = false;
		jardi = false;
		mascotes = true;
		numero_dormitoris_simples = 4;
		numero_dormitoris_dobles = 2;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = true;
		plaça_garatge = true;
		preu_MIN = 500;
		preu_MAX = 900;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
		printHouses(4);

		DISTRICTE = "B";
		INDEX = 3;
		type = "Unifamiliar";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 0;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 1900;
		any_construccio_MAX = 2000;
		area_MIN = 100;
		area_MAX = 250;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = true;
		mascotes = true;
		numero_dormitoris_simples = 2;
		numero_dormitoris_dobles = 1;
		numero_lavabos = 1;
		parquet = true;
		piscina_comunitaria = false;
		plaça_garatge = true;
		preu_MIN = 400;
		preu_MAX = 900;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
		printHouses(4);

		//districte C: districte cultural/Oci. Algun transport public. Cases de preu mitja-alt, pero algo petites.
        //molt oci nocturn, cultural i biblioteques. Algun supermercat. Un CAP, una escola i un gimnas
		DISTRICTE = "C";
		INDEX = 1;
		type = "Pis";
		ascensor = true;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 5;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 2000;
		any_construccio_MAX = 2010;
		area_MIN = 80;
		area_MAX = 120;
		balco = true;
		bones_vistes = false;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = true;
		numero_dormitoris_simples = 2;
		numero_dormitoris_dobles = 1;
		numero_lavabos = 1;
		parquet = true;
		piscina_comunitaria = false;
		plaça_garatge = false;
		preu_MIN = 120;
		preu_MAX = 300;
		solejat = "mati";
		terrassa = false;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*3/3;
		printHouses(8);

		DISTRICTE = "C";
		INDEX = 2;
		type = "Pis";
		ascensor = true;
		atic = true;
		planta_MIN = 3;
		planta_MAX = 6;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 2000;
		any_construccio_MAX = 2010;
		area_MIN = 80;
		area_MAX = 120;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = false;
		numero_dormitoris_simples = 2;
		numero_dormitoris_dobles = 2;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = false;
		plaça_garatge = false;
		preu_MIN = 170;
		preu_MAX = 400;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*3/3;
		printHouses(8);

		DISTRICTE = "C";
		INDEX = 3;
		type = "Duplex";
		ascensor = true;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 4;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 2000;
		any_construccio_MAX = 2010;
		area_MIN = 120;
		area_MAX = 200;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = true;
		numero_dormitoris_simples = 2;
		numero_dormitoris_dobles = 2;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = false;
		plaça_garatge = true;
		preu_MIN = 170;
		preu_MAX = 400;
		solejat = "ambdues";
		terrassa = false;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*3/3;
		printHouses(8);

		//districte D: districte universitari. Ben comunicat. Pisos majoritariament orientats a estudiants.
        //moltes escoles i biblioteques. Algunes zones verdes, oci nocturn i gimnasos. Un supermercat, un lloc emblemàtic i una zona cultural.
		DISTRICTE = "D";
		INDEX = 1;
		type = "Pis";
		ascensor = true;
		atic = true;
		planta_MIN = 3;
		planta_MAX = 6;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 2006;
		any_construccio_MAX = 2015;
		area_MIN = 50;
		area_MAX = 100;
		balco = true;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = false;
		numero_dormitoris_simples = 4;
		numero_dormitoris_dobles = 0;
		numero_lavabos = 1;
		parquet = false;
		piscina_comunitaria = false;
		plaça_garatge = false;
		preu_MIN = 300;
		preu_MAX = 600;
		solejat = "mati";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		printHouses(4);

		DISTRICTE = "D";
		INDEX = 2;
		type = "Pis";
		ascensor = false;
		atic = false;
		planta_MIN = 0;
		planta_MAX = 4;
		acces_mobilitat_reduida = false;
		aire_condicionat = false;
		amb_mobles = true;
		any_construccio_MIN = 2006;
		any_construccio_MAX = 2015;
		area_MIN = 50;
		area_MAX = 90;
		balco = true;
		bones_vistes = false;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = false;
		numero_dormitoris_simples = 3;
		numero_dormitoris_dobles = 0;
		numero_lavabos = 1;
		parquet = false;
		piscina_comunitaria = false;
		plaça_garatge = false;
		preu_MIN = 200;
		preu_MAX = 400;
		solejat = "tarda";
		terrassa = false;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		printHouses(4);

		DISTRICTE = "D";
		INDEX = 3;
		type = "Duplex";
		ascensor = true;
		atic = true;
		planta_MIN = 3;
		planta_MAX = 6;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 2006;
		any_construccio_MAX = 2015;
		area_MIN = 80;
		area_MAX = 120;
		balco = false;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = true;
		numero_dormitoris_simples = 4;
		numero_dormitoris_dobles = 1;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = true;
		plaça_garatge = false;
		preu_MIN = 500;
		preu_MAX = 800;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;

		//districte E: casc antic. Pisos cars i petits, però excelentment comunicats.
        //Molts llocs emblematics i una gran quantitat de serveis diversos.
		DISTRICTE = "E";
		INDEX = 1;
		type = "Pis";
		ascensor = true;
		atic = true;
		planta_MIN = 3;
		planta_MAX = 6;
		acces_mobilitat_reduida = true;
		aire_condicionat = true;
		amb_mobles = true;
		any_construccio_MIN = 1700;
		any_construccio_MAX = 1950;
		area_MIN = 80;
		area_MAX = 120;
		balco = false;
		bones_vistes = true;
		calefaccio = true;
		electrodomestics = true;
		jardi = false;
		mascotes = true;
		numero_dormitoris_simples = 4;
		numero_dormitoris_dobles = 1;
		numero_lavabos = 2;
		parquet = true;
		piscina_comunitaria = true;
		plaça_garatge = false;
		preu_MIN = 500;
		preu_MAX = 800;
		solejat = "ambdues";
		terrassa = true;
		ubicacio_lat_MIN = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
		ubicacio_lat_MAX = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
		ubicacio_long_MIN = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
		ubicacio_long_MAX = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
    }
}
