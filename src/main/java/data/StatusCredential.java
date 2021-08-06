package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusCredential {

    @JsonProperty("valid")
    public CustomUser valid;
    @JsonProperty("invalid")
    public CustomUser invalid;
}
