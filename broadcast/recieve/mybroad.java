

public class MyBroadcastreciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Broadcastreciever","BroadcastReciever message is recieved");
        Toast.makeText(context,"Broadcast message is recieved",Toast.LENGTH_SHORT).show();
    }
}
