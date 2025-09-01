package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.NavBar;
import utils.ElementActions;

public class SignUpAccInfo
{
    private final NavBar nav;
    private final ElementActions elActions;
    //fields
    private final By TITLE_MR  = By.id("id_gender1");
    private final By TITLE_MRS = By.id("id_gender2");
    private final By NAME=By.cssSelector("[data-qa='name']");
    private final By PASSWORD   = By.cssSelector("[data-qa='password']");
    private final By BIRTH_DAY  = By.cssSelector("[data-qa='days']");
    private final By BIRTH_MONTH= By.cssSelector("[data-qa='months']");
    private final By BIRTH_YEAR = By.cssSelector("[data-qa='years']");
    private final By FIRST_NAME=By.cssSelector("[data-qa='first_name']");
    private final By LAST_NAME = By.cssSelector("[data-qa='last_name']");
    private final By COMPANY   = By.cssSelector("[data-qa='company']");
    private final By ADDRESS   = By.cssSelector("[data-qa='address']");
    private final By ADDRESS2  = By.cssSelector("[data-qa='address2']");
    private final By COUNTRY   = By.cssSelector("[data-qa='country']");
    private final By STATE     = By.cssSelector("[data-qa='state']");
    private final By CITY      = By.cssSelector("[data-qa='city']");
    private final By ZIP_CODE       = By.cssSelector("[data-qa='zipcode']");
    private final By MOBILE    = By.cssSelector("[data-qa='mobile_number']");
    private final By CREATE_BTN = By.cssSelector("[data-qa='create-account']");

    public SignUpAccInfo(WebDriver driver){
        this.nav=new NavBar(driver);
        this.elActions=new ElementActions(driver);
    }

    public void fillAllAccountInfo(
            String title,
            String name,
            String password,
            String birthDayValue,
            String birthMonthText,
            String birthYearValue,
            String firstName,
            String lastName,
            String company,
            String address1,
            String address2,
            String countryText,
            String state,
            String city,
            String zipCode,
            String mobileNumber
    ) {
        String t = title == null ? "" : title.trim().toLowerCase();
        switch (t) {
            case "mr":
                elActions.click(TITLE_MR);
                break;
            case "mrs":
                elActions.click(TITLE_MRS);
                break;
            default:
                throw new IllegalArgumentException("Unsupported title: '" + title + "'. Use 'mr' or 'mrs'.");
        }
        elActions.type(NAME, name);
        elActions.type(PASSWORD, password);
        elActions.selectByValue(BIRTH_DAY, birthDayValue);
        elActions.selectByText(BIRTH_MONTH, birthMonthText);
        elActions.selectByValue(BIRTH_YEAR, birthYearValue);
        elActions.type(FIRST_NAME, firstName);
        elActions.type(LAST_NAME, lastName);
        elActions.type(COMPANY, company);
        elActions.type(ADDRESS, address1);
        elActions.type(ADDRESS2, address2);
        elActions.selectByText(COUNTRY, countryText);
        elActions.type(STATE, state);
        elActions.type(CITY, city);
        elActions.type(ZIP_CODE, zipCode);
        elActions.type(MOBILE, mobileNumber);
    }

    public void createAccountClick() {
        elActions.click(CREATE_BTN);
    }

    public SignUpAccInfo waitUrlNavigated(){
        elActions.waitUrlContains("/signup");
        return this;
    }

    public boolean isAt(){
        try {
            elActions.visible(PASSWORD);
            elActions.visible(CREATE_BTN);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    public NavBar navBar(){
        return nav;
    }
}
