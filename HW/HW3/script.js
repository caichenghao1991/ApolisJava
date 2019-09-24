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

document.getElementById("form").addEventListener("click",()=>{
    console.log(emp[0]['Name']);
    var table=document.createElement("table");
    table.border=1;
    var tbody = document.createElement("tbody");
    var thead = document.createElement("thead");
    var row1=document.createElement("tr");
 
    var attributes=["Name","Age","City"]
    for(var i=0;i<3;i++){
        var cel=document.createElement("th");
        cel.innerHTML=attributes[i];
        row1.appendChild(cel);   
    }
    thead.appendChild(row1);
    /*
    for(var i=0;i<emp.length;i++){
        
        var row=document.createElement("tr");
        var cel1=document.createElement("td");
        var cel2=document.createElement("td");
        var cel3=document.createElement("td");
        cel1.innerHTML=emp[i]["Name"];
        cel2.innerHTML=emp[i]["Age"];
        cel3.innerHTML=emp[i]["City"];
        row.appendChild(cel1);
        row.appendChild(cel2);
        row.appendChild(cel3);
        tbody.appendChild(row);
    }*/
    for(var i=0;i<emp.length;i++){
        var row=document.createElement("tr");
        for(var j=0;j<3;j++){
            var cel=document.createElement("td");
            cel.innerHTML=emp[i][attributes[j]];
            row.appendChild(cel);
        }
        tbody.appendChild(row);
    }  
    table.appendChild(thead);
    table.appendChild(tbody);
    document.body.appendChild(table);

})
