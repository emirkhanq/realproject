import java.util.Scanner;

public class Main {
    private static final String[] ONDOR = {"", "он", "жыйырма", "отуз", "кырк", "элүү", "алтымыш", "жетимиш", "сексен", "токсон"};
    private static final String[] BIRLIKTER = {"", "бир", "эки", "үч", "төрт", "беш", "алты", "жети", "сегиз", "тогуз"};
    private static final String[] JUZDER = {"", "жүз", "эки жүз", "үч жүз", "төрт жүз", "беш жүз", "алты жүз", "жети жүз", "сегиз жүз", "тогуз жүз"};

    public static String convertNumberToText(int number) {
        if (number == 0) {
            return "нөл";
        }

        StringBuilder result = new StringBuilder();

        if (number >= 10000) {
            int tensOfThousands = number / 10000;
            result.append(ONDOR[tensOfThousands]).append(" ");
            number %= 10000;
        }

        if (number >= 1000) {
            int thousands = number / 1000;
            if (thousands == 1 && result.length() == 0) {
                result.append("миң ");
            } else if (thousands > 0) {
                result.append(BIRLIKTER[thousands]).append(" миң ");
            }
            number %= 1000;
        }

        if (number >= 100) {
            result.append(JUZDER[number / 100]).append(" ");
            number %= 100;
        }

        if (number >= 10) {
            result.append(ONDOR[number / 10]).append(" ");
            number %= 10;
        }

        if (number > 0) {
            result.append(BIRLIKTER[number]).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сан киргизиңиз (0-99999): ");
        int number = scanner.nextInt();
        if (number < 0 || number > 99999) {
            System.out.println("Ката! Сан 0 менен 99999 ортосунда болушу керек.");
        } else {
            System.out.println("Жазуу түрүндө: " + convertNumberToText(number));
        }
        scanner.close();
    }
}
