const countUniqueValues = (arr) => {
  let i = 0

  if (arr.length === 0) return 0

  for (let j = 1; j < arr.length; j++) {
    if (arr[j] !== arr[i]) {
      i++
      arr[i] = arr[j]
    }
  }
  return i+1
}

let a = [2, 2, 2, 1, 5, 6, 12, 0, 14]

console.log(countUniqueValues(a))
