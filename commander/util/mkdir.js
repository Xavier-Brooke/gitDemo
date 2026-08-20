import path from 'node:path' ;
import fs from 'node:fs/promises' ;

async function mkdir(fileName, srcDir='./demo') {
    try {
        const fullPath = path.join(srcDir, fileName) ;
        await fs.writeFile(fullPath, '', 'utf-8') ;
        console.log(`Sir, File has been created`) ;
    } catch(err) {
        console.log(`Sorry sir, Something went wrong..`) ;
        console.log(err) ;
    }
}

export default mkdir ;