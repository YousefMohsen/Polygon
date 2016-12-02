package entity;

import java.io.InputStream;

/**
 * This class contains all intformation about a document. Document is instiated
 * in the database layer and returned to presentation or vice versa.
 */
public class Document {

    private int id;
    private InputStream file;
    private String note;
    private int buildingId;

    public Document(int id, InputStream file, String note, int buildingId) {
        this.id = id;
        this.file = file;
        this.note = note;
        this.buildingId = buildingId;
    }

    public Document(InputStream file, String note, int buildingId) {
        this.file = file;
        this.note = note;
        this.buildingId = buildingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }
}
