// Complexity: O(N)
// Two pointers, credit given to 4ms sample solution
int maxArea(int* height, int heightSize) {
    int i = 0, j = heightSize - 1, tmp = 0, vol = 0;
    while (i < j) {
        if (*(height + i) < *(height + j)) {
            tmp = *(height + i) * (j - i);
            i++;
        }
        else {
            tmp = *(height + j) * (j - i);
            j--;
        }
        if (tmp > vol) vol = tmp;
    }
    return vol;
}
