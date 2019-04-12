package com.example.lesson_12_0402.example02_fragment_data_change;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_12_0402.R;

public class ExampleFragmentDataChangeActivity extends AppCompatActivity implements View.OnClickListener {

    private static String ActivityName = "ExampleFragmentDataChangeActivity";

    private Fragment ExampleDataChangeFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ExampleDataChangeFirstFragment exampleDataChangeFirstFragment;

    private Button doChangeFirstFragmentTextButton;
    private Button doChangeFragmentButton;
    private Button doChangeFirstFragmentText;

    private TextView FirstFragmentTextView;
    int currentFragmentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_fragment_data_change);

        initView();

        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_create), Toast.LENGTH_SHORT).show();
    }

    private void initView() {

        ActivityName = getString(R.string.data_change_activity);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        ExampleDataChangeFragment = new ExampleDataChangeFirstFragment();
        fragmentTransaction.add(R.id.example_data_change_linear_layout, ExampleDataChangeFragment);
        fragmentTransaction.commit();

        // view
        doChangeFirstFragmentTextButton = findViewById(R.id.btn_do_change_first_fragment_text);
        doChangeFragmentButton = findViewById(R.id.btn_do_change_fragment_text);

        doChangeFirstFragmentTextButton.setOnClickListener(this);
        doChangeFragmentButton.setOnClickListener(this);
        currentFragmentIndex = 0;
    }

    private void initFragmentView() {
        exampleDataChangeFirstFragment = (ExampleDataChangeFirstFragment) getSupportFragmentManager()
                .findFragmentById(R.id.example_data_change_linear_layout);
        FirstFragmentTextView = findViewById(R.id.first_fragment_text);
        doChangeFirstFragmentText = findViewById(R.id.btn_do_change_first_fragment_text);

        exampleDataChangeFirstFragment.fragment_var = 10;
        doChangeFirstFragmentText.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // 액티비티가 비로소 화면에 보여지는 단계 사용자에게 화면이 제공되었고 포커스가 잡힌 상태
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_resume), Toast.LENGTH_SHORT).show();

        initFragmentView();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_change_first_fragment_text:
                FirstFragmentTextView.setText(getString(R.string.activity_changed));
                break;

            case R.id.btn_do_change_fragment_text:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment;

                if (currentFragmentIndex == 0) {
                    fragment = new ExampleDataChangeFirstFragment();
                    currentFragmentIndex++;
                } else {
                    fragment = new ExampleDataChangeSecondFragment();
                    currentFragmentIndex--;
                }

                fragmentTransaction.replace(R.id.example_data_change_linear_layout, fragment);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_start), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_restart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_pause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_stop), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_destroy), Toast.LENGTH_SHORT).show();
    }
}
