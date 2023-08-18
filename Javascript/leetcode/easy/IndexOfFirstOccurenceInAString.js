const strStr = (hayStack, needle) => {
  let left = 0
  let right = needle.length

  while (right <= hayStack.length) {
    if (hayStack.substr(left, right) === needle) {
      return left
    }
    left += 1
    right += 1
  }

  return -1
}

console.log(strStr('sadbutsad', 'sad'))
console.log(strStr('leetcode', 'leeto'))
