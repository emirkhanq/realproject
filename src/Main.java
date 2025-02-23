import java.util.Scanner;

public class Main {
    private static final String[] ones = {
            "нөл", "бир", "эки", "үч", "төрт", "беш", "алты", "жети", "сегиз", "тогуз"
    };

    private static final String[] teens = {
            "он", "он бир", "он эки", "он үч", "он төрт",
            "он беш", "он алты", "он жети", "он сегиз", "он тогуз"
    };

    private static final String[] tens = {
            "", "он", "жыйырма", "отуз", "кырк", "элүү",
            "алтымыш", "жетимиш", "сексен", "токсон"
    };

    private static final String[] hundreds = {
            "", "жүз", "эки жүз", "үч жүз", "төрт жүз",
            "беш жүз", "алты жүз", "жети жүз", "сегиз жүз", "тогуз жүз"
    };

    public static String convertToKyrgyz(int number) {
        if (number < 0 || number > 99999) {
            return "Чектен ашкан сан!";
        }
        if (number == 0) {
            return ones[0];
        }

        StringBuilder result = new StringBuilder();

        // Разбираем тысячи
        if (number >= 1000) {
            int thousands = number / 1000;
            if (thousands < 10) {
                // Если тысячи от 1 до 9
                if (thousands == 1) {
                    result.append("миң ");
                } else {
                    result.append(ones[thousands]).append(" миң ");
                }
            } else {
                // Если тысячи двузначные (10-99)
                if (thousands < 20) {
                    result.append(teens[thousands - 10]).append(" миң ");
                } else {
                    result.append(tens[thousands / 10]).append(" ");
                    if (thousands % 10 != 0) {
                        result.append(ones[thousands % 10]).append(" ");
                    }
                    result.append("миң ");
                }
            }
            number %= 1000;
        }

        // Разбираем сотни
        if (number >= 100) {
            result.append(hundreds[number / 100]).append(" ");
            number %= 100;
        }

        // Разбираем десятки
        if (number >= 20) {
            result.append(tens[number / 10]).append(" ");
            number %= 10;
        } else if (number >= 10) {
            result.append(teens[number - 10]);
            number = 0;
        }

        // Разбираем единицы
        if (number > 0) {
            result.append(ones[number]);
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.print("Санды киргизиңиз (0 - 99999): ");
        int number = scanner.nextInt();
        System.out.println("Жазуу түрүндө: " + convertToKyrgyz(number));
        scanner.close();
    }
}
