package CalculatorApp;


/**
* CalculatorApp/CalculatorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalculatorApp.idl
* Monday, 29 May, 2023 4:48:34 AM IST
*/

public abstract class CalculatorPOA extends org.omg.PortableServer.Servant
 implements CalculatorApp.CalculatorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("subtract", new java.lang.Integer (1));
    _methods.put ("multiply", new java.lang.Integer (2));
    _methods.put ("divide", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CalculatorApp/Calculator/add
       {
         float x = in.read_float ();
         float y = in.read_float ();
         float $result = (float)0;
         $result = this.add (x, y);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 1:  // CalculatorApp/Calculator/subtract
       {
         float x = in.read_float ();
         float y = in.read_float ();
         float $result = (float)0;
         $result = this.subtract (x, y);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 2:  // CalculatorApp/Calculator/multiply
       {
         float x = in.read_float ();
         float y = in.read_float ();
         float $result = (float)0;
         $result = this.multiply (x, y);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 3:  // CalculatorApp/Calculator/divide
       {
         float x = in.read_float ();
         float y = in.read_float ();
         float $result = (float)0;
         $result = this.divide (x, y);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CalculatorApp/Calculator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calculator _this() 
  {
    return CalculatorHelper.narrow(
    super._this_object());
  }

  public Calculator _this(org.omg.CORBA.ORB orb) 
  {
    return CalculatorHelper.narrow(
    super._this_object(orb));
  }


} // class CalculatorPOA
