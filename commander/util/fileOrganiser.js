import path from 'node:path' ;
import fs from 'node:fs/promises' ;

const data = [] ;

/**
 * fileOrganiser Can be Used to organise files based on their extensions
 * @param {string} srcDir - Path for the dir to be organised
 */
async function fileOrganiser(srcDir) {
    try {
        const entries = await fs.readdir(srcDir, { withFileTypes:true, recursive:true }) ;
        // console.log(entries) ;
        for(const entry of entries) {
            // data.push({name: entry.name, parentPath : entry.parentPath, dirStatus : entry.isDirectory(), fileStatus : entry.isFile()}) ;
            const fullPath = path.join(entry.parentPath, entry.name) ;
            console.log(`is ${fullPath} dir : ${entry.isDirectory()}`) ;
            if(entry.isFile()) {
                const ext = path.extname(fullPath) ;
                switch(ext) {
                    case '.txt' :
                        const filePath = path.join(srcDir, 'Text') ;
                        await fs.mkdir(filePath, { recursive:true }) ;
                        const targetPath = path.join(filePath, path.basename(fullPath)) ;
                        await fs.rename(fullPath, targetPath) ;
                        console.log(`${fullPath} -> ${targetPath}`) ;
                        break ;

                    case '.pdf' :
                        // work to be done for .pdf
                    default :
                        console.log(`Done nothing for ${ext}`) ;
                }

            }
        }
        // console.log(data) ;
    } catch(err) {
        console.log(`fileOrganising Process Couldn't be completed`) ;
        console.log(err) ;
    }
}

export default fileOrganiser ;