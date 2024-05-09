import com.example.aggregator.Entry;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

@Service
public class AggregatorService {

    private final AggregatorRestClient restClient;

    public AggregatorService(AggregatorRestClient restClient) {
        this.restClient = restClient;
    }

    public List<Entry> getAllPalindromes() {
        List<Entry> candidates = new ArrayList<>();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char c : alphabet) {
            List<String> startsWith = restClient.getWordsStartingWith(Character.toString(c));
            List<String> endsWith = restClient.getWordsEndingWith(Character.toString(c));

            List<String> startsAndEndsWith = new ArrayList<>(startsWith);
            startsAndEndsWith.retainAll(endsWith);

            for (String word : startsAndEndsWith) {
                String reverse = new StringBuilder(word).reverse().toString();
                if (word.equals(reverse)) {
                    candidates.add(new Entry(word, "definition")); // Change "definition" with your actual definition
                }
            }
        }

        candidates.sort(Comparator.comparing(Entry::getWord));
        return candidates;
    }
}