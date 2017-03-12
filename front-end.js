const assert = require('assert')

// function isMatrixSquare(matrix) {
//   const n = matrix.length
//   for (let i = 0; i < n - 1; i++) {
//     for (let j = i; j < n; j++) {
//       if (matrix[i][j] !== matrix[j][i]) {
//         return false
//       }
//     }
//   }

//   return true
// }

// assert(isMatrixSquare([]))
// assert(isMatrixSquare([[1]]))
// assert(isMatrixSquare([[1, 2], [2, 3]]))
// assert(!isMatrixSquare([[1, 3], [2, 1]]))

// function setinterval50mili (fn) {
//   return function(...args) {
//     return setInterval(() => {fn(...args)}, 500)
//   }
// }

// function unitTest () {
//   let counter = 0
//   const handle = setinterval50mili(() => { counter++ })()
//   setTimeout(() => {
//     clearInterval(handle)
//     assert(counter === 2)
//   }, 1010)
// }

// unitTest()


// function wrapper (fn) {
//   return () => {
//     setTimeout(fn, 1000)
//   }
// }

// function getElementByClassName (className) {
//   const children = []

//   function dfs (node) {
//     if (node.classList.contains(className)) {
//       children.push(node)
//     }

//     for (let child of node.children) {
//       dfs(child)
//     }
//   }

//   dfs(document.documentElement)

//   return children
// }


