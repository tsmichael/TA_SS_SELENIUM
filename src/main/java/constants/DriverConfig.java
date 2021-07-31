package constants;

public enum DriverConfig {

    CHROME_NAME("webdriver.chrome.driver"),
    CHROME_DRIVER_LOCATION("src/main/resources/chromedriver.exe"),
    IMPLICITLY_WAIT(10),
    EXPLICITLY_WAIT(10);

    String path;
    long seconds;

    DriverConfig(String path) {
        this.path = path;
    }

    DriverConfig(long seconds) {
        this.seconds = seconds;
    }

    public String getPath() {
        return this.path;
    }

    public long getSeconds() {
        return this.seconds;
    }

    @Override
    public String toString() {
        return path;
    }
}
