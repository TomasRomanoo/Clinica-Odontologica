// window.addEventListener('load', function () {

//      //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
//      //los datos que el usuario cargará del nuevo estudiante
//     const formulario = document.querySelector('#add_new_paciente');

//     //Ante un submit del formulario se ejecutará la siguiente funcion
//     formulario.addEventListener('submit', function (event) {

//         //creamos un JSON que tendrá los datos del nuevo estudiante
//         const formData = {
//             nombre: document.querySelector('#nombre').value,
//             apellido: document.querySelector('#apellido').value,

//         };

//         //invocamos utilizando la función fetch la API estudiantes con el método POST
//         //que guardará al estudiante que enviaremos en formato JSON
//         const url = '/pacientes';
//         const settings = {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             body: JSON.stringify(formData)
//         }

//         fetch(url, settings)
//             .then(response => response.json())
//             .then(data => {
//                //Si no hay ningun error se muestra un mensaje diciendo que el estudiante
//                //se agrego bien
//                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
//                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
//                     '<strong></strong> Estudiante agregado </div>'

//                 document.querySelector('#response').innerHTML = successAlert;
//                 document.querySelector('#response').style.display = "block";
//                  //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
//                 resetUploadForm();

//             })
//             .catch(error => {
//                  //Si hay algun error se muestra un mensaje diciendo que el estudiante
//                  //no se pudo guardar y se intente nuevamente
//                 let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
//                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
//                                     '<strong> Error intente nuevamente</strong> </div>'

//                 document.querySelector('#response').innerHTML = errorAlert;
//                 document.querySelector('#response').style.display = "block";
//                    //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
//                 resetUploadForm();})
//     });

//     function resetUploadForm(){
//         document.querySelector('#nombre').value = "";
//         document.querySelector('#apellido').value = "";

//     }

//     (function(){
//         let pathname = window.location.pathname;
//         if(pathname === "/"){
//             document.querySelector(".nav .nav-item a:first").addClass("active");
//         } else if (pathname == "/pacienteList.html") {
//             document.querySelector(".nav .nav-item a:last").addClass("active");
//         }
//     })();
// });

window.addEventListener("load",function(){
const formulario = document.querySelector('#nuevo-paciente');


//Ante un submit del formulario se ejecutará la siguiente funcion
formulario.addEventListener('submit', function (event) {
            event.preventDefault();
            const formData = {
                            nombre: document.querySelector('#nombre').value,
                            apellido: document.querySelector('#apellido').value,
                            dni: document.querySelector('#dni').value,
                            fechaDeAlta:document.querySelector('#fechaDeAlta').value,
                            domicilio: {
                                        calle: document.querySelector('#calle').value,
                                        numero: document.querySelector('#numero').value,
                                        localidad: document.querySelector('#localidad').value,
                                        provincia: document.querySelector('#provincia').value,
                                        }
                            }
            const url = '/pacientes/crear';
            const settings = {
                        method: 'POST',
                        headers: {
                                    'Content-Type': 'application/json',
                                    },
                        body: JSON.stringify(formData)
                            }
            fetch(url,settings)
            .then(response => response.json())
            .then(dataPaciente =>{
                        //Si no hay ningun error se muestra un mensaje diciendo que el paciente se agrego bien
                        let successAlert = '<p>Se ha enviado</p>';
                document.querySelector('.main-form').innerHTML = successAlert;
                document.querySelector('.main-form').style.display="block";
                })
            .catch(error =>{
                let errorAlert = '<p>No Se ha enviado</p>';

                document.querySelector('.main-form').innerHTML = errorAlert;
                document.querySelector('.main-form').style.display="block";
                        //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                    })
        })})