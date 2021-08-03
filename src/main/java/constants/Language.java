package constants;

public enum Language {

    ENGLISH("English", "SIGN IN"),
    RUSSIAN("Русский", "ВОЙТИ"),
    UKRAINIAN("Українська", "УВІЙТИ");

    String language;
    String signInButtonText;

    Language(String language, String signInButtonText) {
        this.language = language;
        this.signInButtonText = signInButtonText;
    }

    public String getLanguage() {
        return language;
    }

    public String getSignInButtonText() {
        return signInButtonText;
    }


}
