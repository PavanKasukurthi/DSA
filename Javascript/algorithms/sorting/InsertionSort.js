const InsertionSort = (arr) => {
  for (let i = 1; i < arr.length; i++) {
    let currentValue = arr[i]
    for (let j = i - 1; j >= 0 && arr[j] > currentValue; j--) {
      console.log(arr)
      arr[j + 1] = arr[j]
      arr[j] = currentValue
    }
  }
  return arr
}

// console.log(InsertionSort([2, 1, 9, 76, 4]))
console.log(InsertionSort([12, 11, 13, 5, 6]))
