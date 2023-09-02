package services;

import org.example.entites.Questions;
import org.example.services.QuestionsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuestionsTest {
    @Test
    void FindQuestionTopic()
    {
        List<Questions> tmp = new ArrayList<>();
        Questions question = Mockito.mock(Questions.class);
        tmp.add(question);
        QuestionsService service = Mockito.mock(QuestionsService.class);
        when(service.getQuestionsByTopic(1)).thenReturn(tmp);
        assertEquals(tmp, service.getQuestionsByTopic(1));
        verify(service).getQuestionsByTopic(1);
    }

    @Test
    void verificationTest() {
        Questions question = Mockito.mock(Questions.class);
        question.getQuestionId();
        verify(question).getQuestionId();
    }
}
