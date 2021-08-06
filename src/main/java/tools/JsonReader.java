package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.BusinessConfig;
import data.CustomUser;
import data.StatusCredential;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    StatusCredential user;

    public JsonReader(BusinessConfig pathToFile) {
        try {
            user = new ObjectMapper()
                    .readValue(new File(pathToFile.getPath()), StatusCredential.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StatusCredential getUser() {
        return this.user;
    }

    public CustomUser getValidUser() {
        return this.user.valid;
    }

    public CustomUser getInvalidUser() {
        return this.user.invalid;
    }


}
