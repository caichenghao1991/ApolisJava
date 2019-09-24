// ajax
let animalList;
$('.btn').click(()=>{
    $.ajax({
        type:'get',
        url:'https://dog.ceo/api/breeds/list/all',
        datatype:'json',
        success:function(data){
            console.log("TCL: data", data)
            animalList=data['message'];
            console.log("TCL: animalList", animalList) //animalList.size
            console.log("TCL: animalList",Object.keys(animalList) )

        },
        error:function(err){
        console.log("TCL: err", err)
            
        }
    })
})
$( "#animals" ).autocomplete({
    source: Object.keys(animalList)
  });

