package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        GeoData geo = new GeoData();
        geo.setLat("00");
        geo.setLng("11");

        Address address = new Address();
        address.setCity("Kyiv");
        address.setGeo(geo);
        address.setStreet("River");
        address.setSuite("Apt. 556");
        address.setZipcode("777");

        User user = new User();
        user.setName("Anna");
        user.setAddress(address);
        user.setEmail("sfsfs@sds.sdfs");
        user.setUsername("sfsfs");


        String url = "https://jsonplaceholder.typicode.com/users";



        String json = Jsoup.connect(url)
                .ignoreContentType(true)
                .post()
                .body()
                .text();

        Type type = TypeToken.getParameterized(User.class)
                .getType();

        User items = new Gson().fromJson(json, type);
    }

    public static Map<String, Object> userToMap(User user) {
        Map<String, String> postData = new HashMap<>();
        postData.put("username", "xxxx");
        postData.put("cmd", "login");
        postData.put("password", "yyyyy");
    }
}