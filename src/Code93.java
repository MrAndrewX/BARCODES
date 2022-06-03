// https://en.wikipedia.org/wiki/Code_93

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
        StringBuilder s = new StringBuilder(str);
        int checksum1 = 0;
        int checksum2 = 0;



        //Calcular checksum 1
        int total = 0;
        for (int i = s.length() - 1, j = 1; i >= 0; i--, j++) {
            char c = s.charAt(i);
            int value = valor(c) * j;
            total += value;

            if (j == 20) j = 0;
            System.out.println("Char "+ c + "Valor: " + value +" Posicion: "+ j);
        }
        checksum1 = total % 47;

        //Añadimos el primer cheksum

        s.append(valoraChar(checksum1));

        total = 0;
        for (int i = s.length() - 1, j = 1; i >= 0; i--, j++) {
            char c = s.charAt(i);
            int value = valor(c) * j;
            total += value;

            if (j == 15) j = 0;
            System.out.println("Char "+ c + "Valor: " + value +" Posicion: "+ j);
        }
        checksum2 = total % 47;
        s.append(valoraChar(checksum2));



        //Añadimos el segundo cheksum


        s.insert(0,"*");
        s.append("*");
        System.out.println(s);


        return StringToAscci(s.toString()).toString();

    }



    private static StringBuilder StringToAscci(String s) {
        StringBuilder result = new StringBuilder();
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                result.append("█ █ ████");
                contador++;
            }
            if (s.charAt(i) == '0') {
                result.append("█   █ █ ");
            }
            if (s.charAt(i) == '1') {
                result.append("█ █  █  ");
            }
            if (s.charAt(i) == '2') {
                result.append("█ █   █ ");
            }
            if (s.charAt(i) == '3') {
                result.append("█ █    █");
            }
            if (s.charAt(i) == '4') {
                result.append("█  █ █  ");
            }
            if (s.charAt(i) == '5') {
                result.append("█  █  █ ");
            }
            if (s.charAt(i) == '6') {
                result.append("█  █   █");
            }
            if (s.charAt(i) == '7') {
                result.append("█ █ █   ");
            }
            if (s.charAt(i) == '8') {
                result.append("█   █  █");
            }
            if (s.charAt(i) == '9') {
                result.append("█    █ █");
            }
            if (s.charAt(i) == 'A') {
                result.append("██ █ █  ");
            }
            if (s.charAt(i) == 'B') {
                result.append("██ █  █ ");
            }
            if (s.charAt(i) == 'C') {
                result.append("██ █   █");
            }
            if (s.charAt(i) == 'D') {
                result.append("██  █ █ ");
            }
            if (s.charAt(i) == 'E') {
                result.append("██  █  █");
            }
            if (s.charAt(i) == 'F') {
                result.append("██   █ █");
            }
            if (s.charAt(i) == 'G') {
                result.append("█ ██ █  ");
            }
            if (s.charAt(i) == 'H') {
                result.append("█ ██  █ ");
            }
            if (s.charAt(i) == 'I') {
                result.append("█ ██   █");
            }
            if (s.charAt(i) == 'J') {
                result.append("█  ██ █ ");
            }
            if (s.charAt(i) == 'K') {
                result.append("█   ██ █");
            }
            if (s.charAt(i) == 'L') {
                result.append("█ █ ██  ");
            }
            if (s.charAt(i) == 'M') {
                result.append("█ █  ██ ");
            }
            if (s.charAt(i) == 'N') {
                result.append("█ █   ██");
            }
            if (s.charAt(i) == 'O') {
                result.append("█  █ ██ ");
            }
            if (s.charAt(i) == 'P') {
                result.append("█   █ ██");
            }
            if (s.charAt(i) == 'Q') {
                result.append("██ ██ █ ");
            }
            if (s.charAt(i) == 'R') {
                result.append("██ ██  █");
            }
            if (s.charAt(i) == 'S') {
                result.append("██ █ ██ ");
            }
            if (s.charAt(i) == 'T') {
                result.append("██ █  ██");
            }
            if (s.charAt(i) == 'U') {
                result.append("██  █ ██");
            }
            if (s.charAt(i) == 'V') {
                result.append("██  ██ █");
            }
            if (s.charAt(i) == 'W') {
                result.append("█ ██ ██ ");
            }
            if (s.charAt(i) == 'X') {
                result.append("█ ██  ██");
            }
            if (s.charAt(i) == 'Y') {
                result.append("█  ██ ██");
            }
            if (s.charAt(i) == 'Z') {
                result.append("█  ███ █");
            }
            if (s.charAt(i) == '-') {
                result.append("█  █ ███");
            }
            if (s.charAt(i) == '.') {
                result.append("███ █ █ ");
            }
            if (s.charAt(i) == ' ') {
                result.append("███ █  █");
            }
            if (s.charAt(i) == '$') {
                result.append("███  █ █");
            }
            if (s.charAt(i) == '/') {
                result.append("█ ██ ███");
            }
            if (s.charAt(i) == '+') {
                result.append("█ ███ ██");
            }
            if (s.charAt(i) == '%') {
                result.append("██ █ ███");
            }



            if (s.charAt(i) == '∈') {
                result.append("█  █  ██");
            }

            if (s.charAt(i) == '⊖') {
                result.append("███ ██ █");
            }

            if (s.charAt(i) == '∃') {
                result.append("███ █ ██");
            }

            if (s.charAt(i) == '∐') {
                result.append("█  ██  █");
            }



            if (i != s.length() - 1) {
                result.append(" ");
            }
        }
        // Cierre
        result.append(" █");
        return result;
    }

    private static int valor(char c) {
        switch (c){
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case 'A': return 10;
            case 'B': return 11;
            case 'C': return 12;
            case 'D': return 13;
            case 'E': return 14;
            case 'F': return 15;
            case 'G': return 16;
            case 'H': return 17;
            case 'I': return 18;
            case 'J': return 19;
            case 'K': return 20;
            case 'L': return 21;
            case 'M': return 22;
            case 'N': return 23;
            case 'O': return 24;
            case 'P': return 25;
            case 'Q': return 26;
            case 'R': return 27;
            case 'S': return 28;
            case 'T': return 29;
            case 'U': return 30;
            case 'V': return 31;
            case 'W': return 32;
            case 'X': return 33;
            case 'Y': return 34;
            case 'Z': return 35;
            case '-': return 36;
            case '.': return 37;
            case ' ': return 38;
            case '$': return 39;
            case '/': return 40;
            case '+': return 41;
            case '%': return 42;
            case '∈': return 43;
            case '⊖': return 44;
            case '∃': return 45;
            case '∐': return 46;
        }
        return 0;
    }
    private static String valoraChar(int n) {
        switch (n){
            case 0: return "0";
            case 1: return "1";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
            case 16: return "G";
            case 17: return "H";
            case 18: return "I";
            case 19: return "J";
            case 20: return "K";
            case 21: return "L";
            case 22: return "M";
            case 23: return "N";
            case 24: return "O";
            case 25: return "P";
            case 26: return "Q";
            case 27: return "R";
            case 28: return "S";
            case 29: return "T";
            case 30: return "U";
            case 31: return "V";
            case 32: return "W";
            case 33: return "X";
            case 34: return "Y";
            case 35: return "Z";
            case 36: return "-";
            case 37: return ".";
            case 38: return " ";
            case 39: return "$";
            case 40: return "/";
            case 41: return "+";
            case 42: return "%";
            case 43: return "∈";
            case 44: return "⊖";
            case 45: return "∃";
            case 46: return "∐";
        }
        return "";
    }

    // Decodifica emprant Code93
    static String decode(String s) {
        String str = s.trim();
        List<Integer> numbers = new ArrayList<>();

        //En esta funcion vamos a crear una lista de integers, cada elemento dera el numero de veces que se repite el mismo caracter hasta que sea diferente.
        countSameCharsOnAList(numbers, str);

        //Sacamos de la lista el valor mayor y el valor menor para poder decidir que interpretar como linea gruesa o delgada.

        int max = getMax(numbers);
        int min = getMin(numbers);

        int limite = min;
        System.out.println(numbers);
        System.out.println("Max: " + min);

        while (limite >= min) {
            String m = decodeNum(limite, numbers);
            if (m == null) {
                limite--;
            } else {
                return m.substring(1,m.length()-3);
            }
        }

        return null;


    }
    private static String decodeNum(int limite, List<Integer> numbers) {

        StringBuilder strvariable = new StringBuilder();
        StringBuilder cadena = new StringBuilder();
        StringBuilder caracter = new StringBuilder();



        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= limite) {
                strvariable.append(numbers.get(i) / limite);
            } else if (numbers.get(i) < limite) {
                strvariable.append(numbers.get(i) / limite);
            }


        }






        return binarioASimbolo(strvariable,cadena,caracter);

    }
    private static String binarioASimbolo(StringBuilder strvariable, StringBuilder cadena, StringBuilder caracter) {
        int contador = 0;
        for (int i = 0; i < strvariable.length(); i++) {

            char c = strvariable.charAt(i);
            cadena.append(c);

            //Si es el ultimo valor necesitamos de tectar el ultimo '*', ya que no lleva espacio
            if (cadena.toString().equals("1111411") && contador == 1) {

                caracter.append("*");
                contador++;
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111141")) {
                caracter.append("*");
                contador++;
                cadena = new StringBuilder();
            }

            if (cadena.toString().equals("131112")) {
                caracter.append("0");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111213")) {
                caracter.append("1");
                cadena = new StringBuilder();

            }
            if (cadena.toString().equals("111312")) {
                caracter.append("2");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111411")) {
                caracter.append("3");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("121113")) {
                caracter.append("4");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("121212")) {
                caracter.append("5");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("121311")) {
                caracter.append("6");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111114")) {
                caracter.append("7");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("131211")) {
                caracter.append("8");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("141111")) {
                caracter.append("9");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("211113")) {
                caracter.append("A");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("211212")) {
                caracter.append("B");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("211311")) {
                caracter.append("C");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("221112")) {
                caracter.append("D");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("221211")) {
                caracter.append("E");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("231111")) {
                caracter.append("F");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("112113")) {
                caracter.append("G");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("112212")) {
                caracter.append("H");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("112311")) {
                caracter.append("I");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("122112")) {
                caracter.append("J");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("132111")) {
                caracter.append("K");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111123")) {
                caracter.append("L");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111222")) {
                caracter.append("M");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("111321")) {
                caracter.append("N");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("121122")) {
                caracter.append("O");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("131121")) {
                caracter.append("P");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("212112")) {
                caracter.append("Q");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("212211")) {
                caracter.append("R");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("211122")) {
                caracter.append("S");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("211221")) {
                caracter.append("T");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("221121")) {
                caracter.append("U");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("222111")) {
                caracter.append("V");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("112122")) {
                caracter.append("W");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("112221")) {
                caracter.append("X");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("122121")) {
                caracter.append("Y");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("123111")) {
                caracter.append("Z");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("121131")) {
                caracter.append("-");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("311112")) {
                caracter.append(".");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("311211")) {
                caracter.append(" ");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("321111")) {
                caracter.append("$");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("112131")) {
                caracter.append("/");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("113121")) {
                caracter.append("+");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("211131")) {
                caracter.append("%");
                cadena = new StringBuilder();
            }

            if (cadena.toString().equals("121221")) {
                caracter.append("∈");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("312111")) {
                caracter.append("⊖");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("311121")) {
                caracter.append("∃");
                cadena = new StringBuilder();
            }
            if (cadena.toString().equals("122211")) {
                caracter.append("∐");
                cadena = new StringBuilder();
            }

        }
        //Este if nos permite validar el resultado, ya que un resultado solo puede contener 2 simbolos "*", en cualquier otro caso, la string será null.
        if (contador != 2) {
            return null;
        } else return caracter.toString();
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


    // Genera imatge a partir de barcode code93
    // Unitat barra mínima: 3 pixels
    // Alçada: 100px
    // Marges: vertical: 5px, horizontal: 15px
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
        System.out.println(result);

        return result;
    }
}
