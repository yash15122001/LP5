import CalculatorApp.*;
//import org.omg.CORBA.*;

public class CalculatorImpl extends CalculatorPOA {
    //private ORB orb;

    //public void setORB(ORB orb_val) {
    //    orb = orb_val;
    //}
    CalculatorImpl(){
		super();
	}

    public float add(float x, float y) {
        return x + y;
    }

    public float subtract(float x, float y) {
        return x - y;
    }

    public float multiply(float x, float y) {
        return x * y;
    }

    public float divide(float x, float y) {
        return x / y;
    }

    //public void shutdown() {
    //    orb.shutdown(false);
    //}
}
