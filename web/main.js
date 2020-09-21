function checkY() {
    let y = document.getElementById('Y_field').value.trim().replace(",", ".");
    if (y === ""){
        document.getElementById('labelY').className = "input-group-text bg-danger text-white";
        return false
    } else if (!isFinite(y) || y === "-0"){
        setValidMessageY("Должно быть числом");
        document.getElementById('labelY').className = "input-group-text bg-warning text-white";
        return false
    } else if (y > 5 || y < -3){
        setValidMessageY("Должно быть в диапазоне (-3; 5)");
        document.getElementById('labelY').className = "input-group-text bg-warning text-white";
        return false
    }

    document.getElementById('labelY').className = "input-group-text";
    return true
}

function setValidMessageY(message) {
    const fieldMessage = document.getElementById('fieldMessageY');
    if (message.trim() === ""){
        fieldMessage.className = "";
        fieldMessage.innerHTML = "";
    } else {
        fieldMessage.className = "alert alert-dark";
        fieldMessage.innerHTML = message;
    }

}


function removeClaimsForY() {
    setValidMessageY("");
    document.getElementById('labelY').className = "input-group-text";
}

function getR() {
    const R = document.querySelector('input[name="r_field"]:checked');
    document.querySelector('input[name="r_field"]:checked');
    if(R !== null){
        document.getElementById('labelR').className = "input-group-text";
        return  R.value;
    }
    return null
}

function xChoose(x) {
    const X_field = document.getElementById('X_field');
    if (X_field.value === x) {
        X_field.value = "";
        document.getElementById("x" + x).classList.remove("active");
    } else {
        if (X_field.value !== "") {
            document.getElementById("x" + X_field.value).classList.remove("active");
        }
        X_field.value = x;
        document.getElementById("x" + x).classList.add("active");
        document.getElementById('labelX').className = "input-group-text";
    }
    update()
}

const submit_btn = function(e) {
    const rValue = getR();
    const xValue = document.getElementById('X_field').value;
    if (!(checkY() && (rValue != null) && (xValue !== "") )) e.preventDefault();

    if (xValue === "") document.getElementById('labelX').className = "input-group-text bg-danger text-white";
    if (rValue == null) document.getElementById('labelR').className = "input-group-text bg-danger text-white";
};

document.addEventListener('DOMContentLoaded', function(){
    document.getElementById('submitButton').addEventListener('click', submit_btn);
});