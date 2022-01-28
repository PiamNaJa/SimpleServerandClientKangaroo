import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException 
    {
        Socket s = new Socket("localhost", 1234);
        Scanner kb = new Scanner(System.in); 
        System.out.print("Word 1 : ");
        String w1 = kb.nextLine();
        System.out.print("Word 2 : ");
        String w2 = kb.nextLine();
        System.out.println("-----------------------------------");
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(w1);
        pr.flush();
        pr.println(w2);
        pr.flush();
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String ans = bf.readLine();
        System.out.println("Server : " + ans);
        s.close();
        pr.close();
        in.close();
        bf.close();
        kb.close();
    }

}