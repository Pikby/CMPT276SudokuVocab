package com.example.testing;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    final int sudokuArrayWidth = 3;
    private Button[] sudokuArray = new Button[9];
    private Button mRandomize;


    private void changeCellValue(int x,int y,String value)
    {
        sudokuArray[x+sudokuArrayWidth*y].setText(value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        for(int x=0;x<3;x++)
            for (int y = 0; y < 3; y++) {

                String idStr = "C"+Integer.toString(x)+Integer.toString(y);
                int  a =32;
                int id = res.getIdentifier(idStr,"id",getPackageName());
                sudokuArray[x+sudokuArrayWidth*y] = findViewById(id);
                sudokuArray[x+sudokuArrayWidth*y].setText("C"+Integer.toString(x)+Integer.toString(y));
            }




        final List<Integer> numbList = new ArrayList<>();
        for(int i = 1;i<=9;i++)
        {
            numbList.add(i);
        }
        mRandomize = (Button)findViewById(R.id.RandButton);
        mRandomize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Collections.shuffle(numbList);
                for(int i =1;i<9;i++){
                   sudokuArray[i-1].setText(Integer.toString( numbList.get(i)));
                }

            }
        });
    }
}
