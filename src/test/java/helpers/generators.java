package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class generators {
    public static String generateRandomString(int count) {
        String random = RandomStringUtils.randomAlphabetic(count);
        return random;
    }

    public static String generateRandomPassword(int total) {
        int lowerCount = total / 2;
        int upperCount = total / 3;

        String randomLower = RandomStringUtils.randomAlphanumeric(lowerCount).toLowerCase();
        String randomUpper = RandomStringUtils.randomAlphanumeric(upperCount).toUpperCase();
        String randomSpecial = RandomStringUtils.random(total - lowerCount - upperCount, "!@#$%^&*()_+~`{}[]:;'<>?,.'/");

        String randomPassword = randomLower + randomUpper + randomSpecial;
        return randomPassword;
    }

    public static String generateRandomPassword_withoutSpecialChar(int total) {
        int lowerCount = total / 2;
        int upperCount = total / 3;

        String randomLower = RandomStringUtils.randomAlphanumeric(lowerCount).toLowerCase();
        String randomUpper = RandomStringUtils.randomAlphanumeric(upperCount).toUpperCase();

        String randomPassword = randomLower + randomUpper;
        return randomPassword;
    }

    public static String generateRandomPassword_withoutNumber(int total) {
        int lowerCount = total / 2;
        int upperCount = total / 3;

        String randomLower = RandomStringUtils.randomAlphabetic(lowerCount).toLowerCase();
        String randomUpper = RandomStringUtils.randomAlphabetic(upperCount).toUpperCase();
        String randomSpecial = RandomStringUtils.random(total - lowerCount - upperCount, "!@#$%^&*()_+~`{}[]:;'<>?,.'/");

        String randomPassword = randomLower + randomUpper + randomSpecial;
        return randomPassword;
    }

    public static String generateRandomPassword_withoutLowerCase(int total) {
        int upperCount = total / 3;

        String randomUpper = RandomStringUtils.randomAlphanumeric(upperCount).toUpperCase();
        String randomSpecial = RandomStringUtils.random(total - upperCount, "!@#$%^&*()_+~`{}[]:;'<>?,.'/");

        String randomPassword = randomUpper + randomSpecial;
        return randomPassword;
    }

    public static String generateRandomPassword_withoutUpperCase(int total) {
        int lowerCount = total / 2;

        String randomLower = RandomStringUtils.randomAlphanumeric(lowerCount).toLowerCase();
        String randomSpecial = RandomStringUtils.random(total - lowerCount, "!@#$%^&*()_+~`{}[]:;'<>?,.'/");

        String randomPassword = randomLower + randomSpecial;
        return randomPassword;
    }
}
