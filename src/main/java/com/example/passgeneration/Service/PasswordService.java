package com.example.passgeneration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.passgeneration.Entity.Password;
import com.example.passgeneration.Entity.User;
import com.example.passgeneration.Repository.PasswordRepository;
import com.example.passgeneration.Repository.UserRepository;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private UserRepository userRepository;

    public Password criar(String name, String pass, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Password password = new Password();
        password.setName(name);
        password.setPass(pass);
        password.setUser(user);

        return passwordRepository.save(password);
    }

    public List<Password> listar(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return passwordRepository.findByUserId(user.getId());
    }

    public void deletar(Long id) {
        passwordRepository.deleteById(id);
    }
}
