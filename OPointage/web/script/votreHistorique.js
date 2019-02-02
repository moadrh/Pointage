load();

function load() {
    if (typeof localStorage != 'undefined') {
        let tab = JSON.parse(localStorage.getItem('infos'));
        console.log(tab.id);
        $.ajax({
            url: "VotreHistoriqueController",
            type: "POST",
            cache: false,
            data: {op: 'load', employe: tab.id},
            success: function (data, textStatus, jqXHR) {
                remplir(data);
                console.log("ok" + data);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error" + errorThrown);
            }
        });
    }
}

$("#date1").change(() => {
    let container = $("#mTable");
    container.empty();
});

$("#date2").change(() => {
    if (typeof localStorage != 'undefined') {
        let tab = JSON.parse(localStorage.getItem('infos'));
        let date1 = $('#date1').val();
        let date2 = $('#date2').val();
        if (date1 === "") {
             alert("Veuillez saisir la 1ere date")
        } else {
            $.ajax({
                url: "VotreHistoriqueController",
                type: "POST",
                cache: false,
                data: {op: 'between', employe: tab.id, date1: date1, date2: date2},
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                    console.log("ok" + data);

                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("error" + errorThrown);
                }
            });
        }
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
        var de = (moment(new Date(data[i][0])).format('LT'));
        var ds = (moment(new Date(data[i][1])).format('LT'));
        row += '<tr><td>' + d + '</td><td>' + data[i][2] + ' ' + data[i][3] + '</td><td>' + de + '</td><td>' + ds + '</td></tr>'

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
