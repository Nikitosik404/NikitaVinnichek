package setup;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ManageMobileCloud extends TestProperties {

    private static String auth = "Bearer ";
    private static String bookingId;


    public static void bookDevice(String udid, String token) {
        Response request = RestAssured.given()
                .header("Authorization", auth + token)
                .contentType("application/json")
                .queryParam("serial", udid)
                .queryParam("begin", getCurrentTime())
                .queryParam("duration", 15)
                .post("http://mobilecloud.epam.com/automation/api/booking");

        List<Map<String, String>> success = request.jsonPath().getList("success");

        bookingId = success.get(0).get("booking_id");
    }

    public static void installApplication(String udid, String token, String pathToApp) {
        RestAssured.given()
                .header("Authorization", auth + token)
                .pathParam("serial", udid)
                .multiPart("file", new File(pathToApp))
                .post("http://mobilecloud.epam.com/automation/api/storage/install/{serial}");
    }


    public static void cancelBooking(String token) {
        RestAssured.given()
                .header("Authorization", auth + token)
                .contentType("application/json")
                .queryParam("id", bookingId)
                .delete("http://mobilecloud.epam.com/automation/api/booking");
    }

    public static String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String now = formatter.format(ZonedDateTime.now(Clock.systemUTC()).plusSeconds(4));
        return now;
    }
}