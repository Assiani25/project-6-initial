import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

@Component
public class AggregatorRestClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public AggregatorRestClient(RestTemplate restTemplate, @Value("${api.baseurl}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public List<String> getWordsStartingWith(String value) {
        String endpoint = baseUrl + "/getWordsStartingWith/{value}";
        return restTemplate.getForObject(endpoint, List.class, value);
    }

    public List<String> getWordsEndingWith(String value) {
        String endpoint = baseUrl + "/getWordsEndingWith/{value}";
        return restTemplate.getForObject(endpoint, List.class, value);
    }
}