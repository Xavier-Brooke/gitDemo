# commander

`commander` is a small Node.js command-line tool for basic file-system operations.

## Requirements

- Node.js 14 or newer
- npm

## Installation

From the project directory, install the CLI globally:

```bash
npm install -g .
```

This registers the `commander` command. To run it without a global installation, use:

```bash
node index.js <command> [argument]
```

## Usage

```text
commander <command> [argument]
```

### Display the version

```bash
commander --version
commander -v
```

Output:

```text
v1.0.0
```

A short description is available through the version command's help flag:

```bash
commander --version --help
commander -v -h
```

### Print the current working directory

```bash
commander cwd
```

This prints the directory from which the command was run. The command name is case-insensitive, so `commander CWD` is also accepted.

### Create a directory

```bash
commander mkdir <directory-name>
```

The directory is created inside the current working directory:

```bash
commander mkdir reports
```

If no directory name is supplied, the utility uses `temp`:

```bash
commander mkdir
```

Existing directories are not overwritten. The command reports that the directory already exists.

Directory names must not contain any of these characters:

```text
/ \ : * ? " < > |
```

The command accepts a single directory name, not a nested path.

## Unrecognized commands

For an unsupported command, the CLI prints:

```text
Command not matched
```

## Project structure

```text
index.js          CLI entry point
utils/main.js     Utility exports
utils/mkdir.js    Directory creation implementation
package.json      npm metadata and CLI configuration
test.js           Scratch test file
```

## License

ISC
