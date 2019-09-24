// $ --> jquery
$(".signout").click(()=>{console.log("jquery");})
$(".signout").on('click',()=>{
    console.log("jquery2");
    $("body").append($("<p class='add'>Hello jQuery</p>"));

})
$(".name").keyup(($event)=>{
    console.log($event.target.value);
   
})
$(".remove").click(()=>{
    $(".add").remove();
})
$(".change").click(()=>{
    $( ".add" ).replaceWith( "<p class='add'>Hello again</p>" );
})
//$(function(){
    //$('document').ready(function(){
// events https://www.runoob.com/jquery/jquery-ref-events.html
//https://api.jquery.com/category

let emp=[
    {
        Name:'Tom',
        Age:35,
        City:'Chicago'
    },
    {
        Name:'John',
        Age:30,
        City:'New York'
    },
    {
        Name:'Ronald',
        Age:31,
        City:'Austria'
    },
    {
        Name:'Enice',
        Age:29,
        City:'London'
    },
    {
        Name:'David',
        Age:36,
        City:'Miami'
    }
]


$("#form").click(()=>{   
        var $tab=$("<table></table>");
        var attributes=["Name","Age","City"];
        var $thead=$("<thead></thead>");
        var $tbody=$("<tbody></tbody>");
        var $tr1=$("<tr></tr>");
        for(var i=0;i<3;i++){
           // var $th=$("<th></th>");
           // $th.html(attributes[i]);
           $tr1.append($("<th></th>").html(attributes[i]).css("border","solid 1px black"));
            //$th.css("border","solid 1px black");
        }
        $thead.append($tr1);
        $tab.append($thead);
        for(var i=0;i<emp.length;i++){
            var $tr2=$("<tr></tr>");
            for(var j=0;j<3;j++){
                var $cel=$("<td></td>");
                $cel.html(emp[i][attributes[j]]);
                $tr2.append($cel);
                $cel.css("border","solid 1px black");
            }
            $tbody.append($tr2);
            
        }
        $tab.append($tbody);
        $("body").append($tab);
        $tab.css("border","solid 1px black");
        
})


