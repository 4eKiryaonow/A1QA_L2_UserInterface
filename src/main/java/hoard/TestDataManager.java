package hoard;

import utils.RandomUtil;

import static constant.KeyConstants.*;

public abstract class TestDataManager {
    public static int getLengthRandomString() {
        return (Integer) SettingsManager.getTestData().getValue(LENGTH_STRING_KEY);
    }

    public static String getPassword() {
        return RandomUtil.getRandomPassword(getLengthRandomString());
    }

    public static String getEmail() {
        return RandomUtil.getRandomEmail(getLengthRandomString());
    }

    public static String getDomainName() {
        return RandomUtil.getRandomString(getLengthRandomString());
    }

    public static String getTimeValue() {
        return (String) SettingsManager.getTestData().getValue(TIME_VALUE_KEY);
    }

    public static int getAmountInterests() {
        return (Integer) SettingsManager.getTestData().getValue(AMOUNT_INTERESTS_KEY);
    }
}