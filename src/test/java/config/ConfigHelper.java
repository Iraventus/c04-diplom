package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getUrl() {
        return getWebConfig().url();
    }
    public static String getText() {
        return getSearchConfig().text();
    }

    public static String getWebRemoteDriver() {
        return String.format(System.getProperty("web.remote.driver"),
                getWebConfig().webRemoteDriverUser(),
                getWebConfig().webRemoteDriverPassword());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    private static SearchConfig getSearchConfig() {
        return ConfigFactory.newInstance().create(SearchConfig.class, System.getProperties());
    }
}