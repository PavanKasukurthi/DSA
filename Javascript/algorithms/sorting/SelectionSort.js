const SelectionSort = (arr) => {
  for (let i = 0; i < arr.length - 1; i++) {
    let min = i
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[min]) {
        min = j
      }
    }
    if (i !== min) {
      //optimization
      // console.log(i, min)
      ;[arr[min], arr[i]] = [arr[i], arr[min]]
    }
  }
  return arr
}

console.log(SelectionSort([2, 1, 9, 76, 4]))
