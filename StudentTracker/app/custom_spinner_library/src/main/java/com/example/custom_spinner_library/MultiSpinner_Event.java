package com.example.custom_spinner_library;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MultiSpinner_Event extends TextView implements DialogInterface.OnMultiChoiceClickListener {

    public enum AllSelectedDisplayMode {
        UseAllText,
        DisplayAllItems
    }

    private SpinnerAdapter mAdapter;
    private boolean[] mOldSelection;
    private boolean[] mSelected;
    private String mDefaultText="Select Students";
    private String mAllText;
    private boolean mAllSelected;
    private AllSelectedDisplayMode mAllSelectedDisplayMode;
    private MultiSpinnerListener mListener;

    public MultiSpinner_Event(Context context) {
        super(context);
        setText("Select Students");
    }

    public MultiSpinner_Event(Context context, AttributeSet attr) {
        this(context, attr, R.attr.spinnerStyle);
    }

    public MultiSpinner_Event(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        mSelected[which] = isChecked;
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            String choices[] = new String[mAdapter.getCount()];

            for (int i = 0; i < choices.length; i++) {
                choices[i] = mAdapter.getItem(i).toString();
            }

            for (int i = 0; i < mSelected.length; i++) {
                mOldSelection[i] = mSelected[i];
            }
            builder.setMultiChoiceItems(choices, mSelected, MultiSpinner_Event.this);
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    for (int i = 0; i < mSelected.length; i++) {
                        mSelected[i] = mOldSelection[i];
                    }
                    dialog.dismiss();
                }
            });

            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    refreshSpinner();
                    mListener.onItemsSelected(mSelected);
                    dialog.dismiss();
                }
            });

            builder.show();
        }
    };

    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    DataSetObserver dataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            // all selected by default
            mOldSelection = new boolean[mAdapter.getCount()];
            mSelected = new boolean[mAdapter.getCount()];
            for (int i = 0; i < mSelected.length; i++) {
                mOldSelection[i] = false;
                mSelected[i] = mAllSelected;
            }
        }
    };


    public void setAdapter(SpinnerAdapter adapter, boolean allSelected, MultiSpinnerListener listener) {
        SpinnerAdapter oldAdapter = this.mAdapter;

        setOnClickListener(null);

        this.mAdapter = adapter;
        this.mListener = listener;
        this.mAllSelected = allSelected;
        if (oldAdapter != null) {
            oldAdapter.unregisterDataSetObserver(dataSetObserver);
        }
        if (mAdapter != null) {
            mAdapter.registerDataSetObserver(dataSetObserver);
            // all selected by default
            mOldSelection = new boolean[mAdapter.getCount()];
            mSelected = new boolean[mAdapter.getCount()];
            for (int i = 0; i < mSelected.length; i++) {
                mOldSelection[i] = false;
                mSelected[i] = allSelected;
            }
            setOnClickListener(onClickListener);
        }
        setText("Select Students");
    }

    public void setOnItemsSelectedListener(MultiSpinnerListener listener) {
        this.mListener = listener;
    }

    public interface MultiSpinnerListener {
        public void onItemsSelected(boolean[] selected);
    }

    public boolean[] getSelected() {
        return this.mSelected;
    }

    public void setSelected(boolean[] selected) {
        if (this.mSelected.length != selected.length)
            return;
        this.mSelected = selected;
        refreshSpinner();
    }

    private void refreshSpinner() {
        // refresh text on spinner
        StringBuffer spinnerBuffer = new StringBuffer();
        boolean someUnselected = false;
        boolean allUnselected = true;

        for (int i = 0; i < mAdapter.getCount(); i++) {
            if (mSelected[i]) {
                spinnerBuffer.append(mAdapter.getItem(i).toString());
                spinnerBuffer.append(", ");
                allUnselected = false;
            } else {
                someUnselected = true;
            }
        }

        String spinnerText="Select Students";

        if (!allUnselected) {

            if ((someUnselected && !(mAllText != null && mAllText.length() > 0)) || mAllSelectedDisplayMode == AllSelectedDisplayMode.DisplayAllItems) {
                spinnerText = "Select Students";
                if (spinnerText.length() > 2)
                    spinnerText = "Select Students";
            } else {

            }
        } else {
            spinnerText = mDefaultText;
        }

        setText("Select Students");
    }

    public String getDefaultText() {
        return mDefaultText;
    }

    public void setDefaultText(String defaultText) {
        this.mDefaultText = defaultText;
    }

    public String getAllText() {
        return mAllText;
    }

    public void setAllText(String allText) {
        this.mAllText = allText;
    }

    public AllSelectedDisplayMode getAllSelectedDisplayMode() {
        return mAllSelectedDisplayMode;
    }

    public void setAllSelectedDisplayMode(AllSelectedDisplayMode allSelectedDisplayMode) {
        this.mAllSelectedDisplayMode = allSelectedDisplayMode;
    }
}


