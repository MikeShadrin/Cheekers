package edu.nuzp.fragmentapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class Fragment2 extends Fragment implements View.OnClickListener
{
    private ImageButton btn;
    private ImageButton btn1;
    private Fragment1 fragment1;
    DataAdapter dataadapter;
    private FragmentTransaction transaction;
    int selpos,selval=0,val,count=0;
    int pos1=0,pos2=0,pos3=0,pos4=0,flag;
    boolean hod=true;
    ArrayList<Integer> postodel = new ArrayList<Integer>();
    ArrayList<Integer> moves = new ArrayList<Integer>();
    public Fragment2()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        fragment1 = new Fragment1();
        View v =  inflater.inflate(R.layout.fragment2, container, false);
        btn = v.findViewById(R.id.btn2F2);
        btn1 = v.findViewById(R.id.btn1F2);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        dataadapter = new DataAdapter(getContext(),flg);
        GridView gridview = (GridView) v.findViewById(R.id.gridView1);
        gridview.setAdapter(dataadapter);
        gridview.setOnItemClickListener(gridviewOnItemClickListener);
        return v;
    }
    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                                long id) {
            if(hod==true) {
                if (dataadapter.getGridItem(position) != 0) {
                    if (dataadapter.getGridItem(selpos) != 0) {
                        dataadapter.changeItem(selpos, val);
                    }
                    switch (dataadapter.getGridItem(position)) {
                        case R.drawable.black1:
                            dataadapter.changeItem(position, R.drawable.selectedblack1);
                            selpos = position;
                            val = R.drawable.black1;
                            selval = R.drawable.selectedblack1;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black2:
                            dataadapter.changeItem(position, R.drawable.selectedblack2);
                            selpos = position;
                            val = R.drawable.black2;
                            selval = R.drawable.selectedblack2;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black3:
                            dataadapter.changeItem(position, R.drawable.selectedblack3);
                            selpos = position;
                            val = R.drawable.black3;
                            selval = R.drawable.selectedblack3;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black4:
                            dataadapter.changeItem(position, R.drawable.selectedblack4);
                            selpos = position;
                            val = R.drawable.black4;
                            selval = R.drawable.selectedblack4;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black5:
                            dataadapter.changeItem(position, R.drawable.selectedblack5);
                            selpos = position;
                            val = R.drawable.black5;
                            selval = R.drawable.selectedblack5;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black6:
                            dataadapter.changeItem(position, R.drawable.selectedblack6);
                            selpos = position;
                            val = R.drawable.black6;
                            selval = R.drawable.selectedblack6;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black7:
                            dataadapter.changeItem(position, R.drawable.selectedblack7);
                            selpos = position;
                            val = R.drawable.black7;
                            selval = R.drawable.selectedblack7;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.black8:
                            dataadapter.changeItem(position, R.drawable.selectedblack8);
                            selpos = position;
                            val = R.drawable.black8;
                            selval = R.drawable.selectedblack8;
                            if (count==0){ count++; }
                            break;
                    }
                } else {
                    flag=0;
                    beatPos(1,selpos, flag, position);
                    for(int i = moves.size()-1,k=0;i>=0;i--,k++) {
                        if (position == moves.get(i) && position < 8) {
                            dataadapter.changeItem(position, 0);
                            dataadapter.updateSaved(position, 0);
                            dataadapter.changeItem(selpos, 0);
                            dataadapter.updateSaved(selpos, 0);
                            for (int j = postodel.size()-1; j >= i; j--) {
                                dataadapter.changeItem(postodel.get(j), 0);
                                dataadapter.updateSaved(postodel.get(j), 0);
                            }
                            count++;
                        }
                    }
                    for(int i = moves.size()-1,k=0;i>=0;i--,k++) {
                        if (position == moves.get(i) && position > 8) {
                            dataadapter.changeItem(position, val);
                            dataadapter.updateSaved(position, val);
                            dataadapter.changeItem(selpos, 0);
                            dataadapter.updateSaved(selpos, 0);
                            for (int j = postodel.size()-1; j >= i; j--) {
                                dataadapter.changeItem(postodel.get(j), 0);
                                dataadapter.updateSaved(postodel.get(j), 0);
                            }
                            count++;
                        }
                    }
                    postodel.clear();
                    moves.clear();
                    try{
                            if (position!=55 && dataadapter.getGridItem(position + 9) == selval && position<8) {
                                        dataadapter.changeItem(position + 9, 0);
                                        dataadapter.updateSaved(position + 9,0);
                                    if (count == 1) {
                                        count++;
                                    }
                                }
                            else if(position!=55 && dataadapter.getGridItem(position + 9) == selval && position>8){
                                dataadapter.changeItem(position, val);
                                dataadapter.updateSaved(position,val);
                                dataadapter.changeItem(position + 9, 0);
                                dataadapter.updateSaved(position + 9,0);
                                if (count == 1) {
                                    count++;
                                }
                            }
                        if (dataadapter.getGridItem(position + 7) == selval && position<8) {
                            dataadapter.changeItem(position + 7, 0);
                            dataadapter.updateSaved(position + 7, 0);
                            if (count == 1) {
                                count++;
                            }
                        }
                        else if(dataadapter.getGridItem(position + 7) == selval && position>8){
                            dataadapter.changeItem(position, val);
                            dataadapter.updateSaved(position,val);
                            dataadapter.changeItem(position + 7, 0);
                            dataadapter.updateSaved(position + 7,0);
                            if (count == 1) {
                                count++;
                            }
                        }
                }
                    catch(Exception e){}
                }
                if(count == 2) {
                    hod = false;
                    count=0;
                }
            }
            else{
                if (dataadapter.getGridItem(position) != 0) {
                    if (dataadapter.getGridItem(selpos) != 0) {
                        dataadapter.changeItem(selpos, val);
                    }
                    switch (dataadapter.getGridItem(position)) {
                        case R.drawable.white1:
                            dataadapter.changeItem(position, R.drawable.selectedwhite1);
                            selpos = position;
                            val = R.drawable.white1;
                            selval = R.drawable.selectedwhite1;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white2:
                            dataadapter.changeItem(position, R.drawable.selectedwhite2);
                            selpos = position;
                            val = R.drawable.white2;
                            selval = R.drawable.selectedwhite2;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white3:
                            dataadapter.changeItem(position, R.drawable.selectedwhite3);
                            selpos = position;
                            val = R.drawable.white3;
                            selval = R.drawable.selectedwhite3;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white4:
                            dataadapter.changeItem(position, R.drawable.selectedwhite4);
                            selpos = position;
                            val = R.drawable.white4;
                            selval = R.drawable.selectedwhite4;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white5:
                            dataadapter.changeItem(position, R.drawable.selectedwhite5);
                            selpos = position;
                            val = R.drawable.white5;
                            selval = R.drawable.selectedwhite5;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white6:
                            dataadapter.changeItem(position, R.drawable.selectedwhite6);
                            selpos = position;
                            val = R.drawable.white6;
                            selval = R.drawable.selectedwhite6;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white7:
                            dataadapter.changeItem(position, R.drawable.selectedwhite7);
                            selpos = position;
                            val = R.drawable.white7;
                            selval = R.drawable.selectedwhite7;
                            if (count==0){ count++; }
                            break;
                        case R.drawable.white8:
                            dataadapter.changeItem(position, R.drawable.selectedwhite8);
                            selpos = position;
                            val = R.drawable.white8;
                            selval = R.drawable.selectedwhite8;
                            if (count==0){ count++; }
                            break;
                    }
                } else {
                    flag=0;
                    beatPos(2 ,selpos, flag, position);
                    for(int i = moves.size()-1,k=0;i>=0;i--,k++) {
                        if (position == moves.get(i) && position > 56) {
                            dataadapter.changeItem(position, 0);
                            dataadapter.updateSaved(position, 0);
                            dataadapter.changeItem(selpos, 0);
                            dataadapter.updateSaved(selpos, 0);
                            for (int j = postodel.size()-1; j >= i; j--) {
                                dataadapter.changeItem(postodel.get(j), 0);
                                dataadapter.updateSaved(postodel.get(j), 0);
                            }
                            count++;
                        }
                    }
                    for(int i = moves.size()-1,k=0;i>=0;i--,k++) {
                        if (position == moves.get(i) && position < 56) {
                            dataadapter.changeItem(position, val);
                            dataadapter.updateSaved(position, val);
                            dataadapter.changeItem(selpos, 0);
                            dataadapter.updateSaved(selpos, 0);
                            for (int j = postodel.size()-1; j >= i; j--) {
                                dataadapter.changeItem(postodel.get(j), 0);
                                dataadapter.updateSaved(postodel.get(j), 0);
                            }
                            count++;
                        }
                    }
                    postodel.clear();
                    moves.clear();
                    try {
                        if (dataadapter.getGridItem(position - 9) == selval && position>55) {
                            dataadapter.changeItem(position - 9, 0);
                            dataadapter.updateSaved(position - 9,0);
                            if (count == 1) {
                                count++;
                            }
                        }
                        else if(dataadapter.getGridItem(position - 9) == selval && position<55){
                            dataadapter.changeItem(position, val);
                            dataadapter.updateSaved(position,val);
                            dataadapter.changeItem(position - 9, 0);
                            dataadapter.updateSaved(position - 9,0);
                            if (count == 1) {
                                count++;
                            }
                        }
                        if (dataadapter.getGridItem(position - 7) == selval && position>55) {
                            dataadapter.changeItem(position - 7, 0);
                            dataadapter.updateSaved(position - 7, 0);
                            if (count == 1) {
                                count++;
                            }
                        }
                        else if(dataadapter.getGridItem(position - 7) == selval && position<55){
                            dataadapter.changeItem(position, val);
                            dataadapter.updateSaved(position,val);
                            dataadapter.changeItem(position - 7, 0);
                            dataadapter.updateSaved(position - 7,0);
                            if (count == 1) {
                                count++;
                            }
                        }
                    }
                    catch(Exception e){}
                }
                if(count == 2) {
                    hod = true;
                    count=0;
                }
            }
        }
    };
    @Override
    public void onClick(View v)
    {
        transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn2F2:

                transaction.setCustomAnimations(0,R.animator.slide_in_left);
                transaction
                        .replace(R.id.frame1,fragment1)
                        .commit();;
                break;
            case R.id.btn1F2:
                getActivity().finish();
                break;
        }
    }
    int cheekColor(int val){
        if ((val % 2131165200)>100){
            return 1;
        }
        else if((val % 2131165200)<100 && val>2131165200){
            return 2;
        }
        else{
            return 0;
        }
    }
    boolean flg=true;
    public void setFalg(boolean fl){
        this.flg=fl;
    }
    void beatPos(int color, int spos, int fl,int pos){
        try{
            if (spos + 9 < 64 && spos + 18 < 64 && cheekColor(dataadapter.getGridItem(spos + 9)) == color && dataadapter.getGridItem(spos + 18) == 0) {
                if (flag != 3) {
                    pos1 = spos + 18;
                    flag = 1;
                    beatPos(color, pos1, flag, pos);
                    if (pos1 == pos || pos2 == pos || pos3 == pos || pos4 == pos) {
                        postodel.add(spos + 9);
                        moves.add(spos + 18);
                        return;
                    }
                    flag = fl;
                }
            }
            if (spos + 7 < 64 && spos + 14 < 64 && cheekColor(dataadapter.getGridItem(spos + 7)) == color && dataadapter.getGridItem(spos + 14) == 0) {
                if (flag != 4) {
                    pos2 = spos + 14;
                    flag = 2;
                    beatPos(color, pos2, flag, pos);
                    if (pos1 == pos || pos2 == pos || pos3 == pos || pos4 == pos) {
                        postodel.add(spos + 7);
                        moves.add(spos + 14);
                        return;
                    }
                    flag = fl;
                }
            }
            if (cheekColor(dataadapter.getGridItem(spos - 9)) == color && dataadapter.getGridItem(spos - 18) == 0) {
                if (flag != 1) {
                    pos3 = spos - 18;
                    flag = 3;
                    beatPos(color, pos3, flag, pos);
                    if (pos1 == pos || pos2 == pos || pos3 == pos || pos4 == pos) {
                        postodel.add(spos - 9);
                        moves.add(spos - 18);
                        return;
                    }
                    flag = fl;
                }
            }
            if (cheekColor(dataadapter.getGridItem(spos - 7)) == color && dataadapter.getGridItem(spos - 14) == 0) {
                if (flag != 2) {
                    pos4 = spos - 14;
                    flag = 4;
                    beatPos(color, pos4, flag, pos);
                    if (pos1 == pos || pos2 == pos || pos3 == pos || pos4 == pos) {
                        postodel.add(spos - 7);
                        moves.add(spos - 14);
                        return;
                    }
                    flag = fl;
                }
            }
        }
        catch(Exception e){}
    }
}