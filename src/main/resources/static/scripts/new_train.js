offset = 0;
trainerId = 0;
window.onload = function () {
    refreshSchedule(offset())

};


function refreshSchedule(offset) {
    $.ajax({
        type: "GET",
        url: "/trainer_schedule/refresh?month_offset=" + offset + "&trainer_id=" + trainerId,
        dataType: "json",
        success: function (data) {
            var j = -1;
            var dayCounter = 0;
            var arr = [];
            for (var i = 0; i < data.length; i++) {
                arr[++j] = '<tr>';
                if (data[i].days.MONDAY.count > 0){
                    arr[++j] = '<td style="background-color: aqua">';
                    arr[++j] = '<a href=""><p class="tooltip">' +data[i].days.MONDAY.count+' занятий<span class="tooltiptext">' + 'data[i].days.MONDAY.text' + '</span></p></a>'
                    arr[++j] = '<td/><td>';
                }

            }
        }
    })
}