package apps.kaltengguide.rofiqoff.com.kaltengguide.database;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rofiqoff on 4/25/17.
 */

public class Helper {

    public static String BASE_URL = "http://palangkarayaguide.pe.hu/";

    public static boolean isCompare(EditText et1, EditText et2){
        String a = et1.getText().toString();
        String b = et2.getText().toString();

        if (a.equals(b)){
            return false;
        } else {
            return true;
        }
    }

    public static void pesan (Context c, String msg){
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(EditText editText){
        if (editText.getText().toString().trim().length() > 0){
            return false;
        }else {
            return true;
        }
    }

    // validasi untuk inputan email
    public static boolean isEmailValid(EditText email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email.getText().toString();

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}
