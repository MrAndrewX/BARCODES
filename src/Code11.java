
// Consultar taula https://en.wikipedia.org/wiki/Barcode#Linear_barcodes
// Code11: https://en.wikipedia.org/wiki/Code_11

// Generadors de codis:
//     https://barcode.tec-it.com/en/Code11
//     https://www.free-barcode-generator.net/code-11/
//     https://products.aspose.app/barcode/generate


import java.util.*;

public class Code11 {

    // Codifica un String amb Code11
    static String encode(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*'){
                result.append("█ ██  █");
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
            if (i != s.length()-1){
                result.append(" ");
            }


            }

        return result.toString();
    }

    // Decodifica amb Code11
    static String decode(String s) {
        StringBuilder cadena = new StringBuilder();
        StringBuilder caracter = new StringBuilder();
        int contador= 0;
        //Trim elimina los espacios
        String str = s.trim();
        List<Integer> numbers = new ArrayList<>();
        int numerolinea = 0;

        int j = 0;
        for (int i = 0; i < str.length();) {
            char c = str.charAt(i);
            char k = str.charAt(j);

            if (c == k){

                numerolinea++;

                if (j == str.length()-1){
                    numbers.add(numerolinea);
                    break;
                }
                j++;
            }else {
                numbers.add(numerolinea);
                i += numerolinea;
                numerolinea = 0;
            }



        }
        //Sacamos de la lista el valor mayor y el valor menor para poder decidir que interpretar como linea gruesa o delgada.
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println(max);
        System.out.println(min);


        System.out.println(numbers);
        for (int i = 0; i < str.length(); i++) {

                char c = str.charAt(i);
                cadena.append(c);

                //Si es el ultimo valor necesitamos de tectar el ultimo '*', ya que no lleva espacio
            if (cadena.toString().equals("█ ██  █") && contador == 1) {

                caracter.append("*");
                contador++;
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("█ ██  █ ")) {
                caracter.append("*");
                contador++;
                cadena = new StringBuilder();
            }

            if (cadena.toString().equals("█ █ ██ ")){
                caracter.append("0");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("██ █ ██ ")){
                caracter.append("1");
                cadena = new StringBuilder();

            }
            if (cadena.toString().equals("█  █ ██ ")){
                caracter.append("2");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("██  █ █ ")){
                caracter.append("3");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("█ ██ ██ ")){
                caracter.append("4");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("██ ██ █ ")){
                caracter.append("5");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("█  ██ █ ")){
                caracter.append("6");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("█ █  ██ ")){
                caracter.append("7");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("██ █  █ ")){
                caracter.append("8");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("██ █ █ ")){
                caracter.append("9");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("█ ██ █ ")){
                caracter.append("-");
                cadena = new StringBuilder();
            }

        }

        return caracter.toString();
    }




    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {
        return "";
    }

    // Genera imatge a partir de codi de barres
    // Alçada: 100px
    // Marges: vertical 4px, horizontal 8px
    public static String generateImage(String s) {
        return "";
    }
}
