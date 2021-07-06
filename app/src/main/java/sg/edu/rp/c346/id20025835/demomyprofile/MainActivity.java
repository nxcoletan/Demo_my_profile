package sg.edu.rp.c346.id20025835.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //get user input from editText and store it in a a variable
        String name = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        //obtain instance of SharedPreference
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //obtain instance of SharedPreference Editor for update
        SharedPreferences.Editor prefEdit = prefs.edit();

        //add key-value pair
        prefEdit.putString("name",name);
        prefEdit.putFloat("gpa",gpa);

        //commit changes
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String name = prefs.getString("name","John");
        float gpa = prefs.getFloat("gpa", 4.0f);

        etName.setText(name);
        etGPA.setText(gpa + "");
    }
}