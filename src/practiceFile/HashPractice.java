package practiceFile;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

public class HashPractice {
    public static void main(String[] args) {
        /*
         * String -> byte 변경 필요
         */
        String key = "hashtest";

        //To SHA512
        String result = getSHA512(key);
        System.out.println("================================================");
        System.out.println("after sha512 : ");
        System.out.println(result);
        System.out.println("================================================");

        //encode
        String encodedToBase64 = Base64.getEncoder().encodeToString(result.getBytes());
        
        //without padding
        // String encodedToBase64 = Base64.getEncoder().withoutPadding().encodeToString(result.getBytes());

        System.out.println("================================================");
        System.out.println("after base64 : ");
        System.out.println(encodedToBase64);
        System.out.println("================================================");

        //add randStr
        String addedCode = encodedToBase64 + "." + "12323";

        System.out.println("================================================");
        System.out.println("addedCode:");
        System.out.println(addedCode);
        System.out.println("================================================");

        //To SHA512
        String toReSha512 = getSHA512(addedCode);
        System.out.println("================================================");
        System.out.println("after sha512 again : ");
        System.out.println(toReSha512);
        System.out.println("================================================");

        //encode as String
        String finalBase64Encode = Base64.getEncoder().encodeToString(toReSha512.getBytes());

        System.out.println("================================================");
        System.out.println("after base64 again: ");
        System.out.println(finalBase64Encode);
        System.out.println("================================================");

        //encode as byte array
        byte[] toBytes = Base64.getEncoder().encode(toReSha512.getBytes());
        
        System.out.println("================================================");
        System.out.println("after base64 again: ");
        System.out.println(new String(toBytes));
        System.out.println("================================================");

        //decode
        byte [] bytes = Base64.getDecoder().decode(finalBase64Encode);
        System.out.println("================================================");
        System.out.println("decoded:");
        System.out.println(new String(bytes));
        System.out.println("================================================");

    }

    public static String getSHA512(String input){
		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
     }

}
