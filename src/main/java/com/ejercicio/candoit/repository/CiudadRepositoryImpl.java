package com.ejercicio.candoit.repository;

import com.ejercicio.candoit.model.Ciudad;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CiudadRepositoryImpl implements CiudadRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public CiudadRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    @Override
    public List<Ciudad> findAll() {
        return (List<Ciudad>) sessionFactory.getCurrentSession().createCriteria(Ciudad.class).list();
    }

    @Override
    public void save(Ciudad ciudad) {
        sessionFactory.getCurrentSession().save(ciudad);
    }

    @Override
    public void saveAll(List<Ciudad> ciudades) {
        for (Ciudad ciudad: ciudades) {
            this.save(ciudad);
        }
    }
}
