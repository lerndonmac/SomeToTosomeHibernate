package service;

import DAO.DAO;
import model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceGenre implements DAO<Genre, Integer> {
    private final SessionFactory factory;

    public ServiceGenre(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(Genre genre) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        }
    }

    @Override
    public Genre read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Genre.class, integer);
        }
    }

    @Override
    public List<Genre> readByAll() {
        try(Session session = factory.openSession()){
            String hql = "FROM Genre ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Genre genre) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.update(genre);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Genre genre) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        }
    }
}
