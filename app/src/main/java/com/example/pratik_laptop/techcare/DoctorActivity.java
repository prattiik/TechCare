package com.example.pratik_laptop.techcare;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;

import static com.example.pratik_laptop.techcare.SharedPrefManager1.getInstance;

public class DoctorActivity extends AppCompatActivity {

    Button add,view;
    EditText name,special,address,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        view=findViewById(R.id.doc_button2);
        name=findViewById(R.id.doc_editText3);
        special=findViewById(R.id.doc_editText4);
        address=findViewById(R.id.doc_editText);
        contact=findViewById(R.id.doc_editText5);
        add=findViewById(R.id.doc_button1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }
    private void registerUser() {
        final String Name = name.getText().toString().trim();
        final String Special = special.getText().toString().trim();
        final String Address = address.getText().toString().trim();
        final String Contact = contact.getText().toString().trim();

        //first we will do the validations

        if (TextUtils.isEmpty(Name)) {
            name.setError("Please enter username");
            name.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Special)) {
            special.setError("Please enter specialization");
            special.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Contact)) {
            contact.setError("Please enter contact number");
            contact.requestFocus();
            return;
        }

        //if it passes all the validations

        class RegisterUser extends AsyncTask<Void, Void, String> {

            private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("name", Name);
                params.put("special", Special);
                params.put("address", Address);
                params.put("contact", Contact);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_DOCTOR, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //displaying the progress bar while user registers on the server
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //hiding the progressbar after completion
                progressBar.setVisibility(View.GONE);

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("doc");

                        //creating a new user object
                        Doc doc = new Doc(
                                userJson.getInt("id"),
                                userJson.getString("name"),
                                userJson.getString("special"),
                                userJson.getString("address"),
                                userJson.getString("contact")
                        );

                        //storing the user in shared preferences
                        SharedPrefManager1.getInstance(getApplicationContext()).userLogin(doc);

                        //starting the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        RegisterUser ru = new RegisterUser();
        ru.execute();
    }

}

