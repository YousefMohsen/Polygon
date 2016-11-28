<%@page import="entity.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Domain.DomainFacade"%>
<%@page import="data.CreateRapport"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="entity.Rapport"%>
<%-- 
    Document   : rapport
    Created on : Nov 10, 2016, 4:27:45 PM
    Author     : Asger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rapport</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/rapportCss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% 
            List<Rapport> r = null;
            int id = 0;
            List<Building> buildings = null;
            if(request.getParameter("buildingID") != null) {
                try {
                    id = Integer.parseInt(request.getParameter("buildingID"));
                    if(request.getParameter("newRapport") != null) {
                        buildings = new ArrayList<>();
                        buildings.add(DomainFacade.getBuilding(id));
                    }
                    if(request.getParameter("pdf") != null) {
                        r = new ArrayList<>();
                        r.add(DomainFacade.getRapport(id));
                    }
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                    response.sendRedirect("buildingTable.jsp");
                }
            }
            if(request.getAttribute("rapportData") != null) {
                r = new ArrayList<>();
                r = (List<Rapport>) request.getAttribute("rapportData");
            } else {
                System.out.println("no data");
            }
        %>
        <div id="container">
            <form action="rapportServlet" method="post">
            <div class="pages">
                <img src="images/PolygonLogo.jpg" alt="polygon logo" class="polygologo"> 
                <img src="images/SundeBygningerLogo.jpg" alt="sundebygninger logo" class="sundebygningerlogo">
                <div class="clear"></div>

                <div class="rapportNr" id="firstRapportNR">
                        <span>Rapport nr.:</span>
                        <input type="text" name="rapportnr1" <% if(r != null) {%> value="<%= r.get(0).getRapportNr() %>" <% } %>> 
                </div>
                <h1 align="center">Bygningsgennemgang</h1>

                <div id="addressform">
                        <div class="left">
                            <input type="text" name="nameOnBuilding" <% if(r != null) {%> value="<%= r.get(0).getBuildingName() %>" <% } else { if(buildings != null) { %> value="<%= buildings.get(0).getBuildingName() %>" <% }} %>>
                            <div class="border-bot"></div>
                            <p>Navn på bygning</p>
                            <input type="text" name="address" <% if(r != null) {%> value="<%= r.get(0).getAddress() %>" <% } else { if(buildings != null) { %> value="<%= buildings.get(0).getAddress().getAddressline() %>" <% }} %>> 
                            <div class="border-bot"></div>
                            <p>Adresse</p>
                            <input type="text" name="zipCity" <% if(r != null) {%> value="<%= r.get(0).getZip() %>" <% } else { if(buildings != null) { %> value="<%= buildings.get(0).getAddress().getZipCode().getZip()%> / <%= buildings.get(0).getAddress().getZipCode().getCity()%>" <% }} %>>
                            <div class="border-bot"></div>
                            <p>Postnr./By</p>
                        </div>
                        <div class="left">
                            <%
                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                String dateString = format.format(new java.util.Date());
                            %>
                            <input type="text" name="date" value="<%= dateString %>">
                            <div class="border-bot"></div>
                            <p>Dato</p>
                        </div>
                        <img class="left" src="images/PolygonKontaktInfo.jpg" alt="kontakt info">
                        <div class="clear"></div>
                </div>
                <div id="upload-picture">
                    <p>(Indsæt billede af bygningen udefra)</p>
                        <input type="file" name="pictureOfBuilding" id="pictureOfBuilding">
                        <input type="submit" name="submitPicture" value="Upload Image">
                </div>
                <div id="general-building-info">
                    <h2>General information om bygningen</h2>
                        <div>
                            <p>Byggeår</p>
                            <input type="text" name="buildYear" <% if(r != null) {%> value="<%= r.get(0).getBuildYear() %>" <% } %>>
                            <div class="border-bot"></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <p>Bygningsareal i &#x33a1; (hver etage tælles separat)</p>
                            <input type="text" name="buildingArea" <% if(r != null) {%> value="<%= r.get(0).getBuildingArea() %>" <% } %>>
                            <div class="border-bot"></div>
                            <div class="clear"></div>                            
                        </div>
                        <div>
                            <p>Hvad bruges bygningen til / Hvad har bygningen været brugt til?</p>
                            <input type="text" name="buildingUse" <% if(r != null && r.get(0).getBuildingUse() != null) {%> value="<%= r.get(0).getBuildingUse()%>" <% } %>>
                            <div class="border-bot"></div>
                            <div class="clear"></div>
                        </div>
                </div>
                <div id="examination-building-outside">
                    <h2>Gennemgang af bygningen udvendig</h2>
                    <div>
                            <table cellspacing="0">
                                <tr>
                                    <th rowspan="2">Tag</th>
                                    <th>Bemærkninger</th>
                                    <th>Ingen bemærkninger</th>
                                    <th>Billede</th>
                                </tr>
                                <tr>
                                    <th><input type="radio" name="comments1" value="0" <% if(r != null) { if(r.get(0).getCommentRoof() == 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments1" value="1" <% if(r != null) { if(r.get(0).getCommentRoof() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="picture1" value="1" <% if(r != null) { if(r.get(0).getPictureRoof() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="roofDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionRoof() %> <% } %></textarea></th>
                                </tr>
                            </table>
                    </div>
                    <div>
                            <table cellspacing="0">
                                <tr>
                                    <th rowspan="2">Ydervægge</th>
                                    <th>Bemærkninger</th>
                                    <th>Ingen bemærkninger</th>
                                    <th>Billede</th>
                                </tr>
                                <tr>
                                    <th><input type="radio" name="comments2" value="0" <% if(r != null) { if(r.get(0).getCommentOuterwall()== 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments2" value="1" <% if(r != null) { if(r.get(0).getCommentOuterwall() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="picture2" value="1" <% if(r != null) { if(r.get(0).getPictureOuterwall() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="outerwallDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionOuterwall()%> <% } %></textarea></th>
                                </tr>
                            </table>
                    </div>
                </div>
                <div class="pageNr">
                    <p>1</p>
                </div>
                <div class="clear"></div>
            </div><!--pageOne end-->
            
            <div class="pages">
                <img src="images/PolygonLogo.jpg" alt="polygon logo" class="polygologo">
                <div class="clear"></div>

                <div class="rapportNr">
                        <span>Rapport nr.:</span>
                        <input type="text" name="rapportnr2" <% if(r != null) {%> value="<%= r.get(0).getRapportNr() %>" <% } %>> 
                </div>
                
                <div id="room-info">
                        <div>
                            <p>Lokale</p>
                            <input type="text" name="room" <% if(r != null) {%> value="<%= r.get(0).getRoom()%>" <% } %>>
                            <div id="room-info-checkbox">
                                <div class="border-left">
                                    <input type="radio" name="comment3" value="0" <% if(r != null) { if(r.get(0).getCommentRoom()== 0) {%> checked <% } } %>>
                                    <p>Bemærkninger</p>
                                </div>
                                <div class="border-left">
                                    <input type="radio" name="comment3" value="1" <% if(r != null) { if(r.get(0).getCommentRoom() == 1) {%> checked <% } } %>>
                                    <p>Ingen bemærkninger</p>
                                </div>
                            </div>
                        </div>
                </div>
                
                <div id="damage-repair">
                    <h2>Skade og reparation</h2>
                        <table cellspacing="0">
                            <tr>
                                <th>Har der været skade i lokalet?</th>
                                <th colspan="3">
                                    <div><input type="radio" name="yesNo1" value="0" <% if(r != null) { if(r.get(0).getYesNoRoomDamage() == 0) {%> checked <% } } %>> Ja</div>
                                    <div><input type="radio" name="yesNo1" value="1" <% if(r != null) { if(r.get(0).getYesNoRoomDamage() == 1) {%> checked <% } } %>> Nej</div>
                                </th>
                            </tr>
                            <tr>
                                <th>Hvornår</th>
                                <th><input type="text" name="when" <% if(r != null) {%> value="<%= r.get(0).getWhen() %>" <% } %>></th>
                                <th>Hvor</th>
                                <th><input type="text" name="where" <% if(r != null) {%> value="<%= r.get(0).getWhere() %>" <% } %>></th>
                            </tr>
                            <tr>
                                <th>Hvad er der sket</th>
                                <th><textarea name="whatHappend"><% if(r != null) {%> <%= r.get(0).getWhatHappend()%> <% } %></textarea></th>
                                <th>Hvad er repareret</th>
                                <th><textarea name="whatRepaired"><% if(r != null) {%> <%= r.get(0).getWhatRepaired()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th>Skade</th>
                                <th colspan="3">
                                    <div><input type="radio" name="damageRadio" value="1" <% if(r != null) { if(r.get(0).getDamageType()== 1) {%> checked <% } } %>> Fugt</div>
                                    <div><input type="radio" name="damageRadio" value="2" <% if(r != null) { if(r.get(0).getDamageType()== 2) {%> checked <% } } %>> Råd og swamp</div>
                                    <div><input type="radio" name="damageRadio" value="3" <% if(r != null) { if(r.get(0).getDamageType()== 3) {%> checked <% } } %>> Skimmel</div>
                                    <div><input type="radio" name="damageRadio" value="4" <% if(r != null) { if(r.get(0).getDamageType()== 4) {%> checked <% } } %>> Brand</div>
                                    <div>
                                        <input type="radio" name="damageRadio" value="5" <% if(r != null) { if(r.get(0).getDamageType()== 5) {%> checked <% } } %>> Anden skade 
                                        <input type="text" name="otherText" <% if(r != null) {%> value="<%= r.get(0).getOtherDamageType() %>" <% } %>>
                                        <div class="border-bot"></div>
                                        <div class="clear"></div>
                                    </div>
                                </th>
                            </tr>
                        </table>
                </div>
                
                <div id="examination-of">
                    <h2>Gennemgang af...</h2>
                        <table cellspacing="0">
                                <tr>
                                    <th></th>
                                    <th>Bemærkninger</th>
                                    <th>Ingen bemærkninger</th>
                                    <th>Billede</th>
                                </tr>
                                <tr>
                                    <th>Vægge</th>
                                    <th><input type="radio" name="comments4" value="0" <% if(r != null) { if(r.get(0).getCommentWall() == 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments4" value="1" <% if(r != null) { if(r.get(0).getCommentWall() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="pictureWall" value="1" <% if(r != null) { if(r.get(0).getPictureWall() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="wallDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionWall()  %> <% } %></textarea></th>
                                </tr>
                                <tr>
                                    <th>Loft</th>
                                    <th><input type="radio" name="comments5" value="0" <% if(r != null) { if(r.get(0).getCommentCeiling() == 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments5" value="1" <% if(r != null) { if(r.get(0).getCommentCeiling() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="pictureCeiling" value="1" <% if(r != null) { if(r.get(0).getPictureCeiling()== 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="ceilingDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionCeiling()%> <% } %></textarea></th>
                                </tr>
                                <tr>
                                    <th>Gulv</th>
                                    <th><input type="radio" name="comments6" value="0" <% if(r != null) { if(r.get(0).getCommentFloor() == 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments6" value="1" <% if(r != null) { if(r.get(0).getCommentFloor() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="pictureFloor" value="1" <% if(r != null) { if(r.get(0).getPictureFloor() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="floorDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionFloor() %> <% } %></textarea></th>
                                </tr>
                                <tr>
                                    <th>Vinduer/døre</th>
                                    <th><input type="radio" name="comments7" value="0"> <% if(r != null) { if(r.get(0).getCommentWindows() == 0) {%> checked <% } } %></th>
                                    <th><input type="radio" name="comments7" value="1" <% if(r != null) { if(r.get(0).getCommentWindows() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="pictureWindows" value="1" <% if(r != null) { if(r.get(0).getPictureWindows() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="windowsDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionWindows() %> <% } %></textarea></th>
                                </tr>
                                <tr>
                                    <th><input type="text" name="other" <% if(r != null) {%> value="<%= r.get(0).getOtherReview() %>" <% } %>></th>
                                    <th><input type="radio" name="comments8" value="0" <% if(r != null) { if(r.get(0).getCommentOther() == 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments8" value="1" <% if(r != null) { if(r.get(0).getCommentOther() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="pictureOther" value="1" <% if(r != null) { if(r.get(0).getPictureOther() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="otherDescription"><% if(r != null) {%> <%= r.get(0).getDescriptionOther() %> <% } %></textarea></th>
                                </tr>
                                <tr>
                                    <th><input type="text" name="other2" <% if(r != null) {%> value="<%= r.get(0).getOtherReview2()%>" <% } %>></th>
                                    <th><input type="radio" name="comments9" value="0" <% if(r != null) { if(r.get(0).getCommentOther2() == 0) {%> checked <% } } %>></th>
                                    <th><input type="radio" name="comments9" value="1" <% if(r != null) { if(r.get(0).getCommentOther2() == 1) {%> checked <% } } %>></th>
                                    <th><input type="checkbox" name="pictureOther2" value="1" <% if(r != null) { if(r.get(0).getPictureOther2() == 1) {%> checked <% } } %>></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="other2Description"><% if(r != null) {%> <%= r.get(0).getDescriptionOther2() %> <% } %></textarea></th>
                                </tr>
                            </table>
                </div>
                
                <div id="humidity-scan">
                    <h2>Fugtscanning</h2>
                        <table cellspacing="0">
                            <tr>
                                <th colspan="2">Er der foretaget fugtscanning?</th>
                                <th colspan="2">
                                    <div><input type="radio" name="yesNo2" value="0" <% if(r != null) { if(r.get(0).getHumidityYesNo() == 0) {%> checked <% } } %>> Ja</div>
                                    <div><input type="radio" name="yesNo2" value="1" <% if(r != null) { if(r.get(0).getHumidityYesNo() == 1) {%> checked <% } } %>> Nej</div>
                                </th>
                            </tr>
                            <tr>
                                <th>Fugtscanning</th>
                                <th><input type="text" name="humidityScan" <% if(r != null && r.get(0).getDescriptionScanning() != null) {%> value="<%= r.get(0).getDescriptionScanning()%>" <% } %>></th>
                                <th>Målpunkt</th>
                                <th><input type="text" name="measuring" <% if(r != null && r.get(0).getDescriptionMeasuring() != null) {%> value="<%= r.get(0).getDescriptionMeasuring()%>" <% } %>></th>
                            </tr>
                            <tr>
                                <th colspan="4"><textarea name="humidityDescription"><% if(r != null && r.get(0).getDescriptionHumidity() != null) {%><%= r.get(0).getDescriptionHumidity()%> <% } %></textarea></th>
                            </tr>
                        </table>
                </div>
                <div class="pageNr">
                    <p>2</p>
                </div>
                <div class="clear"></div>
            </div><!--pageTwo end-->
            <div class="pages">
                <img src="images/PolygonLogo.jpg" alt="polygon logo" class="polygologo">
                <div class="clear"></div>

                <div class="rapportNr">
                        <span>Rapport nr.:</span>
                        <input type="text" name="rapportnr" <% if(r != null) {%> value="<%= r.get(0).getRapportNr()%>" <% } %>> 
                </div>
                
                <div id="conclusion">
                    <h2>Konklusion</h2>
                        <table cellspacing="0">
                            <tr>
                                <th>Lokale</th>
                                <th>Anbefalinger</th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room1" <% if(r != null && r.get(0).getConclusionRoom1() != null) {%> value="<%= r.get(0).getConclusionRoom1()%>" <% } %>></th>
                                <th><textarea name="conclusion1"><% if(r != null && r.get(0).getConclusionConclusion1()!= null) {%> <%= r.get(0).getConclusionConclusion1()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room2" <% if(r != null && r.get(0).getConclusionRoom2() != null) {%> value="<%= r.get(0).getConclusionRoom2()%>" <% } %>></th>
                                <th><textarea name="conclusion2"><% if(r != null && r.get(0).getConclusionConclusion2()!= null) {%> <%= r.get(0).getConclusionConclusion2()%>" <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room3" <% if(r != null && r.get(0).getConclusionRoom3() != null) {%> value="<%= r.get(0).getConclusionRoom3()%>" <% } %>></th>
                                <th><textarea name="conclusion3"><% if(r != null && r.get(0).getConclusionRoom3()!= null) {%> <%= r.get(0).getConclusionConclusion3()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room4" <% if(r != null && r.get(0).getConclusionRoom4() != null) {%> value="<%= r.get(0).getConclusionRoom4()%>" <% } %>></th>
                                <th><textarea name="conclusion4"><% if(r != null && r.get(0).getConclusionConclusion4()!= null) {%> <%= r.get(0).getConclusionConclusion4()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room5" <% if(r != null && r.get(0).getConclusionRoom5() != null) {%> value="<%= r.get(0).getConclusionRoom5()%>" <% } %>></th>
                                <th><textarea name="conclusion5"><% if(r != null && r.get(0).getConclusionConclusion5()!= null) {%> <%= r.get(0).getConclusionConclusion5()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room6" <% if(r != null && r.get(0).getConclusionRoom6() != null) {%> value="<%= r.get(0).getConclusionRoom6()%>" <% } %>></th>
                                <th><textarea name="conclusion6"><% if(r != null && r.get(0).getConclusionConclusion6()!= null) {%> <%= r.get(0).getConclusionConclusion6()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room7" <% if(r != null && r.get(0).getConclusionRoom7() != null) {%> value="<%= r.get(0).getConclusionRoom7()%>" <% } %>></th>
                                <th><textarea name="conclusion7"><% if(r != null && r.get(0).getConclusionConclusion7()!= null) {%> <%= r.get(0).getConclusionConclusion7()%> <% } %></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room8" <% if(r != null && r.get(0).getConclusionRoom8() != null) {%> value="<%= r.get(0).getConclusionRoom8()%>" <% } %>></th>
                                <th><textarea name="conclusion8"><% if(r != null && r.get(0).getConclusionConclusion8()!= null) {%> <%= r.get(0).getConclusionConclusion8()%> <% } %></textarea></th>
                            </tr>

                        </table>
                </div>
                
                <div id="rapport-writer">
                        <p>
                            Bygningsgennemgangen er fortaget af <input type="text" name="writer" <% if(r != null && r.get(0).getWriter() != null) {%> value="<%= r.get(0).getWriter()%>" <% } %>>, Polygon<br>
                            i samarbejde med <input type="text" name="collaborator" <% if(r != null && r.get(0).getCollaborator() != null) {%> value="<%= r.get(0).getCollaborator()%>" <% } %>> (bygningsansvarlig).
                        </p> 
                </div>
                
                <div id="categorize">
                    <h2>Bygningen er katagoriseret som</h2>
                        <table cellspacing="0">
                            <tr>
                                <th>Tilstand</th>
                                <th>Beskrivelse af bygningen</th>
                                <th>Tilstandsgrad</th>
                            </tr>
                            <tr>
                                <th><span>Tilstandsgrad 1</span><br>God tilstand</th>
                                <th>Der er ingen problemer med bygningen; bygningens funktion er uden problemer</th>
                                <th><input type="radio" name="grade" value="1" <% if(r != null) { if(r.get(0).getCategorize() == 1) {%> checked <% } } %>></th>
                            </tr>
                            <tr>
                                <th><span>Tilstandsgrad 2</span><br>Middel tilstand</th>
                                <th>Der er slid og skader på bygningen eller risiko for potentielle
                                    problemer med bygningen; bygningen funktion er nedstat, eller der er
                                    risiko for, at funktionen bliver nedsat</th>
                                <th><input type="radio" name="grade" value="2" <% if(r != null) { if(r.get(0).getCategorize() == 2) {%> checked <% } } %>></th>
                            </tr>
                            <tr>
                                <th><span>Tilstandsgrad 3</span><br>Dårlig tilstand</th>
                                <th>Der er problemer med bygningen; bygningen er begyndt at forfalde,
                                    har defekte komponenter, er nedbrudt eller bør udskiftes; bygningens
                                    funktion er nedsat, eller bygningen er næsen eller helt ubrugeligt</th>
                                <th><input type="radio" name="grade" value="3" <% if(r != null) { if(r.get(0).getCategorize() == 3) {%> checked <% } } %>></th>
                            </tr>
                        </table>
                </div>
                
                <div id="bot-text">
                    <p>
                        Denne rapport og bygningsgennemgang er lavet for at klarlægge umiddelbare visuelle problemstillinger. Vores formål er at sikre, at
bygningens anvendelse kan opretholdes. Vi udbedrer ikke skader som en del af bygningsgennemgangen/rapporten. Gennemgangen
af bygningen indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i bygningen, hvis vi
finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi fremlægge anbefalinger angående yderligere tiltag så som
yderligere undersøgelser, reparationer eller bygningsopdateringer.
                    </p>
                    <p>
                        Bemærk at vi skal have adgang til hele bygningen for at kunne udføre en fuld gennemgang (dette inkluderer adgang til tag, tagrum,
kælder, krybekælder eller andre aflukkede områder). Denne bygningsgennemgang er ikke-destruktiv. Hvis der skal laves destruktive
indgreb, skal dette først godkendes af de bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller
bygningsgennemgang.
                    </p>
                    <p>
                        Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages.
                    </p>
                </div>
                
                <div class="pageNr">
                    <p>3</p>
                </div>
                <div class="clear"></div>
            </div><!--pageThree end-->
                <input type="hidden" name="buildingID" value="<%= id %>">
                <input id="back" type="submit" name="goBack" value="back">
                <input id="save" type="submit" name="createRapport" value="Gem Rapport">
            </form>
        </div><!--container end-->
    </body>
</html>
<% 
    if(request.getAttribute("rapportData") != null){
        CreateRapport cr = new CreateRapport();
        cr.createPDF(id, r.get(0).getBuildingName());
        response.sendRedirect("FrontController?ID=Servlet&switch=editBuilding&buildingID="+id);
        return;
    }
%>