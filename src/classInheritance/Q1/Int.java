package classInheritance.Q1;

public class Int implements Number{
    private int value;
    public Int(int value){
        this.value = value;
    };

    public int getValue(){
        return this.value;
    }
    @Override
    public boolean equalTo(Number n){
        if(n instanceof Int aInt){
            return aInt.getValue() == this.value;
        }
        if(n instanceof  Float aFloat){
            return aFloat.getValue() == (float) this.value;
        }

        return false;
    }
    @Override
    public int comparedTo(Number n){
        if(n instanceof Float afloat){
            if ((float) this.getValue() > afloat.getValue()){
                return 1;
            } else if((float) this.getValue() < afloat.getValue()){
                return -1;
            } else return 0;
        } else if(n instanceof Int aInt){
            if(this.getValue() > aInt.getValue()) {
                return 1;
            } else if(this.getValue() < aInt.getValue()){
                return -1;
            } else return 0;
        }
        return 0;
    }

}
