const TwoSum = (nums, target) => {
  let res = []
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) {
        res[0] = i
        res[1] = j
        break
      }
    }
  }
  return res
}

console.log(TwoSum([3, 2, 4], 6))
