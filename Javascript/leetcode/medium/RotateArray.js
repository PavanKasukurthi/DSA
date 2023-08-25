const RotateArray = (nums, k) => {
  k = k % nums.length
  const spliced = nums.splice(nums.length - k, k)
  nums.unshift(...spliced)
  console.log(nums)
}

//USING REVERSE
const rotateArray = (nums, k) => {
  k = k % nums.length
  reverse(nums, 0, nums.length - 1)
  reverse(nums, 0, k - 1)
  reverse(nums, k, nums.length - 1)
}

const reverse = (nums, start, end) => {
  while (start < end) {
    let temp = nums[start]
    nums[start] = nums[end]
    nums[end] = temp
    start++
    end--
  }
}

console.log(rotateArray([1, 2, 3, 4, 5, 6, 7], 3))
