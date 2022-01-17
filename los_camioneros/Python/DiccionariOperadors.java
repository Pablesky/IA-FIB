package Python;
//package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DiccionariOperadors {

    public static void main(String[] args) {
        Map<String, Integer> resultados = new HashMap<String, Integer>();
        try (Scanner s = new Scanner(new FileReader("out.txt"))) {
            while (s.hasNext()) {
                String temp = s.nextLine();
                if (resultados.get(temp) == null) {
                    resultados.put(temp, 1);
                } else {
                    int uwu = resultados.get(temp);
                    resultados.replace(temp, uwu + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(resultados.toString());
        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "," + value);
        }
    }
}

