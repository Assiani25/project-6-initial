import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.aggregator.Entry;

@RestController
public class AggregatorController {

    private final AggregatorService aggregatorService;

    @Autowired
    public AggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/getAllPalindromes")
    public ResponseEntity<List<Entry>> getAllPalindromes() {
        List<Entry> palindromes = aggregatorService.getAllPalindromes();
        System.out.println("Returned all palindromes: " + palindromes);
        return ResponseEntity.ok(palindromes);
    }
}
