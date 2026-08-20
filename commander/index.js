#!/usr/bin/env node

import utils from './util/main.js' ;

const args = process.argv.slice(2);
const query = args[0];

async function main() {
  switch (query) {
    case "fileOrganiser":
      await utils.fileOrganiser("./demo");
      break;

    case "mkdir":
      console.log(`mkdir is called`) ;
      const dirName = args[1] ;
      await utils.mkdir(dirName);
      console.log(`mkdir finished`) ;
      break;

    default:
      console.log(`This is default response for switch case`);
  }
}

main() ;