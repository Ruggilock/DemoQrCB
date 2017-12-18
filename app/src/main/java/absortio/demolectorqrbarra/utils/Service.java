package absortio.demolectorqrbarra.utils;

/**
 * Created by ruggi on 11/22/17.
 */

public class Service {
    public static final String BASE_URL = "http://200.16.7.148:8080/m00p4-0.0.1-SNAPSHOT/";

    public static ServiceInterface userService() {
        return RetrofitClient.getClient(BASE_URL).create(ServiceInterface.class);
    }

}
