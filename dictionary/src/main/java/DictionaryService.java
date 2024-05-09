// DictionaryService.java
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictionaryService {
    private final DictionaryRepository dictionaryRepository;

    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public List<String> getWordsEndingWith(String value) {
        return dictionaryRepository.getAllWords()
                .stream()
                .filter(word -> word.endsWith(value))
                .collect(Collectors.toList());
    }
}