package com.example.passgeneration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.passgeneration.Entity.Password;

public interface PasswordRepository extends JpaRepository<Password, Long> {

    List<Password> findByUserId(Long userId);
}
