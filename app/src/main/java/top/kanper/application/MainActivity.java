package top.kanper.application;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;

    private EditText name, surname, marks;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper = new DataBaseHelper(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> addStudent());
    }

    public void addStudent() {
        name = findViewById(R.id.editText);
        surname = findViewById(R.id.editText2);
        marks = findViewById(R.id.editText3);

        Boolean b = dataBaseHelper.insertData(name.getText().toString(), surname.getText().toString(), Integer.parseInt(marks.getText().toString()));
        if (b) {
            Toast.makeText(this, "数据添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "数据添加失败", Toast.LENGTH_SHORT).show();
        }

    }
}
