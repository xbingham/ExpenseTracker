import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputWrapper {
    
    private static BufferedReader Reader;

    public static void Setup(){
       InputWrapper.Reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String GetStringInput(String Output){
        String ReturnData = null;
        do
            try {
                System.out.println(Output);
                ReturnData = InputWrapper.Reader.readLine();
            }catch(Exception ex){
                System.out.println("Wrong Type Of Input. Try Again.");
            }
        while(ReturnData == null);
        System.out.println();
        return ReturnData;
    }

    public static Integer GetIntInput(String Output){
        Integer ReturnData = null;
        do
            try {
                System.out.println(Output);
                ReturnData = Integer.parseInt(InputWrapper.Reader.readLine());
            }catch(Exception ex){
                System.out.println("Wrong Type Of Input. Try Again.");
            }
        while(ReturnData == null);
        System.out.println();
        return ReturnData;
    }
    
    public static Double GetDoubleInput(String Output){
        Double ReturnData = null;
        do
            try {
                System.out.println(Output);
                ReturnData = Double.parseDouble(InputWrapper.Reader.readLine());
            }catch(Exception ex){
                System.out.println("Wrong Type Of Input. Try Again.");
            }
        while(ReturnData == null);
        System.out.println();
        return ReturnData;
    }

}
