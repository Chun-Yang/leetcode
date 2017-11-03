const fs = require('fs')
const scrapeIt = require("scrape-it");

const questionsString = require('./scriper-string')

const questions = questionsString.split('\n').map((s) => {
  const [index, href, title] = s.split(',').map((s) => s.toLowerCase())
  return { index, href, title }
})

function stringify (index, href) {
  return [index, href.split('/')[2]].join('-') + '.java'
}

questions.forEach((props) => {
  const { index, href, title } = props
  const fullHref = 'https://leetcode.com' + href
  const valid = index > 151 && index <= 200
  if (!valid) {
    return
  }
  scrapeIt(fullHref, { q: '.question-description' })
    .then(({ q }) => {
      const fileName = stringify(index, href)
      const formattedQ = q
        .split('\n')
        .map(s => '// ' + s.trim())
        .concat(['', '', '// ' + fullHref ])
        .join('\n')
      fs.writeFile(fileName, formattedQ, (e) => {
        if (e) {
          console.log('FILE ERROR: ', e)
        }
      })
      // fs.writeSync('./pages/${stringify(index, title)}', q)
    })
    .catch((e) => {
      console.log('PROMISE ERROR: ', e)
    })
})
