package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener {
    public static final String fullName_KEY = "fullName";
    public static final String Email_KEY = "Email";
    public static final String Password_KEY = "Password";
    public static final String ConfirmPassword_KEY = "ConfirmPassword";
    public static final String HomePage_KEY = "HomePage";
    public static final String AboutYou_KEY = "AboutYou";
    @NotEmpty
    private EditText fullName;
    @NotEmpty
    @Email
    private EditText Email;
    @NotEmpty
    @com.mobsandgeeks.saripaar.annotation.Password
    private EditText Password;
    @NotEmpty
    @com.mobsandgeeks.saripaar.annotation.ConfirmPassword
    private EditText ConfirmPassword;
    @NotEmpty
    private EditText HomePage;
    @NotEmpty
    private EditText AboutYou;
    protected Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        validator = new Validator(this);
        validator.setValidationListener(this);
        validator.validate(true);

        fullName = findViewById(R.id.text_fullname);
        Email = findViewById(R.id.text_email);
        Password = findViewById(R.id.text_password);
        ConfirmPassword = findViewById(R.id.text_confirm_password);
        HomePage = findViewById(R.id.text_homepage);
        AboutYou = findViewById(R.id.text_about);
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void handleOK(View view) {
        validator.validate();
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(FullName_KEY,FullName);


    }
}

