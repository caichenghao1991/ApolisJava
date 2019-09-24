// javascript basic
//Datatypes
//primitives
var a = "yash";
a = 234;
a = true;
console.log(typeof a);
a = null;
//non -primitives
//var a1 = [1,"yash",3];
var a1 = [1,5,3]; //global scope
a1.push(4); //add to the end of array
a1.pop(); //remove at the end of array
a1.unshift(0); //add at the beginning of array
a1.shift(); //remove at the beginning of array

a1.sort(function(x,y){   // => arrow(lambda equation)
    return y-x;
})

console.log(a1.slice(0,2)); //check in browser console

b={}; //create object don't need var
var a2 = {name:'yash',ssn:112233} //create object,don't need class
console.log(a2.name);
console.log(a2['name']);
console.log(Object.prototype.toString.call(a1));  //check detailed data type
function addNumber(x,y){
    var f=123; // function scope
    let f2=123;
    return x+y;
}
//console.log('function scope',f2); //not defined
var sum = addNumber(10,20);
console.log(sum);
// logical operators  &, |, !

var str='Chicago';  //can use '' or ""
console.log(str.toLowerCase);
console.log(str.substr(0,3));
console.log(str.indexOf('i'));

//undefined and defined
//hoisting(moving to the top)  all variable declaration move to the top of code
console.log(z);  // undefined: a variable is declared, but no value is assigned to it
var z='Hello';
//console.log(aa); //not defined, no variable declared in the whole code

// == vs ===
console.log(1=='1'); //true
//coercion --convert to another data type 
console.log(1==='1'); //not apply coercion

//truthy falsy values
// undefined, null, 0 --> falsy, everything else is truthy
console.log(false==0);  //true
console.log(true==1);  //true

var q; //undefined is false
var q1=12; 
console.log('q value',!!q)
console.log('q1 value',!!q1)
if(!!q){ // !! return the truth/false value of variable
    var g1='Gir'; // block scope  {}
    let g2='Gir';  
    console.log('q');
}
console.log('g1 is ',g1); // undefined
//console.log('g2 is ',g2); //  not defined
//js -- javascript
// es -- ecmascript -- standard body governs js
//es6 /es7/es8/es9 features  


//es 6 features
//scopes  global / function /block / lexical
let x=3;  // wont apply hoisting
const x1='10'; //constant

//arrow function
function getCoffee(){
    return "coffee";
}
//anonymous function
let coffee = function(x){
    return x+' '+'coffee';
}
let coffee2 = (x,y)=>
{
    return x+' '+'coffee';
    // return `${x} coffee, ${y}`;    template literal strings
}

let anonymous=coffee2('strong','hi');
console.log("anonymous function",anonymous);

// before es6, use prototypes
class Student{
    constructor(name,ssn){
        this.name=name;
        this.ssn=ssn;
    }
}
let stu=new Student('yash',12345)

//spread operator
var trainee=['a','b','c'];
var traineeCopy=['e',...trainee,'f'];
console.log('spread operator',traineeCopy);

let employee=[['john',30],['gerrit',30]];
let x2=Object.keys(employee); //retrieve the keys
let employeeCopy=[...employee]; // pass by reference (non-primitive), pass by value (primitive) shalow copy
console.log("emloyee copy",employeeCopy);
employeeCopy[0][0]='jim';
console.log("emloyee copy",employeeCopy);
console.log('employee',employee); 
let employeeDeepCopy=JSON.parse(JSON.stringify(employee)); //deep copy, won't affect original  java script object notation
employeeDeepCopy[0][0]='tom';
console.log("emloyee deep copy",employeeDeepCopy);
console.log('employee',employee); 

var animal={
    type: 'cat',
    age:'10'
}
var animalCopy={...animal}
animalCopy.type='dog';
console.log("animal copy",animalCopy);
console.log('animal',animal); 

var animal={
    type: 'cat',
    age:'10'
}
var animal2={
    type: 'cat',
livesin:{
        place1:'cage',
        place2:'forest'
    }
}
//shallow copy
var animalCopy2={...animal2}
animalCopy2['livesin']['place1']='woods';
console.log("animal2 copy",animalCopy2);
console.log('animal2',animal2); 
//deep copy
var animalDeepCopy2=JSON.parse(JSON.stringify(animal2))
animalDeepCopy2['livesin']['place1']='river';
console.log("animal2 deep copy",animalDeepCopy2);
console.log('animal2',animal2); 

function getDetail(){
    let name='John'; //lexical scope, inner function can access outer function
    function getAddress(){
        let city='chicago';
        console.log(name);
    }
    getAddress();
    //console.log(city); // not defined
}
getDetail();

//clossures
function getName(){
    let name='Albert';
    return function(){
        console.log(name);
    }
}
console.log(getName);
let nameCopy=getName(); // return function can access lexical scope 
nameCopy();

//dom  -- document  object model
//API's   document. show all the api functions
//call back function -- when you pass and execute a function as an argument to another function, 
// then this is called call back function

var signInbutton=document.querySelector('.signin');  //return first element  new Html5 API
var signInbutton2=document.getElementsByClassName('signin'); //return collection of class element
console.log("signInButton",signInbutton);
console.log("signInButton",signInbutton2);

var text=document.querySelector('#txt');
var text2=document.getElementById('txt');
console.log("input text",text2);

document.getElementsByClassName('signin')[0].addEventListener('click',()=>{  //'click',function(){}
    console.log("input text",text2.innerHTML);
    text2.innerHTML='Hello World';
    var para=document.createElement('p');
    para.innerHTML='Star War';
    document.body.appendChild(para);
    //document.getElementById('txt').appendChild(para);
    document.getElementsByTagName('form')[0].appendChild(para);
  //  document.getElementsByTagName('form')[0].removeChild(document.getElementById('txt2')); //remove element
    //document.getElementsByTagName('form')[0].style.color='rd';
})

//event propagation (bubbling:event will propagate to all its parent element ,capturing: child capture parent), 
document.querySelector('ul').addEventListener('click',($event)=>{
    console.log($event);
    console.log('You clicked '+$event.target.innerHTML);
})
document.querySelector('.miami').addEventListener('click',($event)=>{
    //$event.stopPropagation(); //stop propagation from parent event
    $event.stopImmediatePropagation(); //stop all propagation
})

for(var i=0;i<document.querySelectorAll('li').length;i++){
    document.querySelectorAll('li')[i].addEventListener('click',($event)=>{
        console.log('You clicked list item')
    })
}

//$event.preventDefault
document.querySelector('.googleref').addEventListener('click',($event)=>{
    $event.preventDefault();
    console.log('you clicked the anchor')
 })
 
 //document.ready
