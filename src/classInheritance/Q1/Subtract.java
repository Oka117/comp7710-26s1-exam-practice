package classInheritance.Q1;

public class Subtract implements Operation{
    @Override
    public Number execute(Number a, Number b){
        if(a instanceof Int aInt && b instanceof Int bInt){
            return new Int(aInt.getValue() - bInt.getValue());
        }

        if(a instanceof Float afloat){
            if(b instanceof Float bFloat){
                return new Float(afloat.getValue() - bFloat.getValue());
            }
        }
        if(a instanceof Int aInt){
            if(b instanceof Float bFloat){
                return new Float((float)aInt.getValue() - bFloat.getValue());
            }
        }
        if(b instanceof Int bInt){
            if(a instanceof Float aFloat){
                return new Float(aFloat.getValue() - (float)bInt.getValue());
            }
        }
        return null;
    };
}
