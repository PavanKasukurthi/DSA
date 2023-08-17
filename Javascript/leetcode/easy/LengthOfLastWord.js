const LengthOfLastWord = (str) => {
  let s = str.trim().split(' ')
  return s[s.length - 1].length
}

console.log(LengthOfLastWord('Hello World'))
