package eu.cscheer.demo.springai;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class Tools {

    @Tool(description = "Returns the current time in a specific time for an IANA time zone identifier")
    public String currentTimeIn(
            @ToolParam(required = false, description = "IANA time zone identifier. optional. if empty, current time zone of user is used") String timeZone) {
        if (timeZone == null) {
            return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        }
        ZoneId zoneId = ZoneId.of(timeZone);
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        return now.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Tool(description = "gets the weather at a city")
    public String weather(@ToolParam(description = "city") String city) {
        return "In " + city + " it is 20 Degrees Celsius warm, the sun is shining and it is a little windy";
    }

}
