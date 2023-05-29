import CalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA.*;

public class CalculatorServer {
    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            CalculatorImpl calculatorImpl = new CalculatorImpl();
            //calculatorImpl.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calculatorImpl);
            
            System.out.println("Step1");
            Calculator href = CalculatorHelper.narrow(ref);

            // get the root naming context
            System.out.println("Step2");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            System.out.println("Step3");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the object reference in naming
            System.out.println("Step4");
            NameComponent path[] = ncRef.to_name("Calculator");
            ncRef.rebind(path, href);

            System.out.println("CalculatorServer ready and waiting ...");

            // wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("CalculatorServer exiting ...");
    }
}
