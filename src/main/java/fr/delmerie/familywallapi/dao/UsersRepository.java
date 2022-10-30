package fr.delmerie.familywallapi.dao;

import fr.delmerie.familywallapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findByEmail(String email);
    public Users findByUsername(String email);
}
