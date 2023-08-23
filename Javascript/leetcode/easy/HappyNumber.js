const HappyNumber = (n) => {
  if (n === 1 || n === 7) return true
  if (n % 10 === n) return false

  let sum = 0
  let temp = n

  while (temp != 0) {
    sum += Math.floor(temp % 10) ** 2
    temp = temp / 10
  }

  if (sum === 1) {
    return true
  }

  return HappyNumber(sum)
}

console.log(HappyNumber(19))
