package Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiController {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String apiUrl;
    @GetMapping("/games")
    public String getGames(
            @RequestParam String genre,
            @RequestParam int year) {
        String url = String.format("%s?key=%s&page_size=8&genres=%s&dates=%d-01-01,%d-12-31",
                apiUrl, apiKey, genre, year, year);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

}
