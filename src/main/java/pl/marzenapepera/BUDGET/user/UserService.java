package pl.marzenapepera.BUDGET.user;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

    public void updateUserPassword(String newPassword, String email);

    public void updateUserProfile(String newName, String newLastName, String newEmail, int id);

    User findUserById(int id_user);
}
