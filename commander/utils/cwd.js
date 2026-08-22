import process from 'node:process' ;

/**
 * can be used to get the path of current working directory.
 * @returns current working directory
 */
function cwd() {
    return process.cwd();
}

export default cwd ;