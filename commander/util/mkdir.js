import path from 'node:path' ;
import fs from 'node:fs/promises' ;

async function mkdir(dirName) {
    try {
        const dirPath = path.join(process.cwd(), dirName) ;
        const res = await fs.mkdir(dirPath, { recursive:true }) ;
        console.log(`${res ?? 'Directory has been created successfully'}`) ;
    } catch(err) {
        console.log(`Sorry sir, Something went wrong..`) ;
        console.log(err.message) ;
    }
}

export default mkdir ;