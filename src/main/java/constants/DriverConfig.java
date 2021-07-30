package constants;

public enum DriverConfig {

    CHROME_NAME("webdriver.chrome.driver"),
    CHROME_DRIVER_LOCATION("src/main/resources/chromedriver.exe");

    String path;

    DriverConfig(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
