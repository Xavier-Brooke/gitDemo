#!/usr/bin/env node

import fileOrganiser from "./util/fileOrganiser.js";
import mkdir from "./util/mkdir.js";

const args = process.argv.slice(2);
const query = args[0];

async function main() {
  switch (query) {
    case "fileOrganiser":
      await fileOrganiser("./demo");
      break;

    case "mkdir":
        console.log(`mkdir is called`) ;
      const fileName = args[1] ?? "optional1.txt";
      await mkdir(fileName);
      console.log(`mkdir finished`) ;
      break;

    default:
      console.log(`This is default response for switch case`);
  }
}

main() ;