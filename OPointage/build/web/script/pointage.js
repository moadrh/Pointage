load();

function load() {
//    var date1 = new Date("7/13/2010 12:00");
//    var date2 = new Date("12/15/2010 12:00");
//    var timeDiff = Math.abs(date2.getTime() - date1.getTime());
//    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
    $.ajax({
        url: "PointageController",
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

$('#mTable').on("click", ".operation", function () {
    let employe1 = $('#employe1').val();
    let date1 = $('#date1').val();
    let date2 = $('#date2').val();
    if ($(this).html() == "modifier") {
        let r, d, s, m;
        let date = $(this).parent().parent().children().next().html();
        let etat = $(this).parent().parent().children().next().next().html();
        let n = date.length;
        if (n === 19) {
            r = date.slice(11, 16);
            d = date.replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$2-$1");
            s = d.slice(0, 10);
            m = s + "T" + r;
        } else {
            r = date.slice(11, 15);
            d = date.replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$2-$1");
            s = d.slice(0, 10);
            m = s + "T0" + r;
        }

        //  let f = date.format(LT);

        console.log(" dd " + n);
        $('#update').val($(this).attr("indice"));
        $('#date').val(m);
        $('#etat').val(etat);
        $('#employe').val($(this).attr("num"));
        $('#save').html('Modifier');
    } else if ($(this).html() == "supprimer") {
        if (confirm("Voulez-vous Vraiment supprimer ce pointage ?")) {
            $.ajax({
                url: "PointageController",
                type: "POST",
                cache: false,
                data: {op: 'delete', id: $(this).attr("indice"), employe1: employe1, date1: date1, date2: date2},
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                    //  clearFields();
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

$("#save").click(() => {
    let date = $('#date').val();
    let etat = $('#etat').val();
    let employe = $('#employe').val();
    let update_id = $('#update').val();
    if ($('#save').html() == "Ajouter") {
        $.ajax({
            url: "PointageController",
            type: "POST",
            cache: false,
            data: {op: 'add', date: date, etat: etat, employe: employe},
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                remplir(data);
                remplirCombobox2();
                clearFields();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    } else if ($('#save').html() == "Modifier") {

        $.ajax({
            url: "PointageController",
            type: "POST",
            cache: false,
            data: {op: 'update', date: date, etat: etat, employe: employe, id: update_id},
            success: function (data, textStatus, jqXHR) {
                remplir(data);
                console.log("data update : " + data);
                clearFields();
                $('#save').html("Ajouter");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    }


});

function clearFields() {
    $('#date').val("");
    $('#etat').val("");
    $('#employe').val("");
    $('#date1').val("");
    $('#date2').val("");
    $('#employe1').val("");

}

$("#employe").change(() => {
    let employe = $('#employe').val();
    $.ajax({
        url: "PointageController",
        type: "POST",
        cache: false,
        data: {op: 'list', employe: employe},
        success: function (data, textStatus, jqXHR) {
            console.log(data.etat);
            if (data.etat === "entree") {
                remplirCombobox();
            }else{
                remplirCombobox2();
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("error")
        }
    });
});


$("#employe1").change(() => {
    let date1 = $('#date1').val();
    let date2 = $('#date2').val();
    let employe1 = $('#employe1').val();
    console.log(" " + date1 + " " + date2 + " " + employe1);
    if (date1 == "" && date2 == "") {
        $.ajax({
            url: "PointageController",
            type: "POST",
            cache: false,
            data: {op: 'employe', employe1: employe1},
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
            url: "PointageController",
            type: "POST",
            cache: false,
            data: {op: 'between', date1: date1, date2: date2, employe1: employe1},
            success: function (data, textStatus, jqXHR) {
                console.log("jjhjhj");
                console.log(data);
                remplir(data);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    }

});


function show() {
    let checkbox = document.getElementById("box");
    let dates = document.getElementById("dates");

    if (checkbox.checked) {
        dates.hidden = false;
    } else {
        dates.hidden = true;
    }
}
function remplir(data) {
    console.log(data);
    let container = $("#mTable");
    let row = "";
    for (let i = 0; i < data.length; i++) {
        console.log("i :" + data[i]);
        var s = (moment(new Date(data[i].date)).format('L')).split("/");
        var d = s[1] + "/" + s[0] + "/" + s[2];
        var t = (moment(new Date(data[i].date)).format('LT'));
        var r = d + " " + t
        console.log("gfg" + r);
        row += '<tr><td>' + data[i].id + '</td><td>' + data[i].date + '</td><td>' + data[i].etat + '</td><td>' + data[i].employe.nom + ' ' + data[i].employe.prenom + '</td><td><button class="btn btn-round btn-danger operation" indice="' + data[i].id + '">supprimer</button></td><td><button class="btn btn-round btn-warning operation"  num ="' + data[i].employe.id + '" indice="' + data[i].id + '">modifier</button></td></tr>'

    }
    container.empty();
    container.html(row);
}

function remplirCombobox() {
    let combo = $("#etat");
    let option = "";

    option = '<option value="sortie" >Sortie</option>'
    combo.empty();
    combo.html(option);

}
function remplirCombobox2() {
    let combo = $("#etat");
    let option = "";

    option = '<option value="hidden">Choisit un état</option><option value="sortie" >Sortie</option><option value="entree" >Entrée</option>'
    combo.empty();
    combo.html(option);

}


