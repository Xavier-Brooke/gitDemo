import path from 'node:path' ;
import fs from 'node:fs/promises' ;
import process from 'node:process' ;

async function mkdir(dirName) {
    try {
        const dirPath = path.join(process.cwd(), dirName) ;
        await fs.mkdir(dirPath) ;
        console.log('Directory has been created successfully') ;
    } catch(err) {
        console.log(`mkdir: cannot create directory ‘${dirName}’: File exists`) ;
        console.log(err.message) ;
    }
}

export default mkdir ;