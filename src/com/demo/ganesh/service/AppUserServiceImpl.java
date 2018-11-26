package com.demo.ganesh.service;

import org.springframework.stereotype.Service;

import com.demo.ganesh.model.AppUser;


@Service(value = "appUserService")
public class AppUserServiceImpl implements AppUserService {

   // @Autowired
   // private SessionFactory sessionFactory;


    //@Transactional
    public AppUser findByUsername(String username) {
    	AppUser user = new AppUser(1l, "Ganesh", "password", "ROLE_USER,ROLE_ADMIN");
    	
        return user;
    }

    /*@Transactional
    public long create(AppUser appUser) {
        return (long) sessionFactory.getCurrentSession().save(appUser);
    }

    @Transactional
    public AppUser findById(long id) {
        return sessionFactory.getCurrentSession().get(AppUser.class, id);
    }

    @Transactional
    public AppUser update(AppUser appUser) {
        sessionFactory.getCurrentSession().update(appUser);
        return findById(appUser.getId());
    }

    @Transactional
    public boolean delete(long id) {
        sessionFactory.getCurrentSession().delete(findById(id));
        return true;
    }*/
}
