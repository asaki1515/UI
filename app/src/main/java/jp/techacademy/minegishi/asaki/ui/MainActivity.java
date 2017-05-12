package jp.techacademy.minegishi.asaki.ui;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {  //new View.OnClickListener() {…}無名クラス
            @Override                                            // OnClickListenerクラスを実装したクラスを指定する以外に直接記述することもできる。
            public void onClick(View v) {
                Log.d("UI_PARTS", "ボタンをタップしました");
            }
        });
    }
}