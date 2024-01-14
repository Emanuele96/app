package com.emanuele.app.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DataProcessorArchiver {
    @Autowired
    protected EntityManager em;

    DataProcessorArchiver(){}

    protected void persistEntity(final Object entity){
        em.persist(entity);
    }
}
