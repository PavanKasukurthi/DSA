// Given an array of strings, capitalize the first letter of each string using recursion

function capitalizeFirst(arr) {
  let result = []

  if (arr.length < 1) return result

  result.push(arr[0][0].toUpperCase() + arr[0].substring(1))

  return result.concat(capitalizeFirst(arr.slice(1)))
}

const capitalizeWords = (arr) => {
  let result = []

  if (arr.length < 1) return result

  result.push(arr[0].toUpperCase())

  return result.concat(capitalizeWords(arr.slice(1)))
}

console.log(capitalizeWords(['car', 'taco', 'banana']))
console.log(capitalizeFirst(['car', 'taco', 'banana']))
