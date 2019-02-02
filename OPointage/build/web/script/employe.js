load();


function load() {
    $.ajax({
        url: "EmployeController",
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
        console.log($(this).attr("pass"));
        let nom = $(this).parent().parent().children().next().html();
        let prenom = $(this).parent().parent().children().next().next().html();
        let sexe = $(this).parent().parent().children().next().next().next().html();
        let dateN = $(this).parent().parent().children().next().next().next().next().html();
        let tel = $(this).parent().parent().children().next().next().next().next().next().html();
        let adresse = $(this).parent().parent().children().next().next().next().next().next().next().html();
        let dateE = $(this).parent().parent().children().next().next().next().next().next().next().next().html();
        let email = $(this).parent().parent().children().next().next().next().next().next().next().next().next().html();

        let dN = dateN.replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$2-$1");
        let dE = dateN.replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$2-$1");
        console.log("date : " + dateE);
        $('#update').val($(this).attr("indice"));
        $('#nom').val(nom);
        $('#prenom').val(prenom);
        $('#sexe').val(sexe);
        $('#dateNaissance').val(dN);
        $('#telephone').val(tel);
        $('#adresse').val(adresse);
        $('#prenom').val(prenom);
        $('#dateEmbauche').val(dE);
        $('#email').val(email);
        $('#password').val($(this).attr("pass"));
        $('#role').val($(this).attr("num1"));
        $('#fonction').val($(this).attr("num2"));
        $('#save').html('Modifier');
    } else if ($(this).html() == "supprimer") {
        if (confirm("Voulez-vous Vraiment supprimer ce revenue ?")) {
            $.ajax({
                url: "EmployeController",
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
    let nom = $('#nom').val();
    let prenom = $('#prenom').val();
    let sexe = $('#sexe').val();
    let dateN = $('#dateNaissance').val();
    let email = $('#email').val();
    let password = $('#password').val();
    let adresse = $('#adresse').val();
    let tel = $('#telephone').val();
    let fonction = $('#fonction').val();
    let role = $('#role').val();
    let dateE = $('#dateEmbauche').val();

    let update_id = $('#update').val();
    if ($('#save').html() == "Ajouter") {
        $.ajax({
            url: "EmployeController",
            type: "POST",
            cache: false,
            data: {op: 'add', nom: nom, prenom: prenom, sexe: sexe, dateN: dateN, email: email, password: password, adresse: adresse, tel: tel, dateE: dateE, fonction: fonction, role: role},
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
            url: "EmployeController",
            type: "POST",
            cache: false,
            data: {op: 'update', nom: nom, prenom: prenom, sexe: sexe, dateN: dateN, email: email, password: password, adresse: adresse, tel: tel, dateE: dateE, fonction: fonction, role: role, id: update_id},
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
    $('#nom').val("");
    $('#prenom').val("");
    $('#sexe').val("");
    $('#adresse').val("");
    $('#email').val("");
    $('#telephone').val("");
    $('#dateNaissance').val("");
    $('#dateEmbauche').val("");
    $('#role').val("");
    $('#fonction').val("");
    $('#password').val("");

}


function remplir(data) {

    console.log(data);
    let container = $("#mTable");
    let row = "";
    for (let i = 0; i < data.length ; i++) {
        console.log("i :" + data[i]);
      
        var s = (moment(new Date(data[i].dateNaissance)).format('L').split("/"));      
        var dn = s[1] + "/" + s[0] + "/" + s[2];     
        console.log("date " + dn);
        var s1 = (moment(new Date(data[i].dateEmbauche)).format('L')).split("/");
        var de = s1[1] + "/" + s1[0] + "/" + s1[2];
        row += '<tr><td>' + data[i].id + '</td><td>' + data[i].nom + '</td><td>' + data[i].prenom + '</td><td>' + data[i].sexe + '</td><td>' + dn + '</td><td>' + data[i].telephone + '</td><td>' + data[i].adresse + '</td><td>' + de + '</td><td>' + data[i].email + '</td><td>' + data[i].role.libelle + '</td><td>' + data[i].fonction.libelle + '</td><td><button class="btn btn-round btn-danger operation" indice="' + data[i].id + '">supprimer</button></td><td><button class="btn btn-round btn-warning operation"  num1 ="' + data[i].role.id + '" num2 ="' + data[i].fonction.id + '" pass="'+ data[i].password +'" indice="' + data[i].id + '">modifier</button></td></tr>'
    }
    container.empty();
    container.html(row);
}







