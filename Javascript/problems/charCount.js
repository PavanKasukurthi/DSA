const charCount = (str) => {
  result = {}
  str = str.toLowerCase()

  for (let char of str) {
    if (/[a-z0-9]/.test(char)) {
      result[char] > 0 ? result[char]++ : (result[char] = 1)
    }
  }

  return result
}

console.log(charCount('Hello'))
