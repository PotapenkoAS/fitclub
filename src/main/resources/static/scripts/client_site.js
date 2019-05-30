edit = false;

function editor() {
    var nameH = document.getElementById("nameH");
    var nameI = document.getElementById("nameI");
    var surnameI = document.getElementById("surnameI");
    var mailH = document.getElementById("mailH");
    var mailI = document.getElementById("mailI");
    var heightP = document.getElementById("heightP");
    var heightI = document.getElementById("heightI");
    var weightP = document.getElementById("weightP");
    var weightI = document.getElementById("weightI");
    if (!edit) {
        nameH.style.display = "none";
        nameI.style.display = "block";
        surnameI.style.display = "block";
        nameI.value = nameH.innerText.split(" ")[0];
        surnameI.value = nameH.innerText.split(" ")[1];
        mailH.style.display = "none";
        mailI.style.display = "block";
        mailI.value = mailH.innerText;
        heightP.style.display = "none";
        heightI.style.display = "block";
        heightI.value = heightP.innerText;
        weightP.style.display = "none";
        weightI.style.display = "block";
        weightI.value = weightP.innerText;
        edit = true;
    } else {
        $.ajax({
            type: "post",
            url: "/client/update",
            data: {
                name: nameI.value,
                surname: surnameI.value,
                mail: mailI.value,
                height: heightI.value,
                weight: weightI.value
            }
        });
        nameH.innerText = surnameI.value + ' ' + nameI.value;
        nameH.style.display = "block";
        nameI.style.display = "none";
        surnameI.style.display = "none";
        mailH.innerText = mailI.value;
        mailH.style.display = "block";
        mailI.style.display = "none";
        heightP.innerText = heightI.value;
        heightP.style.display = "block";
        heightI.style.display = "none";
        weightP.innerText = weightI.value;
        weightP.style.display = "block";
        weightI.style.display = "none";
        edit = false;
    }
}