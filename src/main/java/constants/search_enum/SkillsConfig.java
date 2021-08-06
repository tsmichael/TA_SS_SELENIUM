package constants.searchenum;

public enum SkillsConfig {

    JAVA("Java"),
    RUBY("Ruby");

    String skillName;

    SkillsConfig(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return this.skillName;
    }
}
