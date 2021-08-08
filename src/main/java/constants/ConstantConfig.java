package constants;

public enum ConstantConfig {

    IMPLICITLY_WAIT(10),
    IMPLICITLY_WAIT_ONE(1),
    EXPLICITLY_WAIT(20);

    long seconds;

    ConstantConfig(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }
}
