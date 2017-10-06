//String Opperator Experimentation
var aString = "Torre Norton";

//String to array of characters
var charArray = [];
for (var i = 0; i < aString.length; i++) {
    charArray[i] = aString.charAt(i);
}
console.log(charArray);

//Hash code from string
var hashFactor = 31;
var hashCode = aString.charCodeAt(0).valueOf();

for (var i = 1; i < aString.length; i++) {
    var charHash = aString.charCodeAt(i).valueOf();
    
    hashCode += (charHash * hashFactor); 
    
}

console.log("Hash Code: " + hashCode);
console.log("Bucket: " + (hashCode % 101));

//ternary operator syntax (condition) ? false return: true return

var booty = (hashCode > 50) ? "Its bucket is 50-" : "It's 50+";
console.log(booty);

//if, else if, else structure
if (booty.length > 10)
    console.log("It's a big booty");
else if (booty.length <= 10)
    console.log("It's a small booty");
else
    console.log("This should never be displayed.");

//switch structure, with many values bundled to default
var text;
switch (new Date().getDay()) {
    case 6:
        text = "Today is Saturday";
        break; 
    case 0:
        text = "Today is Sunday";
        break; 
    default: 
        text = "Looking forward to the Weekend";
}
console.log(text);

//with fallthrough behavior
switch (new Date().getDay()) {
    case 1:
    case 2:
    case 3:
    default: 
        text = "Looking forward to the Weekend";
        break; 
    case 4:
    case 5:
       text = "Soon it is Weekend";
        break; 
    case 0:
    case 6:
       text = "It is Weekend";
}
console.log(text);

//MATH Operators (called as MATH.__) Example: int 0-100;
var rando = Math.round((Math.random() *100));
console.log(rando);

//Array Fuctions
anArray = [1, 2, 3, 4, 5, 6, 7]


//filter  (creates new array with elements fitting condition) (condition must a be a function (built-in, predefined or anonymous))

var evenArray = anArray.filter(function (elem) {return elem % 2  ==  0});
console.log(evenArray);


//every (tells if every element passes a condition)
var j= anArray.every(isFinite);
console.log(j);

//map (applys function to each object and returns new array)
function toThe2nd (item) {
    return item * item;
}
console.log(anArray.map(toThe2nd));

//reduce (keeps total/result of function across all elements)
function sumOfSquares (total, item) {
    return total + (item * item);
}

console.log(anArray.reduce(sumOfSquares, 0));

//fill (fills an array with a static data point)
//      format (value, start index, end index)
var randomArray = [];
randomArray[9] = 0;
randomArray.fill(null, 0, 10);


function randomGenerator () {
    return Math.round(Math.random() * 100);
}

//forIn loop syntax
for(var index in randomArray) {
    randomArray[index] = randomGenerator();
}

console.log(randomArray);

//forEach syntax doesn't work as attempting to fill array, not access data, but syntax is provided.

//anArray.forEach(randomGenerator);

//sort (returns an array sorted by STRING VALUE, unless an appropriate comperator function is provided, eg:
function numericalComperator(a, b) {
    return a - b;
}
//comperator must return negative number if first item is less than second, 0 if equal, and positive if first item is larger,
//mostly very annoying but can be used to sort in novel ways (distance from nearest binary number or such);

console.log(randomArray.sort(numericalComperator));
