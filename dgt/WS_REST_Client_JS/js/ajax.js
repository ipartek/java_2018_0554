/** 
*   Libreria para realizar llamadas AJAX XMLHttpRequest en vanilla JavaScript.
*   response-type == 'text', no funciona para 'xml'
*
*   @method: 'GET','POST','PUT','DELETE', etc
*   @url: url donde escucha el servicio Rest
*   @data: formato 'application/json', valor por defecto null
*   @return: Promise
*/


function ajax ( method, url, data = null ){
    
    return new Promise(function(resolve,reject){
        
        let request;
        
        //soporte para diferentes navegadores
        if (window.XMLHttpRequest) { // chrome, safari, etc...
            request = new XMLHttpRequest();    
            request.responseType = 'text';
            
        } else if (window.ActiveXObject) { // IE
            request = new ActiveXObject("Msxml2.XMLHTTP");
            
        } else {
            reject("Tu navegador no soporta llamadas Ajax");
        }
        
        //comprobar cambios de estado
        request.onreadystatechange = function(){
        
         if (request.readyState == 4 ){             
             if ( request.status >= 200 && request.status <= 299 ) {
                 resolve( JSON.parse(request.responseText) );
             }else{
                 reject(Error(request.statusText));
             }             
         }      
        
        };
                
        request.open(method, url, true);
        
        request.setRequestHeader("Content-type", "application/json");
        request.send( JSON.stringify(data) );
        
    });    
}
