const TwoSumII = (nums, target) => {
    let i = 0;
    let j = nums.length - 1;

    while(i < j){
        if(nums[i] + nums[j] === target){
            return [i+1, j+1]
        }
        else if(nums[i] + nums[j] > target){
            j--;
        }
        else if(nums[i] + nums[j] < target){
            i++;
        }
    }
}