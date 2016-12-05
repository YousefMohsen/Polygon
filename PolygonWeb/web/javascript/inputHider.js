var inputs = document.getElementsByTagName("INPUT");
function lock() {
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].disabled = true;
    }
}
function unlock() {
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].disabled = false;
    }
}

window.onload = function () {
    lock();
};