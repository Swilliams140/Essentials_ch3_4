package CustomeException.Binary;

public class Binary {
    private String binaryString;
    public Binary() throws IllegalBinaryNumberException{
        this("1111");
    }

    public Binary(String binaryString) throws IllegalBinaryNumberException{
    //    this.binaryString = binaryString; //if you use this way, you won't have
        //    any checked exception case
        setBinaryString(binaryString);
    }

    public String getBinaryString() {
        return binaryString;
    }

    public void setBinaryString(String binaryString) throws IllegalBinaryNumberException{
        for(int i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i) == '0' || binaryString.charAt(i) == '1'){
                this.binaryString = binaryString;
            }
            else{
                throw new IllegalBinaryNumberException("Binary number includes " +
                        "only 0 or 1");
            }
        }

    }


    //change string value of the binary number to decimal number
    public int binaryToDecimal(String binaryString) throws IllegalBinaryNumberException{
        int decimalValue = 0;
        for(int i = 0; i < binaryString.length(); i++){
            char ch = binaryString.charAt(i);
            if (ch == '0' || ch == '1') {

                decimalValue = decimalValue * 2 + binaryString.charAt(i) - '0';

            }
            else throw new IllegalBinaryNumberException("Binary number include " +
                    "only 0 and 1");
        }

        return decimalValue;
    }
}
