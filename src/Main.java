import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input two binary strings: ");
        Scanner input=new Scanner(System.in);
        String firstString = input.next();
        String secondString = input.next();

        String addition = Addition(firstString,secondString);
        String multiplication = Multiplication(firstString,secondString);
        int i=0,j=0;
        while(true ){//deleting unwanted zeros at the first of the string
            if(addition.charAt(i)=='0'){
                i++;
            }
            else{
                addition=addition.substring(i);
                break;
            }

        }

        while(true ){//deleting unwanted zeros at the first of the string
            if(addition.charAt(j)=='0'){
                j++;
            }
            else{
                multiplication=multiplication.substring(i);
                break;
            }

        }
        int additionDecimalValue=Integer.parseInt(addition,2);//parsing binary string to decimal
        int multiplicationDecimalValue=Integer.parseInt(multiplication,2);//parsing binary string to decimal
        System.out.println("Addition: "+addition+"("+additionDecimalValue+")");
        System.out.println("Multiplication: "+multiplication+"("+multiplicationDecimalValue+")");

    }
    public static String Addition(String str1, String str2){
        StringBuilder sb= new StringBuilder(32);//we used string builder to store our one to one digit char sums in 32

        int first = str1.length()-1;
        int second = str2.length()-1;

        int carry = 0;
        while(first >= 0 || second >= 0)
        {
            int oneToOneSum = carry;
            if(first >= 0 ){
                oneToOneSum += str1.charAt(first) -'0';
                first--;
            }
            if(second >= 0 ){
                oneToOneSum += str2.charAt(second)-'0';
                second--;
                //then we decrease indexes by 1 to calculate other oneToOneSums
            }
           carry = oneToOneSum>>1;
            oneToOneSum=oneToOneSum&1;


            sb.append(oneToOneSum==0 ? '0' :'1');//then we add the strings' digit sum to string builder array in format of char



        }
        //at the end of the loop, we have an array full of one to one sums.
        if(carry == 1)//means we have 1 one more digit to be add
            sb.append('1');//we add that digit to the first

        sb.reverse();
        return String.valueOf(sb);//finally function returns the string that we derived from oneToOneSums
    }

    public static String Multiplication(String str1,String str2){
        String result = "";
        String index_zero = "";
        for(int i = str2.length()-1; i>=0; i--){
            if(str2.charAt(i) == '1'){
                result = Addition(result,str1+index_zero);
            }
            index_zero += '0' ;

        }
        return result;
    }
}


