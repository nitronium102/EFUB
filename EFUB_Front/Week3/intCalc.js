const intArray = [1, 2, 3, 4, 5];

const array = intArray.map(num => num * 3
).filter(function (num) {
    if (num % 2 == 0) {
        console.log(num);
    };
});
