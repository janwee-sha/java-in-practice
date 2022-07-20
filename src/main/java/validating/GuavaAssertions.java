package validating;

import com.google.common.base.VerifyException;

import static com.google.common.base.Verify.verify;

public class GuavaAssertions {
    public static void main(String[] args) {
        try{
            verify(2+2==5);
        }catch (VerifyException e){
            e.printStackTrace();
        }
    }
}
