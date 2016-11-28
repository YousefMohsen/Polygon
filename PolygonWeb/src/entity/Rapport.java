package entity;

public class Rapport {
    
    private String buildingName;
    private String address;
    private String zip;
    private int buildYear;
    private double buildingArea;
    private String buildingUse;
    private String descriptionRoof;
    private String descriptionOuterwall;
    private String room;
    private String when;
    private String where;
    private String whatHappend;
    private String whatRepaired;
    private String otherDamageType;
    private String descriptionWall;
    private String descriptionCeiling;
    private String descriptionFloor;
    private String descriptionWindows;
    private String descriptionOther;
    private String descriptionOther2;
    private String descriptionScanning;
    private String descriptionMeasuring;
    private String descriptionHumidity;
    private String otherReview;
    private String otherReview2;
    private String conclusionRoom1;
    private String conclusionConclusion1;
    private String conclusionRoom2;
    private String conclusionConclusion2;
    private String conclusionRoom3;
    private String conclusionConclusion3;
    private String conclusionRoom4;
    private String conclusionConclusion4;
    private String conclusionRoom5;
    private String conclusionConclusion5;
    private String conclusionRoom6;
    private String conclusionConclusion6;
    private String conclusionRoom7;
    private String conclusionConclusion7;
    private String conclusionRoom8;
    private String conclusionConclusion8;
    private String writer;
    private String collaborator;
    
    private int commentRoof;
    private int pictureRoof;
    private int commentOuterwall;
    private int pictureOuterwall;
    private int commentRoom;
    private int yesNoRoomDamage;
    private int damageType;
    private int commentWall;
    private int pictureWall;
    private int commentCeiling;
    private int pictureCeiling;
    private int commentFloor;
    private int pictureFloor;
    private int commentWindows;
    private int pictureWindows;
    private int commentOther;
    private int pictureOther;
    private int commentOther2;
    private int pictureOther2;
    private int humidityYesNo;
    private int categorize;
    private int rapportNr;

    public Rapport() {
    }

    public Rapport(String buildingName, String address, String zip, int buildYear, double buildingArea, String buildingUse, String descriptionRoof, String descriptionOuterwall, String room, String when, String where, String whatHappend, String whatRepaired, String otherDamageType, String descriptionWall, String descriptionCeiling, String descriptionFloor, String descriptionWindows, String otherReview, String descriptionOther, String otherReview2, String descriptionOther2, String descriptionScanning, String descriptionMeasuring, String descriptionHumidity, String conclusionRoom1, String conclusionConclusion1, String conclusionRoom2, String conclusionConclusion2, String conclusionRoom3, String conclusionConclusion3, String conclusionRoom4, String conclusionConclusion4, String conclusionRoom5, String conclusionConclusion5, String conclusionRoom6, String conclusionConclusion6, String conclusionRoom7, String conclusionConclusion7, String conclusionRoom8, String conclusionConclusion8, String writer, String collaborator, int commentRoof, int pictureRoof, int commentOuterwall, int pictureOuterwall, int commentRoom, int yesNoRoomDamage, int damageType, int commentWall, int pictureWall, int commentCeiling, int pictureCeiling, int commentFloor, int pictureFloor, int commentWindows, int pictureWindows, int commentOther, int pictureOther, int commentOther2, int pictureOther2, int humidityYesNo, int categorize, int rapportNr) {
        this.buildingName = buildingName;
        this.address = address;
        this.zip = zip;
        this.buildYear = buildYear;
        this.buildingArea = buildingArea;
        this.buildingUse = buildingUse;
        this.descriptionRoof = descriptionRoof;
        this.descriptionOuterwall = descriptionOuterwall;
        this.room = room;
        this.when = when;
        this.where = where;
        this.whatHappend = whatHappend;
        this.whatRepaired = whatRepaired;
        this.otherDamageType = otherDamageType;
        this.descriptionWall = descriptionWall;
        this.descriptionCeiling = descriptionCeiling;
        this.descriptionFloor = descriptionFloor;
        this.descriptionWindows = descriptionWindows;
        this.otherReview = otherReview;
        this.descriptionOther = descriptionOther;
        this.otherReview2 = otherReview2;
        this.descriptionOther2 = descriptionOther2;
        this.descriptionScanning = descriptionScanning;
        this.descriptionMeasuring = descriptionMeasuring;
        this.descriptionHumidity = descriptionHumidity;
        this.conclusionRoom1 = conclusionRoom1;
        this.conclusionConclusion1 = conclusionConclusion1;
        this.conclusionRoom2 = conclusionRoom2;
        this.conclusionConclusion2 = conclusionConclusion2;
        this.conclusionRoom3 = conclusionRoom3;
        this.conclusionConclusion3 = conclusionConclusion3;
        this.conclusionRoom4 = conclusionRoom4;
        this.conclusionConclusion4 = conclusionConclusion4;
        this.conclusionRoom5 = conclusionRoom5;
        this.conclusionConclusion5 = conclusionConclusion5;
        this.conclusionRoom6 = conclusionRoom6;
        this.conclusionConclusion6 = conclusionConclusion6;
        this.conclusionRoom7 = conclusionRoom7;
        this.conclusionConclusion7 = conclusionConclusion7;
        this.conclusionRoom8 = conclusionRoom8;
        this.conclusionConclusion8 = conclusionConclusion8;
        this.writer = writer;
        this.collaborator = collaborator;
        this.commentRoof = commentRoof;
        this.pictureRoof = pictureRoof;
        this.commentOuterwall = commentOuterwall;
        this.pictureOuterwall = pictureOuterwall;
        this.commentRoom = commentRoom;
        this.yesNoRoomDamage = yesNoRoomDamage;
        this.damageType = damageType;
        this.commentWall = commentWall;
        this.pictureWall = pictureWall;
        this.commentCeiling = commentCeiling;
        this.pictureCeiling = pictureCeiling;
        this.commentFloor = commentFloor;
        this.pictureFloor = pictureFloor;
        this.commentWindows = commentWindows;
        this.pictureWindows = pictureWindows;
        this.commentOther = commentOther;
        this.pictureOther = pictureOther;
        this.commentOther2 = commentOther2;
        this.pictureOther2 = pictureOther2;
        this.humidityYesNo = humidityYesNo;
        this.categorize = categorize;
        this.rapportNr = rapportNr;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getBuildingUse() {
        return buildingUse;
    }

    public void setBuildingUse(String buildingUse) {
        this.buildingUse = buildingUse;
    }

    public String getDescriptionRoof() {
        return descriptionRoof;
    }

    public void setDescriptionRoof(String descriptionRoof) {
        this.descriptionRoof = descriptionRoof;
    }

    public String getDescriptionOuterwall() {
        return descriptionOuterwall;
    }

    public void setDescriptionOuterwall(String descriptionOuterwall) {
        this.descriptionOuterwall = descriptionOuterwall;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhatHappend() {
        return whatHappend;
    }

    public void setWhatHappend(String whatHappend) {
        this.whatHappend = whatHappend;
    }

    public String getWhatRepaired() {
        return whatRepaired;
    }

    public void setWhatRepaired(String whatRepaired) {
        this.whatRepaired = whatRepaired;
    }

    public String getOtherDamageType() {
        return otherDamageType;
    }

    public void setOtherDamageType(String otherDamageType) {
        this.otherDamageType = otherDamageType;
    }

    public String getDescriptionWall() {
        return descriptionWall;
    }

    public void setDescriptionWall(String descriptionWall) {
        this.descriptionWall = descriptionWall;
    }

    public String getDescriptionCeiling() {
        return descriptionCeiling;
    }

    public void setDescriptionCeiling(String descriptionCeiling) {
        this.descriptionCeiling = descriptionCeiling;
    }

    public String getDescriptionFloor() {
        return descriptionFloor;
    }

    public void setDescriptionFloor(String descriptionFloor) {
        this.descriptionFloor = descriptionFloor;
    }

    public String getDescriptionWindows() {
        return descriptionWindows;
    }

    public void setDescriptionWindows(String descriptionWindows) {
        this.descriptionWindows = descriptionWindows;
    }

    public String getOtherReview() {
        return otherReview;
    }

    public void setOtherReview(String otherReview) {
        this.otherReview = otherReview;
    }

    public String getOtherReview2() {
        return otherReview2;
    }

    public void setOtherReview2(String otherReview2) {
        this.otherReview2 = otherReview2;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public String getDescriptionOther2() {
        return descriptionOther2;
    }

    public void setDescriptionOther2(String descriptionOther2) {
        this.descriptionOther2 = descriptionOther2;
    }

    public String getDescriptionScanning() {
        return descriptionScanning;
    }

    public void setDescriptionScanning(String descriptionScanning) {
        this.descriptionScanning = descriptionScanning;
    }

    public String getDescriptionMeasuring() {
        return descriptionMeasuring;
    }

    public void setDescriptionMeasuring(String descriptionMeasuring) {
        this.descriptionMeasuring = descriptionMeasuring;
    }

    public String getDescriptionHumidity() {
        return descriptionHumidity;
    }

    public void setDescriptionHumidity(String descriptionHumidity) {
        this.descriptionHumidity = descriptionHumidity;
    }

    public String getConclusionRoom1() {
        return conclusionRoom1;
    }

    public void setConclusionRoom1(String conclusionRoom1) {
        this.conclusionRoom1 = conclusionRoom1;
    }

    public String getConclusionConclusion1() {
        return conclusionConclusion1;
    }

    public void setConclusionConclusion1(String conclusionConclusion1) {
        this.conclusionConclusion1 = conclusionConclusion1;
    }

    public String getConclusionRoom2() {
        return conclusionRoom2;
    }

    public void setConclusionRoom2(String conclusionRoom2) {
        this.conclusionRoom2 = conclusionRoom2;
    }

    public String getConclusionConclusion2() {
        return conclusionConclusion2;
    }

    public void setConclusionConclusion2(String conclusionConclusion2) {
        this.conclusionConclusion2 = conclusionConclusion2;
    }

    public String getConclusionRoom3() {
        return conclusionRoom3;
    }

    public void setConclusionRoom3(String conclusionRoom3) {
        this.conclusionRoom3 = conclusionRoom3;
    }

    public String getConclusionConclusion3() {
        return conclusionConclusion3;
    }

    public void setConclusionConclusion3(String conclusionConclusion3) {
        this.conclusionConclusion3 = conclusionConclusion3;
    }

    public String getConclusionRoom4() {
        return conclusionRoom4;
    }

    public void setConclusionRoom4(String conclusionRoom4) {
        this.conclusionRoom4 = conclusionRoom4;
    }

    public String getConclusionConclusion4() {
        return conclusionConclusion4;
    }

    public void setConclusionConclusion4(String conclusionConclusion4) {
        this.conclusionConclusion4 = conclusionConclusion4;
    }

    public String getConclusionRoom5() {
        return conclusionRoom5;
    }

    public void setConclusionRoom5(String conclusionRoom5) {
        this.conclusionRoom5 = conclusionRoom5;
    }

    public String getConclusionConclusion5() {
        return conclusionConclusion5;
    }

    public void setConclusionConclusion5(String conclusionConclusion5) {
        this.conclusionConclusion5 = conclusionConclusion5;
    }

    public String getConclusionRoom6() {
        return conclusionRoom6;
    }

    public void setConclusionRoom6(String conclusionRoom6) {
        this.conclusionRoom6 = conclusionRoom6;
    }

    public String getConclusionConclusion6() {
        return conclusionConclusion6;
    }

    public void setConclusionConclusion6(String conclusionConclusion6) {
        this.conclusionConclusion6 = conclusionConclusion6;
    }

    public String getConclusionRoom7() {
        return conclusionRoom7;
    }

    public void setConclusionRoom7(String conclusionRoom7) {
        this.conclusionRoom7 = conclusionRoom7;
    }

    public String getConclusionConclusion7() {
        return conclusionConclusion7;
    }

    public void setConclusionConclusion7(String conclusionConclusion7) {
        this.conclusionConclusion7 = conclusionConclusion7;
    }

    public String getConclusionRoom8() {
        return conclusionRoom8;
    }

    public void setConclusionRoom8(String conclusionRoom8) {
        this.conclusionRoom8 = conclusionRoom8;
    }

    public String getConclusionConclusion8() {
        return conclusionConclusion8;
    }

    public void setConclusionConclusion8(String conclusionConclusion8) {
        this.conclusionConclusion8 = conclusionConclusion8;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(String collaborator) {
        this.collaborator = collaborator;
    }

    public int getCommentRoof() {
        return commentRoof;
    }

    public void setCommentRoof(int commentRoof) {
        this.commentRoof = commentRoof;
    }

    public int getPictureRoof() {
        return pictureRoof;
    }

    public void setPictureRoof(int pictureRoof) {
        this.pictureRoof = pictureRoof;
    }

    public int getCommentOuterwall() {
        return commentOuterwall;
    }

    public void setCommentOuterwall(int commentOuterwall) {
        this.commentOuterwall = commentOuterwall;
    }

    public int getPictureOuterwall() {
        return pictureOuterwall;
    }

    public void setPictureOuterwall(int pictureOuterwall) {
        this.pictureOuterwall = pictureOuterwall;
    }

    public int getCommentRoom() {
        return commentRoom;
    }

    public void setCommentRoom(int commentRoom) {
        this.commentRoom = commentRoom;
    }

    public int getYesNoRoomDamage() {
        return yesNoRoomDamage;
    }

    public void setYesNoRoomDamage(int yesNoRoomDamage) {
        this.yesNoRoomDamage = yesNoRoomDamage;
    }

    public int getDamageType() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }

    public int getCommentWall() {
        return commentWall;
    }

    public void setCommentWall(int commentWall) {
        this.commentWall = commentWall;
    }

    public int getPictureWall() {
        return pictureWall;
    }

    public void setPictureWall(int pictureWall) {
        this.pictureWall = pictureWall;
    }

    public int getCommentCeiling() {
        return commentCeiling;
    }

    public void setCommentCeiling(int commentCeiling) {
        this.commentCeiling = commentCeiling;
    }

    public int getPictureCeiling() {
        return pictureCeiling;
    }

    public void setPictureCeiling(int pictureCeiling) {
        this.pictureCeiling = pictureCeiling;
    }

    public int getCommentFloor() {
        return commentFloor;
    }

    public void setCommentFloor(int commentFloor) {
        this.commentFloor = commentFloor;
    }

    public int getPictureFloor() {
        return pictureFloor;
    }

    public void setPictureFloor(int pictureFloor) {
        this.pictureFloor = pictureFloor;
    }

    public int getCommentWindows() {
        return commentWindows;
    }

    public void setCommentWindows(int commentWindows) {
        this.commentWindows = commentWindows;
    }

    public int getPictureWindows() {
        return pictureWindows;
    }

    public void setPictureWindows(int pictureWindows) {
        this.pictureWindows = pictureWindows;
    }

    public int getCommentOther() {
        return commentOther;
    }

    public void setCommentOther(int commentOther) {
        this.commentOther = commentOther;
    }

    public int getPictureOther() {
        return pictureOther;
    }

    public void setPictureOther(int pictureOther) {
        this.pictureOther = pictureOther;
    }

    public int getCommentOther2() {
        return commentOther2;
    }

    public void setCommentOther2(int commentOther2) {
        this.commentOther2 = commentOther2;
    }

    public int getPictureOther2() {
        return pictureOther2;
    }

    public void setPictureOther2(int pictureOther2) {
        this.pictureOther2 = pictureOther2;
    }

    public int getHumidityYesNo() {
        return humidityYesNo;
    }

    public void setHumidityYesNo(int humidityYesNo) {
        this.humidityYesNo = humidityYesNo;
    }

    public int getCategorize() {
        return categorize;
    }

    public void setCategorize(int categorize) {
        this.categorize = categorize;
    }

    public int getRapportNr() {
        return rapportNr;
    }

    public void setRapportNr(int rapportNr) {
        this.rapportNr = rapportNr;
    }
    
    
}
