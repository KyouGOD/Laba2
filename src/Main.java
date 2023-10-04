import java.util.Scanner;

public class Main {
    static String pattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    public static boolean isValidColorCode(String colorCode) {
        return colorCode.matches(pattern);
    }

    public static String hexToRgb(String hexColor) {
        int red = Integer.parseInt(hexColor.substring(1, 3), 16);
        int green = Integer.parseInt(hexColor.substring(3, 5), 16);
        int blue = Integer.parseInt(hexColor.substring(5, 7), 16);

        return red + ";" + green + ";" + blue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку в формате шестнадцатиричного идентификатора цвета в HTML: ");
        String str = in.next();
        System.out.printf("Вы ввели: %s \n", str);
        in.close();
        Boolean status = isValidColorCode(str);
        if (status == Boolean.TRUE)
        {
            System.out.println("Вы ввели корректный шестнадцатиричный идентификатор цвета");
            String resetColor = "\u001B[0m";
            String setColor = "\u001B[38;2;" + hexToRgb(str) + "m";
            System.out.println(setColor + "██████");
            System.out.println("██████");
            System.out.println("██████");
            System.out.println("██████");
            System.out.println(resetColor);
        }
        else
            System.out.println("Введенная строка не соответствует шестнадцатиричному идентификатору цвета");
    }
}