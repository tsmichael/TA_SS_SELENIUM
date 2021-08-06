package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomUser {

    @JsonProperty("email")
    public String email;
    @JsonProperty("password")
    public String password;
    @JsonProperty("name")
    public String name;

}
