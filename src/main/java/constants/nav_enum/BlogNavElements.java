package constants;

public enum BlogNavElements {

    NEWS("news", "NEWS"),
    REAL_STORIES("real-stories", "REAL STORIES"),
    MATERIALS("materials", "MATERIALS"),
    HARD_SKILLS("hard-skills", "HARD SKILLS"),
    SOFT_SKILLS("soft-skills", "SOFT SKILLS"),
    EVENTS("events", "EVENTS");

    String link;
    String name;

    BlogNavElements(String link, String name) {
        this.link = link;
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
