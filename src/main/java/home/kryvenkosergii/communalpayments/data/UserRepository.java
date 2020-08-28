package home.kryvenkosergii.communalpayments.data;

import home.kryvenkosergii.communalpayments.utils.FileUtil;

/**
 * UserRepository class.
 * @author SergiiK
 * 2020-08-24
 */
public final class UserRepository {
    private static volatile UserRepository instance = null;
    //
    private String pathFile = "values.txt";
    private FileUtil value = new FileUtil(pathFile);
    private int electricityDayValue;
    private int electricityNightValue;
    private int gasMeterValue;
    private int waterMeterValue;
    //
    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    /**
     * <h2>Returns default credentials:
     * <pre> email = System.getenv("USER_EMAIL");
     * password = "12345";
     * userValue1 = 0;
     * userValue2 = 0. </pre>
     * @return User class.
     */
    public User getDefault() {
        return new User(System.getenv("USER_EMAIL"), "12345", 0, 0);
    }

    /**
     * <h2>Returns credentials for LOE site:
     * <pre> email = System.getenv("USER_EMAIL");
     * password = System.getenv("LOE_SITE_PASSWORD");
     * userNumber = System.getenv("LOE_SITE_PRIVATE_INVOICE") - number consumer from URL (https://info.loe.lviv.ua/consumers/{number}/info);
     * userValue1 = electricityDayValue;
     * userValue2 = electricityNightValue. </pre>
     * @return User class.
     */
    public User userLOECredentials() {
        electricityDayValue = value.getElectricityMeterValueDay();
        electricityNightValue = value.getElectricityMeterValueNight();
        return new User(System.getenv("USER_EMAIL"), System.getenv("LOE_SITE_PASSWORD"), System.getenv("LOE_SITE_PRIVATE_INVOICE"), electricityDayValue, electricityNightValue);
    }
    
    /**
     * <h2>Returns credentials for LOE site:
     * <pre> email = System.getenv("USER_EMAIL");
     * password = System.getenv("LOE_SITE_PASSWORD");
     * userNumber = System.getenv("LOE_SITE_PRIVATE_INVOICE") - number consumer from URL (https://info.loe.lviv.ua/consumers/{number}/info);
     * userValue1 = electricityDayValue;
     * userValue2 = -1. </pre>
     * @return User class.
     */
    public User userLOECredentialsOnlyDayValue() {
        electricityDayValue = value.getElectricityMeterValueDay();
        electricityNightValue = value.getElectricityMeterValueNight();
        return new User(System.getenv("USER_EMAIL"), System.getenv("LOE_SITE_PASSWORD"), System.getenv("LOE_SITE_PRIVATE_INVOICE"), electricityDayValue);
    }
    
    /**
     * <h2>Returns credentials for 104UA site:
     * <pre> email = System.getenv("USER_EMAIL");
     * password = System.getenv("LOE_SITE_PASSWORD");
     * userNumber = System.getenv("104UA_SITE_GAS_PRIVATE_INVOICE");
     * userValue1 = gasMeterValue;
     * userValue2 = 0.</pre>
     * @return User class.
     */
    public User user104UACredentials() {
        gasMeterValue = value.getGasMeterValue();
        return new User(System.getenv("USER_EMAIL"), System.getenv("104UA_SITE_PASSWORD"), System.getenv("104UA_SITE_GAS_PRIVATE_INVOICE"), gasMeterValue, 0);
    }
    
    /**
     * <h2>Returns credentials for InfoLviv site:
     * <pre> email = System.getenv("USER_EMAIL");
     * password = System.getenv("INFO_LVIV_SITE_PASSWORD");
     * userNumber = System.getenv("INFO_LVIV_SITE_WATER_PRIVATE_INVOICE");
     * userValue1 = waterMeterValue;
     * userValue2 = 0. </pre>
     * @return User class.
     */
    public User userInfoLvivCredentials() {
        waterMeterValue = value.getWaterMeterValue();
        return new User(System.getenv("USER_EMAIL"), System.getenv("INFO_LVIV_SITE_PASSWORD"), System.getenv("INFO_LVIV_SITE_WATER_PRIVATE_INVOICE"), waterMeterValue, 0);
    }
}
