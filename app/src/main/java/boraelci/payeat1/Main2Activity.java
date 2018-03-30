package boraelci.payeat1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class Main2Activity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    Button button;
    private Button update;
    private Button signOut;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private Button logOut;
    private TextView uinfo;

    public TextView balance;
    public TextView name1;

    //public static final String TAG = "NfcDemo";
    //public static final String MIME_TEXT_PLAIN = "text/plain";


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();

        user = mAuth.getCurrentUser();
        String mail = user.getEmail();
        uinfo = (TextView) findViewById(R.id.textView1) ;
        uinfo.setText("Welcome! \n" + "You are logged in as: " + mail);

        logOut = (Button) findViewById(R.id.logOut);

        logOut.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Main2Activity.this, Intro.class));
            }
        });

        String type ="login";
        String username = user.getUid();



    }

    public void OnLogin(View view) {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null) {

            final String uid = user.getUid();
            String username = uid;
            //String password = PasswordEt.getText().toString();
            String type = "login";

            WOWOWO NABEr


            //KAYDETME KISMI BAŞLAR

            //gets and saves qr code to shared preferences OR uses the already saved one
            //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            //SharedPreferences.Editor editor = sharedPref.edit();

            //String savedString = sharedPref.getString("value","no");

            //ImageView image =(ImageView) findViewById(R.id.image1);
        /*byte[] imageBytes = Base64.decode(savedString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        image.setImageBitmap(decodedImage);*/



            /*editor.putString("value","no");
            editor.commit();*/

            /*if (savedString == "no") {

                RhodeWorker rhodeWorker = new RhodeWorker(this);
                rhodeWorker.execute(type, username);

                Intent intent = getIntent();
                String easyPuzzle = intent.getExtras().getString("epuzzle");


            /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);*/

            /*Bitmap image2 = image;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();
            String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);*/

                /*editor.putString("value", easyPuzzle);
                editor.apply();
            }

            else {


                Toast.makeText(Main2Activity.this, "hey", Toast.LENGTH_SHORT).show();

                byte[] imageBytes = Base64.decode(savedString, Base64.DEFAULT);
                Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                image.setImageBitmap(decodedImage);

            }*/ //KAYDETME KISMI SON

        RhodeWorker rhodeWorker = new RhodeWorker(this);
        rhodeWorker.execute(type, username);


            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username);}

        else {

            Toast.makeText(Main2Activity.this, "Check your internet connection!", Toast.LENGTH_SHORT).show();
            OnLogin(view);

        }



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
// dont call **super**, if u want disable back button in current screen.
    }


}
