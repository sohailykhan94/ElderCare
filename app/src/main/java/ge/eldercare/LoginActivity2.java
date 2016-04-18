package ge.eldercare;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity2 extends AppCompatActivity implements AddEmergencyContactFragment.EmergencyDialogListener{

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    Context context;

    String m_Text;

    // UI references.
    private View mProgressView;
    private View mLoginFormView;

    EditText name;
    EditText phone;
    TextView contact1;
    TextView contact2;
    RadioGroup radioGroupTitle;
    RadioButton radioButtonTitle;
    ArrayList<String> contactListNames = new ArrayList<>();
    ArrayList<String> contactListPhone = new ArrayList<>();
    int contactCount = 0;
    MultiAutoCompleteTextView allergies;
    MultiAutoCompleteTextView diseases;
    String[] allergiesList={"Celery ","Gluten","Crustaceans","Eggs","Fish","Lupin","Milk", "Molluscs", "Mustard", "Nuts", "Peanuts", "Sesame seeds", "Soya", "Sulphur dioxide"};
    String[] diseaseList={"Arthritis ","Heart Disease","Cancer","Respiratory Diseases","Alzheimer’s Disease","Osteoporosis","Diabetes", "Influenza and Pneumonia", "Substance Abuse", "Obesity", "Depression", "Oral Health", "Shingles", "Septicaemia", "Dementia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context  = this.getApplicationContext();
        setContentView(R.layout.activity_login2);
        // Set up the form.
        contact1 = (TextView) findViewById(R.id.contact1);
        contact2 = (TextView) findViewById(R.id.contact2);
        allergies=(MultiAutoCompleteTextView)findViewById(R.id.allergies);
        diseases=(MultiAutoCompleteTextView)findViewById(R.id.diseases);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,allergiesList);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,diseaseList);

        allergies.setAdapter(adapter);
        allergies.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        diseases.setAdapter(adapter2);
        diseases.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    public void addEmergencyContact(View v){

        if(contactCount == 2){
            Toast.makeText(this, "Hey, you can add a maximum of two contacts" , Toast.LENGTH_LONG).show();
            return;
        }

        FragmentManager fm = getSupportFragmentManager();
        AddEmergencyContactFragment editNameDialog = new AddEmergencyContactFragment();
        editNameDialog.show(fm, "fragment_edit_name");

    }

    public void finishSignup(View v){
        Intent myIntent = new Intent(LoginActivity2.this, HomeActivity.class);
        LoginActivity2.this.startActivity(myIntent);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button
        name = (EditText) dialog.getDialog().findViewById(R.id.emergencyName);
        phone = (EditText) dialog.getDialog().findViewById(R.id.emergencyNumber);
        radioGroupTitle = (RadioGroup) dialog.getDialog().findViewById(R.id.radioTitle);

        int selectedId = radioGroupTitle.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButtonTitle = (RadioButton) dialog.getDialog().findViewById(selectedId);

        String title = radioButtonTitle.getText().toString();

        if(contactCount == 2){
            Toast.makeText(this, "Hey, you can add a maximum of two contacts" , Toast.LENGTH_LONG).show();
            return;
        }else if(contactCount ==1 ){
            contactListNames.add(name.getText().toString());
            contactListPhone.add(phone.getText().toString());
            contact2.setText(title + " " + name.getText());
            contactCount++;
        }else{
            contactListNames.add(name.getText().toString());
            contactListPhone.add(phone.getText().toString());
            contact1.setText(title + " " + name.getText());
            contactCount++;
        }
    }


    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}

