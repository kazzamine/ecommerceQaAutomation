package data;

import java.util.UUID;

public final class TestData {
    public static final String DEFAULT_NAME     = "UserTest";
    public static final String DEFAULT_PASSWORD = "P@ssw0rd!";
    public static final String FIRST_NAME       = "user";
    public static final String LAST_NAME        = "test";
    public static final String ADDRESS          = "123 Test St";
    public static final String COUNTRY          = "Morocco";
    public static final String STATE            = "Casablanca";
    public static final String CITY             = "Casablanca";
    public static final String ZIP              = "11111";
    public static final String MOBILE           = "5551234567";


    public static String uniqueEmail() {
        return "qa+" + UUID.randomUUID().toString().substring(0,8) + "@test.com";
    }

}
