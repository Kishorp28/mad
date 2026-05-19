public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        101);
            }
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel nc =
                    new NotificationChannel(
                            "01",
                            "Notification",
                            NotificationManager.IMPORTANCE_HIGH);

            NotificationManager nm =
                    getSystemService(NotificationManager.class);

            nm.createNotificationChannel(nc);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             
                if (ActivityCompat.checkSelfPermission(
                        MainActivity.this,
                        Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

                NotificationCompat.Builder ncb =
                        new NotificationCompat.Builder(MainActivity.this, "01")
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Notify💕💕💕")
                                .setContentText("Hey Successfully sent notification")
                                .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat nmc =
                        NotificationManagerCompat.from(MainActivity.this);

                nmc.notify(1, ncb.build());
            }
        });
    }
}
