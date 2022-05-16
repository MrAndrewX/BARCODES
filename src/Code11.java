
// Consultar taula https://en.wikipedia.org/wiki/Barcode#Linear_barcodes
// Code11: https://en.wikipedia.org/wiki/Code_11

// Generadors de codis:
//     https://barcode.tec-it.com/en/Code11
//     https://www.free-barcode-generator.net/code-11/
//     https://products.aspose.app/barcode/generate


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code11 {

    // Codifica un String amb Code11
    static String encode(String s) {
        int contador = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                result.append("█ ██  █");
                contador++;
            }
            if (s.charAt(i) == '0') {
                result.append("█ █ ██");
            }
            if (s.charAt(i) == '1') {
                result.append("██ █ ██");
            }
            if (s.charAt(i) == '2') {
                result.append("█  █ ██");
            }
            if (s.charAt(i) == '3') {
                result.append("██  █ █");
            }
            if (s.charAt(i) == '4') {
                result.append("█ ██ ██");
            }
            if (s.charAt(i) == '5') {
                result.append("██ ██ █");
            }
            if (s.charAt(i) == '6') {
                result.append("█  ██ █");
            }
            if (s.charAt(i) == '7') {
                result.append("█ █  ██");
            }
            if (s.charAt(i) == '8') {
                result.append("██ █  █");
            }
            if (s.charAt(i) == '9') {
                result.append("██ █ █");
            }
            if (s.charAt(i) == '-') {
                result.append("█ ██ █");
            }
            if (i != s.length() - 1) {
                result.append(" ");
            }
        }
        if (contador != 2) {
            return null;
        }

        return result.toString();
    }

    // Decodifica amb Code11
    static String decode(String s) {


        //Trim elimina los espacios sobrantes al principio y al final de la String
        String str = s.trim();
        List<Integer> numbers = new ArrayList<>();
        int numerolinea = 0;


        int j = 0;
        for (int i = 0; i < str.length(); ) {
            char c = str.charAt(i);
            char k = str.charAt(j);
            //Este algoritmo introduce dentro de una lista el numero de veces que aparece el mismo caracter.
            if (c == k) {
                numerolinea++;
                if (j == str.length() - 1) {
                    numbers.add(numerolinea);
                    break;
                }
                j++;
            } else {
                numbers.add(numerolinea);
                i += numerolinea;
                numerolinea = 0;
            }
        }
        //Sacamos de la lista el valor mayor y el valor menor para poder decidir que interpretar como linea gruesa o delgada.
        int max = getMax(numbers);
        int min = getMin(numbers);
//
//        System.out.println(max);
//        System.out.println(min);


        int limite = max;

        while (limite >= min) {
            String m = decodeNum(limite, numbers);
            if (m == null) {
                limite--;
            } else {
                return m;
            }
        }
        return null;

    }
    public static int getMax(List<Integer> numbers){
        int max = 0;
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i) > max){
                max = numbers.get(i);
            }
        }
        return max;
    }
    public static int getMin(List<Integer> numbers){
        int min = 200;
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i) < min){
                min = numbers.get(i);
            }
        }
        return min;
    }

    private static String decodeNum(int limite, List<Integer> numbers) {

        StringBuilder strvariable = new StringBuilder();
        StringBuilder cadena = new StringBuilder();
        StringBuilder caracter = new StringBuilder();
        int contador = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= limite) {
                strvariable.append("1");
            } else if (numbers.get(i) < limite) {
                strvariable.append("0");
            }

        }

        //System.out.println(numbers);
        //System.out.println(strvariable);


        for (int i = 0; i < strvariable.length(); i++) {

            char c = strvariable.charAt(i);
            cadena.append(c);

            //Si es el ultimo valor necesitamos de tectar el ultimo '*', ya que no lleva espacio
            if (cadena.toString().equals("00110") && contador == 1) {

                caracter.append("*");
                contador++;
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("001100")) {
                caracter.append("*");
                contador++;
                cadena = new StringBuilder();
            }

            if (cadena.toString().equals("000010")) {
                caracter.append("0");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("100010")) {
                caracter.append("1");
                cadena = new StringBuilder();

            }
            if (cadena.toString().equals("010010")) {
                caracter.append("2");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("110000")) {
                caracter.append("3");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("001010")) {
                caracter.append("4");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("101000")) {
                caracter.append("5");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("011000")) {
                caracter.append("6");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("000110")) {
                caracter.append("7");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("100100")) {
                caracter.append("8");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("100000")) {
                caracter.append("9");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("001000")) {
                caracter.append("-");
                cadena = new StringBuilder();
            }

        }

        if (contador != 2) {
            return null;
        } else return caracter.toString();
    }


    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {

        List<String> list = new ArrayList<>();


        list = List.of(str.split("\n"));


        String matches = "";

        Pattern p = Pattern.compile("\\d{3}\\s\\d{3}");
        int contador = 0;
        for (int i = 0; i<list.size();i++) {
        String s = list.get(i);
            if (p.matcher(s).matches()) {
                matches+=s;
                contador = i;

            }

        }
        List<String> lista = list.subList(contador + 2, list.size());
        String[] coords;

        coords = matches.split(" ");



        int coordX = Integer.parseInt(coords[0]);
        int coordY = Integer.parseInt(coords[1]);



        System.out.println("X:" + coordX + " y:" + coordY);

        List<String> parsedListWithoutText = new ArrayList<>();
        parsedListWithoutText = lista;
//        System.out.println(parsedListWithoutText);
        List<String> rgbList = new ArrayList<>();

        for (int i = 0; i < parsedListWithoutText.size(); i+=3) {
            rgbList.add((String.valueOf((
                    Integer.parseInt(parsedListWithoutText.get(i)) +
                            Integer.parseInt(parsedListWithoutText.get(i+1)) +
                            Integer.parseInt(parsedListWithoutText.get(i+2))/3))));

        }
        //System.out.println(list);
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        int numeroLinea = 1;



            result1 = leerLinea(coordX, rgbList, result1, coordY, numeroLinea);


            result2 = leerLinea(coordX, rgbList, result2, coordY, coordY/2);


            if (decode(result1.toString()) == null){
                return decode(result2.toString());
            }
        return decode(result1.toString());
    }



    private static StringBuilder leerLinea(int coordX, List<String> rgbList, StringBuilder result, int coordY, int numeroLinea) {
        for (int i = (numeroLinea*coordX)-coordX; i < coordX*numeroLinea; i++) {
            if (Integer.parseInt(rgbList.get(i)) < 100) {
                result.append("█");
            } else {
                result.append(" ");
            }

        }
        return result;
    }


    // Genera imatge a partir de codi de barres
    // Alçada: 100px
    // Marges: vertical 4px, horizontal 8px
    public static String generateImage(String s) {
        return "";
    }
}
