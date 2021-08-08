package constants.search_enum;

public enum LocationConfig {

    LVIV("Ukraine", "Lviv"),
    TASHKENT("Uzbekistan", "Tashkent"),
    GEORGIA("Georgia", "Tbilisi");

    String countryName;
    String cityName;

    LocationConfig(String countryName, String cityName) {
        this.countryName = countryName;
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }
}
