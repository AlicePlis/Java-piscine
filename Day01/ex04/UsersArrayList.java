public class UsersArrayList implements UsersList {

    private User[] Users = new User[10];
    private int usersCount = 0;

    public void addUser(User user) {
        Users[usersCount] = user;
        usersCount++;
        if (usersCount == Users.length) {
            User[] tmp = new User[Users.length];
            for (int j = 0; j < Users.length; j++) {
                tmp[j] = Users[j];
            }
            Users = new User[(int) (Users.length * 1.5)];
            for (int j = 0; j < tmp.length; j++) {
                Users[j] = tmp[j];
            }
        }
    }

    public User findUserByID(int ID) throws UserNotFoundException {
        for (int i = 0; i < usersCount; i++) {
                if (Users[i].getID() == ID) {
                    return (Users[i]);
                }
            }
        throw new UserNotFoundException("User not found!");
    }

    public User findUserByIndex(int index) throws UserNotFoundException {
        if (this.Users[index] != null) {
            return (Users[index]);
        }
        throw new UserNotFoundException("User not found!");
    }

    public int getUserCount() {
        return (this.usersCount);
    }
}
