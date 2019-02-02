load();

function load() {
    $.ajax({
        url: "TotalHeureController",
        type: "POST",
        cache: false,
        data: {op: 'load'},
        success: function (data, textStatus, jqXHR) {
            remplir(data);
            console.log("ok" + data);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("error" + errorThrown);
        }
    });
}

$("#employe").change(() => {
    let employe = $('#employe').val();
    let date1 = $('#date1').val();
    let date2 = $('#date2').val();
    if (date1 == "" && date2 == "") {
        $.ajax({
            url: "TotalHeureController",
            type: "POST",
            cache: false,
            data: {op: 'employe', employe: employe},
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                remplir(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    } else {
        $.ajax({
            url: "TotalHeureController",
            type: "POST",
            cache: false,
            data: {op: 'between', date1: date1, date2: date2, employe: employe},
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                remplir(data);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    }
});



function remplir(data) {
    console.log(data);
    let container = $("#mTable");
    let row = "";
    for (let i = 0; i < data.length; i++) {
        console.log("i :" + data[i]);
        var s = (moment(new Date(data[i][0])).format('L')).split("/");
        var d = s[1] + "/" + s[0] + "/" + s[2];
        var h1 = Math.floor(data[i][4] / 60);
        console.log(h1);
        var min = data[i][4] % 60;
        console.log(min);
        var heure = data[i][3] + h1;
        console.log(heure);
        row += '<tr><td>' + d + '</td><td>' + data[i][1] + ' ' + data[i][2] + '</td><td>' + heure + ' h  ' + min + ' min' + '</td></tr>'

    }
    container.empty();
    container.html(row);
}

function show() {
    let checkbox = document.getElementById("box");
    let dates = document.getElementById("dates");

    if (checkbox.checked) {
        dates.hidden = false;
    } else {
        dates.hidden = true;
    }
}


