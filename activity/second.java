
public class SecondActivity extends AppCompatActivity {

    TextView tvReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvReceived = findViewById(R.id.tvReceived);

        String receivedMsg = getIntent().getStringExtra("msg");
        tvReceived.setText("Message: " + receivedMsg);
    }
}
