// Complexity O(N*2)
// Two pointers
int maxArea(int* height, int heightSize) {
    int vol = *height < *(height + 1) ? *height : *(height + 1);
    int i, j;
    for (i = 0; i < heightSize - 1; i++) {
        if (i > 0 && *(height + i) <= *(height + i - 1)) continue;
        for (j = i + 1; j < heightSize; j++) {
            if (j < heightSize - 2 && *(height + i) >= *(height + j + 1) && *(height + j + 1) >= *(height + j)) continue;
            if (vol < (*(height + i) < *(height + j) ? *(height + i) : *(height + j)) * (j - i)) {
                vol = (*(height + i) < *(height + j) ? *(height + i) : *(height + j)) * (j - i);
            }
        }
    }
    return vol;
}
