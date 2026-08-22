#!/usr/bin/env node

import utils from './utils/main.js' ;

const args = process.argv.slice(2);
const command = args[0];

async function main() {
 
  if((command?.toLowerCase() === 'version') || (command === '-v') || (command === '--version')) {
    console.log('v1.0.0') ;
  } else 

  if(command?.toLocaleLowerCase() === 'cwd') {
    console.log(utils.cwd()) ;
  } else 

  if(command?.toLocaleLowerCase() === 'mkdir') {
    const dirName = args[1] ;
    await utils.mkdir(dirName);
  } else 

  if(command?.toLocaleLowerCase() === 'organise') {
    await utils.fileOrganiser("./demo");
  } else {
    console.log(`Invalid command`) ;
  }
}

main() ;