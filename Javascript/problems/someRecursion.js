// Write a recursive func called someRecursive which accepts an array and a callback. The function returns true
// if a single value in the array returns true when passed to the callback. Otherwise return false

const someRecursive = (arr, callback) => {
  if (arr.length === 0) return false

  if (callback(arr[0])) return true

  return someRecursive(arr.slice(1), callback)
}

const isOdd = (n) => {
  return n % 2 !== 0 ? true : false
}

console.log(someRecursive([2, 3, 4], isOdd))
