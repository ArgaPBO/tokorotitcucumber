package stepDefinitions;

import java.util.UUID;

public class RandomStringGenerator {
    static String randomString(int l) {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < l) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, l);
    }
}
