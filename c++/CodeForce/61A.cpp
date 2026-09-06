#include <iostream>
#include <string>
using namespace std;

int main() {
    string a, b;

    cin >> a >> b;

    for (int i = 0; i < a.length(); i++) {
        int x = a[i] - '0';
        int y = b[i] - '0';

        cout << (x ^ y);
    }

    return 0;
}