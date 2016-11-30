package entity;

/**
 * This class contains all intformation about Login. Login is instiated in the
 * database layer and returned to presentation or vice versa.
 */
public class Login {

    String username;
    String password;
    int rank;
    int id;
    private int uId;

    public Login(String username, String password, int rank, int id) {
        this.username = username;
        this.password = password;
        this.rank = rank;
        this.id = id;
    }

    public Login(int uId, String username, String password, int rank, int id) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.rank = rank;
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return password + id;
    }
}
