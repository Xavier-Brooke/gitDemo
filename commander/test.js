import path from 'node:path' ;
import fs from 'node:fs/promises' ;
import process from 'node:process' ;

const dirPath = path.join(process.cwd(), 'dedfmo') ;
async function checkDirectoryExists(dirPath) {
  try {
    // const stats = await fs.stat(dirPath);
    const stats = await fs.readdir(dirPath, { withFileTypes:true }) ;
    const ans = stats.isDirectory();
    console.log(ans) ;
  } catch (error) {
    // If the error code is ENOENT, the path does not exist
    if (error.code === 'ENOENT') {
      console.log(false);
      return ;
    }
    // Re-throw other errors (e.g., permission issues)
    throw error;
  }
}

await checkDirectoryExists(dirPath) ;
// const demoPath = path.resolve('demo') ;
// console.log(demoPath) ;
// const newPath = path.resolve('memo') ;
// console.log(newPath) ;
// const targetPath = path.join(demoPath, newPath) ;
// console.log(targetPath) ;