package com.app.bissudroid.androidtutorials.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.activity.CodeActivity;
import com.app.bissudroid.androidtutorials.adapter.FileNamesAdapter;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import java.util.Arrays;
import java.util.List;

public class ProgramsFilesNamesFragment extends Fragment implements ListView.OnItemClickListener {
    MainActivityViewModel mainActivityViewModel;
    ListView listView;
    int position = 0;
    int subposition = 0;
    int fileposition = 0;
    String title = "";
    String arr[];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_helper, container, false);
        listView = view.findViewById(R.id.itemslist);
        if (getArguments() != null) {
            position = getArguments().getInt(Constants.POSITION_KEY, position);
            subposition = getArguments().getInt(Constants.SUB_POS_KEY, subposition);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        chooseArraytoload();
        List<String> filenames = Arrays.asList(arr);
        FileNamesAdapter fileNamesAdapter = new FileNamesAdapter(getActivity(), filenames);
        listView.setAdapter(fileNamesAdapter);
        listView.setOnItemClickListener(this);
    }

    private void chooseArraytoload() {
        Resources resources = getResources();
        if (position == 1) {
            if (subposition == 0 || subposition == 1) {
                arr = resources.getStringArray(R.array.file_activity_names);
            } else arr = resources.getStringArray(R.array.intents);
        } else if (position == 2) {
            if (subposition == 2)
                arr = resources.getStringArray(R.array.fragmentxmlitems);
            else arr = resources.getStringArray(R.array.fragment_contents);

        } else if (position == 3) {
            if (subposition != 6)
                arr = resources.getStringArray(R.array.file_activity_names);
            else
                arr = resources.getStringArray(R.array.SpinnerNames);
        } else if (position == 4) arr = resources.getStringArray(R.array.animation_items);
        else if (position == 5) {
            if (subposition == 2) {
                arr = resources.getStringArray(R.array.NavDrawerContents);
            } else if (subposition == 0) {

                arr = resources.getStringArray(R.array.ToolbarContents);
            } else if (subposition == 1) {
                arr = resources.getStringArray(R.array.CollapseSection);
            } else if (subposition == 4) {
                arr = resources.getStringArray(R.array.BottomNavContents);

            } else if (subposition == 6) {
                arr = resources.getStringArray(R.array.SharedElementContents);
            } else arr = resources.getStringArray(R.array.materialdesigncontents);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        String text = null;
        String filename = "MainActivity.java";

        if (position == 1) {
            if (subposition == 0) {
                title = "Simple Activity";
                if (pos == 0) {
                    text = getString(R.string.MainActivityJavaFirst);


                } else {
                    filename = "activity_main.xml";
                    text = getString(R.string.MainActivityXMLfirst);
                }
            } else if (subposition == 1) {
                title = "Activity Life Cycle";
                if (pos == 0) {

                    text = getString(R.string.MainActivityLifeCycleJava);
                } else {
                    filename = "activity_main.xml";
                    text = getString(R.string.MainActivityXMLfirst);
                }
            } else {
                title = "Intents";

                switch (pos) {
                    case 0:

                        text = getString(R.string.MainActivityIntentFirstJava);
                        break;
                    case 1:
                        filename = "activity_main.xml";
                        text = getString(R.string.firstintentxml);
                        break;
                    case 2:
                        filename = "SecondActivity.java";
                        text = getString(R.string.SecondActivityIntent);
                        break;
                    case 3:
                        filename = "second_activity.xml";
                        text = getString(R.string.secondactivity_xml);
                        break;
                }
            }
        } else if (position == 2) {
            if (subposition == 0) {
                title = "Fragment Transactions";

                if (pos == 0) {
                    text = getString(R.string.fragTrans);
                } else if (pos == 1) {
                    text = getString(R.string.firstfragmentlayout);
                    filename = "activity_main.xml";
                } else if (pos == 2) {
                    text = getString(R.string.FragmentOne);
                    filename = "FragmentOne.java";
                } else if (pos == 3) {
                    text = getString(R.string.fragmentone_xml);
                    filename = "fragment_one.xml";

                }
            } else if (subposition == 1) {
                title = "Fragment Lifecycle";
                if (pos == 0) {
                    text = getString(R.string.fragTrans);
                } else if (pos == 1) {
                    text = getString(R.string.firstfragmentlayout);
                    filename = "activity_main.xml";
                } else if (pos == 2) {
                    text = getString(R.string.SecondFragmentJava);
                    filename = "FragmentOne.java";
                } else if (pos == 3) {
                    text = getString(R.string.fragmentone_xml);
                    filename = "fragment_one.xml";

                }

            } else if (subposition == 2) {
                title = "Fragments Via XML";
                if (pos == 0) {
                    text = getString(R.string.MainActivityJavaFirst);
                } else if (pos == 1) {
                    text = getString(R.string.FragmentsViaXmlActivity);
                    filename = "activity_main.xml";
                } else if (pos == 2) {
                    text = getString(R.string.FragmentsViaXmlFirstFragment);
                    filename = "fragment_one.xml";
                } else if (pos == 3) {
                    text = getString(R.string.FragmentsViaXmlSecondFragment);
                    filename = "fragment_two.xml";
                } else if (pos == 4) {
                    text = getString(R.string.FragmentsViaXmlFirstFragmentJava);
                    filename = "FragmentOne.java";
                } else if (pos == 5) {
                    text = getString(R.string.FragmentsViaXmlSecondFragmentJava);
                    filename = "FragmentTwo.java";
                }

            }
        } else if (position == 3) {
            if (subposition == 0) {
                title = "TextViews";
                if (pos == 0) text = getString(R.string.MainActivityJavaFirst);
                else if (pos == 1) {
                    text = getString(R.string.TextViewXML);
                    filename = "activity_main.xml";
                }
            } else if (subposition == 1) {
                title = "EditText";
                if (pos == 0) text = getString(R.string.MainActivityJavaFirst);
                else if (pos == 1) {
                    text = getString(R.string.EditTextXML);
                    filename = "activity_main.xml";
                }

            } else if (subposition == 2) {
                title = "Buttons";
                if (pos == 0) text = getString(R.string.ButtonJava);
                else if (pos == 1) {
                    text = getString(R.string.ButtonXML);
                    filename = "activity_main.xml";
                }
            } else if (subposition == 3) {
                title = "ImageViews";
                if (pos == 0) text = getString(R.string.ImageViewJava);
                else if (pos == 1) {
                    text = getString(R.string.ImageViewXML);
                    filename = "activity_main.xml";
                }
            } else if (subposition == 4) {
                title = "Switches";
                if (pos == 0) text = getString(R.string.SwitchesJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.SwitchesXML);

                }
            } else if (subposition == 5) {
                title = "Toggles";
                if (pos == 0) text = getString(R.string.ToggleJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.ToggleXML);
                }

            } else if (subposition == 7) {
                title = "Seekbar";
                if (pos == 0) text = getString(R.string.seekbarjava);
                else if (pos == 1) {
                    text = getString(R.string.seekbarxml);
                    filename = "activity_main.xml";
                }
            }
            //Radio Buttons

            else if (subposition == 8) {
                title = "Radio Buttons";
                if (pos == 0) text = getString(R.string.RadioJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.RadioXML);
                }
//checkbox
            } else if (subposition == 9) {
                title = "CheckBoxes";
                if (pos == 0) text = getString(R.string.CheckBoxJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.CheckBoxXML);
                }
//progressdialog
            } else if (subposition == 10) {
                title = "Progress Dialog";
                if (pos == 0) text = getString(R.string.ProgressDialogJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.ProgressDialogXML);
                }
//Webview
            } else if (subposition == 11) {
                title = "Webview";
                if (pos == 0) text = getString(R.string.WebviewJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.WebviewXML);
                }
//Spinner
            } else if (subposition == 6) {
                title = "Spinner";
                if (pos == 0) text = getString(R.string.SpinnerJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.SpinnerXML);
                } else if (pos == 2) {

                    filename = "strings.xml";
                    text = getString(R.string.EntriesSpinner);

                }

            } else if (subposition == 12) {
                title = "Datepicker";
                if (pos == 0) text = getString(R.string.dateJava);
                else if (pos == 1) {
                    text = getString(R.string.dateXml);
                    filename = "activity_main.xml";
                }
            } else if (subposition == 13) {
                title = "Timepicker";
                if (pos == 0) text = getString(R.string.timeJava);
                else if (pos == 1) {
                    text = getString(R.string.timeXml);
                    filename = "activity_main.xml";
                }

            }
        } else if (position == 4) {
            if (subposition == 0) {
                title="Move";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    text = getString(R.string.Animxml);
                    filename = "activity_main.xml";
                }
                else if(pos==2){
                    text = getString(R.string.MoveXML);
                    filename = "@anim/animation.xml";

                }
            } else if (subposition == 1) {
                title="Slide";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    text = getString(R.string.SlideXML);
                    filename = "activity_main.xml";
                }

            } else if (subposition == 2) {
                title="Rotate";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    text = getString(R.string.Animxml);
                    filename = "activity_main.xml";
                }
                else if(pos==2){
                    text = getString(R.string.RotateXML);
                    filename = "@anim/animation.xml";

                }
            } else if (subposition == 3) {
                title="Fade In";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    text = getString(R.string.Animxml);
                    filename = "activity_main.xml";
                }
                else if(pos==2){
                    text = getString(R.string.FadeINXML);
                    filename = "@anim/animation.xml";

                }
            } else if (subposition == 4) {
                title="Fade Out";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.Animxml);

                }
                else if(pos==2){
                    text = getString(R.string.FadeOutXML);
                    filename = "@anim/animation.xml";

                }
            } else if (subposition == 5) {
                title="Scale";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.Animxml);
                }
                else if(pos==2){
                    text = getString(R.string.ScaleXML);
                    filename = "@anim/animation.xml";

                }

            }
            else if (subposition == 6) {
                title="Blink";
                if (pos == 0) text = getString(R.string.ScaleJava);
                else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.Animxml);
                }
                else if(pos==2){
                    text = getString(R.string.BlinkXML);
                    filename = "@anim/animation.xml";

                }

            }
        } else if (position == 5) {
            if (subposition == 0) {
                title = "Toolbar";
                if (pos == 0) {
                    filename = "toolbar.xml";
                    text = getString(R.string.toolbarlayout);

                } else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.activitytoolbar);
                } else if (pos == 2) {
                    text = getString(R.string.toolbarjava);

                } else if (pos == 3) {
                    text = getString(R.string.toolbarstyles);
                    filename = "styles.xml";

                }

            } else if (subposition == 2) {
                title = "Navigation Drawer";
                if (pos == 0) {
                    filename = "header.xml";
                    text = getString(R.string.headerxml);
                } else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.navxml);
                } else if (pos == 2) {
                    text = getString(R.string.NavJava);
                } else if (pos == 3) {
                    filename = "navigation_menu.xml";
                    text = getString(R.string.navmenu);
                } else if (pos == 4) {
                    filename = "toolbar.xml";
                    text = getString(R.string.toolbarlayout);
                }
            } else if (subposition == 3) {
                title = "Floating Action Button";
                if (pos == 0) {
                    text = getString(R.string.fabjava);
                } else if (pos == 1) {
                    filename = "activity_main.xml";
                    text = getString(R.string.fabxml);
                }
            } else if (subposition == 1) {
                title = "Collapsing Toolbar ";
                if (pos == 0) {
                    text = getString(R.string.MainActivityJavaFirst);

                } else if (pos == 1) {
                    text = getString(R.string.collapsingactivity);
                    filename = "activity_main.xml";
                } else if (pos == 3) {
                    text = getString(R.string.nestedview);
                    filename = "item_nested_scrollview.xml";
                } else if (pos == 2) {
                    filename = "@string/test";
                    text = getString(R.string.test);
                }
            } else if (subposition == 5) {
                title = "TextInput Layout";
                if (pos == 0) {
                    text = getString(R.string.TextInputJava);

                } else if (pos == 1) {
                    text = getString(R.string.TextInputXml);
                    filename = "activity_main.xml";
                }

            } else if (subposition == 6) {
                title = "Shared Element Transitions";
                if (pos == 0) {
                    text = getString(R.string.SharedSourceJava);

                } else if (pos == 1) {
                    text = getString(R.string.SharedDestJava);
                    filename = "SecondActivity.java";
                } else if (pos == 2) {
                    text = getString(R.string.SharedSourceXml);
                    filename = "activity_main.xml";
                } else if (pos == 3) {
                    filename = "second_activity.xml";
                    text = getString(R.string.SharedDestXml);
                }

            } else if (subposition == 4) {
                title = "Bottom Nav View";
                if (pos == 0) {
                    text = getString(R.string.MainActivityBottom);

                } else if (pos == 1) {
                    text = getString(R.string.OneFragmentViewPager);
                    filename = "FragmentOne.java";
                } else if (pos == 2) {
                    text = getString(R.string.TwoFragmentViewpager);
                    filename = "FragmentTwo.java";
                } else if (pos == 3) {
                    filename = "FragmentThree.java";
                    text = getString(R.string.ThirdViewPager);
                } else if (pos == 4) {
                    filename = "activity_main.xml";
                    text = getString(R.string.activity_mainBottom);

                } else if (pos == 5) {
                    text = getString(R.string.OneFragmentViewPagerXml);
                    filename = "fragment_one.xml";
                } else if (pos == 6) {
                    text = getString(R.string.TwoFragmentViewPagerXml);
                    filename = "fragment_two.xml";
                } else if (pos == 7) {
                    filename = "fragment_three.xml";
                    text = getString(R.string.ThirdFragmentViewPagerXml);
                } else if (pos == 8) {
                    text = getString(R.string.menu_bottom_navigationBottom);
                    filename = "bottom_navigation.xml";


                }


            }

        }


        if (text != null)
            startActivity(new Intent(getActivity(), CodeActivity.class).putExtra(Constants.FIELD_KEY, text)
                    .putExtra("title", title)
                    .putExtra(Constants.FIELDFILENAME, filename));
    }
}
