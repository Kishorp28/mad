
public class MainActivity extends AppCompatActivity {
    EditText etMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("msg", message);
                startActivity(intent);
            }
        });
    }
}
