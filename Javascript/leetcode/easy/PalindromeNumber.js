const PalindromeNumber = (num) => {
  let rev = 0
  let temp = num
  while (temp !== 0) {
    rev = rev * 10 + (temp % 10)
    temp = Math.floor(temp / 10)
  }
  return num === rev ? true : false
}

console.log(PalindromeNumber(4554354))
