package service;

import DAO.DAO;
import model.Authors;
import model.Authors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceAuthors implements DAO<Authors, Integer> {
    private final SessionFactory factory;

    public ServiceAuthors(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(Authors authors) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(authors);
            session.getTransaction().commit();
        }
    }

    @Override
    public Authors read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Authors.class, integer);
        }
    }

    @Override
    public List<Authors> readByAll() {
        try(Session session = factory.openSession()){
            String hql = "FROM Authors ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Authors authors) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.update(authors);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Authors authors) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.delete(authors);
            session.getTransaction().commit();
        }
    }
}
