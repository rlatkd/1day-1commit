/* [0] in html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Hello React</h1>


    <scripts>
        alert("Hello");
    </scripts>

    
</body>
</html>
*/

/* [1] recursive: 함수표현식으로 만든함수는 외부에서 사용불가
let myfactorial = function factorial(n) {
    if (n<=1) return 1;
    return n * factorial(n-1);
};
console.log(myfactorial(5))
*/

/* [2] Function()
const add = new Function('x', 'y', 'return x+y');
console.log(add(2,4));
*/

/* [3] function  hoisting: 아무곳에나 함수 만들어도 알아서 찾아감; 함수선언문으로 선언해야 됨
console.log('20+30=', add(20,30));
function add(x,y) {return x+y;};
*/

/* [4] function hoisting: 적용안됨; 함수표현식으로 선언했기 떄문
console.log("20 + 30 = ", add(20, 30));
let add = function(x, y) {
    return x + y ;
};
*/

/* [5] var, let 차이
console.log(none);  // Uncaught ReferenceError: none is not defined
        
console.log(i);     // undefined
var i;              //  <== 변수의 선언이 호이스팅되어 위치와 관계 없이 사용이 가능
console.log(i);     // undefined
i = 10;
console.log(i);     // 10

console.log(x);     // undefined
var x = 10;         // <== 변수의 선언과 초기화가 분리되어 변수의 선언이 호이팅됨
console.log(x);     // 10

// Uncaught ReferenceError: Cannot access 'j' before initialization
// console.log("j = ", j);      <== 선언전에 참조하는 경우 오류가 발생
let j;
console.log("j = ", j);     // j = undefined
j = 10;
console.log("j = ", j);     // j = 10

// Uncaught ReferenceError: Cannot access 'y' before initialization
// console.log("y = ", y); 
let y = 10;
console.log("y = " , y);    // y = 10
*/

/*[6]
console.log(sum(10, 20));   // Uncaught TypeError: sum is not a function
var sum = function(x, y) {
    return x + y;
};
console.log(sum(10, 20));   // 30

console.log(sum(10, 20));   // Uncaught ReferenceError: Cannot access 'sum' before initialization
let sum = function(x, y) {
    return x + y;
};
console.log(sum(10, 20));   // 30
*/

/*[7] const
const a = 100;
a = 200;      // Uncaught TypeError: Assignment to constant variable.

const a;    	// 'const' declarations must be initialized.
a = 200;    

const add = function(x, y) {
    return x + y;
};
console.log(add(10, 20));
*/

/*[8] 객체
// 객체 선언
let obj = {
    "key": "value", 
    "first name": "hong"
};

// 객체의 요소를 참조
console.log(obj.key);
console.log(obj["key"]);
console.log(obj["first name"]);

// 새로운 요소를 추가
obj.email = "test@test.com";
obj["last name"] = "gil dong";
console.log(obj);

// 기존 요소를 수정
obj.key = "NEW VALUE";
console.log(obj);

// 함수를 정의
function add(x, y) {
    return x + y;
}
console.log(add(10, 20));
add.result = add(10, 20);
add.status = "OK";
console.log(add.result);
console.log(add.status);
console.dir(add);
*/

/*[9] 함수를 다른 함수의 인자로 전달
let click = function(fname) {
    fname();
};

let myfunc = function() {
    console.log('내 함수');
};
let yourfunc = function() {
    console.log('니 함수');
};

click(myfunc);
click(yourfunc);
*/

/*[10] 함수를 다른 함수의 리턴값으로 활용
let foo = function() {
    return function() {
        console.log("반환함수");
    };
};

let bar = foo();
bar();
*/

// [11] 즉시실행함수(=자기호출함수)
(function(name) {
    console.log(name + '는 즉시 실행됩니다.');
})      ('이 함수');

/* [11-1] in python
def foo():
    def func():
        print('반환함수')
    return func()
x = foo()
*/