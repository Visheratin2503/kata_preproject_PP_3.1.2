package SpringBootApps.SpringBootApp1.dao;

import SpringBootApps.SpringBootApp1.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        //entityManager.remove(entityManager.find(User.class, id));
    }
//использовать createQuery, гарантировать один запрос, delete from user where id = итд, по id. не явные join. через точку!
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }
}
