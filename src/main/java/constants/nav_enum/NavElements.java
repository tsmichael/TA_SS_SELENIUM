package constants.nav_enum;

public enum NavElements {

    TRAINING_LIST("TrainingList"),
    ABOUT("About"),
    BLOG("News"),
    FAQ("FAQ");

    String link;

    NavElements(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
