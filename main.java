import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main {
    enum NowType {
        FUNCTION,
        SRED,
        VALUE
    }
    enum Functions {
        Out,
        In,
        OutIn,
        OutL
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("path:");
        String fileName = in.nextLine();
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result = result + line + "\n";
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        NowType now = NowType.FUNCTION;
        Functions fun = Functions.Out;
        String InV = "NULL";

        for (char val: result.toCharArray())
        {
            if (now==NowType.FUNCTION)
            {
                if (val=='a')
                {
                    fun = Functions.Out;
                } else if (val=='b')
                {
                    fun = Functions.In;
                } else if (val=='c')
                {
                    fun = Functions.OutIn;
                } else if (val=='d')
                {
                    fun = Functions.OutL;
                } else {
                    fun = Functions.Out;
                }
                now = NowType.SRED;
            } else if (now==NowType.SRED)
            {
                now = NowType.VALUE;
            } else if (now==NowType.VALUE)
            {
                if (fun==Functions.Out)
                {
                    System.out.print(val);
                } else if (fun==Functions.In)
                {
                    InV = in.nextLine();
                } else if (fun==Functions.OutIn)
                {
                    System.out.print(InV);
                } else if (fun==Functions.OutL)
                {
                    System.out.println(val);
                }
                now = NowType.FUNCTION;
            }
        }
        in.close();
    }
}