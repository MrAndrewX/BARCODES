// https://en.wikipedia.org/wiki/Code_93

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
        StringBuilder result = new StringBuilder(str);


        String s = str;
        int checksum1 = 0;

        StringBuilder resultVerbose;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*'){
                continue;
            }
            int valor = valor(c);
            System.out.println(c +" : " + (s.length()-i-1) *  valor);
            checksum1 += ((s.length()-i-1) *  valor);
            if (i == 20){
                break;
            }

        }
        checksum1 = checksum1 % 43;
        result.deleteCharAt(result.length()-1);

        result.append(valoraChar(checksum1));

        int checksum2 = 0;
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c == '*'){
                continue;
            }
            int valor = valor(c);

            checksum2 += ((((result.length()-i-1)+1) *  valor));

            if (i == 15){
                break;
            }
        }
        result.append(valoraChar(checksum2));
        result.append("*");
        System.out.println(StringToAscci(String.valueOf(result)));


        System.out.println(result);
        return StringToAscci(result.toString()).toString();
    }

    private static StringBuilder StringToAscci(String s) {
        StringBuilder result = new StringBuilder();
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                result.append("█ █ ████");
                contador++;
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
                result.append("█  ███ █ ");
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
        }
        return ".";
    }

    // Decodifica emprant Code93
    static String decode(String str) {
        return "";
    }

    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {
        return "";
    }

    // Genera imatge a partir de barcode code93
    // Unitat barra mínima: 3 pixels
    // Alçada: 100px
    // Marges: vertical: 5px, horizontal: 15px
    public static String generateImage(String s) {
        return "";
    }
}
