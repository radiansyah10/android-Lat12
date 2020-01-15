package id.ac.poliban.latihan12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);
        TextView tvResult = findViewById(R.id.tvResult);

        btSave.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            String fname,lname;
            fname = etFirstName.getText().toString();
            lname = etLastName.getText().toString();

            edit.putString("fname", fname);
            edit.putString("lname", lname);
            edit.apply();

            Toast.makeText(this, "data has been seved it", Toast.LENGTH_SHORT).show();
        });

        btLoad.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            String fname = sp.getString("fname", "na");
            String lname = sp.getString("lname", "na");
            tvResult.setText(String.format("%s %s", fname, lname));
        });
    }
}