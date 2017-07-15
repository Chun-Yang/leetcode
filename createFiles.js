const fileNames = `\
`.split('\n')

const fs = require('fs')

fileNames.forEach((name) => {
  fs.closeSync(fs.openSync(name, 'w'));
})
