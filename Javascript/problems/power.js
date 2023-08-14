//RECURSION

const power = (base, exponent) => {
  if (exponent === 0) return 1
  if (exponent < 0) return 'Enter a positive exponent'

  return base * power(base, exponent - 1)
}

console.log(power(2, 0)) //1
console.log(power(-2, 2)) //4
