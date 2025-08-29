//PROBLEMS USING REDUCE

//FLATTENING A NESTED ARRAY
const nested = [[1, 2], [3, 4], [5]]
const flat = nested.reduce((acc, curr) => acc.concat(curr), [])

console.log(flat)

//SUM AND PRODUCT OF ALL THE ELEMENTS IN AN ARRAY
const arr = [1, 2, 3, 4, 5, 6, 7]
const sum = arr.reduce((a, b) => a + b, 0)
const product = arr.reduce((a, b) => a * b, 1)
console.log(sum)
console.log(product)

//COUNT OCCURRENCES
const fruits = ['apple', 'banana', 'apple', 'orange', 'banana', 'apple']
const count = fruits.reduce((acc, fruit) => {
  acc[fruit] = (acc[fruit] || 0) + 1
  return acc
}, [])

console.log(count)

//FIND THE MAXIMUM ELEMENT
const numbers = [10, 25, 3, 47, 5]

const max = numbers.reduce((a, b) => (a > b ? a : b), numbers[0])
const secondMax = numbers
  .filter((e) => e != max)
  .reduce((a, b) => (a > b ? a : b), numbers[0])
console.log(max)
console.log(secondMax)

//REMOVE DUPLICATES IN AN ARRAY
const nums = [1, 2, 3, 2, 4, 1, 5, 3]
const unique = nums.reduce((acc, curr) => {
  if (!acc.includes(curr)) {
    acc.push(curr)
  }
  return acc
}, [])

console.log(unique)
