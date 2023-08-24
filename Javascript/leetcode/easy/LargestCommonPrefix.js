const LargestCommonPrefix = (strs) => {
  strs.sort()
  let count = 0
  let start = strs[0]
  let end = strs[strs.length - 1]

  for (let i = 0; i < strs.length; i++) {
    if (start.charAt(count) === end.charAt(count)) {
      count++
    }
  }

  return start.substring(0, count)
}

console.log(LargestCommonPrefix(['flower', 'flow', 'flip']))
