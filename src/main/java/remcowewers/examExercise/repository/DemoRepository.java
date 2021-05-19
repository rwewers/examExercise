package remcowewers.examExercise.repository;

import remcowewers.examExercise.domain.Demodrop;
import org.springframework.data.jpa.repository.JpaRepository;
import remcowewers.examExercise.domain.User;

import java.util.List;

public interface DemoRepository extends JpaRepository<Demodrop, Long> {

    List<Demodrop> findDemosByUser(User user);
    List<Demodrop> findAllByOrderByUser();
    List<Demodrop> findAllByUserUserId(long userId);
}
