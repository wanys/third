package dao;

import Model.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("UserDao")
public interface UserDao {
    public User getUerNameAndPsw(Map<String,Object> map);
    public int addUser(User u);
}
