package com.kt.std.quizeg1.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kt.std.quizeg1.R;
import com.kt.std.quizeg1.utilities.ActivityUtilities;
import com.kt.std.quizeg1.utilities.AppUtilities;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends BaseActivity {
    private Toolbar toolbar;
    private AccountHeader header = null;
    private Drawer drawer = null;
    Activity activity;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activity = MainActivity.this;
        context = getApplicationContext();

        final IProfile profile = new ProfileDrawerItem().withIcon(R.drawable.sharp_star_black_18dp);

        header = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.sharp_star_black_18dp)
                .withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
                    @Override
                    public boolean onProfileImageClick(View view, IProfile profile, boolean current) {
                        ActivityUtilities.getInstance().invokeCustomUrlActivity(activity, CustomUrlActivity.class, getResources().getString(R.string.site),
                                getResources().getString(R.string.site_url), false);
                        return false;
                    }

                    @Override
                    public boolean onProfileImageLongClick(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .addProfiles(profile)
                .build();

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withAccountHeader(header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("О приложении").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(10).withSelectable(false),

                        new SecondaryDrawerItem().withName("YouTube").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(20).withSelectable(false),
                        new SecondaryDrawerItem().withName("Facebook").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(21).withSelectable(false),
                        new SecondaryDrawerItem().withName("Twitter").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(22).withSelectable(false),
                        new SecondaryDrawerItem().withName("Google+").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(23).withSelectable(false),

                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Настройки").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(30).withSelectable(false),
                        new SecondaryDrawerItem().withName("Оцените приложение").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(31).withSelectable(false),
                        new SecondaryDrawerItem().withName("Поделиться").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(32).withSelectable(false),
                        new SecondaryDrawerItem().withName("Соглашение").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(33).withSelectable(false),

                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Выход").withIcon(R.drawable.sharp_star_black_18dp).withIdentifier(40).withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 10) {
                                ActivityUtilities.getInstance().invokeNewActivity(activity, AboutDevActivity.class, false);

                            } else if (drawerItem.getIdentifier() == 20) {
                                AppUtilities.youtubeLink(activity);

                            } else if (drawerItem.getIdentifier() == 21) {
                                AppUtilities.facebookLink(activity);

                            } else if (drawerItem.getIdentifier() == 22) {
                                AppUtilities.twitterLink(activity);
                            } else if (drawerItem.getIdentifier() == 23) {
                            } else if (drawerItem.getIdentifier() == 30) {
//TODO invoke setting activity
                            } else if (drawerItem.getIdentifier() == 31) {
                                AppUtilities.rateThisApp(activity);
                            } else if (drawerItem.getIdentifier() == 32) {
                                AppUtilities.shareApp(activity);
                            } else if (drawerItem.getIdentifier() == 33) {
                                ActivityUtilities.getInstance().invokeCustomUrlActivity(activity, CustomUrlActivity.class, getResources().getString(R.string.privacy), getResources().getString(R.string.privacy_url), false);
                            } else if (drawerItem.getIdentifier() == 40) {

                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .withShowDrawerUntilDraggedOpened(true)
                .build();

    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            AppUtilities.tapPromtToExit(this);
        }
    }
}
















