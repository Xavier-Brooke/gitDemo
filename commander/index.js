#!/usr/bin/env node

import process from 'node:process' ;
import utils from './utils/main.js' ;

const args = process.argv.slice(2) ;
const command = args[0] ;

async function main() {
    try {

        const flag = args[1] ;

        // version
        if((command === '--version') || (command === '-v')) {
            if(!flag) {
                console.log(`v1.0.0`) ;
            } else if((flag === '--help') || (flag === '-h')) {
                if(!args[2]) {
                    console.log(`Display version information about commander`) ;
                } else {
                    console.log(`version : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                }
            } else {
                console.log(`version : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
            }
        }  

        // consoles path of current working directory
        else if(command?.toLowerCase() === 'cwd') {
            if(!flag) {
                console.log(process.cwd()) ;
            } else if((flag === '--help') || (flag === '-h')) {
                if(!args[2]) {
                    console.log(`Print the name of the current working directory.`) ;
                } else {
                    console.log(`cwd : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                }
            } else {
                console.log(`cwd : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
            }
        } 

        // create dir, if not exists
        else if(command?.toLowerCase() === 'mkdir') {
            if(!flag) {
                console.log(`mkdir: missing operand`) ;
                console.log(`Try 'mkdir --help' for more information`) ;
            } else if((flag === '--help') || (flag === '-h')) {
                if(!args[2]) {
                    console.log(`Usage: mkdir [OPTION]... DIRECTORY...`) ;
                    console.log(`Create the DIRECTORY(ies), if they do not already exist.`)
                } else {
                    console.log(`mkdir : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                }
            } else {
                const dirName = args.slice(1) ;
                let isInvalidStart = false ;
                let invalidName = '' ;
                for(const dir of dirName) {
                    if((dir.startsWith('--')) || (dir.startsWith('-'))) {
                        invalidName = dir ;
                        isInvalidStart = true ;
                        break ;
                    }
                }

                if((isInvalidStart) && ((invalidName === '--help') || (invalidName === '-h'))) {
                    console.log(`Usage: mkdir [OPTION]... DIRECTORY...`) ;
                    console.log(`Create the DIRECTORY(ies), if they do not already exist.`)
                } else if(isInvalidStart) {
                    console.log(`mkdir : unknown option ${invalidName}`) ;
                    console.log(`Try 'mkdir --help' for more information`) ;
                } else if(!isInvalidStart) {
                    await utils.mkdir(dirName) ;
                }
            }
            // console.log(`Creating dir`) ;
            // const dirName = args[1] ;
            // await utils.mkdir(dirName) ;
            // console.log(`Folder Created Successfully`) ;
        }

        else {
            console.log(`commander : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command. See 'commander --help'`) ;
        }
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.log(err) ;
    }
}

main() ;