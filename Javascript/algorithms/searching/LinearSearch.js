//TIME COMPLEXITY: O(n) - as length of array increases time complexity increases
// Best case: O(1)
// Average: O(n)
// Worst case: O(n)
//SPACE COMPLEXITY: O(1)

const LinearSearch = (arr, target) => {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) {
      return i
    }
  }

  return -1
}

console.log(LinearSearch([10, 15, 20, 25, 30], 15))
