import path from 'node:path';
import fs from 'node:fs/promises' ;
import process from 'node:process';

/**
 * Create the DIRECTORY(ies), if they do not already exist.
 * @param {Array<String>} dirName dir name
 */
async function mkdir(dirName) {
    try {
        const validName = /^(?!(?:COM[1-9]|LPT[1-9]|CON|PRN|NUL|AUX)(?:\..*)?$)[^\\/:*?"<>|]+$/i;
        const invalidArr = ['/', '\\', ':', '*', '?', '"', '<', '>', '|'] ;
        let invalidName = dirName.filter((name) => !validName.test(name)) ;
        let validNameArr = dirName.filter(name => validName.test(name)) ;

        for(let name of validNameArr) {
            const dirPath = path.join(process.cwd(), name) ;
            await fs.mkdir(dirPath, { recursive:true }) ;
        }

        let checkLoop = false ;
        for(let name of invalidName) {
            console.log(`mkdir : Directory '${name}' can't be created`) ;
            checkLoop = true ;
        }
        if(checkLoop) {
            console.log(`Guide 1 :- Don't include the given character in Directory name [${invalidArr.join(' ')}]`) ;
            console.log(`Guide 2 :- Don't use the reserved Windows device names. [CON, NUL, PRN, AUX, COM1-COM9, LPT1-LPT9]`) ;
        }
    } catch(err) {
        if(err.code === 'EEXIST') {
            console.log(`mkdir : cannot create directory ‘${dirName}’ : File exists`) ;
        } else {
            console.log(`Can't create dir`) ;
            console.log(err) ;
        }
    }
}

export default mkdir ;