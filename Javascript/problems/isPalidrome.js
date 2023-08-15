//USING MULTIPLE POINTERS
const isPalindrome = (str) => {
  let start = 0
  let end = str.length - 1

  if (str.length === 0 || str.length === 1) return true

  while (start <= end) {
    if (str[start] !== str[end]) {
      return 'Not a palindrome'
    }
    start += 1
    end -= 1
  }

  return 'It is a palindrome'
}

//RECURSION
const Palindrome = (str) => {
  if (str.length === 0 || str.length === 1) return true

  if (str[0] === str.slice(-1)) return Palindrome(str.slice(1, -1))
  return false
}

console.log(Palindrome('taadcaat'))
