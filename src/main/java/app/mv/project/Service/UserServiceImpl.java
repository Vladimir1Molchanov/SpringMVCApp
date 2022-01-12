package app.mv.project.Service;

import app.mv.project.dao.UserDao;
import app.mv.project.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDao ud;

    public UserServiceImpl(UserDao ud) {
        this.ud = ud;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return ud.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUser() {
        return ud.listUser();
    }

    @Override
    @Transactional
    public void changeUser(int id, User user) {
        ud.changeUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        ud.deleteUserById(id);
    }
}
