

$("#employe").change(() => {
    let date1 = $('#date1').val();
    let date2 = $('#date2').val();
    let employe = $('#employe').val();
    console.log(" " + date1 + " " + date2 + " " + employe);
    if (date1 == "" && date2 == "") {
        $.ajax({
            url: "RecherchePointage",
            type: "POST",
            cache: false,
            data: {op: 'employe', employe: employe},
            success: function (data, textStatus, jqXHR) {
                console.log("jjhjhj");
                console.log(data);
                remplirCombobox(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    } else {
        $.ajax({
            url: "RecherchePointage",
            type: "POST",
            cache: false,
            data: {op: 'between', date1: date1, date2: date2, employe: employe},
            success: function (data, textStatus, jqXHR) {
                console.log("jjhjhj");
                console.log(data);
                remplirCombobox(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    }
   
});

function clearFields() {
    $('#date1').val("");
    $('#date2').val("");
    $('#employe').val("");

}

function remplirCombobox(data) {

    console.log(data);
    let container = $("#mTable");
    let row = "";
    for (let i = 0; i < data.length; i++) {
        console.log("i :" + data[i]);
        var s = (moment(new Date(data[i].date)).format('L')).split("/");
        var d = s[1] + "/" + s[0] + "/" + s[2];
        var t = (moment(new Date(data[i].date)).format('LT'));
        var r = d + " " + t
        row += '<tr><td>' + data[i].id + '</td><td>' + r + '</td><td>' + data[i].etat + '</td><td>' + data[i].employe.nom + '</td><td>' + data[i].employe.prenom + '</td><td><button class="btn btn-gradient-danger mr-2 operation" num="' + data[i].employe.id + '"indice="' + data[i].id + '">supprimer</button></td></tr>'
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
$('#mTable').on("click", ".operation", function () {
    if ($(this).html() == "supprimer") {
        if (confirm("Voulez-vous Vraiment supprimer ce pointage ?")) {
            $.ajax({
                url: "RecherchePointage",
                type: "POST",
                cache: false,
                data: {op: 'delete', id: $(this).attr("indice") ,employe :$(this).attr("num")},
                success: function (data, textStatus, jqXHR) {
                    remplirCombobox(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("error")
                }
            });
            return true;
        } else {
            return false;
        }
    }
});
