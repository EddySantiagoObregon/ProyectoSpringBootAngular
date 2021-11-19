

$(function(){


        Agregar();
 
  

});
function Agregar(){
   
     var parametros = {
               PostMapping: "/api/persona",
               nombre:"Santiago",
               apellido:"Obregon",
               email:"santiiagoobregon2009@gmail.com",
               telefono:"2121",
    };    
    $.ajax({          
        url: '../PersonaController',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
                        if (resultado) {
                alert("Agregado correctamente");
                 $("tbody tr").remove(); 
                 listarForma();
         
              }else{
                  alert("Problemas al agregar");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}


