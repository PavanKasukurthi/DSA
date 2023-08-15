const BinarySearch = (arr, target) => {
  let start = 0
  let end = arr.length - 1

  while (start <= end) {
    let mid = Math.floor((start + end) / 2)

    if (arr[mid] === target) return mid
    else if (arr[mid] > target) end = mid - 1
    else if (arr[mid] < target) start = mid + 1
  }

  return -1
}

console.log(BinarySearch([1, 2, 4, 5, 6, 7, 11, 24], 0))
