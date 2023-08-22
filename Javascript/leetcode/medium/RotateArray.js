const RotateArray = (nums, k) => {
  k = k % nums.length
  reverse(nums, 0, nums.length - 1)
  reverse(nums, 0, k - 1)
  reverse(nums, k, nums.length - 1)

  console.log(nums)
}

const reverse = (nums, left, right) => {
  while (left < right) {
    let temp = nums[left]
    nums[left] = nums[right]
    nums[right] = temp
    right--
    left++
  }
}

RotateArray([1, 2, 3, 4, 5, 6, 7], 3)
