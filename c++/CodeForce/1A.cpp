#include <bits/stdc++.h>
using namespace std;

int main() {
    long long n, m, a;
    cin >> n >> m >> a;

    long long x =  ceil((double)n/ a);
    long long y = ceil((double)m/ a);

    long long output = x * y;

    cout << output;

    return 0;
}