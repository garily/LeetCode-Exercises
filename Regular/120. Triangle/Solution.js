/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    if (triangle.length == 0) return 0;
    if (triangle.length == 1) return triangle[0][0];
    var minArr = [triangle[0][0]];
    for (i = 1; i < triangle.length; i++) {
        let rowMinArr = [];
        for (j = 0; j < triangle[i].length; j++) {
            if (j == 0) rowMinArr.push(triangle[i][j] + minArr[0]);
            else if (j == triangle[i].length - 1) rowMinArr.push(triangle[i][j] + minArr[triangle[i].length - 2]);
            else rowMinArr.push(triangle[i][j] + Math.min(minArr[j - 1], minArr[j]));
        }
        minArr = rowMinArr;
    }
    return Math.min(...minArr);
};
