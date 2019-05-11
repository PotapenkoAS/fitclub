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
            inputs[i].value = "0";
        }
    } else {
        date.style.display = "none";
        count.style.display = "inline";
        inputs = document.getElementsByClassName("dateInput");
        for (i = 0; i < inputs.length; i++) {
            inputs[i].value = "0";
        }
    }
}

function refreshSelect() {
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

    })
}