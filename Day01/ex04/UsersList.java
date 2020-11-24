public interface UsersList {

    public void addUser(User user);
    public User findUserByID(int ID) throws UserNotFoundException;
    public User findUserByIndex(int index) throws UserNotFoundException;
    public int getUserCount();
}