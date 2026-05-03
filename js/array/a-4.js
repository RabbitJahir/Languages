let arr = [6, 8, 2, 9.8, 45,  "text???"];

console.log(`${arr}`); // 6,8,2,9,45,text???
arr.reverse(); // text???,45,9,2,8,6,46

arr.push(46);
console.log(`push: ${arr}`);

// only works 0-9
arr.sort();
console.log(`sort : ${arr}`);

// 100/100 working
arr.sort((a, b) => a - b);
console.log("sorted:", arr);