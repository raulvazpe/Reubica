
$(document).ready(function() {
  cambiarLogin()
});



//? =============================================== LOGIN


/* VAREAVEIS DE FADE PARA EL MODAL LOGIN */
let loginToogle = $(".contanier-login");
let loginVisible = false;

/* FUNCTION FADE PARA EL MODAL LOGIN */
function iniciarSesion() {
  $("main").css("filter", "blur(4px)");
  loginToogle.fadeIn();
  loginToogle.animate({ top: "50%" });
  disableScroll();
  loginVisibleAdmin = true;
  $(".nav-telefono").hide();
}

//? =============================================== NAV TELEFONO

var nav = $(".nav-telefono");

$(window).resize(function () {
  if ($(window).width() >= 1025) {
    nav.hide();
  }
});

function navToggle() {
  console.log('LLAMADA');
  if(nav.is(":visible")){
    nav.slideUp();

  }else{
    nav.slideDown();
  }


}

//? =============================================== FILTRO DOWN

var containerActive = false;
let containerFiltro = $(".change-filter");

$(window).resize(function () {
  if ($(window).width() >= 1025) {
    containerFiltro.show();
  } else {
    containerFiltro.hide();
  }
});

function filtroDown() {
  let containerFiltro = $(".change-filter");

  if (!containerActive) {
    containerFiltro.slideDown();
    containerActive = true;
  } else {
    containerFiltro.slideUp();
    containerActive = false;
  }
}

//? =============================================== LOGIN ADMIN
/* VAREAVEIS DE FADE PARA EL MODAL LOGIN */
let loginToogleAdmin = $(".contanier-login-admin");
let loginVisibleAdmin = false;

/* FUNCTION FADE PARA EL MODAL LOGIN */
function loginAdmin() {
  $("main").css("filter", "blur(4px)");
  backToTop();
  loginToogleAdmin.fadeIn();
  loginToogleAdmin.animate({ top: "50%" });
  disableScroll();
  loginVisibleAdmin = true;
}

/* VAREAVEIS DE FADE PARA EL MODAL LOGIN */
let contactoToogle = $(".contanier-contacto");
let modalContacto = false;


$('.contacto').on('click',function(e){
  $("main").css("filter", "blur(4px)");
  contactoToogle.fadeIn();
  contactoToogle.animate({ top: "50%" });
  loginVisibleAdmin = true;

  let nombreperro = $(this).attr('data-nombre');



  $('#t-nombrec').html(nombreperro)


});




function cerrarModalContacto() {
  $("main").css("filter", "none");
  contactoToogle.animate({ top: "-100%" });
  contactoToogle.fadeOut();
  enableScroll();
}

//? =============================================== NUEVO PERRO
/* VAREAVEIS DE FADE PARA EL MODAL NUEVO PERRO */
let NuevoPerroToogle = $(".container-nuevoPerro");
let btnNuevoPerro = $("#nuevoPerro");
let modalNuevoPerroVisible = false;

/* FUNCTION DE FADE PARA EL MODAL NUEVO PERRO */
btnNuevoPerro.click(function () {
  $("main").css("filter", "blur(4px)");
  NuevoPerroToogle.fadeIn();
  modalNuevoPerroVisible = true;
});

//? =============================================== CERRAR MODALES
/*  FUNTION PARA CERRAR EL MODAL [LOGIN] AL HACER UN CLICK FUERA  */
$("main").click(function () {
  if (loginVisible || loginVisibleAdmin) {
    loginToogleAdmin.animate({ top: "70%" });
    loginToogleAdmin.fadeOut();
    loginToogle.animate({ top: "70%" });
    loginToogle.fadeOut();
    $("main").css("filter", "none");
    loginVisible = false;
    enableScroll();
  }
});

/*  FUNTION PARA CERRAR EL MODAL NUEVO PERRO AL HACER UN CLICK EN EL BOTON [X]  */
$("#cerrarModalCperros").click(function () {
  if (modalNuevoPerroVisible) {
    NuevoPerroToogle.fadeOut();
    $("main").css("filter", "none");
    modalNuevoPerroVisible = false;
  }
});

//? =============================================== BLOQUEAR SCROLL

var keys = { 37: 1, 38: 1, 39: 1, 40: 1 };

function preventDefault(e) {
  e.preventDefault();
}

function preventDefaultForScrollKeys(e) {
  if (keys[e.keyCode]) {
    preventDefault(e);
    return false;
  }
}

// modern Chrome requires { passive: false } when adding event
var supportsPassive = false;
try {
  window.addEventListener(
    "test",
    null,
    Object.defineProperty({}, "passive", {
      get: function () {
        supportsPassive = true;
      },
    })
  );
} catch (e) {}

var wheelOpt = supportsPassive ? { passive: false } : false;
var wheelEvent =
  "onwheel" in document.createElement("div") ? "wheel" : "mousewheel";

// call this to Disable
function disableScroll() {
  window.addEventListener("DOMMouseScroll", preventDefault, false); // older FF
  window.addEventListener(wheelEvent, preventDefault, wheelOpt); // modern desktop
  window.addEventListener("touchmove", preventDefault, wheelOpt); // mobile
  window.addEventListener("keydown", preventDefaultForScrollKeys, false);
}

// call this to Enable
function enableScroll() {
  window.removeEventListener("DOMMouseScroll", preventDefault, false);
  window.removeEventListener(wheelEvent, preventDefault, wheelOpt);
  window.removeEventListener("touchmove", preventDefault, wheelOpt);
  window.removeEventListener("keydown", preventDefaultForScrollKeys, false);
}

//? =============================================== FUNCTION - BOTON VOLVER AL TOPO

let mybutton = document.getElementById("btn-back-to-top");

window.onscroll = function () {
  scrollFunction();
};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

mybutton.addEventListener("click", backToTop);

function backToTop() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}

//? =============================================== FUNCTION PARA ATUALIZAR EL AÑO DEL FILTRO DE EDAD
var valorEdadFiltro 
function changeVar(value) {

  valorEdadFiltro = value;

  $("#rangeField").css("--progressW", value);
  if (value == 0) {
    $("#hasta").html("Todos");
    $("#output").html("");
    $("#años").html("");
  } else if (value == 10) {
    $("#hasta").html("Todos");
    $("#output").html("");
    $("#años").html("");
  } else {
    $("#hasta").html("Hasta ");
    $("#output").html(value);
    $("#años").html(" año(s)");
  }






}
  
//? =============================================== FILTRO


function filtrar() {


  $( ".cartaperro" ).each(function( index ) {



    //! VALOR FILTROS
    let macho =  $("#box-1").is(":checked")
    let hembra = $("#box-2").is(":checked")
    let pequeno =  $("#box-3").is(":checked")
    let mediano = $("#box-4").is(":checked")
    let grande =  $("#box-5").is(":checked")

    $( this ).show()
    
    //! VARS - PERROS
    // EDAD - PERROS
    let edadPerro = parseInt($( this ).find( ".edadPerro" ).text())
    // SEXO - PERROS
    let sexoPerros = $( this ).find( ".sexo" ).attr('id')
    // TAMAÑO - PERROS
    let tamanoPerros = $( this ).find( ".size" ).text()
    

    //? FILTRAR SEXO
    if (macho && hembra){

    }else if (hembra){
      if (sexoPerros != "hembra"){
        $( this ).hide()
      }
    }else if (macho){
      if (sexoPerros != "macho"){
        $( this ).hide()
      }
    }
    //? FILTRAR EDAD
    if(valorEdadFiltro > 0){
      if(valorEdadFiltro == 10){

      } else if (edadPerro > valorEdadFiltro){
      $( this ).hide()
      } 
    }
    
    //? FILTRAR TAMAÑO
    if (pequeno && mediano && grande){

    }else if (pequeno && mediano){
      if (tamanoPerros == "Grande"){
        $( this ).hide()
      }
    }else if (pequeno && grande){
      if (tamanoPerros == "Mediano"){
        $( this ).hide()
      }
    }else if (mediano && grande){
      if (tamanoPerros == "Pequeño"){
        $( this ).hide()
      }
    }else if (pequeno){
      if (tamanoPerros != "Pequeño"){
        $( this ).hide()
      }
    }else if (mediano){
      if (tamanoPerros != "Mediano"){
        $( this ).hide()
      }
    }else if (grande){
      if (tamanoPerros != "Grande"){
        $( this ).hide()
      }
    }
});

}
/* 
`'+${perro.idPerro}+','+'\"+${perro.nombre}.toString()+\"'+'`

 */
//? =============================================== FADE DEL MODAL BORRAR PERRO

let modalBorrarPerro = $("#modal-borrar-perro");
let idPerroBorrar
/* FADE-IN  MODAL BORRAR PERRO TABLA */
$('.abrirModalBorrarPerro').on('click',function(){
  $("main").css("filter", "blur(4px)");
  modalBorrarPerro.fadeIn();
  modalBorrarPerro.animate({ top: "50%" });


  let idperro = $(this).attr('data-id');
  let nombreperro = $(this).attr('data-nombre');
  let tamanoperro = $(this).attr('data-tamano');
  let sexoperro = $(this).attr('data-sexo');

  $('#t-nombre').html(nombreperro)
  $('#t-tamano').html(tamanoperro)
  $('#t-sexo').html(sexoperro)

  idPerroBorrar = idperro

});

$('#borrarPerro').click(function () {

  window.location.href = "http://localhost:8080/administrar/perros/eliminar/"+idPerroBorrar;
})


/* FADE-OUT MODAL BORRAR PERRO TABLA */
function cerrarModalBorrarPerro() {
  $("main").css("filter", "none");
  modalBorrarPerro.animate({ top: "-100%" });
  modalBorrarPerro.fadeOut();
  enableScroll();
}

//? =============================================== FADE DEL MODAL BORRAR PROTECTORA


let modalBorrarProtectora = $("#modal-borrar-protectora");
let idProtectoraBorrar
/* FADE-IN  MODAL BORRAR PERRO TABLA */
$('.borrar-perro-tabla').on('click',function(){
  $("main").css("filter", "blur(4px)");
  modalBorrarProtectora.fadeIn();
  modalBorrarProtectora.animate({ top: "50%" });


  let idprotectora = $(this).attr('data-Pid');
  let nombreprotectora = $(this).attr('data-Pnombre');
  let ciudadprotectora = $(this).attr('data-ciudad');


  $('#tp-nombreProtectora').html(nombreprotectora)
  $('#tp-ciudadprotectora').html(ciudadprotectora)


  idProtectoraBorrar = idprotectora

});

$('#borrarProtectoraa').click(function () {

  window.location.href = "http://localhost:8080/administrar/protectoras/eliminar/"+idProtectoraBorrar;
})


/* FADE-OUT MODAL BORRAR PERRO TABLA */
function cerrarModalprotectoraPerro() {
  $("main").css("filter", "none");
  modalBorrarProtectora.animate({ top: "-100%" });
  modalBorrarProtectora.fadeOut();
  enableScroll();
}

//? =============================================== FADE DEL MODAL EDITAR PERRO

let modalEditarPerro = $(".contanier-editarPerro");

/* FADE-IN  MODAL BORRAR PERRO TABLA */
function abrirModalEditarPerro() {
  $("main").css("filter", "blur(4px)");
  modalEditarPerro.fadeIn();
}

/* FADE-OUT MODAL BORRAR PERRO TABLA */
function cerrarModalEditarPerro() {
  $("main").css("filter", "none");
  modalEditarPerro.fadeOut();
}

//? =============================================== FADE CONFIRMAR DEL MODAL EDITAR PERRO

let modalConfirmarEditarPerro = $(".confirmar-cambios");

/* FADE-IN  MODAL BORRAR PERRO TABLA */
function abrirModalConfirmarEditarPerro() {
  $(".contanier-editarPerro").css("filter", "blur(4px)");
  modalConfirmarEditarPerro.fadeIn();
}

/* FADE-OUT MODAL BORRAR PERRO TABLA */
function cerrarModalConfirmarEditarPerro() {
  $(".contanier-editarPerro").css("filter", "none");
  modalConfirmarEditarPerro.fadeOut();
}

//? =============================================== FADE DEL CAMBIO DE PAGINAS DE OPCIONES EN PROTECTORAS

function toggleOptionProtectora(position) {
  if (position === 1) {
    // POSICION [1] INDICA QUE ESTA SELECCIONADA LA OPCION [PERROS] DE LA PAGINA PROTECTORAS
    $(".container-informaciones-contacto").hide();
    $(".container-options-perros").fadeIn();
    $("#perros-protectora").css("background-color", "#4ac074"); // color quando seleccionado

    $("#protectora-infos").css("background-color", "#4ade80"); // color verde
  } else {
    // INDICA QUE ESTA SELECCIONADA LA OPCION [INFORMACIONES DE LA PROTECTORA] DE LA PAGINA PROTECTORAS
    $(".container-options-perros").hide();
    $(".container-informaciones-contacto").fadeIn();
    $("#protectora-infos").css("background-color", "#4ac074"); // color quando seleccionado

    $("#perros-protectora").css("background-color", "#4ade80"); // color verde
  }
}

//? =============================================== CAMBIO DE ICONOS AL HACER EL LOGIN
var buscarCookie = document.cookie.indexOf("Alex")
/* SI SE CONECTA  */
if (window.location.pathname == "/administrar/perros" || 
	window.location.pathname == "/administrar/perros/nuevo" ||
	window.location.pathname == "/administrar/perros/editar" ||
	window.location.pathname == "/administrar/protectoras" ||
	window.location.pathname == "/administrar/protectoras/nueva" ||
	window.location.pathname == "/administrar/protectoras/editar")  {
  console.log("Estas en la ruta");
  if (buscarCookie < 0) {
    console.log(buscarCookie)
    window.location.href = "/"
  }
}


function conectadoLogin() {

  if(buscarCookie < 0){
    $(".iniciarSesion").hide(); // ESCONDER [INICIAR SESION DEL HEADER]
    $(".op-iniciar").hide(); // ESCONDER [INICIAR SESION DEL HEADER]
    $(".sesionIniciada").fadeIn(); // MOSTRAR [NOBRE DE LA PROTECTORA + ICONO DE IR A SU PAGINA + ICONO LOGOUT]
  }
}

function logOut() {
  $(".iniciarSesion").fadeIn(); // MOSTRAR [INICIAR SESION DEL HEADER]
  $(".op-iniciar").fadeIn(); // ESCONDER [INICIAR SESION DEL HEADER]
  $(".sesionIniciada").hide(); // ESCONDER [NOBRE DE LA PROTECTORA + ICONO DE IR A SU PAGINA + ICONO LOGOUT]


  window.location.href = "http://localhost:8080/";
  
  document.cookie = "Alex=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/;"
}

function cambiarLogin(){
  let logear = $(".iniciarSesion").is(":visible")
  let logeado = $(".sesionIniciada").is(":visible")


  if(buscarCookie == 0){
    if(logear){
      $(".iniciarSesion").hide(); // ESCONDER [INICIAR SESION DEL HEADER]
      $(".op-iniciar").hide(); // ESCONDER [INICIAR SESION DEL HEADER]
      $(".sesionIniciada").show(); // MOSTRAR [NOBRE DE LA PROTECTORA + ICONO DE IR A SU PAGINA + ICONO LOGOUT]

      $(".nav-telefono .iniciarSesion").hide(); // ESCONDER [INICIAR SESION DEL HEADER]
      $(".nav-telefono .op-iniciar").hide(); // ESCONDER [INICIAR SESION DEL HEADER]
      $(".nav-telefono .sesionIniciada").show(); // MOSTRAR [NOBRE DE LA PROTECTORA + ICONO DE IR A SU PAGINA + ICONO LOGOUT]
    }
  }else{
    if(logeado){
      $(".nav-telefono .iniciarSesion").show(); // MOSTRAR [INICIAR SESION DEL HEADER]
      $(".nav-telefono .op-iniciar").show(); // ESCONDER [INICIAR SESION DEL HEADER]
      $(".nav-telefono .sesionIniciada").hide(); // ESCONDER [NOBRE DE LA PROTECTORA + ICONO DE IR A SU PAGINA + ICONO LOGOUT]

      $(".iniciarSesion").show(); // MOSTRAR [INICIAR SESION DEL HEADER]
      $(".op-iniciar").show(); // ESCONDER [INICIAR SESION DEL HEADER]
      $(".sesionIniciada").hide(); // ESCONDER [NOBRE DE LA PROTECTORA + ICONO DE IR A SU PAGINA + ICONO LOGOUT]
    }
  }
}






//? =============================================== COOKIES

const avisoCookies = $("#aviso-cookies");
const fondoAvisoCookies = $("#fondo-aviso-cookies");

dataLayer = [];

if (!localStorage.getItem("cookies-aceptadas")) {
  avisoCookies.classList.add("activo");
  fondoAvisoCookies.classList.add("activo");
} else {
  dataLayer.push({ event: "cookies-aceptadas" });
}

function  btnCookies() {
  avisoCookies.classList.remove("activo");
  fondoAvisoCookies.classList.remove("activo");

  localStorage.setItem("cookies-aceptadas", true);

  dataLayer.push({ event: "cookies-aceptadas" });
}





//? =============================================== FAQ

function pregunta(className) {
  let thisClass = $("."+className+" .panel");
  let repostaClass = $("."+className+" .pregunta");


  if(!thisClass.is(":visible")){
    thisClass.slideDown()
    repostaClass.css({
      "border-top-right-radius": "0px",
      "border-bottom-left-radius": "0px",
      "border-bottom-right-radius": "0px",
   });
  }else{
    thisClass.slideUp()
    setTimeout(
      function() 
      {
        repostaClass.css({
          "border-top-right-radius": "12px",
          "border-bottom-left-radius": "12px",
          "border-bottom-right-radius": "12px",
       });
      }, 350);
  }
  
}
