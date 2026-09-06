void main() {
  try {
    // ~/ integer division, floors the deciaml number,
    int num = 7 ~/ 0;
    print(num);
    // specific exception, ai for more. can change (on IntegerDivisionByZeroEception) to
    // ( catch (e) ), catch error, use if unsure of what exceptions might occur
  } catch(e){
    print(e);
  } finally {
    print("finally always print");
  }
}

// @Deprecated
