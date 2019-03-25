package com.example.lesson_5_0322.example02;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.lesson_5_0322.R;

public class ReservationTimeActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    Chronometer cmViewTime;

    RadioButton rdoCal;
    RadioButton rdoTime;

    DatePicker dPicker;
    TimePicker tPicker;

    TextView tvYear;
    TextView tvMonth;
    TextView tvDay;
    TextView tvHour;
    TextView tvMinute;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_time);

        setTitle("시간 예약");

        // 크로노미터
        cmViewTime = (Chronometer) findViewById(R.id.cm_view_time);

        // 라디오버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        dPicker = (DatePicker) findViewById(R.id.datePicker);
        tPicker = (TimePicker) findViewById(R.id.timePicker);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tv_Year);
        tvMonth = (TextView) findViewById(R.id.tv_Month);
        tvDay = (TextView) findViewById(R.id.tv_Day);
        tvHour = (TextView) findViewById(R.id.tv_Hour);
        tvMinute = (TextView) findViewById(R.id.tv_Minute);

        // 처음에는 2개를 안보이게 설정
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(this);
        rdoTime.setOnClickListener(this);
        cmViewTime.setOnClickListener(this);

        cmViewTime.setOnLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rdoCal:
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
                break;
            case R.id.rdoTime:
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
                break;
            case R.id.cm_view_time:  // 크로노미터를 클릭하면..타이머 시작
                cmViewTime.setBase(SystemClock.elapsedRealtime());
                cmViewTime.start();
                cmViewTime.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.cm_view_time:  // 크로노미터를 롱클릭하면..타이머 중지
                cmViewTime.stop();
                cmViewTime.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                break;
        }
        return false;
    }
}

