package com.example.lesson_12_0402.example02_fragment_data_change;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_12_0402.R;

public class ExampleDataChangeFirstFragment extends Fragment implements View.OnClickListener {

    private static String FragmentName="";
    private Context context;

    private ExampleFragmentDataChangeActivity exampleFragmentDataChangeActivity;
    private Button doChangeFirstFragment;
    private TextView FirstFragmentTextView;
    int fragment_var;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(context, FragmentName + context.getString(R.string.on_create_view), Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_example_data_change_first, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
        FragmentName = context.getString(R.string.first_fragment);
        Toast.makeText(context, FragmentName + context.getString(R.string.on_attach), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(context, FragmentName + context.getString(R.string.on_create), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        exampleFragmentDataChangeActivity = (ExampleFragmentDataChangeActivity) getActivity();
        exampleFragmentDataChangeActivity.currentFragmentIndex = 10;

        Toast.makeText(context, FragmentName + context.getString(R.string.on_activity_created), Toast.LENGTH_SHORT).show();

        initView();
    }

    void initView() {
        doChangeFirstFragment = getActivity().findViewById(R.id.btn_do_change_activity_text);
        FirstFragmentTextView = getActivity().findViewById(R.id.tv_do_access_fragment);

        doChangeFirstFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_change_activity_text:
                FirstFragmentTextView.setText(getString(R.string.first_fragment_changed));
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(context, FragmentName + context.getString(R.string.on_start), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(context, FragmentName + context.getString(R.string.on_resume), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(context, FragmentName + context.getString(R.string.on_destroy_view), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(context, FragmentName + context.getString(R.string.on_stop), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(context, FragmentName + context.getString(R.string.on_pause), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(context, FragmentName + context.getString(R.string.on_destroy), Toast.LENGTH_SHORT).show();
    }


}
