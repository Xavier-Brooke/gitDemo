import path from 'node:path' ;
import fs from 'node:fs/promises' ;
import process from 'node:process' ;

/**
 * mkdir can make dir if the dir not exists
 * @param {string} dirName directory name
 */
async function mkdir(dirName) {
    try {
        const validName = /^[^\\/:*?"<>|]+$/;
        if(!validName.test(dirName)) {
            
        }
        const dirPath = path.join(process.cwd(), dirName) ;
        await fs.mkdir(dirPath) ;
        console.log('Directory has been created successfully') ;
    } catch(err) {
        console.log(`mkdir: cannot create directory ‘${dirName}’: File exists`) ;
        console.log(err.message) ;
    }
}

export default mkdir ;