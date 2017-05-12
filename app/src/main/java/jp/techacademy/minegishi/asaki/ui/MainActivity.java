package jp.techacademy.minegishi.asaki.ui;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // メンバ変数
    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);  // (Button)というのはButtonクラスにキャストするという意味
        button1.setOnClickListener(this);                      // findViewByIdメソッドで取得したViewのインスタンスをButtonクラスに変換して、
                                                               // button1という変数に入れている
                                                               // ButtonクラスはViewクラスを継承しているので、キャストすることができる

        mTextView = (TextView) findViewById(R.id.textView);  // インスタンスを代入
        mEditText = (EditText) findViewById(R.id.editText);  // インスタンスを代入
    }

    @Override
    public void onClick(View v) {
        mTextView.setText(mEditText.getText().toString());  // EditTextに入力された文字列をStringクラスのインスタンスとして取得
    }   // getTextメソッドではStringクラスではなく、Editableインタフェースを実装した何らかのクラスのインスタンス。
        // このままではTextViewに設定することができないのでtoStringメソッドでStringクラスに変換
}