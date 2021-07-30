package constants;

public enum BusinessConfig {

    BASE_URL("https://training.by"),
    HOME_PAGE_URL(BASE_URL+"/#/Home"),

    REAL_USER_CREDENTIALS("src/main/resources/data.json");

    String path;

    BusinessConfig(String path){
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
