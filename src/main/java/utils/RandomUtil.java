package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class RandomUtil {

    private static final String[] LATIN_UPPERCASE = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] SYMBOLS = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+", "=", "[", "]", "{", "}", "<", ">", "/", "?"};
    private static String email;

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }

    public static String getRandomEmail(int length) {
        if (Objects.isNull(email)) {
            email = getRandomString(length);
        }
        return email;
    }

    public static String getRandomPassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        password.append(LATIN_UPPERCASE[random.nextInt(LATIN_UPPERCASE.length)]);
        password.append(SYMBOLS[random.nextInt(SYMBOLS.length)]);
        password.append(NUMBERS[random.nextInt(NUMBERS.length)]);
        password.append(getRandomEmail(length));
        return password.toString();
    }

    public static List<Integer> getRandomIndexes(int amount, int length) {
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();
        while (numbers.size() < amount) {
            int number = random.nextInt(length);
            numbers.add(number);
        }
        List<Integer> numbersList = new ArrayList<>(numbers);
        return numbersList;
    }
    public static int getRandomInt(int length) {
        return new Random().nextInt(length);
    }
}