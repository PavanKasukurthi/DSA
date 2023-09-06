// ASKED IN INTERVIEW

const SpiralMatrix = (matrix) => {
  let rBegin = 0
  let cBegin = 0
  let rEnd = matrix.length - 1
  let cEnd = matrix[0].length - 1

  let result = []

  while (rBegin <= rEnd && cBegin <= cEnd) {
    for (let i = cBegin; i <= cEnd; i++) {
      result.push(matrix[rBegin][i])
    }

    rBegin++

    for (let i = rBegin; i <= rEnd; i++) {
      result.push(matrix[i][cEnd])
    }

    cEnd--

    if (rBegin <= rEnd) {
      for (let i = cEnd; i >= cBegin; i--) {
        result.push(matrix[rEnd][i])
      }
    }

    rEnd--

    if (cBegin <= cEnd) {
      for (let i = rEnd; i >= rBegin; i--) {
        result.push(matrix[i][cBegin])
      }
    }

    cBegin++
  }

  return result
}

const matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
]

console.log(SpiralMatrix(matrix))
