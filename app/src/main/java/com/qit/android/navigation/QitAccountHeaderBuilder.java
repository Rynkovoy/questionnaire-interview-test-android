package com.qit.android.navigation;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.qit.R;
import com.qit.android.models.user.User;

public class QitAccountHeaderBuilder {

    private AccountHeaderBuilder accountHeaderBuilder;
    private Activity activity;
    private Toolbar toolbar;

    public QitAccountHeaderBuilder() {
        this.accountHeaderBuilder = new AccountHeaderBuilder();
    }

    public QitAccountHeaderBuilder setActivity(Activity activity) {
        this.activity = activity;
        accountHeaderBuilder.withActivity(activity);
        return this;
    }


    private String fullName = "LOADING...";
    private String email = "LOADING DATA...";
    User user;
    public AccountHeader build() {

        final AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.color.colorDarkBlue)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName(fullName)
                                .withEmail(email)
                                .withIcon(R.drawable.ic_face_black_36dp)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();





        return headerResult;
    }
}
