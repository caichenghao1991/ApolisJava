let animalList;
$('document').ready(function(){  // IIFE An IIFE (Immediately Invoked Function Expression) is a JavaScript function that runs as soon as it is defined.
 // (function () { statements})
    console.log('dom loaded successfully');
    
    $.ajax({
        type:'get',
        url:'https://dog.ceo/api/breeds/list/all',
        datatype:'json',
        success:function(data){
            console.log("TCL: data", data)
            animalList=Object.keys(data['message']);

            $('#animals').autocomplete({
                source:animalList
            })
        },
        error:function(err){
        console.log("TCL: err", err)
            
        }
    })
});


