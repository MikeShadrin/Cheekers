package edu.nuzp.fragmentapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Fragment1 fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame1,fragment1)
                .commit();
    }

    @Override
    public void onClick(View v) {
    }

}