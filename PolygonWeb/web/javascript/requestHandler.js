/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var deletionRequest = function(){
    
    var txt;
var r = confirm("Please confirm the deletion of the building!");
if (r == true) {
    document.getElementById("deletionForm").submit();
    
    alert("Deletion request sent to Polygon.");
} else {
   
}

    
    
};

