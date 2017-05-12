package jp.techacademy.minegishi.asaki.ui;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        // setOnClickListenerメソッドの引数にはonClickメソッドを実装した
        // クリックリスナークラスを渡す必要がある。
        // 今回はMainActivityクラス自身(this)を設定。
    }

    @Override
    public void onClick(View v) {  // onClickメソッドを実装
        Log.d("UI_PARTS", "ボタンをタップしました");
    }
}
