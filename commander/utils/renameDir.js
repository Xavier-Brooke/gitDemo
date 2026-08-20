import path from 'node:path' ;
import fs from 'node:fs/promises' ;
import process from 'node:process' ;

/**
 * Renames oldPath to newPath.
 * @param {string} oldPath - Old path of directory
 * @param {string} newPath - New path for directory
 * @return — Fulfills with `undefined` upon success.
 */
async function renameDir(oldPath, newPath) {
    try {
        await fs.rename(path.resolve(oldPath), path.resolve(newPath)) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.log(err) ;
    }
}

export default renameDir ;