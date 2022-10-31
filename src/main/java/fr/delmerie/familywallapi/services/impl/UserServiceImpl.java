package fr.delmerie.familywallapi.services.impl;

import fr.delmerie.familywallapi.dao.UsersRepository;
import fr.delmerie.familywallapi.entities.Users;
import fr.delmerie.familywallapi.services.APIService;
import fr.delmerie.familywallapi.utils.error.AlwaysExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements APIService<Users> {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public Optional<Users> getOneById(long id) {
        return Optional.empty();
    }

    @Override
    public Users save(Users obj) {
        return usersRepository.save(obj);
    }

    @Override
    public void delete(long id) {

    }

    public boolean isEmailOrUsernameToken(String email, String username) {
        if (usersRepository.findByEmail(email) != null) {
            throw new AlwaysExistException("Cet email est déjà utilisé !");
        }

        if (usersRepository.findByUsername(username) != null) {
            throw new AlwaysExistException("Ce pseudo existe déjà !");
        }
        return false;
    }

    public Users getByEmail(String username) {
        return usersRepository.findByEmail(username);
    }
}
