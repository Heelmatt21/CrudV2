package sr.unasat.crudv2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DisplayDataActivity extends AppCompatActivity {

    private ListView listView;
    private DataDAO dataDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        listView = findViewById(R.id.listView);
        dataDAO = new DataDAO(this);

        displayData();
    }

    private void displayData() {
        dataDAO.open();
        List<DataModel> dataList = dataDAO.getAllData();
        dataDAO.close();

        for (DataModel data : dataList) {
            Log.d("DisplayDataDebug", "Custom Data: " + data.getCustomData());
        }

        ArrayAdapter<DataModel> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataList);

        listView.setAdapter(adapter);
    }
    /*private void displayData() {
        dataDAO.open();
        List<DataModel> dataList = dataDAO.getAllData();
        dataDAO.close();

        CustomDataAdapter adapter = new CustomDataAdapter(this, android.R.layout.simple_list_item_1, dataList);

        listView.setAdapter(adapter);
    }*/


}
