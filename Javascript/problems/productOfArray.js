const productOfArray = (arr) => {
  if (arr.length === 0) return 'Empty array'

  return arr[0] * productOfArray(arr.slice(1))
}

console.log(productOfArray([]))
