package cn.dlut.conspirer.wordhub.Services;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.Impls.WordServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class WordServicesTest {
    @Mock
    WordMapper wordMapper;

    @InjectMocks
    private WordService wordService = new WordServiceImpl(wordMapper);

    @Test
    void addWordToDict(){
       long dictId = 101L ;
       String testWordName = "testName";
        JsonNode extension;
        try {
            extension = new ObjectMapper().readTree("{\"ukphone\": \"uk\", \"usphone\": \"us\", \"trans\": [\"trans1\",\"trans2\"]}");
            // log.info(extension.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Word word =
                Word.builder().id(101L).name(testWordName).dictId(101L).extension(extension).build();
        wordService.addWordToDict(dictId,word);
        verify(wordMapper).addWordToDict(dictId,word);
    }






}
