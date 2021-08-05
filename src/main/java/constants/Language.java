package constants;

public enum Language {

    ENGLISH("English", "SIGN IN", "en"),
    RUSSIAN("Русский", "ВОЙТИ", "ru"),
    UKRAINIAN("Українська", "УВІЙТИ", "ua");

    String language;
    String signInButtonText;
    String domain;

    Language(String language, String signInButtonText, String domain) {
        this.language = language;
        this.signInButtonText = signInButtonText;
        this.domain = domain;
    }

    public String getLanguage() {
        return language;
    }

    public String getSignInButtonText() {
        return signInButtonText;
    }

    public String getDomain() {
        return this.domain;
    }

}
