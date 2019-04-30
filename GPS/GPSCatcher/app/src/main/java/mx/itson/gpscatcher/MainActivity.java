package mx.itson.gpscatcher;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private static Socket socket;
    private static DataInputStream dataInputStream;
    private static String ip = "192.168.0.17";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catching();
    }

    public void catching(){
        new catcher().execute();
    }

    class catcher extends AsyncTask<Void, Void, Void>{

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected Void doInBackground(Void... params) {
            try{
                while (true){
                    socket = new Socket(ip,3030);
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    String message = dataInputStream.readUTF();
                    ((TextView)findViewById(R.id.txt)).setText(message);
                    dataInputStream.close();
                    socket.close();
                }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
}
