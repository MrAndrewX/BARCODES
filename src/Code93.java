// https://en.wikipedia.org/wiki/Code_93

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
        int contador = 0;
        StringBuilder result = new StringBuilder();

        String s = str;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*'){
                continue;
            }
            int valor = valor(c);
            System.out.println(" : " + (s.length()-i-1));
        }
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
        return result.toString();
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
