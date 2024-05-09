// InMemoryDictionaryRepository.java
import java.util.Arrays;
import java.util.List;

public class InMemoryDictionaryRepository implements DictionaryRepository {
    private static final List<String> dictionary = Arrays.asList("apple", "banana", "car", "dog", "cat");

    @Override
    public List<String> getAllWords() {
        return dictionary;
    }
}