package uz.pdp.shaftoli.repository.user;

import uz.pdp.shaftoli.model.User;
import uz.pdp.shaftoli.repository.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
    String INSERT_USER = "insert into users(id, name, role, email, password) " +
            "values(?, ?, ?, ?, ?);";
    String GET_USER_BY_ID = "select * from users where id = ?;";
    String GET_USER_BY_EMAIL = "select * from users u where email = ?;";
    String GET_ALL = "select * from users;";
    String CHANGE_VALIDATED = "update users u set validated = true where u.email = ?;";
    String CHECK_VALIDATED = "select u.validated from users u where u.email = ?";

    User getByEmail(String email);
    Boolean checkUserValidate(String email);
    void changeValidated(String email);

}
