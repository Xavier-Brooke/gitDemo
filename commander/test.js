import path from 'node:path';
import fs from 'node:fs/promises' ;
import process from 'node:process';

/* test 5 */
const args = process.argv.slice(2) ;
const checkPath = args[0] ;

async function main() {
    try {
        console.log(path.isAbsolute(checkPath)) ;
    } catch(err) {
        console.log(err) ;
    }
}

main() ; 

/* test 4 */
// console.log('hello') ;
// process.exitCode = 2 ;
// console.log('bye') ;
// if([]) {
//     console.log(`Array`) ;
//     process.exitCode = 0 ; 
// } else {
//     console.log('else') ;
//     process.exitCode = 1 ;
// }

/* test 3 */
// let strArr = ['node.js', '.js', 'next.js', 'python', 'react.js'] ;
// let deletedArr = [] ;

// for(let i = 0; i < strArr.length; i++) {
//     if(strArr[i].indexOf('.js') !== -1) {
//         deletedArr.push(strArr.splice(i, 1).join(' ')) ;
//     }
// }
// console.log(strArr.indexOf('.js')) ;
// console.log(deletedArr) ;
// console.log(strArr) ;

/* test 2 */
// const validName = /^[^\\/:*?"<>|]+$/;
// const dirName = 'con?dl' ;
// console.log(validName.test(dirName)) ;

/* test 1 */
// let arr = [] ;
// console.log(arr[0]) ;
// console.log(arr[1]) ;