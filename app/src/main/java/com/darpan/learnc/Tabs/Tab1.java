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


import com.darpan.learnc.Adapters.RecyclerViewAdapter;
import com.darpan.learnc.R;
import com.darpan.learnc.models.firstFragmentitems;

import java.util.ArrayList;
import java.util.List;


;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
    View v;
    //BottomNavigationView bottomNavigationView;
   // boolean isdark = false;
   // LinearLayout rootlayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView firstFragmentRecycleview;
    private List<firstFragmentitems> FragmentItemsOne;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Pa rameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override//Limitation of C Limitation of C
    //History of C //Format specifiers
    //C Installation/C Program Structure/C Input output
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentItemsOne = new ArrayList<>();
        FragmentItemsOne.add(new firstFragmentitems(R.string.desc
                , "C Intro", "C Intro", "by Sandeep", "2 min Read", R.drawable.ic_lock_open_black_24dp,R.drawable.dennis_ritchie));

        FragmentItemsOne.add(new firstFragmentitems(R.string.history_c
                , "C Intro", "History of C", "by me", "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.history_of_c));

        FragmentItemsOne.add(new firstFragmentitems(R.string.c_install
                , "C Intro", "C Installation", "by me", "6 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.download_c));

        FragmentItemsOne.add(new firstFragmentitems(R.string.c_struct
                , "C Intro", "C Program Structure", "by me", "10 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.structure_in_c));


        FragmentItemsOne.add(new firstFragmentitems(R.string.c_in_out
                , "C Intro", "C Input output", "by me", "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.input_output));

        FragmentItemsOne.add(new firstFragmentitems(R.string.fromat_specifier
                , "C Intro", "Format specifiers", "by me", "5 min Read",R.drawable.ic_lock_open_black_24dp,R.drawable.format_data));


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tab1, container, false);

     //   rootlayout = v.findViewById(R.id.first_fragment_layout);
      //  bottomNavigationView = v.findViewById(R.id.bottomNavigationMenu);

        firstFragmentRecycleview = (RecyclerView) v.findViewById(R.id.fisrtFragmentRecyclerView);
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), FragmentItemsOne);
        firstFragmentRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        firstFragmentRecycleview.setAdapter(recyclerViewAdapter);

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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
