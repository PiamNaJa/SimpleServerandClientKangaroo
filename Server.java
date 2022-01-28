import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket s1 = new ServerSocket(1234);
        Socket s = s1.accept();
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String c1 = bf.readLine();
        String c2 = bf.readLine();
        System.out.println("Entered Word from Client : " + c1);
        System.out.println("Search Word from Client : " + c2);
        String o1 = c1;
        String o2 = c2;
        c1 = c1.toUpperCase();
        c2 = c2.toUpperCase();
        int n1 = c1.length();
        int n2 = c2.length();
        int i, j=0;
        boolean is_kang_word = false;
        char[] w1 = c1.toCharArray();
        char[] w2 = c2.toCharArray();
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        if (n2 > n1)
        {
            pr.println("Search Word Must less than Word");
        }
        else
        {
            for (i = 0; i < n1; i++)
            {
                if (w1[i] == w2[j])
                {
                    j++;
                    if (j == n2)
                    {
                        is_kang_word = true;
                        break;
                    }
                }
            }
        }
        if(is_kang_word == true)
        {
            pr.println(o2 + " Is Kangaroo Word Of " + o1 + ".");
        }
        else
        {
            pr.println(o2 + " Is Not Kangaroo Word Of " + o1 + ".");
        }
        pr.flush();
        s.close();
        s1.close();
        in.close();
        bf.close();
        pr.close();
    }
}
