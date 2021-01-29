package service;

import DAO.DAO;
import model.Books;
import model.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceBooks implements DAO<Books, Integer> {
    private final SessionFactory factory;

    public ServiceBooks(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(Books books) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(books);
            session.getTransaction().commit();
        }
    }

    @Override
    public Books read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Books.class, integer);
        }
    }

    @Override
    public List<Books> readByAll() {
        try(Session session = factory.openSession()){
            String hql = "FROM Books ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Books books) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.update(books);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Books books) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.delete(books);
            session.getTransaction().commit();
        }
    }
}
