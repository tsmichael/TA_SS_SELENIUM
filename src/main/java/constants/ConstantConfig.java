package constants;

public enum ConstantConfig {

    IMPLICITLY_WAIT(10),
    EXPLICITLY_WAIT(10);

    long seconds;

    ConstantConfig(long seconds){
        this.seconds = seconds;
    }

    public long getSeconds(){
        return seconds;
    }
}
