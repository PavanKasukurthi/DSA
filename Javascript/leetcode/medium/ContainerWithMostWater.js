const ContainerWithMostWater = (height) => {
  let left = 0,
    right = height.length - 1
  let max_area = 0

  while (left < right) {
    if (height[left] < height[right]) {
      max_area = Math.max(max_area, height[left] * (right - left))
      left++
    } else {
      max_area = Math.max(max_area, height[right] * (right - left))
      right--
    }
  }
  return max_area
}

console.log(ContainerWithMostWater([1, 8, 6, 2, 5, 4, 8, 3, 7]))