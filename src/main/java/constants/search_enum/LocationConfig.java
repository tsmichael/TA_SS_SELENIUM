package constants.searchenum;

public enum LocationConfig {

    LVIV("Ukraine", "Lviv");

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
