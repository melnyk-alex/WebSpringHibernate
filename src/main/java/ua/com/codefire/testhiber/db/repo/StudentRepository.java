/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.testhiber.db.repo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.testhiber.db.entity.Student;

/**
 *
 * @author human
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class StudentRepository {
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT s FROM Student s").list();
    }
}
