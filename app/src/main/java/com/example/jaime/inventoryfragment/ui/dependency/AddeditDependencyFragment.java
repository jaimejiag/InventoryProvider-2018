package com.example.jaime.inventoryfragment.ui.dependency;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.jaime.inventoryfragment.R;
import com.example.jaime.inventoryfragment.ui.base.BasePresenter;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddeditDependencyFragment extends Fragment implements AddeditDependencyContract.View {
    public static final String TAG = "addeditdependency";
    private AddeditDependencyContract.Presenter mPresenter;
    private AddeditDependencyListener mCallback;

    private FloatingActionButton fabDependency;
    private TextInputLayout tilName;
    private EditText edtName;
    private TextInputLayout tilSortName;
    private TextInputLayout tilDescription;


    interface AddeditDependencyListener {
        void listDependency();
    }


    public static AddeditDependencyFragment newInstance(Bundle bundle) {
        AddeditDependencyFragment addeditDependencyFragment = new AddeditDependencyFragment();

        if (bundle != null)
            addeditDependencyFragment.setArguments(bundle);

        return addeditDependencyFragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (AddeditDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDepedencyListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_addedit_dependency, container, false);

        fabDependency = (FloatingActionButton) root.findViewById(R.id.fab_dependency_save);
        tilName = (TextInputLayout) root.findViewById(R.id.til_dependency_name);
        edtName = (EditText) root.findViewById(R.id.edt_dependency_name);
        edtName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tilSortName = (TextInputLayout) root.findViewById(R.id.til_dependency_sortname);
        tilDescription = (TextInputLayout) root.findViewById(R.id.til_dependency_description);

        if (getArguments() != null) {

        }


        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fabDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.saveDependency(
                        tilName.getEditText().getText().toString(),
                        tilSortName.getEditText().getText().toString(),
                        tilDescription.getEditText().getText().toString());
            }
        });
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        mPresenter = (AddeditDependencyContract.Presenter) presenter;
    }


    @Override
    public void navigateToListDependency() {
        mCallback.listDependency();
    }


    @Override
    public void setNameEmptyError() {
        tilName.setError(getResources().getString(R.string.errorDependencyNameEmptyError));
    }


    @Override
    public void setSortNameEmptyError() {
        tilSortName.setError(getResources().getString(R.string.errorDependencySortNameEmptyError));
    }


    @Override
    public void setSortNameLengthError() {
        tilSortName.setError(getResources().getString(R.string.errorDependencySortNameLengthError));
    }


    @Override
    public void setDescriptionEmptyError() {
        tilDescription.setError(getResources().getString(R.string.errorDependencyDescriptionEmptyError));
    }


    @Override
    public void setValidateDependencyError() {

    }
}
