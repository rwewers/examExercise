package remcowewers.examExercise.repository;

import remcowewers.examExercise.domain.ERole;
import remcowewers.examExercise.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}