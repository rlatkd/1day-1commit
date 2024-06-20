/* [1] array
// 배열 선언
let values = [ "빨강", '노랑', `파랑`, true, 123 ];

// 배열 길이는 배열의 length 속성(property)을 이용해서 확인이 가능
console.log(values.length);     // 5
console.log(values["length"]);  // 5

// 배열 요소에 접근할 때는 일반적으로 배열의 인덱스를 사용
console.log('첫번째', values[0]);
console.log('마지막', values[values.length-1]);

// 배열 요소에 순차적으로 접근하는 방법 1
console.log(values[0]);
console.log(values[1]);
console.log(values[2]);
console.log(values[3]);
console.log(values[4]);

// 배열 요소에 순차적으로 접근하는 방법 2
for (let i = 0; i < values.length; i ++) {
    console.log(values[i]);
}

// 배열 요소에 순차적으로 접근하는 방법 3
for (let index in values) {
    console.log(values[index]);
}

// 배열 요소에 순차적으로 접근하는 방법 4
for (let value of values) {
    console.log(value);
}

// 배열 요소에 순차적으로 접근하는 방법 5-1
let print = function(color) {
    console.log(color);        
};
values.forEach(print);

// 배열 요소에 순차적으로 접근하는 방법 5-2
values.forEach(function(color) {
    console.log(color);        
});

// 배열 요소에 순차적으로 접근하는 방법 5-3
values.forEach((color) => {
    console.log(color);        
});

// 배열 요소에 순차적으로 접근하는 방법 5-4
values.forEach(color => console.log(color));
*/


/* [2] object
// 객체 선언
let person = {
    "name": '홍길동', 
    'age': 23, 
    isMarried: false,
    'favorite color': ['빨강', '노랑'],
    hello: function() {
        return '안녕, 나는 ' + this.name + "이야";
    }
};     

// 객체 속성을 참조할 때는 객체변수.속성이름 또는 객체변수["속성이름"] 형식을 이용
console.log(person.name);
console.log(person["name"]);
console.log(person["favorite color"]);
console.log(person.hello());

// 객체 속성의 값을 변경
person.name = "고길동";
console.log(person.name);
console.log(person.hello());

// 객체의 속성을 순회하면서 가져오는 방법 => 모든 객체 속성을 출력
for (let key in person) {
    console.log(key, ' 속성의 값은 ', person[key]);
}

// Uncaught TypeError: person is not iterable
for (let value of person) {
    console.log(value);
}
*/


/* [3] in, with 연산자
// 객체 선언
let person = {
    name: '홍길동', 
    age: 23, 
    isMarried: false,
    'favorite color': ['빨강', '노랑'],
    hello: function() {
        return '안녕, 나는 ' + this.name + "이야";
    }
};     

// in 연산자 - 해당 속성이 객체에 존재하는지 여부를 확인
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/in
console.log("name" in person);
console.log("email" in person);

// with 연산자 - 사용할 객체를 지정
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals
console.log(`name: ${person.name}`);
console.log(`age: ${person.age}`);
with(person) {
    console.log(`name: ${name}`);
    console.log(`age: ${age}`);
}
*/


/* [4] 객체에 속성 추가, 삭제
// 빈 객체를 정의
let person = {};
console.log(person);

// 객체에 속성을 추가
person.name = "신길동";
person.age = 33;
person["favorite color"] = ["빨강", "파랑"];
console.log(person);

// person 객체가 가지고 있는 모든 속성과 속성의 값을 출력하는 print라는 이름의 함수를 객체에 추가
// (단 함수 자신은 출력에서 제외)
person.print = function() {
    for (let key in person) {
        if (key !== 'print') {
            console.log(`${key}: ${person[key]}`);
        }
    }
};
person.print(); 

// 객체의 속성을 삭제
delete person.age;
person.print();
*/


/* [5] 객체와 배열을 이용한 데이터 처리
// 학생별 점수를 출력

    // ----------- --------- --------- --------- --------- ---------
    // 학생이름     국어      영어      수학      합계      평균
    // ----------- --------- --------- --------- --------- ---------
    // 홍길동       80        90        90        260       86.7
    //     :          :         :         :          :        :



// 학생별 과목별 점수를 값으로 가지는 배열을 정의
let scores = [];

// 0: {name: '홍길동', korean: 80, math: 90, english: 90}
// 1: {name: '고길동', korean: 90, math: 80, english: 80}
// 2: {name: '신길동', korean: 70, math: 80, english: 70}



console.log(`--------\t------\t------\t------\t------\t------`);
console.log(`학생이름\t국어\t영어\t수학\t합계\t평균`);
console.log(`--------\t------\t------\t------\t------\t------`);

scores.forEach(score => {
    score.sum = function() {
        return this.korean + this.math + this.english;
    };


    score.average = function() {
        let result = this.sum() / 3;
        return Math.round(result * 10) / 10;
    };
   
    console.log(`${score.name}\t${score.korean}\t${score.english}\t${score.math}\t${score.sum()}\t${score.average()}`);
});


// 서버와의 통신을 통해서 데이터를 받는 경우
let scores = `[{"name": "홍길동", "korean": 80, "math": 90, "english": 90},{"name": "고길동", "korean": 90, "math": 80, "english": 80},{"name": "신길동", "korean": 70, "math": 80, "english": 70}]`;
console.log('데이터 변경 전', scores);
scores = JSON.parse(scores);
console.log('데이터 변경 후', scores);


console.log(`--------\t------\t------\t------\t------\t------`);
console.log(`학생이름\t국어\t영어\t수학\t합계\t평균`);
console.log(`--------\t------\t------\t------\t------\t------`);


scores.forEach(score => {
    score.sum = function() {
        return this.korean + this.math + this.english;
    };


    score.average = function() {
        let result = this.sum() / 3;
        return Math.round(result * 10) / 10;
    };
   
    console.log(`${score.name}\t${score.korean}\t${score.english}\t${score.math}\t${score.sum()}\t${score.average()}`);
});
*/


/* [6] 단축속성명 (shorthand property names)
let name = "John";
const obj = {
    age: 21,
    name: name,
    getName: function getName() {
        return this.name;
    }
};
console.log(obj);
console.log(obj.getName());

const obj2 = {
    age: 21,
    name,			// 속성 이름을 생략 ← 속성 이름과 속성값을 가지고 있는 변수 이름이 동일한 경우
    getName() {		//                  ← 속성 이름과 함수(메서드) 이름이 동일한 경우 
        return this.name;                       function 키워드와 함께 생략
    }
};
console.log(obj2);
console.log(obj2.getName());

// ex1) 매개변수를 객체로 반환하는 함수를 정의하는 경우
function returnObject(age, name) {
    return { age: age, name: name };
}
console.log(returnObject(20, '홍길동'));    // {age: 20, name: '홍길동'}

function returnObject2(age, name) {
    return { age, name };
}
console.log(returnObject2(20, '홍길동'));   // {age: 20, name: '홍길동'}

// ex2) 로그를 출력할 때
const age = 20;
const name = '신길동';

console.log("age", age);
console.log("name", name);

console.log(`age = ${age}, name = ${name}`);
console.log({ age: age, name: name });
console.log({ age, name });
*/


/* [7] 계산된 속성명 (computed property names)
// 속성 이름(key)과 속성 값(value)을 전달받아 객체를 반환하는 함수를 정의 
function returnObject(key, value) {
    
    // const obj = {};
    // obj[key] = value;
    // return obj;
    
    return { [key]: value };
}
console.log(returnObject('name', 'John'));  // {name: 'John'}

// 속성 이름이 일련번호 형태를 가지는 객체를 반환하는 함수
function returnObject2(key, value, no) {
    
    // const obj = {};
    // obj[key+no] = value;
    // return obj;
    
    return { [key+no]: value };
}
console.log(returnObject2('name', 'John', 1));  // {name1: 'John'}
console.log(returnObject2('name', 'Mike', 2));  // {name2: 'Mike'}
*/


/* [8] 전개 연산자 (spread operator)
console.log(Math.max(10, 20, 1, 30, 3, 2));     // 30  
console.log(Math.max([10, 20, 1, 30, 3, 2]));   // NaN

const numbers = [10, 20, 1, 30, 3, 2];
console.log(Math.max(numbers));     // NaN
console.log(Math.max(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]));
console.log(Math.max(...numbers));  // 30

console.log(numbers);               // 배열
console.log(...numbers);            // 순열 (숫자의 나열) => 배열 요소의 나열


// ex1) 배열의 값 복사
let arr1 = [ 1, 2, 3 ];
let arr2 = arr1;
console.log(arr1);  // [1, 2, 3]
console.log(arr2);  // [1, 2, 3]

arr1[1] = 20;
console.log(arr1);  // [1, 20, 3]
console.log(arr2);  // [1, 20, 3]

// 위의 문제(주소가 공유)를 해결하기 위해서는 배열의 주소가 아닌 배열의 값을 복사하는 것이 필요
let arr3 = [ 1, 2, 3 ];
let arr4 = [];
for (let i = 0; i < arr3.length; i ++) {
    arr4[i] = arr3[i];
}
console.log(arr3);  // [1, 2, 3]
console.log(arr4);  // [1, 2, 3]

arr3[1] = 20;
console.log(arr3);  // [1, 20, 3]
console.log(arr4);  // [1, 2, 3]

// 전개 연산자를 이용해서 배열의 값을 복사
let arr5 = [ 1, 2, 3 ];
let arr6 = [ ...arr5 ];
console.log(arr5);  // [1, 2, 3]
console.log(arr5);  // [1, 2, 3]

arr5[1] = 20;
console.log(arr5);  // [1, 20, 3]
console.log(arr6);  // [1, 2, 3]


// ex2) 객체의 값 복사
let obj1 = { age: 23, name: 'hong' };
let obj2 = obj1;
console.log(obj1);  // {age: 23, name: 'hong'}
console.log(obj2);  // {age: 23, name: 'hong'}

obj1.age = 200;
console.log(obj1);  // {age: 200, name: 'hong'}
console.log(obj2);  // {age: 200, name: 'hong'}

let obj3 = { age: 23, name: 'hong' };
let obj4 = { ...obj3 };
console.log(obj3);  // {age: 23, name: 'hong'}
console.log(obj4);  // {age: 23, name: 'hong'}

obj3.age = 300;
console.log(obj3);  // {age: 300, name: 'hong'}
console.log(obj4);  // {age: 23, name: 'hong'}


// ex3) 객체를 복사하는 과정에서 새로운 속성을 추가하거나 속성의 값을 변경하는 경우
let obj1 = { age: 23, name: 'hong' };
obj1.age = 40;
obj1.color = [ 'red', 'orange' ];
console.log(obj1);  // {age: 40, name: 'hong', color: Array(2)}

// obj1과 동일한 속성을 가지는 obj2를 정의하고, name 속성의 값을 gildong으로 변경
// let obj2 = { ...obj1 };
// obj2.name = 'gildong';
let obj2 = { ...obj1, name: 'gildong' };
console.log(obj2);  // {age: 40, name: 'gildong', color: Array(2)}

// obj1과 동일한 속성을 가지는 obj3를 정의하고, email 속성을 추가
let obj3 = { ...obj1, email: 'test@test.com' };
console.log(obj3);  // {age: 40, name: 'hong', color: Array(2), email: 'test@test.com'}


// ex4) 배열 또는 객체를 결합할 때
// 두 배열을 결합
const arr1 = [ 1, 2, 3 ];
const arr2 = [ 7, 8, 7 ];
const arr3 = [ ...arr1, ...arr2 ];
console.log(arr3);      // [1, 2, 3, 7, 8, 7]
const arr4 = [ ...arr2, ...arr1 ];
console.log(arr4);      // [7, 8, 7, 1, 2, 3]

// 객체를 결합
const obj1 = { age: 21, name: 'hong' };
const obj2 = { hobby: 'soccer', age: 40 };
const obj3 = { ...obj1, ...obj2 };
console.log(obj3);      // {age: 40, name: 'hong', hobby: 'soccer'}
const obj4 = { ...obj2, ...obj1 };
console.log(obj4);      // {hobby: 'soccer', age: 21, name: 'hong'}
*/


/* [9] 배열 비구조화 (array destructuring)
// 배열 데이터(요소)를 변수에 나눠서 할당
const arr = [ 1, 2, 3, 4, 5 ];
let a = arr[0];
let b = arr[1];
console.log(a, b);

// c, d, e, f 변수에 arr 배열에 첫번째 인덱스부터 차례로 할당
let [ c, d, e, f ] = arr;
console.log(c, d, e, f);    // 1 2 3 4

// 두 변수의 값을 교환
let x = 10;
let y = 20;
console.log(x, y);  // 10 20

let temp = x;
x = y;
y = temp;
console.log(x, y);  // 20 10

비구조화   배열
~~~~~~~~   ~~~~~~~~
[ x, y ] = [ y, x ];
console.log(x, y);  // 10 20

// 배열의 크기 보다 변수의 개수가 많은 경우, 기본값 설정이 가능
const arr = [ 1, 2 ];
let [ a, b, c ] = arr; 
console.log(a, b, c);   // 1 2 undefined

let [ x, y=20, z=30] = arr;
console.log(x, y, z);   // 1 2 30

// 배열의 일부값을 변수에 할당할 경우, 할당하지 않을 자리는 비워둠
const arr = [ 1, 2, 3 ];
let a = 10, b = 20, c = 30;
console.log(a, b, c);   // 10 20 30

// 변수 a에 1을, 변수 c에 3을 재할당하고 변수 b는 20을 그대로 유지
[ a, , c ] = arr;
console.log(a, b, c);   // 1 20 3

// 배열의 값을 할당하고 남은 나머지를 새로운 배열로 만드는 경우 
const arr = [ 1, 2, 3, 4, 5 ];

// arr 배열의 첫번째 값을 first 변수에 넣고, 나머지 값을 rest라는 이름의 배열에 추가
const [first, ...rest] = arr;
console.log(first);    // 1
console.log(rest);     // [2, 3, 4, 5]
*/


/* [10] 객체 비구조화 (object destructuring)
// 객체 비구조화를 할 때는 객체의 속성명(key)이 중요
const obj1 = { age: 21, name: 'mike' };
const obj2 = { age: 40, name: 'john' };

// obj1의 age와 name 속성의 값을 age와 name 변수에 할당
const { age, name } = obj1;
console.log(age, name);     // 21 'mike'

const { ageNew, nameNew } = obj1;
console.log(ageNew, nameNew);   // undefined undefined
console.log(obj1.ageNew);       // undefined

// 객체 비구조화를 통해 가져온 값을 새로운 변수 이름으로 사용할 경우 => 별칭을 부여
const { age: ageNew, name: nameNew } = obj1;
console.log(ageNew, nameNew);

// 객체에 존재하지 않는 요소를 변수에 할당할 때 적용할 기본값 설정도 가능
const { age, name: nameNew, email='default' } = obj1;
console.log(age, nameNew, email);   // 21 'mike' 'default'       

// 객체 비구조화 시 객체의 일부 속성을 변수에 할당하고, 나머지를 새로운 객체로 저장
const obj3 = { age: 32, name: "John", grade: "c" };
// obj3의 age 속성의 값을 johnAge 변수에 할당하고, 나머지를 rest 이름의 객체에 할당
const { age: johnAge, ...rest } = obj3;
console.log(johnAge, rest);     // 32 {name:'John', grade:'c'}
*/


/* [11] 화살표 함수 (arrow function)
// 익명 함수 표현식을 이용한 함수 정의 
let add = function (a, b) { return a + b; };

// 화살표 함수
// function 키워드를 제거하고, 함수 파라미터와 본문 사이에 => 를 추가
let add2 = (a, b) => { return a + b; };

// 화살표 함수 본문의 중괄호를 제거하면 화살표 오른쪽의 결과를 반환
let add3 = (a, b) => a + b;
console.log(add3(10, 20));      // 30

// 파라미터가 하나이면 파라미터를 감싸고 있는 소괄호도 생략이 가능
let add4 = a => a + 4;
console.log(add4(10));          // 14

// 객체를 반환하는 경우에는 소괄호를 감싸야 함
let add5 = (a, b) => { return { result: a+b } };
console.log(add5(10, 20));      // {result: 30}

let add6 = (a, b) => ( { result: a+b } );
console.log(add6(10, 20));      // {result: 30}
*/


/* [12] map() func
const source = [ 1, 4, 9, 16 ];
// source 배열의 값을 두 배수한 결과 배열(twoTimes)을 만들어서 출력하시오. 
const twoTimes = [];
for (let i = 0; i < source.length; i ++) {
    twoTimes[i] = source[i] * 2;
}
console.log(twoTimes);  // [2, 8, 18, 32]


const twoTimes = source.map(value => value * 2);
console.log(twoTimes);  // [2, 8, 18, 32]


const f = value => value * 2;
const twoTimes = source.map(f);
console.log(twoTimes);  // [2, 8, 18, 32]


const f1 = v => v * 2;
const f2 = v => v * 10;
const twoTimes = source.map(f1).map(f2);
console.log(twoTimes);  // [20, 80, 180, 320]
*/


/* [13] filter() func
const words = [ 'srpay', 'limit', 'elite', 'destruction', 'present', 'exuberant' ];
// 길이가 여섯 글자 이상인 단어만 추출
const newWords = [];
for (let i = 0; i < words.length; i ++) {
    if (words[i].length > 6) {
        newWords.push(words[i]);
    }
}
console.log(newWords);  // ['destruction', 'present', 'exuberant']


const newWords = words.filter(word => word.length > 6);
console.log(newWords);  // ['destruction', 'present', 'exuberant']


const numbers = [ 1, 3, 4, 6, 11, 14 ];
// 짝수만 추출해서 10배수한 결과를 출력
console.log(numbers
            .filter(num => num % 2 === 0)
            .map(num => num * 10));     // [40, 60, 140]
*/


/* [14] reduce() func
const numbers = [ 1, 2, 3, 4, 5 ];
// 배열 데이터의 합계
let sum = 0;
for (let i = 0; i < numbers.length; i ++) {
    sum = sum + numbers[i];
}
console.log(sum);   // 15


let sum = numbers.reduce((previous, current) => previous + current);
console.log(sum);



// numbers 배열의 각 항목의 값에 13을 곱한 결과 중 짝수의 합을 구하시오. 
const f1 = n => n * 13;
const f2 = n => n % 2 === 0;
const f3 = (p, c) => p + c;

const result1 = numbers.map(f1);
console.log(result1);
const result2 = result1.filter(f2);
console.log(result2);
const result3 = result2.reduce(f3);
console.log(result3);

console.log(numbers.map(f1).filter(f2).reduce(f3));
console.log(numbers
            .map(n => n * 13)
            .filter(n => n % 2 === 0)
            .reduce((p, c) => p + c));



// 각 과목의 총합을 구하고 출력하시오.
let scores = [];
scores[0] = {name: '홍길동', korean: 80, math: 90, english: 90};
scores.push({name: '고길동', korean: 90, math: 80, english: 80});
scores.push({name: '신길동', korean: 70, math: 80, english: 70});
console.log(scores);


const fk = scores.map(s => s.korean).reduce((p, c) => p+c);
const fe = scores.map(s => s.english).reduce((p, c) => p+c);
const fm = scores.map(s => s.math).reduce((p, c) => p+c);

console.log('국어 점수 총합', fk);
console.log('영어 점수 총합', fe);
console.log('수합 점수 총합', fm);


const f = x => scores.map(s => s[x]).reduce((p, c) => p+c);

console.log('국어 점수 총합', f('korean'));
console.log('영어 점수 총합', f('english'));
console.log('수합 점수 총합', f('math'));


const f1 = x => scores.map(x).reduce((p, c) => p+c);

console.log('국어 점수 총합', f1(s => s.korean));
console.log('영어 점수 총합', f1(s => s.english));
console.log('수합 점수 총합', f1(s => s.math));
*/