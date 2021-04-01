const array = [1, 2, 3, 4, 5];

// 내장함수 filter 사용
const mult3Array = array.map(num => num * 3
).filter(function (num) {
    if (num % 2 === 0) {
        console.log(num);
    };
});

/* 내장함수 map만 사용
const mult3Array = array.map(num => num*3);

mult3Array.forEach(element => {
    if (elememt % 2 === 0){
        console.log(element);
    }
})
*/


