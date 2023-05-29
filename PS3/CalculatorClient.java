import CalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.io.*;

public class CalculatorClient {
    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the object reference in naming
            String name = "Calculator";
            Calculator calculator = CalculatorHelper.narrow(ncRef.resolve_str(name));
            
            System.out.println("Enter first number : ");
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			String x1= br.readLine();
			
			System.out.println("Enter second number : ");
			String y1= br.readLine();

            // perform calculations using the calculator object
            float x = Float.parseFloat(x1);
            float y = Float.parseFloat(y1);
            float result = calculator.add(x, y);
            System.out.println(x + " + " + y + " = " + result);

            result = calculator.subtract(x, y);
            System.out.println(x + " - " + y + " = " + result);

            result = calculator.multiply(x, y);
            System.out.println(x + " * " + y + " = " + result);

            result = calculator.divide(x, y);
            System.out.println(x + " / " + y + " = " + result);

            // shutdown the ORB
            orb.shutdown(false);
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
