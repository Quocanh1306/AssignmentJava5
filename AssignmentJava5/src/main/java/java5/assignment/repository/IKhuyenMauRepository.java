package java5.assignment.repository;

import java5.assignment.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IKhuyenMauRepository extends JpaRepository<KhuyenMai, Integer> {
}
