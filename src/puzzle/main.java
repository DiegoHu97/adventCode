package puzzle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    
    
    public static void main(String args []){


        //puzzle1(list);
        //puzzle1_2(list);
        //puzzle2();
        puzzle2_2();

    }

    private static void puzzle1_2() {
        List<Integer> list = getNumbers();
        Integer anterior = list.get(0)+ list.get(1)+ list.get(2);
        Integer contador = 0;
        Integer val = 0;
        for (int i = 1; i < list.size()-2; i++){
            val = list.get(i)+ list.get(i+1)+ list.get(i+2);
            if(anterior < val){
                contador++;
            }
            anterior = val;
        }

        System.out.println(contador);
    }

    private static void puzzle1() {
        List<Integer> list = getNumbers();
        Integer anterior = list.get(0);
        Integer contador = 0;
        for (Integer val : list) {
            if(val > anterior){
                contador++;
            }
            anterior = val;
        }

        System.out.println(contador);
    }

    private static List<Integer> getNumbers() {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("/Users/diegohu/Documents/advent code/src/resources/data.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }

    private static void puzzle2() {
        Integer vertical = 0;
        Integer horizontal = 0;
        File file = new File("/Users/diegohu/Documents/advent code/src/resources/data2.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                String parts[] = text.split(" ");

                String direccion = parts[0];
                Integer valor = Integer.parseInt(parts[1]);

                switch (direccion){
                    case "forward":
                        horizontal += valor;
                        break;
                    case "up":
                        vertical -= valor;
                        break;
                    case "down":
                        vertical += valor;
                        break;
                }
            }
            System.out.println("Horizontal: "+horizontal+"Vertical: "+vertical);
            System.out.println("Resultado: "+horizontal*vertical);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }

    private static void puzzle2_2() {
        Integer vertical = 0;
        Integer horizontal = 0;
        Integer punteria = 0;
        File file = new File("/Users/diegohu/Documents/advent code/src/resources/data2.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                String parts[] = text.split(" ");

                String direccion = parts[0];
                Integer valor = Integer.parseInt(parts[1]);

                switch (direccion){
                    case "forward":
                        horizontal += valor;
                        vertical += punteria*valor;
                        break;
                    case "up":
                        punteria -= valor;
                        break;
                    case "down":
                        punteria += valor;
                        break;
                }
            }
            System.out.println("Horizontal: "+horizontal+" Vertical: "+vertical);
            System.out.println("Punteria: "+punteria);
            System.out.println("Resultado: "+horizontal*vertical);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
