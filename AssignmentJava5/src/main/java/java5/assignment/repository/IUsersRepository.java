package java5.assignment.repository;

import java5.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsersRepository extends JpaRepository<User, Integer> {
}
