load();

function load() {
    $.ajax({
        url: "RoleController",
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
    if ($(this).html() == "modifier") {
        let code = $(this).parent().parent().children().next().html();
        let libelle = $(this).parent().parent().children().next().next().html();
        $('#update').val($(this).attr("indice"));
        $('#code').val(code);
        $('#libelle').val(libelle);
        $('#save').html('Modifier');
    } else if ($(this).html() == "supprimer") {
        if (confirm("Voulez-vous Vraiment supprimer cet appartement ?")) {
            $.ajax({
                url: "RoleController",
                type: "POST",
                cache: false,
                data: {op: 'delete', id: $(this).attr("indice")},
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
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
    let libelle = $('#libelle').val();
    let code = $('#code').val();
    let update_id = $('#update').val();
    if ($('#save').html() == "Ajouter") {
        $.ajax({
            url: "RoleController",
            type: "POST",
            cache: false,
            data: {op: 'add', code: code, libelle: libelle},
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                remplir(data);
                clearFields();

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error")
            }
        });
    } else if ($('#save').html() == "Modifier") {

        $.ajax({
            url: "RoleController",
            type: "POST",
            cache: false,
            data: {op: 'update', code:code, libelle: libelle, id: update_id},
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
    $('#code').val("");
    $('#libelle').val("");

}

function remplir(data) {

    console.log(data);
    let container = $("#mTable");
    let row = "";
    for (let i = 0; i < data.length; i++) {
        console.log("i :" + data[i]);
        row += '<tr><td>' + data[i].id + '</td><td>' + data[i].code + '</td><td>' + data[i].libelle + '</td><td><button class="btn btn-round btn-danger operation" indice="' + data[i].id + '">supprimer</button></td><td><button class="btn btn-round btn-warning operation"  indice="' + data[i].id + '">modifier</button></td></tr>'
    }
    
    container.empty();
    container.html(row);
}





