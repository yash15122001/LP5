// Implementation of Token Ring Algorithm
import java.io.*;
import java.lang.*;

class TokenRing
{

    public static void main(String args[]) throws Throwable {
        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("Enter number of nodes : ");
        int n = Integer.parseInt(dis.readLine());
        // Decides the number of nodes forming the ring
        int token = 0;
        int ch = 1;
        for (int i = 0; i < n; i++)
            System.out.print(i + " ");
        System.out.println(0);
        try {
            while (ch == 1) {
                System.out.print("\n\nEnter sender : ");
                int s = Integer.parseInt(dis.readLine());
                System.out.print("Enter receiver : ");
                int r = Integer.parseInt(dis.readLine());
                System.out.print("Enter Data : ");
                String d = dis.readLine();
                System.out.print("\nToken passing : ");

                for (int i = token; i != s; i++)
                    System.out.print(" " + i + "->");
                System.out.println(" " + s);
                System.out.println("Sender : " + s + "\tSending data : " + d);
                for (int i = s + 1; i != r; i = (i + 1) % n)
                    System.out.println("Data : " + d + "\tForwarded by : " + i);
                System.out.println("Receiver : " + r + "\tReceived data : " + d);
                token = s;
            }
        } 
        catch (Exception e) {
        	System.out.print(e);
        }
    }
}
