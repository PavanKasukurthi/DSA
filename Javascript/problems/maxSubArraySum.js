// Write a function called maxSubArraySum which accepts an array of integers and a number called n.
// The function should calculate the maximum sum of n consecutive elements in the array.

const maxSubArraySum = (arr, num) => {
  if (arr.length < num) return 'Number is greater than the array length'

  let maxSum = 0
  let tempSum = 0

  for (let i = 0; i < num; i++) {
    maxSum += arr[i]
  }

  tempSum = maxSum

  for (let i = num; i < arr.length; i++) {
    tempSum = tempSum - arr[i - num] + arr[i]
    maxSum = Math.max(maxSum, tempSum)
  }

  return maxSum
}

let a = [7, 1, 6, 2, 4, 3, 1, 5, 6, 7, 5, 2, 4, 0]

console.log(maxSubArraySum(a, 3))
