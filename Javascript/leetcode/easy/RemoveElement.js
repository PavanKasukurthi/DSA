/* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do */

const removeElement = (nums, val) => {
  let count = 0
  nums.filter((num) => {
    if (num !== val) {
      nums[count] = num
      count++
    }
  })
  return count
}

console.log(removeElement([3,2,2,3], 3));