package activitytest.example.shup.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Log.d(TAG, "onClick: button");

                String input = editText.getText().toString();
                Log.d(TAG, "onClick: input = " + input);

                Toast.makeText(MainActivity.this , input , Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_2:
                imageView.setImageResource(R.drawable.image_2);

                break;
            case R.id.button_3:
                //if (progressBar.getVisibility() == View.GONE){
                //    progressBar.setVisibility(View.VISIBLE);
                //}else{
                //    progressBar.setVisibility(View.GONE);
                //}

                //style="?android:attr/progressBarStyleHorizontal"

                int progress = progressBar.getProgress();
                if(progress >=100){
                    progress = 0;
                }else{
                    progress = progress + 10;
                }

                progressBar.setProgress(progress);
                Log.d(TAG, "onClick: prorgress = " + progress);
                break;
            case R.id.button_4:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.button_5:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();

                //关闭对话框
                //dialog.dismiss();
                break;
            default:
                Log.d(TAG, "onClick: default");
                break;
        }
    }
}
