function filterDuplicate(data){
var set = new Set(data);
return set;
}

var arr = [ 1, 3, 2, 3, 5 ];
console.log(filterDuplicate(arr));