// function getDogsList(){
//     let xhr=new XMLHttpRequest();
//     xhr.open('get','https://dog.ceo/api/breeds/list/all');
//     xhr.send();

//     xhr.onload=function(){
//         if(xhr.status>=200 && xhr.status<300){
//             console.log(xhr.response);
//         }
//     }

//     xhr.onerror=function(){
//         console.log(xhr.status);
//     }
// }

// getDogsList();

//IIFE--IMMEDIATELY INVOKED FUNCTION EXPRESSION
(function(){
    console.log('dom loaded javascript');
    let xhr=new XMLHttpRequest();
    xhr.open('get','https://dog.ceo/api/breeds/list/all');
    xhr.send();

    xhr.onload=function(){
        if(xhr.status>=200 && xhr.status<300){
            console.log(xhr.response);
        }
    }

    xhr.onerror=function(){
        console.log(xhr.status);
    }
})();