let animalList;
$('.btn').click(()=>{
    $.ajax({
        type:'get',
        url:'https://dog.ceo/api/breeds/list/all',
        datatype:'json',
        success:function(data){
            console.log("TCL: data", data)
            animalList=data['message'];
            console.log("TCL: animalList", animalList)
            console.log("TCL: animalList",Object.keys(animalList) )
            var ul=$("<ul></ul>");
            for(var i=0;i<Object.keys(animalList).length;i++){

                ul.append($("<li></li>").html(Object.keys(animalList)[i]).css({"list-style":"none","border":"solid 1px black","width":"150px"}));

            }
            
             $("body").append(ul);
  
        },
        error:function(err){
        console.log("TCL: err", err)
        }
        
    })
})



