function send(groupId) {
    $.ajax({
        type: 'POST',
        url: '/training/new',
        data: {groupId: groupId},
        success: function (data) {
            var parsedData = data.split(',');
            if (parsedData[0] === 'No sub') {
                location = '/new_sub?activity_id=' + parsedData[1];
            } else if (parsedData[0] === "Success") {
                var button = document.getElementById('recordButton');
                button.textContent = 'nice';
                button.disabled = 'disabled';
                button.className = 'button_timetable_record_nice';
            }
        }
    })
}