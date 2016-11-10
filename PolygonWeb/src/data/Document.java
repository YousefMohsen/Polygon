package data;

public class Document {

    private int id;
    private String fileURL;
    private String note;

    public Document(int id, String fileURL, String note) {
        this.id = id;
        this.fileURL = fileURL;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
