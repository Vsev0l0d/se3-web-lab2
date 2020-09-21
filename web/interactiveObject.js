const zero = 175;
const rConstLenght = 150;
let x;
let y;
let r;

function draw() {
    const canvas = document.getElementById('canvas');
    if (canvas.getContext) {
        canvas.addEventListener('click', canvasClicked, false);

        function canvasClicked(e) {
            x = e.pageX - e.target.offsetLeft - zero;
            y = zero - (e.pageY - e.target.offsetTop);

            r = getR();
            if (r !== null){
                x = Math.round(x / rConstLenght * r);
                y = (y / rConstLenght * r).toFixed(5);

                if (contains([-5, -4, -3, -2, -1, 0, 1, 2, 3], x) && (-3 < y) && (y < 5)) {
                    const fieldX = document.getElementById('X_field');
                    const fieldY = document.getElementById('Y_field');

                    if (fieldX.value !== "") {
                        document.getElementById("x" + fieldX.value).classList.remove("active");
                    }
                    fieldX.value = x;
                    document.getElementById("x" + x).classList.add("active");
                    fieldY.value = y;
                    setValidMessageY("");

                    pointDraw()
                }
            } else alert("Выберете радиус");
        }
    }
}

function pointDraw() {
    const canvas = document.getElementById('canvas');
    let xCanvas = zero + x/r*rConstLenght;
    let yCanvas = zero - y/r*rConstLenght;
    if (canvas.getContext) {
        const ctx = canvas.getContext('2d');
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.beginPath();

        ctx.fillStyle = "#EDB22E";
        ctx.moveTo(125, 35);
        ctx.arc(xCanvas, yCanvas, 6, 0, 2 * Math.PI);
        ctx.fill();
    }
}

function update() {
    r = getR();
    y = document.getElementById('Y_field').value.trim().replace(",", ".");
    x = document.getElementById('X_field').value;

    if (contains(["-5", "-4", "-3", "-2", "-1", "0", "1", "2", "3"], x)
        && (y !== "") && (-3 < y) && (y < 5) &&
        contains(['1', '2', '3', '4', '5'], r)) pointDraw();
    else {
        const canvas = document.getElementById('canvas');
        if (canvas.getContext) {
            const ctx = canvas.getContext('2d');
            ctx.clearRect(0, 0, canvas.width, canvas.height);
        }
    }
}

function contains(a, obj) {
    for (let i = 0; i < a.length; i++) {
        if (a[i] === obj)
            return true;
    }
    return false;
}