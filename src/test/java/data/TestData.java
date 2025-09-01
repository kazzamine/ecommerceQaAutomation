package data;

import java.util.UUID;

public final class TestData {
    public static final String DEFAULT_NAME     = "UserTest";
    public static final String DEFAULT_PASSWORD = "@7Fmd8uCynGmw";
    public static final String FIRST_NAME       = "user";
    public static final String LAST_NAME        = "test";
    public static final String ADDRESS          = "123 Test St";
    public static final String COUNTRY          = "Canada";
    public static final String STATE            = "Casablanca";
    public static final String CITY             = "Casablanca";
    public static final String ZIP              = "11111";
    public static final String MOBILE           = "5551234567";
    public static final String TITLE            = "mr";
    public static final String BIRTH_DAY        = "5";
    public static final String BIRTH_MONTH      = "May";
    public static final String BIRTH_YEAR       = "1995";
    // Additional optional fields
    public static final String COMPANY          = "Acme Corp";
    public static final String ADDRESS2         = "Apt 4B";
    public static final String EMAIL            = "new_useraminekazz@gmail.com";

    public static String uniqueEmail() {
        return "qa+" + UUID.randomUUID().toString().substring(0,8) + "@test.com";
    }

}
