import path from 'node:path' ;
import fs from 'node:fs/promises' ;
import process from 'node:process' ;

/**
 * rename will change the name of dir or file from oldname to newName
 * @param {string} oldNmae old name of file or dir
 * @param {string} newName new name of file or dir
 */
async function rename(oldNmae, newName) {
    try {
        const oldPath = path.join(process.cwd(), oldNmae) ;
        const newPath = path.join(process.cwd(), newName) ;
        await fs.rename(oldPath, newPath) ;
    } catch(err) {
        console.log(`rename : Something went wrong...`) ;
        console.log(err) ;
    }
}

export default rename ;