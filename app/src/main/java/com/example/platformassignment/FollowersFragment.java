package com.example.platformassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class FollowersFragment extends Fragment {

    RecyclerView recyclerview;
    ArrayList<Follower> folsList;
    FollowersAdapter adapter;
    EditText search_follower;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the view in the fragment to the container, fragment_container
        View view = inflater.inflate(R.layout.fragment_followers, container, false);
        // set the recyclerView reference to the id of the recyclerView in the inflated view
        recyclerview = view.findViewById(R.id.recycler_view);
        search_follower = view.findViewById(R.id.search);

        search_follower.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String entry = editable.toString();
                filter(entry);
            }
        });

        folsList = new ArrayList<>();

        folsList.add(new Follower(R.drawable.emp1, "Julia Roberts","New York", "Offline"));
        folsList.add(new Follower(R.drawable.emp2, "Luke Hill","London", "Online"));
        folsList.add(new Follower(R.drawable.emp3, "Jakob Lenkova","Istanbul", "Online"));
        folsList.add(new Follower(R.drawable.emp4, "Lillian Wu","Japan", "Online"));
        folsList.add(new Follower(R.drawable.emp5, "Olivia Twist","Lagos", "Online"));
        folsList.add(new Follower(R.drawable.test2, "Tracey Saloon","Los Angeles", "Online"));
        folsList.add(new Follower(R.drawable.test3, "Joshua Houston","Texas", "Offline"));
        folsList.add(new Follower(R.drawable.girl2, "Aubrey Nzabana","Rwanda", "Offline"));
        folsList.add(new Follower(R.drawable.man1, "Collins Wolfe","Sierra Leone", "Online"));

        adapter = new FollowersAdapter(folsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerview.setLayoutManager(layoutManager);//recyclerview.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false)); Normally, we use getContext() instead of getActivity()


        DividerItemDecoration itemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        recyclerview.addItemDecoration(itemDecoration);
        recyclerview.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;

    }

    private void filter(String entry) {
        ArrayList<Follower> filteredList = new ArrayList<>();
        for (Follower searchMatch : folsList ) {
            if (searchMatch.getName().toLowerCase().contains(entry.toLowerCase())) {
                filteredList.add(searchMatch);
            }
        }
        adapter.putNewList(filteredList);
     }
}