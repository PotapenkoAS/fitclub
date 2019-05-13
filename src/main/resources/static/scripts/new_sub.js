var py;
var pm;
var pw;
var pt;

function change(value) {
    var count = document.getElementById("countDiv");
    var date = document.getElementById("dateDiv");
    var i = 0;
    var inputs;
    if (value === 1) {
        date.style.display = "inline";
        count.style.display = "none";
        inputs = document.getElementsByClassName("countInput");
        for (i = 0; i < inputs.length; i++) {
            inputs[i].value = null;
        }
        recount();
    } else {
        date.style.display = "none";
        count.style.display = "inline";
        inputs = document.getElementsByClassName("dateInput");
        for (i = 0; i < inputs.length; i++) {
            inputs[i].value = null;
        }
        recount();
    }
}


function refresh() {
    var activityId = document.getElementById("activities").value;
    $.ajax({
        type: 'GET',
        url: "/new_sub/trainerRefresh?activityId=" + activityId,
        dataType: "json",
        success: function r(data) {
            var trainerSelect = document.getElementById("trainers");
            var i;
            for (i = trainerSelect.options.length - 1; i >= 0; i--) {
                trainerSelect.remove(i);
            }
            for (i = 0; i < data.length; i++) {
                var obj = document.createElement('option');
                obj.value = data[i].value;
                obj.text = data[i].text;
                trainerSelect.options.add(obj);
            }
        }
    });
    var price = document.getElementById("price");
    $.ajax({
        type: "GET",
        url: "/new_sub/priceRefresh?activityId=" + activityId,
        dataType: "json",
        success: function (data) {
            py = data.priceForYear;
            pm = data.priceForMonth;
            pw = data.priceForWeek;
            pt = data.priceForTrain;
            recount();
            price.innerText = "За год: " + py + "Р. За месяц: " + pm + "Р. За неделю: " + pw + "Р. За тренировку: " + pt + "Р";
        }
    });
}


function recount() {
    var y = document.getElementById("year").value;
    if (y === null || y === "") {
        y = 0;
    }
    var m = document.getElementById("month").value;
    if (m === null || m === "") {
        m = 0;
    }
    var w = document.getElementById("week").value;
    if (w === null || w === "") {
        w = 0;
    }
    var c = document.getElementById("count").value;
    if (c === null || c === "") {
        c = 0;
    }
    var totalPrice = document.getElementById("totalPrice");
    var total;
    if (y === 0 && m === 0 && w === 0) {
        if (c === 0) {
            total = 0;
        } else {
            total = c * pt;
        }
    } else {
        total = y * py + m * pm + w * pw;
    }
    totalPrice.innerText = "Итого: " + total + "Р";
}

