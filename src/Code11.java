
// Consultar taula https://en.wikipedia.org/wiki/Barcode#Linear_barcodes
// Code11: https://en.wikipedia.org/wiki/Code_11

// Generadors de codis:
//     https://barcode.tec-it.com/en/Code11
//     https://www.free-barcode-generator.net/code-11/
//     https://products.aspose.app/barcode/generate


import java.util.*;
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

        //En esta funcion vamos a crear una lista de integers, cada elemento dera el numero de veces que se repite el mismo caracter hasta que sea diferente.
        countSameCharsOnAList(numbers, str);

        //Sacamos de la lista el valor mayor y el valor menor para poder decidir que interpretar como linea gruesa o delgada.
        int max = getMax(numbers);
        int min = getMin(numbers);

        int limite = max;

        //Este bucle nos permite identificar el patron correcto de una string, vamos a ir probando hasta que el resultado de m sea uno valido.
        // En el caso contrario, vamos disminuyendo el limite para formar diferentes patrones

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

    private static List<Integer> countSameCharsOnAList(List<Integer> numbers, String str) {
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
        return numbers;
    }

    //Metodo para recuperar el valor mayor de una lista
    public static int getMax(List<Integer> numbers) {

        int max = 0;
        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    //Metodo para recuperar el valor minimo de una lista
    public static int getMin(List<Integer> numbers) {
        int min = 200;
        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
    //En esta funcion decodificamos las franjas negras y blancas con su respectivo numero segun el ancho que tenga
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



        return binarioASimbolo(strvariable,cadena,contador,caracter);

    }

    //En este metodo nos entra una string de caracteres binarios y devolvemos un codigo descodificado
    private static String binarioASimbolo(StringBuilder strvariable, StringBuilder cadena, int contador, StringBuilder caracter) {

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
        //Este if nos permite validar el resultado, ya que un resultado solo puede contener 2 simbolos "*", en cualquier otro caso, la string será null.
        if (contador != 2) {
            return null;
        } else return caracter.toString();
    }


    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {

        List<String> list = new ArrayList<>();

        list = List.of(str.split("\n"));

        String matches = "";

        //En esta parte, solo buscamos con expresion regular, un conjunto de dos digitos separados por un espacio. Que son la coordX y la coordY
        Pattern p = Pattern.compile("\\d+\\s\\d+");
        int contador = 0;

        for (int i = 0; i < 10; i++) {

            //El valor maximo "10" es para optimizar un poco mas el programa, ya que seguro que en las 10 primeras posiciones encontramos x y y y así
            //No tendremos que recorrer toda la lista

            String s = list.get(i);
            if (p.matcher(s).matches()) {
                matches += s;
                contador = i;
                break;
            }
        }

        //A continuacion hacemos una lista a partir de la expresion encontrada.
        // Para que ahora en la lista solo nos preocupemos de los valores RGB
        List<String> lista = list.subList(contador + 2, list.size());

        //En esta array de strings guardaremos las coordenadas X y Y de la imagen

        String[] coords;

        coords = matches.split(" ");

        int coordX = Integer.parseInt(coords[0]);
        int coordY = Integer.parseInt(coords[1]);

        List<String> rgbList = new ArrayList<>();

        // Ahora, para interpretar los valores lo que hacemos es crear otra lista, pero el contenido de esta sera la media de los 3 valores RGB
        makeAvgFromRGBItems(lista,rgbList);

        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        StringBuilder result3 = new StringBuilder();



        //Tengo dos resultados, uno es para los que tienen la primera linea valida y el otro resultado para los que no tiene la primera valida y validamos la linea del medio

        leerLinea(coordX, rgbList, result1, coordY, 1);


        leerLinea(coordX, rgbList, result2, coordY, coordY / 2);
        result3 = leerLineaVertical(coordX, rgbList, result3, coordY, coordX/2);

        //Si el resultado1 es null, devolveremos resultado2, si no devolveremos el resultado 1
        if (decode(result1.toString()) == null) {

            //En el caso de que sea null, sabremos que será un codigo de barras invertido.

            if (decode(result2.toString()) == null) {
                if (decode(invertirPatron(result2.toString())) == null){
                    // En el caso que la imagen vertical este en modo espejo, invertiremos la string
                    if (decode(result3.toString()) == null){
                        return decode(invertirPatron(result3.toString()));
                    }
                    return decode(result3.toString());
                }
                return decode(invertirPatron(result2.toString()));
            }
            return decode(result2.toString());

        }
        return decode(result1.toString());

    }

    private static StringBuilder leerLineaVertical(int coordX, List<String> rgbList, StringBuilder result, int coordY, int numeroLinea) {
        for (int i = coordX/2; i < (coordX * coordY) - coordX/2; i++) {
            if (Integer.parseInt(rgbList.get(i)) < 100) {
                result.append("█");
            } else {
                result.append(" ");
            }


            i+=coordX-1;

        }
        return result;
    }


    //Esta funcion hace el promedio de los 3 valores RGB y los almacena en un unico elemento de la lista
    private static List<String> makeAvgFromRGBItems(List<String> lista, List<String> rgbList) {
        for (int i = 0; i < lista.size(); i += 3) {
            rgbList.add((String.valueOf((
                    Integer.parseInt(lista.get(i)) +
                            Integer.parseInt(lista.get(i + 1)) +
                            Integer.parseInt(lista.get(i + 2)) / 3))));

        }
        return rgbList;
    }

    //Esta funcion invierte el string en el caso que tengamos un barcode dado la vuelta
    private static String invertirPatron(String codigo) {
        String resultado = "";
        for (int i = 0; i < codigo.length(); i++) {
            char a = codigo.charAt(codigo.length() - i - 1);
            resultado += a;
        }
        return resultado;
    }

    //Esta funcion nos permite traducir de un codigo rgb a caracteres ascii.
    private static StringBuilder leerLinea(int coordX, List<String> rgbList, StringBuilder result, int coordY, int numeroLinea) {
        for (int i = (numeroLinea * coordX) - coordX; i < coordX * numeroLinea; i++) {
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
        String encoded = encodechangeGrosor(s);

        String result = generateStringImage(encoded);

        return result.trim();
    }

    private static String generateStringImage(String encoded) {
        List<String> lista = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int longitudX = encoded.length() + 16;


        //Esta funcion nos construye el inicio de la string, nos define el comentario, longitud X, Longitud Y y el color maximo, que será 255.
        construirInicioDeImagen(result, encoded, longitudX);

        int margenHorizontal = 8;
        int margenVertical = 4;

        //Margen vertical

        addVerticalMarge(margenVertical, result, longitudX);

        //Esta es la estructura de la imagen, basicamente el traductor de ASCII a valores RGB.
        for (int i = 0; i < 100; i++) {

            //Añadimos un margen horizontal de una longitud de 8 pixeles.
            addHorizontalMarge(margenHorizontal, result, longitudX);

            for (int j = 0; j < encoded.length(); j++) {
                char c = encoded.charAt(j);
                if (c == '█') {
                    result.append("0\n0\n0\n");
                }
                if (c == ' ') {
                    result.append("255\n255\n255\n");
                }
            }

            addHorizontalMarge(margenHorizontal, result, longitudX);

        }
        addVerticalMarge(margenVertical, result, longitudX);

        return result.toString();
    }

    private static void construirInicioDeImagen(StringBuilder result, String encoded, int longitudX) {
        result.append("P3\n");
        result.append(longitudX).append(" ").append("108\n");
        result.append("255\n");
    }

    private static void addHorizontalMarge(int i, StringBuilder result, int longitudX) {
        result.append("255\n255\n255\n".repeat(8));
    }

    private static void addVerticalMarge(int i, StringBuilder result, int longitudX) {
        result.append("255\n255\n255\n".repeat(Math.max(0, longitudX)).repeat(i));
    }

    //Esta funcion traduce los grosores de 1 y 2 a unos de 3 y 10
    private static String encodechangeGrosor(String s) {
        String encoded = encode(s);

        String result = "";
        int j = 1;
        for (int i = 0; i < encoded.length() - 1; i++) {
            char c = encoded.charAt(i);
            char k = encoded.charAt(j);

            if (c == '█' && k == ' ') {
                result += "███";
                j++;
                continue;

            }

            if ((c == ' ' && k == '█')) {
                result += "   ";
                j++;
                continue;
            }
            if ((c == '█' && k == '█')) {
                result += "███████";
                j++;
                continue;
            }
            if ((c == ' ' && k == ' ')) {
                result += "       ";
                j++;
                continue;

            }
        }
        result = result + "███";

        return result;
    }
}
