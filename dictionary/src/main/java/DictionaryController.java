// DictionaryController.java
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DictionaryController {
    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/getWordsEndingWith/{value}")
    public ResponseEntity<List<String>> getWordsEndingWith(@PathVariable String value) {
        List<String> words = dictionaryService.getWordsEndingWith(value);
        System.out.println("Returned words ending with " + value + ": " + words);
        return ResponseEntity.ok(words);
    }
}