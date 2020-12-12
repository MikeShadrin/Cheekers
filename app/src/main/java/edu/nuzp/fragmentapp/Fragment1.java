package edu.nuzp.fragmentapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment implements View.OnClickListener
{
    private ImageButton btn;
    private ImageButton btn1;
    private ImageButton btn2;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private FragmentTransaction transaction;
    public Fragment1()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        View v =  inflater.inflate(R.layout.fragment1, container, false);
        btn = v.findViewById(R.id.btn1F1);
        btn1 = v.findViewById(R.id.btn2F1);
        btn2 = v.findViewById(R.id.btn3F1);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v)
    {
        transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn1F1:
                fragment2.setFalg(true);
                transaction.setCustomAnimations(0,R.animator.slide_in_right);
                transaction
                        .replace(R.id.frame1,fragment2)
                        .commit();;
                break;
            case R.id.btn2F1:
                fragment2.setFalg(false);
                transaction.setCustomAnimations(0,R.animator.slide_in_right);
                transaction
                        .replace(R.id.frame1,fragment2)
                        .commit();;
                break;
            case R.id.btn3F1:
                getActivity().finish();
                break;
        }
    }
}