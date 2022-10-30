package fr.delmerie.familywallapi.services.impl;

import fr.delmerie.familywallapi.dao.RoleRepository;
import fr.delmerie.familywallapi.entities.Role;
import fr.delmerie.familywallapi.services.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements APIService<Role> {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Optional<Role> getOneById(long id) {
        return Optional.of(roleRepository.getById(id));
    }

    @Override
    public Role save(Role obj) {
        return roleRepository.save(obj);
    }

    @Override
    public void delete(long id) {

    }
}
