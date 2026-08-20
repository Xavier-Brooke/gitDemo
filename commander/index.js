#!/usr/bin/env node

import utils from './utils/main.js' ;

const args = process.argv.slice(2);
const command = args[0];

async function main() {
  switch (command) {
    case "organise":
      await utils.fileOrganiser("./demo");
      break;

    case "mkdir":
      const dirName = args[1] ;
      await utils.mkdir(dirName);
      break;

    default:
      console.log(`This is default response for switch case`);
  }
}

main() ;