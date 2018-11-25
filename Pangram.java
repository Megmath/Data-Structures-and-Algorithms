import java.util.Arrays;

public class Pangram {

    public boolean checkPangram(){

        String s = "the quick brown fox jumps over the lazy dog";

        boolean[] alpha = new boolean[26];
        int index=0;
        Arrays.fill(alpha, false);

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                index = s.charAt(i) - 'a';
                alpha[index] = true;
                //  System.out.println(alpha[index] + " ");
            }
        }
/*
        for(int j=0;j<26;j++){
            System.out.println(alpha[j] + " ");
        }
*/
        for (int i = 0; i <= 25; i++)
            if (alpha[i] == false)
                return (false);
        return(true);
    }

    public static void main(String args[]){

        Pangram p = new Pangram();
        boolean check = p.checkPangram();
        if(check==true){
            System.out.println("The string is a pangram");
        }
        else
            System.out.println("The string is NOT a pangram");

    }
}
