package remcowewers.examExercise.service;

import remcowewers.examExercise.exceptions.DemoNotFoundException;
import remcowewers.examExercise.repository.DemoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import remcowewers.examExercise.service.DemodropService;

import java.util.Optional;

class DemodropServiceTest {

    @InjectMocks
    DemodropService demoService;

    @Mock
    DemoRepository demoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void serviceShouldThrowExceptionWhenDemoNotFoundById() {

        Mockito.when(demoRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(DemoNotFoundException.class, () -> {
            demoService.getDemoById(1L);

        });
    }

    @Test
    void deleteDemoShouldThrowExceptionWhenDemoNotExists() {

        Mockito.when(demoRepository.existsById(1L)).thenReturn(false);
        Assertions.assertThrows(DemoNotFoundException.class, () -> {
            demoService.deleteDemo(1L);

        });
    }
}

