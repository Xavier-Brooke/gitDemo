import path from 'node:path';
import fs from 'node:fs/promises' ;
import process from 'node:process';

/* test 3 */
let strArr = ['node.js', '.js', 'next.js', 'python', 'react.js'] ;
let deletedArr = [] ;

for(let i = 0; i < strArr.length; i++) {
    if(strArr[i].indexOf('.js') !== -1) {
        deletedArr.push(strArr.splice(i, 1).join(' ')) ;
    }
}
console.log(strArr.indexOf('.js')) ;
console.log(deletedArr) ;
console.log(strArr) ;

/* test 2 */
// const validName = /^[^\\/:*?"<>|]+$/;
// const dirName = 'con?dl' ;
// console.log(validName.test(dirName)) ;

/* test 1 */
// let arr = [] ;
// console.log(arr[0]) ;
// console.log(arr[1]) ;