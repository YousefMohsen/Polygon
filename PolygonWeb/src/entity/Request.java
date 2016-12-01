package entity;

/**
 * This class contains all intformation about a request. Request is instiated in
 * the database layer and returned to presentation or vice versa.
 */
public class Request {

    private int id;

    public Request(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
