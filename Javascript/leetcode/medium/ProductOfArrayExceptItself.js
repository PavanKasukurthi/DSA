const ProductOfArrayExceptItself = (arr) => {
  let result = []
  result[0] = 1
  for (let i = 1; i < arr.length; i++) {
    result[i] = result[i - 1] * arr[i - 1]
  }

  let R = 1
  for (let i = arr.length - 1; i >= 0; i--) {
    result[i] = result[i] * R
    R = R * arr[i]
  }

  return result
}

console.log(ProductOfArrayExceptItself([1, 2, 3, 4]))
