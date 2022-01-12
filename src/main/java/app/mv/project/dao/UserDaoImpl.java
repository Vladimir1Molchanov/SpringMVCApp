package app.mv.project.dao;

import app.mv.project.model.User;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Component
class UserDaoImpl implements UserDao {

    private final EntityManagerFactory emf;
    private EntityManager em;

    public UserDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @PostConstruct
    public void init() {
        em = emf.createEntityManager();
    }

    @Override
    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User getUserById(int id) {
        User u = em.find(User.class, id);
        em.detach(u);
        return u;
    }

    @Override
    public List<User> listUser() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void changeUser(int id, User user) {
        em.getTransaction().begin();
        Query q = em.createQuery("update User set name = ?1, lastName = ?2, age = ?3 where id = ?4");
        q.setParameter(1, user.getName());
        q.setParameter(2, user.getLastName());
        q.setParameter(3, user.getAge());
        q.setParameter(4, id);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void deleteUserById(int id) {
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }
}
