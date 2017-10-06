function binarySearch(target, start, end, anArray) {
    recursiveCounter++;
    
    var index = Math.round((start + end)/2);
    if (anArray[index] == target)
        return index;
    else if(start >= end)
        return -1;
    else if (target > anArray[index])
        return binarySearch(target, index, end, anArray);
    else
        return binarySearch(target, start, index, anArray);
    
}

var sortedArray = [];

for (i = 0; i < 100; i++) {
    sortedArray[i] = i * 20;
}

var target = 200;
var recursiveCounter = 0;

console.log(binarySearch(target, 0, sortedArray.length - 1, sortedArray));
console.log("Recursive Count = " + recursiveCounter);

//finds all permutations of a string
function permut(string) {
    if (string.length < 2) return string; // This is our break condition

    var permutations = []; // This array will hold our permutations

    for (var i=0; i<string.length; i++) {
        var char = string[i];

        // Cause we don't want any duplicates:
        if (string.indexOf(char) != i) // if char was used already
            continue;           // skip it this time

        var remainingString = string.slice(0,i) + string.slice(i+1,string.length); //Note: you can concat Strings via '+' in JS

        for (var subPermutation of permut(remainingString))
            permutations.push(char + subPermutation)

    }
    return permutations;
}

var myString = "kels";
permutations = permut(myString);
for (permutation of permutations)
    console.log(permutation) //Use the output method of your choice
