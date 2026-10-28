#include <bits/stdc++.h>
using namespace std;

// greedy method

int main(){

    int r=3,c=3;
    int d[r][c]={{3,4,5},{3,2,6},{2,2,1}};

    // matrix print
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cout<<d[i][j]<<" ";
        }
        cout<<endl;
    }

    cout<<endl<<endl;

    // assinging string values to the matrix
    string ascending[r*c];
    
    int k=0;
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            ascending[k] = to_string(d[i][j]) + "R" + to_string(i) + "C" + to_string(j);
            k++;
        }
    }

    for(int i=0;i<(r*c);i++){
        cout<<ascending[i]<<", ";
    }

    cout<<endl<<endl;


    // rearrenging string matrix values, in ascending order
    for(int i=0;i<(r*c);i++){
        for(int j=0;j<(r*c)-i-1;j++){
            int pos = ascending[j].find('R');
            int num = stoi(ascending[j].substr(0, pos));

            int pos1 = ascending[j+1].find('R');
            int num1 = stoi(ascending[j+1].substr(0, pos1));

            if(num>num1){
                swap(ascending[j], ascending[j+1]);
            }
        }
    }


    for(int i=0;i<(r*c);i++){
        cout<<ascending[i]<<", ";
    }

    cout<<endl<<endl;
    
    // actual formula
    

    // Build a separate path starting from every cell
    string paths[r*c][r*c];
    int pathLen[r*c] = {};

    // Try every cell as a starting point
    for(int start = 0; start < r*c; start++){

        int current = start;

        // Add the starting cell to its own path
        paths[start][0] = ascending[start];
        pathLen[start] = 1;

        // Keep finding the next cell
        while(pathLen[start] < r*c){

            int pos = ascending[current].find('R');
            int num = stoi(ascending[current].substr(0, pos));

            int row = stoi(ascending[current].substr(
                pos + 1,
                ascending[current].find('C') - pos - 1
            ));

            int col = stoi(ascending[current].substr(
                ascending[current].find('C') + 1
            ));

            bool found = false;

            // Search all cells for a valid next cell
            for(int j = 0; j < r*c; j++){

                int pos1 = ascending[j].find('R');
                int num1 = stoi(ascending[j].substr(0, pos1));

                int row1 = stoi(ascending[j].substr(
                    pos1 + 1,
                    ascending[j].find('C') - pos1 - 1
                ));

                int col1 = stoi(ascending[j].substr(
                    ascending[j].find('C') + 1
                ));

                if(num1 > num &&
                   abs(row - row1) + abs(col - col1) == 1){

                    paths[start][pathLen[start]] = ascending[j];
                    pathLen[start]++;

                    current = j;
                    found = true;
                    break;
                }
            }

            if(!found){
                break;
            }
        }
    }

    // Print every path
    cout << "\nAll paths:\n";

    for(int i = 0; i < r*c; i++){
        cout << "Starting from " << ascending[i] << ": ";

        for(int j = 0; j < pathLen[i]; j++){
            cout << paths[i][j];

            if(j < pathLen[i] - 1){
                cout << " -> ";
            }
        }

        cout << '\n';
    }

    return 0;
}