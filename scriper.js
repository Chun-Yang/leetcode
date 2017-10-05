const fs = require('fs')
const scrapeIt = require("scrape-it");

const questionsString = require('./scriper-string')

const questions = questionsString.split('\n').map((s) => {
  const [index, href, title] = s.split(',')
  return { index, href, title }
})

function stringify (index, title) {
  return [index, ...title.split(' ')].join('-') + '.java'
}

questions.map(async (props) => {
  const { index, href, title } = props
  return scrapeIt(href, { q: '.question-description' })
    .then(({ q }) => {
      fs.writeSync('../pages/${stringify(index, title)}', q)
    })
})
