offset = 0;
trainerId = 0;
window.onload = function () {
    refreshSchedule(offset)
};

function refreshSchedule(offset) {
    $.ajax({
        type: "GET",
        url: "/trainer_schedule/refresh?month_offset=" + offset + "&trainer_id=" + trainerId,
        dataType: "json",
        success: function (data) {
            var j = -1;
            var arr = [];
            arr[++j] = '  <tr>\n' +
                '            <th>Понедельник</th>\n' +
                '            <th>Вторник</th>\n' +
                '            <th>Среда</th>\n' +
                '            <th>Четверг</th>\n' +
                '            <th>Пятница</th>\n' +
                '            <th>Суббота</th>\n' +
                '            <th>Воскресенье</th>\n' +
                '        </tr>';
            for (var i = 0; i < data.length; i++) {
                arr[++j] = '<tr>';
                for (var d = 0; d < 7; d++) {
                    if (data[i].days[d].value.count > 0) {
                        arr[++j] = '<td style="background-color: #d7f3f7; border: 2px solid #cecece">';
                        arr[++j] = '<p style="position:relative; font-size: 9px" align="left">' + data[i].days[d].value.date.substr(8, 2) + '</p><a href=""><p class="tooltip">' + 'занятий: ' + data[i].days[d].value.count + '<span class="tooltiptext">' + data[i].days[d].value.text + '</span></p></a>';
                        arr[++j] = '</td>';
                    } else {
                        arr[++j] = '<td style="border: 2px solid #cecece"><p style="position:relative; font-size: 9px" align="left">' + data[i].days[d].value.date.substr(8, 2) + '</p><button id="' + i + ' ' + d + '" class="button button_new_train" onclick="change(this)">Записаться</button></td>';
                    }
                }
                arr[++j] = '<tr/>';
            }
            $('#schedule').html(arr.join(''));
        }
    })
}

function change(button) {
    var week = button.id.split(" ")[0];
    var day = button.id.split(" ")[1];
    var actId = Number(document.getElementById("activityId").value);
    var tb = document.getElementById("timeBegin").value;
    var te = document.getElementById("timeEnd").value;
    if (button.innerText === "Записаться") {
        button.innerText = "Отмена";
        button.style.color = "#d8005b";
        $.ajax({
            type: "POST",
            url: "training/new",
            data: {
                week: Number(week),
                day: Number(day),
                offset: offset,
                timeBegin: tb,
                timeEnd: te,
                activityId: actId,
                trainerId: trainerId
            }
        });
    } else {
        button.style.color = "white";
        button.innerText = "Записаться";
        $.ajax({
            type: "DELETE",
            url: "training/delete",
            data: {
                week: Number(week),
                day: Number(day),
                offset: offset,
                timeBegin: tb,
                timeEnd: te,
                activityId: actId,
                trainerId: trainerId
            }
        });
    }
}
