$(document).ready(function () {
    let titre = $('#mot');
   // let menu = document.getElementById("menu_hidden");
    if (typeof localStorage !== 'undefined') {
        let tab = JSON.parse(localStorage.getItem('infos'));
       // console.log(tab.fonction.libelle);
          titre.append(tab.nom + ' ' + tab.prenom );
    } else {
        alert("local storage n'est pas supporté");
    }

});


