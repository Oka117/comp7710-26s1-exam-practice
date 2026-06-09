package classInheritance.Q1;

public class Float implements Number {
    private float value;
    public Float(float value){
        this.value = value;
    };
    public Float(double value){
        this.value = (float)value;
    };
    public float getValue(){
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
            if (this.getValue() > afloat.getValue()){
                return 1;
            } else if((float) this.getValue() < afloat.getValue()){
                return -1;
            } else return 0;
        } else if(n instanceof Int aInt){
            if(this.getValue() > (float) aInt.getValue()) {
                return 1;
            } else if(this.getValue() < (float) aInt.getValue()){
                return -1;
            } else return 0;
        }
        return 0;
    }
}
