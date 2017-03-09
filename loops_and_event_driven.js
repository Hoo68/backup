// sync
console.time('time');

var b = 0;
for(var i = 0; i< 1000; i++){
	for(var j=0;j<9;j++){
		b = b + i;
	}
}
console.log(b);

console.timeEnd('time');


// sync with Anonymous functions
console.time('time');

var b = 0;
(() => {
  for(var i = 0; i< 100000000; i++){
   b = b + i;
  }
  console.log(b);
})();

console.timeEnd('time');


// event driven programming
console.time('time');

function showCallback(num, callback){
	console.timeEnd('time');
	callback();
}

var b = 0;
var count = () => {
  for(var i = 0; i< 100000000; i++){
    b = b + i;
  }
  console.log(b);
}

showCallback(100, count)
