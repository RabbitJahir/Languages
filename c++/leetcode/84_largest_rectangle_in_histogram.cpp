
#include <iostream>
using namespace std;

int main() {
    int heights[] = {2,2, 1, 5, 6, 2, 3};

    int size = sizeof(heights) / sizeof(heights[0]);
    int biggest = 0;

    for (int i = 0; i < size; i++) {
        // pillars to multiply with
        int pillars = 1;

        // Expanding to left
        for (int j = i - 1; j >= 0; j--) {
            if (heights[j] >= heights[i]) {
                pillars++;
            } else {
                break;
            }
        }

        // Expanding to right
        for (int j = i + 1; j < size; j++) {
            if (heights[j] >= heights[i]) {
                pillars++;
            } else {
                break;
            }
        }

        int area = heights[i] * pillars;

        if (area > biggest) {
            biggest = area;
        }
    }

    cout << biggest<<endl;

    return 0;
}
