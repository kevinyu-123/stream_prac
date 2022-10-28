package practiceFile;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

public class HashPractice {
    public static void main(String[] args) {
        /*
         * String -> byte 변경 필요
         */
        String key = "hashtest";

        //To SHA512
        byte [] result = getSHA512(key);
        System.out.println("================================================");
        System.out.println("after sha512 : ");
        System.out.println(result);
        System.out.println("================================================");

        //encode
        String encodedToBase64 = Base64.getEncoder().encodeToString(result);
        
        //without padding
        // String encodedToBase64 = Base64.getEncoder().withoutPadding().encodeToString(result.getBytes());

        System.out.println("================================================");
        System.out.println("after base64 : ");
        System.out.println(encodedToBase64);
        System.out.println("================================================");

        //add randStr
        String addedCode = encodedToBase64 + "." + "12323";
        
        //better use Stringbuffer
        StringBuffer sb = new StringBuffer(addedCode);
        sb.append(rand());


        System.out.println("================================================");
        System.out.println("addedCode:");
        System.out.println(addedCode);
        System.out.println("================================================");

        //To SHA512
        byte [] toReSha512 = getSHA512(addedCode);
        System.out.println("================================================");
        System.out.println("after sha512 again : ");
        System.out.println(toReSha512);
        System.out.println("================================================");

        //encode as String
        String finalBase64Encode = Base64.getEncoder().encodeToString(toReSha512);

        System.out.println("================================================");
        System.out.println("after base64 again: ");
        System.out.println(finalBase64Encode);
        System.out.println("================================================");


    }

    public static byte [] getSHA512(String input){
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    return digest.digest();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return null;
     }

     private static String rand() {
        Random ran = new Random();
        String str = "";
        int num;
        while (str.length() != 20) {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                str += (char) num;
            } else {
                continue;
            }
        }
        return str;
    }

}
