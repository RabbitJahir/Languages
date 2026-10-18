#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        if (height.empty()) return 0;

        int col = height.size();
        int row = height[0];

        // Find the maximum height (row count)
        for(int i = 0; i < col; i++) {
            if(row < height[i]) {
                row = height[i];
            }
        }

        int rain_water = 0;

        // Loop through each row (height level) from 0 to row-1
        for(int i = 0; i < row; i++) {
            bool temp = false;
            int temp_rain_water = 0;
            int current_row_water = 0;
            
            for(int j = 0; j < col - 1; j++) {
                // Virtual grid lookup instead of storing a 2D array
                bool current_is_wall = (height[j] > i);
                bool next_is_wall = (height[j+1] > i);

                if(current_is_wall && !next_is_wall) {
                    temp_rain_water++;
                    temp = true;
                } 
                else if(temp == true && !current_is_wall && !next_is_wall) {
                    temp_rain_water++;
                } 
                else if(temp == true && !current_is_wall && next_is_wall) {
                    current_row_water += temp_rain_water;
                    temp_rain_water = 0;
                    temp = false;
                }
            }
            rain_water += current_row_water;
        }

        return rain_water;
    }
};