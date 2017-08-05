package com.tutorial.dao;

import com.tutorial.model.Credentials;
import com.tutorial.model.User;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
       return sessionFactory.openSession();
    }
    public void insertUser(User user) {
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        session.close();
    }
    public void insertCredential(Credentials cred) {
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        session.save(cred);
        tx.commit();
        session.close();
    }

    public List getUsers() {
        return getSession().createQuery("from User").list();
    }

    public List getUsersWithFilter(int paramVal) {
        getSession().enableFilter("userType").setParameter("type",paramVal);
        return getSession().createQuery("from User").list();
    }

    public void deleteUser(User user) {
        getSession().delete(user);
    }

    public User getUserByName(String name) {
        return getSession().byNaturalId(User.class).using("name",name).load();
    }

    public List<User> getUserByCriteria(String name) {
        Session session =getSession();
        Query query=session.createQuery("from User where name=:name");
        query.setParameter("name",name);
        query.setFirstResult(1);query.setMaxResults(10);

        query.setTimeout(2).setCacheable(true).setCacheMode(CacheMode.REFRESH).scroll();
        return  query.getResultList();
    }

    public boolean updateUserEmail(String name,String email) {
        Session session =getSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery("update User u set u.email=:email where name=:name");
        query.setParameter("name",name);
        query.setParameter("email",email);

        boolean returnVal=query.executeUpdate()>0;
        tx.commit();
        return returnVal;
    }
}
