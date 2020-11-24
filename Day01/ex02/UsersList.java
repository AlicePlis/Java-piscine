public interface UsersList {

    public void addUsers(User user);
    public User findUserByID(int ID) throws UserNotFoundException;
    public User findUserByIndex(int index) throws UserNotFoundException;
    public int getUserCount();
}