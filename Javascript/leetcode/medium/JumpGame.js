const JumpGame = (nums) => {
  if (nums.length == 1 || nums[0] >= nums.length - 1) return true
  if (nums[0] == 0) return false

  let lastIndex = nums.length - 1
  for (let i = nums.length - 1; i >= 0; i--) {
    if (i + nums[i] >= lastIndex) {
      lastIndex = i
    }
  }

  return lastIndex == 0 ? true : false
}

console.log(JumpGame([2, 3, 1, 1, 4]))
