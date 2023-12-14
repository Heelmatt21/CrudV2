package sr.unasat.crudv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DataDAO dataDAO;
    private EditText customDataEditText;

    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataDAO = new DataDAO(this);
        dataDAO.open();

        customDataEditText = findViewById(R.id.customDataEditText);

        addButton = findViewById(R.id.addButton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        Button displayButton = findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
            }
        });



        /*dataDAO = new DataDAO(this);
        dataDAO.open();

        customDataEditText = findViewById(R.id.customDataEditText);

        addButton = findViewById(R.id.addButton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });*/
        displayData();


    }

    private void insertData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        String currentDate = dateFormat.format(new Date());
        String currentTime = timeFormat.format(new Date());

        String customData = customDataEditText.getText().toString().trim();


        DataModel data = new DataModel(currentDate, currentTime);
        data.setCustomData(customData);
        


        long result = dataDAO.insertData(data);

        if (result != -1) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            displayData();
        } else {
            Toast.makeText(this, "Failed to insert data", Toast.LENGTH_SHORT).show();
        }

    }


    private void displayData() {
        List<DataModel> dataList = dataDAO.getAllData();

        for (DataModel data : dataList) {
            // Doe iets met de gegevens, bijvoorbeeld afdrukken in de Logcat
            System.out.println("ID: " + data.getId() +
                    ", Date: " + data.getDate() +
                    ", Time: " + data.getTime());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataDAO.close();
    }
}

