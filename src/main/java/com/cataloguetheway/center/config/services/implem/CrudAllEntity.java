package com.cataloguetheway.center.config.services.implem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CrudAllEntity <repo extends JpaRepository,e> {

    @Autowired
    protected repo entityDao;

    public List<e> all(){ return (List<e>) entityDao.findAll();}

    public e add(e elem){ return (e) entityDao.save(elem);}

    public e getElementById(Integer id){return (e) entityDao.findById(id); }

    public e update(e elem){return (e) entityDao.save(elem);}

    public void delete(Integer id){entityDao.deleteById(id);}

    public e getOneEntity(Integer id){return (e) entityDao.getOne(id); }

}
