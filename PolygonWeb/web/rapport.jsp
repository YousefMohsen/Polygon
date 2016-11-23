<%@include file="include/loginControl.jsp" %>
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
        <div id="container">
            <form action="rapportServlet" method="post">
            <div class="pages">
                <img src="images/PolygonLogo.jpg" alt="polygon logo" class="polygologo"> 
                <img src="images/SundeBygningerLogo.jpg" alt="sundebygninger logo" class="sundebygningerlogo">
                <div class="clear"></div>

                <div class="rapportNr" id="firstRapportNR">
                        <span>Rapport nr.:</span>
                        <input type="text" name="rapportnr1"> 
                </div>
                <h1 align="center">Bygningsgennemgang</h1>

                <div id="addressform">
                        <div class="left">
                            <input type="text" name="nameOnBuilding">
                            <div class="border-bot"></div>
                            <p>Navn på bygning</p>
                            <input type="text" name="address"> 
                            <div class="border-bot"></div>
                            <p>Adresse</p>
                            <input type="text" name="zipCity">
                            <div class="border-bot"></div>
                            <p>Postnr./By</p>
                        </div>
                        <div class="left">
                            <input type="text" name="date">
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
                            <input type="text" name="buildYear">
                            <div class="border-bot"></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <p>Bygningsareal i &#x33a1; (hver etage tælles separat)</p>
                            <input type="text" name="buildingArea">
                            <div class="border-bot"></div>
                            <div class="clear"></div>                            
                        </div>
                        <div>
                            <p>Hvad bruges bygningen til / Hvad har bygningen været brugt til?</p>
                            <input type="text" name="buildingUse">
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
                                    <th><input type="radio" name="comments1" value="0"></th>
                                    <th><input type="radio" name="comments1" value="1"></th>
                                    <th><input type="checkbox" name="picture1" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="roofDescription"></textarea></th>
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
                                    <th><input type="radio" name="comments2" value="0"></th>
                                    <th><input type="radio" name="comments2" value="1"></th>
                                    <th><input type="checkbox" name="picture2" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="outerwallDescription"></textarea></th>
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
                        <input type="text" name="rapportnr2"> 
                </div>
                
                <div id="room-info">
                        <div>
                            <p>Lokale</p>
                            <input type="text" name="room">
                            <div id="room-info-checkbox">
                                <div class="border-left">
                                    <input type="radio" name="comment3" value="0">
                                    <p>Bemærkninger</p>
                                </div>
                                <div class="border-left">
                                    <input type="radio" name="comment3" value="1">
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
                                    <div><input type="radio" name="yesNo1" value="0"> Ja</div>
                                    <div><input type="radio" name="yesNo1" value="1"> Nej</div>
                                </th>
                            </tr>
                            <tr>
                                <th>Hvornår</th>
                                <th><input type="text" name="when"></th>
                                <th>Hvor</th>
                                <th><input type="text" name="where"></th>
                            </tr>
                            <tr>
                                <th>Hvad er der sket</th>
                                <th><textarea name="whatHappend"></textarea></th>
                                <th>Hvad er repareret</th>
                                <th><textarea name="whatRepaired"></textarea></th>
                            </tr>
                            <tr>
                                <th>Skade</th>
                                <th colspan="3">
                                    <div><input type="radio" name="damageRadio" value="0"> Fugt</div>
                                    <div><input type="radio" name="damageRadio" value="1"> Råd og swamp</div>
                                    <div><input type="radio" name="damageRadio" value="2"> Skimmel</div>
                                    <div><input type="radio" name="damageRadio" value="3"> Brand</div>
                                    <div>
                                        <input type="radio" name="damageRadio" value="4"> Anden skade 
                                        <input type="text" name="otherText">
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
                                    <th><input type="radio" name="comments4" value="0"></th>
                                    <th><input type="radio" name="comments4" value="1"></th>
                                    <th><input type="checkbox" name="pictureWall" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="wallDescription"></textarea></th>
                                </tr>
                                <tr>
                                    <th>Loft</th>
                                    <th><input type="radio" name="comments5" value="0"></th>
                                    <th><input type="radio" name="comments5" value="1"></th>
                                    <th><input type="checkbox" name="pictureCeiling" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="ceilingDescription"></textarea></th>
                                </tr>
                                <tr>
                                    <th>Gulv</th>
                                    <th><input type="radio" name="comments6" value="0"></th>
                                    <th><input type="radio" name="comments6" value="1"></th>
                                    <th><input type="checkbox" name="pictureFloor" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="floorDescription"></textarea></th>
                                </tr>
                                <tr>
                                    <th>Vinduer/døre</th>
                                    <th><input type="radio" name="comments7" value="0"></th>
                                    <th><input type="radio" name="comments7" value="1"></th>
                                    <th><input type="checkbox" name="pictureWindows" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="windowsDescription"></textarea></th>
                                </tr>
                                <tr>
                                    <th><input type="text" name="other"></th>
                                    <th><input type="radio" name="comments8" value="0"></th>
                                    <th><input type="radio" name="comments8" value="1"></th>
                                    <th><input type="checkbox" name="pictureOther" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="otherDescription"></textarea></th>
                                </tr>
                                <tr>
                                    <th><input type="text" name="other2"></th>
                                    <th><input type="radio" name="comments9" value="0"></th>
                                    <th><input type="radio" name="comments9" value="1"></th>
                                    <th><input type="checkbox" name="pictureOther2" value="1"></th>
                                </tr>
                                <tr>
                                    <th colspan="4"><textarea name="other2Description"></textarea></th>
                                </tr>
                            </table>
                </div>
                
                <div id="humidity-scan">
                    <h2>Fugtscanning</h2>
                        <table cellspacing="0">
                            <tr>
                                <th colspan="2">Er der foretaget fugtscanning?</th>
                                <th colspan="2">
                                    <div><input type="radio" name="yesNo2" value="0"> Ja</div>
                                    <div><input type="radio" name="yesNo2" value="1"> Nej</div>
                                </th>
                            </tr>
                            <tr>
                                <th>Fugtscanning</th>
                                <th><input type="text" name="humidityScan"></th>
                                <th>Målpunkt</th>
                                <th><input type="text" name="measuring"></th>
                            </tr>
                            <tr>
                                <th colspan="4"><textarea name="humidityDescription"></textarea></th>
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
                        <input type="text" name="rapportnr"> 
                </div>
                
                <div id="conclusion">
                    <h2>Konklusion</h2>
                        <table cellspacing="0">
                            <tr>
                                <th>Lokale</th>
                                <th>Anbefalinger</th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room1"></th>
                                <th><textarea name="conclusion1"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room2"></th>
                                <th><textarea name="conclusion2"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room3"></th>
                                <th><textarea name="conclusion3"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room4"></th>
                                <th><textarea name="conclusion4"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room5"></th>
                                <th><textarea name="conclusion5"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room6"></th>
                                <th><textarea name="conclusion6"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room7"></th>
                                <th><textarea name="conclusion7"></textarea></th>
                            </tr>
                            <tr>
                                <th><input type="text" name="room8"></th>
                                <th><textarea name="conclusion8"></textarea></th>
                            </tr>

                        </table>
                </div>
                
                <div id="rapport-writer">
                        <p>
                            Bygningsgennemgangen er fortaget af <input type="text" name="writer">, Polygon<br>
                            i samarbejde med <input type="text" name="collaborator"> (bygningsansvarlig).
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
                                <th><input type="radio" name="grade" value="1"></th>
                            </tr>
                            <tr>
                                <th><span>Tilstandsgrad 2</span><br>Middel tilstand</th>
                                <th>Der er slid og skader på bygningen eller risiko for potentielle
                                    problemer med bygningen; bygningen funktion er nedstat, eller der er
                                    risiko for, at funktionen bliver nedsat</th>
                                <th><input type="radio" name="grade" value="2"></th>
                            </tr>
                            <tr>
                                <th><span>Tilstandsgrad 3</span><br>Dårlig tilstand</th>
                                <th>Der er problemer med bygningen; bygningen er begyndt at forfalde,
                                    har defekte komponenter, er nedbrudt eller bør udskiftes; bygningens
                                    funktion er nedsat, eller bygningen er næsen eller helt ubrugeligt</th>
                                <th><input type="radio" name="grade" value="3"></th>
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
                <input id="save" type="submit" name="createRapport" value="Gem Rapport">
            </form>
        </div><!--container end-->
    </body>
</html>