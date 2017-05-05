package com.vikas.myapplication;

import android.Manifest;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;



public class Appointment extends AppCompatActivity {
    private static final String TAG = "Appointment";
    String phoneNo,message;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0;

    @Bind(R.id.Afname)
    EditText _nameText;
    @Bind(R.id.Aemail)
    EditText _emailText;
    @Bind(R.id.Amobile)
    EditText _mobileText;
    @Bind(R.id.Aaddress)
    EditText _address;
    @Bind(R.id.Aspecify)
    EditText _specify;
    @Bind(R.id.Abreed)
    EditText _breed;
    @Bind(R.id.Apage)
    EditText _age;
    @Bind(R.id.Adate)
    EditText _date;
    @Bind(R.id.Atime)
    EditText _time;
    @Bind(R.id.btn_submit)
    Button _submit;

    /*@Bind(R.id.btn_signup)
    Button _signupButton;
    @Bind(R.id.link_login)
    TextView _loginLink;
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(this);

        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appoint();
            }
        });
/*
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });*/
    }
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;

    public String addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        //btnDisplay = (Button) findViewById(R.id.btnDisplay);
        // get selected radio button from radioGroup
        int selectedId = radioSexGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioSexButton = (RadioButton) findViewById(selectedId);
        String rdID= radioSexButton.getText().toString();
        return rdID;
/*        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {



                Toast.makeText(MyAndroidAppActivity.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });
*/
    }

    //Message
    public void sendSMSMessage() {
        final String name2 = _nameText.getText().toString();
        final String email2 = _emailText.getText().toString();
        final String mobile2 = _mobileText.getText().toString();
        final String date2 = _date.getText().toString();
        final String time2 = _time.getText().toString();
        CardMainActivity obj1=new CardMainActivity();
        final String docName1 =obj1.getDocEmail();
        phoneNo = mobile2;
        message = "VetsforPets: "+name2+ "("+email2+")"+" ,your Appointment with "+docName1+" ,at "+time2+" on "+date2+" has been booked Successfully.Please adhere to the timings";

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }

        }

    }
    public void appoint() {
        Log.v(TAG, "Appoint");

        if (!validate()) {
            onAppointFailed();
            return;
        }

        //_signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(Appointment.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Setting up your Appointment...");
        progressDialog.show();
        final String name1 = _nameText.getText().toString();
        final String email1 = _emailText.getText().toString();
        final String mobile1 = _mobileText.getText().toString();
        final String address1 = _address.getText().toString();
        final String specify1 = _specify.getText().toString();
        final String breed1 = _breed.getText().toString();
        final String age1 = _age.getText().toString();
        final String date1 = _date.getText().toString();
        final String time1 = _time.getText().toString();
        final String action1=addListenerOnButton();
        CardMainActivity obj=new CardMainActivity();
        final String docName =obj.getDocEmail();


        // TODO: Implement your own signup logic here.
        StringRequest request = new StringRequest(Request.Method.POST,"https://vetsforpets.000webhostapp.com/ajax_appointment_add.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("suuc app")){
                    sendSMSMessage();
                    Toast.makeText(Appointment.this, "Appointment has been booked", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    Intent intent=new Intent(Appointment.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Appointment.this, response, Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Appointment.this, error.getMessage(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<String, String>();
                map.put("name",name1);
                map.put("email",email1);
                map.put("phone",mobile1);
                map.put("address",address1);
                map.put("specify",specify1);
                map.put("breed",breed1);
                map.put("age",age1);
                map.put("action",action1);
                map.put("date",date1);
                map.put("time",time1);
                map.put("doctor",docName);
                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
        /*new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);*/
    }


    public void onAppointSuccess() {
        _submit.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onAppointFailed() {
        Toast.makeText(getBaseContext(), "Appointment failed", Toast.LENGTH_LONG).show();
        _submit.setEnabled(true);
    }


    private Pattern pattern;
    private Matcher matcher;

    private static final String DATE_PATTERN =
            "((19|20)\\d\\d) [/.-] (0?[1-9]|[12][0-9]|3[01]) [/.-] (0?[1-9]|1[012])";

    /**
     * Validate date format with regular expression
     * @param date date address for validation
     * @return true valid date format, false invalid date format
     */
    public boolean validate1(final String date){

        matcher = pattern.matcher(date);

        if(matcher.matches()){
            matcher.reset();

            if(matcher.find()){
                String day = matcher.group(3);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(1));

                if (day.equals("31") &&
                        (month.equals("4") || month .equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month .equals("06") ||
                                month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                }

                else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if(year % 4==0){
                        if(day.equals("30") || day.equals("31")){
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                    else{
                        if(day.equals("29")||day.equals("30")||day.equals("31")){
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                }

                else{
                    return true;
                }
            }

            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean validateT(Time time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date starttime= null;
        try {
            starttime = dateFormat.parse("10:00");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        Date EndTime = null;
        try {
            EndTime = dateFormat.parse("6:45");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date CurrentTime = time;

        if (CurrentTime.after(starttime) || CurrentTime.after(EndTime)) {
            return false;
        }
        return true;
    }
    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String address = _address.getText().toString();
        String specify = _specify.getText().toString();
        String breed = _breed.getText().toString();
        String age = _age.getText().toString();
        String date = _date.getText().toString();
        String time = _time.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            String errorna="at least 3 characters";
            Toast.makeText(Appointment.this,
                    errorna, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            String errorem="enter a valid email address";
            Toast.makeText(Appointment.this,
                    errorem, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() <10 || mobile.length()>10) {
            _mobileText.setError("10 numbers only");
            String errorm="10 numbers only";
            Toast.makeText(Appointment.this,
                    errorm, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        if (address.isEmpty() || address.length() > 50) {
            _address.setError("at most 50 characters");
            String errorad="at mostt 50 characters";
            Toast.makeText(Appointment.this,
                    errorad, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _address.setError(null);
        }

        if (specify.isEmpty() || specify.length() < 3) {
            _specify.setError("at least 3 characters");
            String errors="at least 3 characters";
            Toast.makeText(Appointment.this,
                    errors, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _specify.setError(null);
        }

        if (breed.isEmpty() || breed.length() < 3) {
            _breed.setError("at least 3 characters");
            String errorb="at least 3 characters";
            Toast.makeText(Appointment.this,
                    errorb, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _breed.setError(null);
        }

        if (age.isEmpty() || age.length() < 0 || age.length() > 51) {
            _age.setError("between 1-50 years");
            String errorag="between 1-50 years";
            Toast.makeText(Appointment.this,
                    errorag, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _age.setError(null);
        }
        if (date.isEmpty()) {
            _date.setError("Invalid format");
            String errord="Invalid format";
            Toast.makeText(Appointment.this,
                    errord, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _date.setError(null);
        }

        if (time.isEmpty()) {
            _time.setError("Time is Invalid");
            String errort="Time is Invalid";
            Toast.makeText(Appointment.this,
                    errort, Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            _time.setError(null);
        }

        return valid;
    }
}