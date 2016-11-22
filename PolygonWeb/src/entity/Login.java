package entity;

/**
 *
 * @author joaci
 */
public class Login {
    String username;
    String password;
    int rank;
    int id;

    public Login(String username, String password, int rank, int id) {
        this.username = username;
        this.password = password;
        this.rank = rank;
        this.id = id;
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
    
    public int getId(){
        return id;
    }
    
    @Override
    public String toString(){
        return password + id;
    }
}
