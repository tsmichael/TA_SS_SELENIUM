package constants;

public enum DriverConfig {

    CHROME_NAME("webdriver.chrome.driver");

    String path;

    DriverConfig(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
