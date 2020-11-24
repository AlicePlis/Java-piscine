public class UserIdsGenerator {

    private static UserIdsGenerator instance;
    private int newUserId = 1;

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return (instance);
    }
    public int generateId() {
        int ID = newUserId;
        this.newUserId += 1;
        return (ID);
    }
}