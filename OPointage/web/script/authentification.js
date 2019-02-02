//let menu = document.getElementById("menu_hidden");

$("#connect").click(() => {
    let email = $('#email').val();
    let password = $('#password').val();
    $.ajax({
        url: "AuthentificationController",
        type: "POST",
        cache: false,
        data: {email: email, password: password},
        success: function (data, textStatus, jqXHR) {
            console.log("ici " + data);
            if (data != null) {
                
                if (typeof localStorage != 'undefined') {
                    localStorage.setItem('infos', JSON.stringify(data));
                    let tab = JSON.parse(localStorage.getItem('infos'));
                    if(tab.role.libelle === "administrateur"){
                        window.location = "acceuil.jsp";
                    }else if(tab.role.libelle === "employe"){
                        window.location = "votreHistorique.jsp"
                    }
                    
                } else {
                    console.log("local n'est pas supporté");
                }

            } else {
                alert("Mot de passe ou email incorrect !");
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("error")
        }
    });
});
function clearFields() {
    $('#email').val("");
    $('#password').val("");
}


