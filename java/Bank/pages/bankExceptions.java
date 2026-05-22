package pages;

public class bankExceptions {

    public static class invalidInput extends RuntimeException {
        public invalidInput() { super("\033[1m\033[31mInvalid input.\033[0m"); }
    }

    public static class invalidAmount extends RuntimeException {
        public invalidAmount() { super("\033[1m\033[31mInvalid amount.\033[0m"); }
    }

    public static class existingLoan extends RuntimeException {
        public existingLoan() { super("\033[1m\033[31mPay previous loan first!\033[0m"); }
    }

    public static class invalidDuration extends RuntimeException {
        public invalidDuration() { super("\033[1m\033[31mDuration must be 3, 6, 12, or 24 months.\033[0m"); }
    }

    public static class insufficientBalance extends RuntimeException {
        public insufficientBalance(){
            super("\033[1m\033[33mInsufficient balance.\033[0m\nMinimum $ 100 is to be kept in bank"); 
        }
    }

    public static class similarUser extends RuntimeException {
        public similarUser() { super("\033[1m\033[33mUsername is identitical to yourself.\033[0m"); }
    }

}