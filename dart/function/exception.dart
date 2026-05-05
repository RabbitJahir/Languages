void main() {
  try {
    // ~/ integer division, floors the deciaml number,
    int num = 7 ~/ 0;
    print(num);
    // specifi exception, ai for more. can change (on IntegerDivisionByZeroEception) to
    // ( catch (e) ), catch error
  } on IntegerDivisionByZeroException {
    print("error");
  }
}
