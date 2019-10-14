package com.darpan.learnc.Tabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.darpan.learnc.Adapters.HorizontalRecyclerViewAdapter;
import com.darpan.learnc.R;
import com.darpan.learnc.models.firstFragmentitems;
import com.darpan.learnc.models.secondfragmentsItems;


import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2 extends Fragment {
    View v;
    public Context context;
    // public BillingProcessor bp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView secondtFragmentRecycleview;

//    private RecyclerView secondtFragmentRecycleviewone;

    private List<secondfragmentsItems> FragmentItemsTwo;
    private List<firstFragmentitems> firstnestedItems;
    private List<firstFragmentitems> secondnestedItems;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentItemsTwo = new ArrayList<>();
        firstnestedItems =new ArrayList<>();
        secondnestedItems=new ArrayList<>();

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Operators.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Branching Statements.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C File Input_Output.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Jumping Statements.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Looping Statements.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Programming _ C Arrays.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Programming _ C Functions.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Programming _ C Pointers.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Programming _ C Strings.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

        firstnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "C Programming _ C Structures.pdf", "by Author",
                "5 min Read",R.drawable.ic_lock_black_24dp,R.drawable.ic_lock_black_24dp));

      /*8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888*/

        secondnestedItems.add(new firstFragmentitems(R.string.desc
                , "C Program", "Celsius to Fahrenheit", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.history_of_c));

        secondnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "Convert To Celsius", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.download_c));

        secondnestedItems.add(new firstFragmentitems(R.string.c_install
                , "C Program", "convert To km", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.structure_in_c));

        secondnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "find Leap Year", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.input_output));

        secondnestedItems.add(new firstFragmentitems(R.string.c_struct
                , "C Program", "larger Of Two", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.format_data));

        secondnestedItems.add(new firstFragmentitems(R.string.c_struct
                , "C Program", "larger Of Two With Conditions", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.dennis_ritchie));

        secondnestedItems.add(new firstFragmentitems(R.string.history_c
                , "C Program", "meter to feet", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.structure_in_c));

        secondnestedItems.add(new firstFragmentitems(R.string.c_in_out
                , "C Program", "sum", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.input_output));

        secondnestedItems.add(new firstFragmentitems(R.string.fromat_specifier
                , "C Program", "swap", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.format_data));

        secondnestedItems.add(new firstFragmentitems(R.string.fromat_specifier
                , "C Program", "swap Two Numbers", "by Author",
                "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.download_c));





        FragmentItemsTwo.add(new secondfragmentsItems(firstnestedItems));
        FragmentItemsTwo.add(new secondfragmentsItems(secondnestedItems));

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tab2, container, false);

        secondtFragmentRecycleview = v.findViewById(R.id.secondFragmentRecyclerView);
//        secondtFragmentRecycleviewone = v.findViewById(R.id.secondFragmentRecyclerViewone);

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter =
                new HorizontalRecyclerViewAdapter(getContext(), FragmentItemsTwo);

        secondtFragmentRecycleview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        secondtFragmentRecycleview.setAdapter(horizontalRecyclerViewAdapter);

//        secondtFragmentRecycleviewone.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,
//                false));
//        secondtFragmentRecycleviewone.setAdapter(horizontalRecyclerViewAdapter);


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
