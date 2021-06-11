package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
