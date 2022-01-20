import java.util.Arrays;
import java.util.Random;

class generacioServeis {

    static float LATITUDE_MIN = 41.00f;
    static float OFF_LATITUDE_MAX = 0.054f;
    static float LONGITUDE_MIN = 2.10f;
    static float OFF_LONGITUDE_MAX = 0.072f;

    //lat min, lat max, long min, long max
    static float[] coordinates = new float[4];
        
    //SERVEIS
    //(en c++ aixo serien defines)
     static int Biblioteques = 0;
     static int Escoles = 1;
     static int Gimnas = 2;
     static int Hospital = 3;
     static int Emblematic = 4;
     static int Platja = 5;
     static int Industrial = 6;
     static int Supermercat = 7;
     static int Transport = 8;
     static int Cultural = 9;
     static int Verda = 10;
     static int Comercial = 11;
     static int Nocturn = 12;

     static int[] services = new int[13];

    static void print_services(String districte) {
        Random r = new Random();

        for (int i = 0; i < services.length; ++i) {
            for(int j = 0; j < services[i]; ++j) {

               Double x = r.nextDouble(coordinates[1]-coordinates[0]) + coordinates[0];
               Double y = r.nextDouble(coordinates[3]-coordinates[2]) + coordinates[2];

                    String s = "";
               switch(i) {
                    case 0:
                        s = "Biblioteques";
                        break;
                    case 1:
                        s = "Escoles";
                        break;
                    case 2:
                        s = "Gimnas";
                        break;
                    case 3:
                        s = "Hospital_o_CAP";
                        break;
                    case 4:
                        s = "Llocs_emblematics";
                        break;
                    case 5:
                        s = "Platja";
                        y = (double) LONGITUDE_MIN+OFF_LONGITUDE_MAX;
                        break;
                    case 6:
                        s = "Poligons_Industrials";
                        break;
                    case 7:
                        s = "Supermercat_i_Hipermercats";
                        break;
                    case 8:
                        s = "Transport_Public";
                        break;
                    case 9:
                        s = "Zona_Cultural";
                        break;
                    case 10:
                        s = "Zona_Verda";
                        break;
                    case 11:
                        s = "Zona_comercial";
                        break;
                    case 12:
                        s = "Zona_Oci_Nocturn";
                        break;
                    
               }
                System.out.println("(definstances services_"+s);
                System.out.println("    ("+s+"_"+districte+"_"+j+" of "+s+" (ubicacio_x "+x+") (ubicacio_y "+y+"))");
                System.out.println(")");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        //districte A: districte mega ric. Cap transport públic, però cases de molta alta qualitat i preu.
        //Pocs serveis, només alguna zona verda.
        Arrays.fill(services, 0);
        services[Verda] = 2;
        
        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
        coordinates[2] = LONGITUDE_MIN;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;

        print_services("A");

        //districte B: districte ric. Un unic bus de transport públic, però cases d'alta qualitat i preu.
        //Una escola, una biblioteca, un gimnas, una zona verda, un lloc emblematic, un CAP i un Super (carillo).
        Arrays.fill(services, 0);
        services[Emblematic] = 1;
        services[Verda] = 1;
        services[Hospital] = 1;
        services[Biblioteques] = 1;
        services[Transport] = 1;
        services[Gimnas] = 1;
        services[Cultural] = 1;
        
        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
        coordinates[2] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;

        print_services("B");

        //districte C: districte cultural/Oci. Algun transport public. Cases de preu mitja-alt, pero algo petites.
        //molt oci nocturn, cultural i biblioteques. Algun supermercat. Un CAP, una escola i un gimnas
        Arrays.fill(services, 0);
        services[Transport] = 4;
        services[Nocturn] = 6;
        services[Cultural] = 6;
        services[Biblioteques] = 3;
        services[Supermercat] = 4;
        services[Hospital] = 1;
        services[Escoles] = 1;
        services[Gimnas] = 1;

        services[Platja] = 6;

        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*3/3;
        coordinates[2] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*3/3;

        print_services("C");

        //districte D: districte universitari. Ben comunicat. Pisos majoritariament orientats a estudiants.
        //moltes escoles i biblioteques. Algunes zones verdes, oci nocturn i gimnasos. Un supermercat, un lloc emblemàtic i una zona cultural.
        Arrays.fill(services, 0);
        services[Transport] = 3;
        services[Nocturn] = 2;
        services[Cultural] = 2;
        services[Biblioteques] = 3;
        services[Supermercat] = 2;
        services[Hospital] = 1;
        services[Escoles] = 3;
        services[Gimnas] = 1;
        services[Verda] = 2;

        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
        coordinates[2] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;

        print_services("D");

        //districte E: casc antic. Pisos cars i petits, però excelentment comunicats.
        //Molts llocs emblematics i una gran quantitat de serveis diversos.
        Arrays.fill(services, 0);
        services[Transport] = 4;
        services[Cultural] = 2;
        services[Supermercat] = 2;
        services[Hospital] = 1;
        services[Escoles] = 2;
        services[Gimnas] = 1;
        services[Verda] = 1;
        services[Emblematic] = 3;

        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*2/3;
        coordinates[2] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*2/3;

        print_services("E");

        //districte F: zona chill. Pisos de mitjana qualitat i preu. Ben comunicat.
        //Moltes zones verdes i escoles. Alguns supermercats, biblioteques, i Hospitals. Un gimnàs. Té el centre comercial de la ciutat
        Arrays.fill(services, 0);
        services[Transport] = 2;
        services[Cultural] = 1;
        services[Supermercat] = 3;
        services[Hospital] = 2;
        services[Escoles] = 3;
        services[Gimnas] = 1;
        services[Verda] = 3;
        services[Biblioteques] = 1;
        services[Comercial] = 1;

        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*0/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
        coordinates[2] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;

        print_services("F");

        //districte G: zona industrial. Pisos de mala qualitat però preu baix. Bastant transport públic.
        //Moltes zones industrials i supermercats. Algunes escoles. Un oci nocturn, CAP, gimnas i oci nocturn
        Arrays.fill(services, 0);
        services[Transport] = 5;
        services[Industrial] = 4;
        services[Supermercat] = 5;
        services[Hospital] = 1;
        services[Escoles] = 3;
        services[Gimnas] = 1;
        services[Nocturn] = 1;

        services[Platja] = 3;

        coordinates[0] = LATITUDE_MIN+OFF_LATITUDE_MAX*0/3;
        coordinates[1] = LATITUDE_MIN+OFF_LATITUDE_MAX*1/3;
        coordinates[2] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*0/3;
        coordinates[3] = LONGITUDE_MIN+OFF_LONGITUDE_MAX*1/3;

        print_services("G");

    }
}