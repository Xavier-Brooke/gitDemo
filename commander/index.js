#!/usr/bin/env node

import process from 'node:process' ;
import readline from 'node:readline';
import utils from './utils/main.js' ;

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

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
                    console.log(`Try 'commander --version --help' for more information`) ;
                    process.exitCode = 1 ;
                }
            } else {
                console.log(`version : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                console.log(`Try 'commander --version --help' for more information`) ;
                process.exitCode = 1 ;
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
                    console.log(`Try 'commander cwd --help' for more information`) ;
                    process.exitCode = 1 ;
                }
            } else {
                console.log(`cwd : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                console.log(`Try 'commander cwd --help' for more information`) ;
                process.exitCode = 1 ;
            }
        } 

        // create dir, if not exists
        else if(command?.toLowerCase() === 'mkdir') {
            if(!flag) {
                console.log(`mkdir: missing operand`) ;
                console.log(`Try 'commander mkdir --help' for more information`) ;
            } else if((flag === '--help') || (flag === '-h')) {
                if(!args[2]) {
                    console.log(`Usage: mkdir [OPTION]... DIRECTORY...`) ;
                    console.log(`Create the DIRECTORY(ies), if they do not already exist.`)
                } else {
                    console.log(`mkdir : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                    console.log(`Try 'commander mkdir --help' for more information`) ;
                    process.exitCode = 1 ;
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
                    console.log(`Try 'commander mkdir --help' for more information`) ;
                    process.exitCode = 1 ;
                } else if(!isInvalidStart) {
                    await utils.mkdir(dirName) ;
                }
            }
        }

        // rename dir or file
        else if(command?.toLowerCase() === 'rename') {
            if(!flag) {
                console.log(`rename: missing flag`) ;
                console.log(`Try 'commander rename --help' for more information`) ;
                process.exitCode = 1 ;
            } else if((flag === '--help') || (flag === '-h')) {
                if(!args[2]) {
                    console.log(`Usage: rename [OPTION]... old name of  dir or file... new name of dir or file`) ;
                    console.log(`Rename the dir or file, if that file or dir not exists than commader will exit with 1`) ;
                    console.log(`For changing file name use :- 'commander rename --file oldNmae newName'`) ;
                    console.log(`For changing dir name use :- 'commander rename --dir oldNmae newName'`) ;
                } else {
                    console.log(`mkdir : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                    console.log(`Try 'commander rename --help' for more information`) ;
                    process.exitCode = 1 ;
                }
            } else if(flag === '--dir') {
                // logic for renaming dir
                const oldPath = args[2] ;
                const newPath = args[3] ;
                await utils.rename(oldPath, newPath) ;
            } else if(flag === '--file') {
                // logic for renaming file
                const oldPath = args[2] ;
                const newPath = args[3] ;
                await utils.rename(oldPath, newPath) ;
            } else {
                console.log(`rename : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command`) ;
                console.log(`Try 'commander rename --help' for more information`) ;
                process.exitCode = 1 ;
            }
        }

        // change directory
        /* 
            cd will be implementd after some time
            node.js can't change the shell dir directly
        */
        // else if(command === 'cd') {

        // }

        else if((!command) || (command?.toLowerCase() === '--help') || (command?.toLowerCase() === '-h')){

            utils.help_page_1() ;

            rl.question(`Press m to see more...\nPress q to exit\n`, answer => {
                if(answer?.toLowerCase() === 'm') {
                    console.log(`You will see more`) ;
                } else if(answer?.toLowerCase() === 'q') {
                    rl.close();
                }  else {
                    console.log(`Invalid request`) ;
                    rl.close() ;
                }
            });
        }

        else {
            console.log(`commander : 'commander ${command} ${flag} ${args.slice(2).join(' ')}' is not a valid command. See 'commander --help'`) ;
            process.exitCode = 127 ;
        }
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.log(err) ;
    }
}

main() ;

rl.close() ;