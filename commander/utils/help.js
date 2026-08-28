function help_page_1() {
    console.log(`Help page for 'commander'`) ;

    // help_page for 'version'
    console.log("-".repeat(100)) ;
    console.log(`1. Info Related to 'version'\n`) ;
    console.log(`Type 'commander -v|--version' to check the version of commander`) ;
    console.log(`Type 'commander -v|--version -h|--help' to get the help page for version`) ;
    console.log("-".repeat(100)) ;

    // help_page for 'cwd'
    console.log(`2. Info Related to 'cwd'\n`) ;
    console.log(`Type 'commander cwd' to get the current working directory`) ;
    console.log(`Type 'commander cwd -h|--help' to get the help page for cwd`) ;
    console.log("-".repeat(100)) ;

    // help_page for 'mkdir'
    console.log(`3. Info Related to 'mkdir'\n`) ;
    console.log(`Type 'commander mkdir [DIRECTORY(ies)]' to make the DIRECTORY(ies)`) ;
    console.log(`Type 'commander mkdir -h|--help' to get the help page for mkdir`) ;
    console.log("-".repeat(100)) ;
}

export { help_page_1 } ;