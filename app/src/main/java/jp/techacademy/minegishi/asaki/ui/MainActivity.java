package jp.techacademy.minegishi.asaki.ui;

        import android.app.TimePickerDialog;
        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.app.AlertDialog;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.EditText;
        import android.widget.TimePicker;

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

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        // 2つのボタンのリスナーにMainActivityが登録されているので、
        // どちらのボタンをタップした時にもMainActivityのonClickメソッドが呼ばれることになる

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);


        mTextView = (TextView) findViewById(R.id.textView);  // インスタンスを代入
        mEditText = (EditText) findViewById(R.id.editText);  // インスタンスを代入
    }

    @Override     // クラス内でインタフェースのメソッドの中身を実装する時は@Overrideをつける
    public void onClick(View v) {    // onClickメソッドはView.OnClickListenerインタフェースのメソッド。
        if (v.getId() == R.id.button1) {
            mTextView.setText(mEditText.getText().toString());
        } else if (v.getId() == R.id.button2) {
            showAlertDialog();
        } else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        }
    }

    private void showAlertDialog() {   // AlertDialogを表示させている
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        // コンストラクタ
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("タイトル");  // AlertDialog.Builderクラスから生成されたalertDialogBuilderインスタンスのsetTitlメソッドに引数”タイトル”を渡す
        alertDialogBuilder.setMessage("メッセージ");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定",  // setPositiveButton=肯定
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "肯定ボタン");
                    }
                });

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNeutralButton("中立",   // setNeutralButton=中立
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "中立ボタン");
                    }
                });

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定",   // setNegativeButton=否定
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }   // AlertDialog.BuilderクラスのcreateメソッドでAlertDialogクラスのインスタンスを生成し、showメソッドを呼び出して表示させる

    private void showTimePickerDialog() {
        // コンストラクタ
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  // Activity
                new TimePickerDialog.OnTimeSetListener() { // 無名クラス  OnTimeSetListener（時刻を設定した時にonTimeSetメソッドが呼ばれる）
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {  //OnTimeSetListenerのonTimeSetメソッド
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);  // trueは24時間表記、falseは午前、午後を選択する形
        timePickerDialog.show();  // showメソッドでTimePickerDialogを表示
    }
}