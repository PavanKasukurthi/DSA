//USING FREQUENCY COUNTER

const anagram = (str1, str2) => {
  str1 = str1.toLowerCase()
  str2 = str2.toLowerCase()

  let frequencyCounter1 = {}
  let frequencyCounter2 = {}

  if (str1.length != str2.length) return false

  //FIRST LOOP TO CALCULATE FREQUENCIES OF FIRST STRING
  for (let val of str1) {
    frequencyCounter1[val] = (frequencyCounter1[val] || 0) + 1
  }

  //SECOND LOOP TO CALCULATE FREQUENCIES OF FIRST STRING
  for (let val of str2) {
    frequencyCounter2[val] = (frequencyCounter2[val] || 0) + 1
  }

  //THIRD LOOP TO COMPARE THE FREQUENCIES
  for (let val in frequencyCounter1) {
    if (frequencyCounter1[val] != frequencyCounter2[val]) return false
  }

  return true
}

console.log(anagram('cinema', 'icemaniceman'))
