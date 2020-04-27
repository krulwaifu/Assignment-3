package java;

public class Password {
    // passwordStr // it should contain uppercase and lowercase letters and digits
    // and its length must be more than 9 symbols
    private String passwordStr;

    public Password(String passwordStr){
        setPasswordStr(passwordStr);
    }
    public String getPasswordStr() {
        return passwordStr;
    }

    public void setPasswordStr(String passwordStr) {
        if (checkPassword(passwordStr)) {
            this.passwordStr = passwordStr;
        }else{
            System.out.println("Password is incorrect");
        }
    }
    private boolean checkPassword(String passwordStr){
        if (passwordStr.length()<9){return false;}
        if (!checkStr(passwordStr)){return false;}
        return true;

    }
    private boolean checkStr(String passwordStr){
        char ch;
        boolean capital = false;
        boolean lower = false;
        boolean number = false;
        for(int i=0;i < passwordStr.length();i++) {
            ch = passwordStr.charAt(i);
            if( Character.isDigit(ch)) {
                number = true;
            }
            else if (Character.isUpperCase(ch)) {
                capital = true;
            } else if (Character.isLowerCase(ch)) {
                lower = true;
            }
            if(number && capital && lower)
                return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return passwordStr;
    }
}