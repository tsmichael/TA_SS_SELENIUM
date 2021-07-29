package tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.CustomUser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONDataConfig {

    private List<CustomUser> listUser;

    public JSONDataConfig(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        listUser = null;
        try {
            listUser = objectMapper.readValue(new File(fileName), new TypeReference<List<CustomUser>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmailFromJson(int user_index){
        return listUser.get(user_index).getEmail();
    }

    public String getPasswordFromJson(int user_index) {
        return listUser.get(user_index).getPassword();
    }

    public String getNameFromJson(int user_index) {
        return listUser.get(user_index).getName();
    }
}
