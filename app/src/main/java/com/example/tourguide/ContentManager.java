package com.example.tourguide;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Mayank on 12/5/18 at 8:16 PM
 **/
class ContentManager {

    @SuppressLint("StaticFieldLeak")
    private static volatile ContentManager INSTANCE;
    private ArrayList<Interest> mAttractions;
    private ArrayList<Interest> mFestivals;
    private ArrayList<Interest> mRestaurants;
    private ArrayList<Interest> mHotels;
    private Context mContext;

    static ContentManager getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (ContentManager.class) {
                if (INSTANCE == null)
                    INSTANCE = new ContentManager(context);
            }
        }

        return INSTANCE;
    }

    private ContentManager(Context context) {
        mContext = context;
        mAttractions = new ArrayList<>();
        mFestivals = new ArrayList<>();
        mRestaurants = new ArrayList<>();
        mHotels = new ArrayList<>();

    }

    ArrayList<Interest> getInterests(int pageNumber) {
        switch (pageNumber) {
            case 1:
                return getAttractions();
            case 2:
                return getFestivals();
            case 3:
                return getRestaurants();
            case 4:
                return getHotels();
            default:
                break;
        }

        return null;
    }

    private ArrayList<Interest> getAttractions() {
        if (mAttractions != null && mAttractions.size() > 0) {
            return mAttractions;
        }

        String[] placeTitles = mContext.getResources().getStringArray(R.array.title_attractions_array);
        String[] placeDescriptions = mContext.getResources().getStringArray(R.array.description_attractions_array);
        int[] placesImageResources = new int[]{R.drawable.garh_palace, R.drawable.maharao_madho_singh_museum, R.drawable.abheda_mahal, R.drawable.dad_devi_temple, R.drawable.jagmandir_palace, R.drawable.kota_barrage, R.drawable.chambal_garden, R.drawable.seven_wonders, R.drawable.godawri_dham, R.drawable.alnia_dam, R.drawable.mukundra_tiger_reserve, R.drawable.garadia_mahadev_temple, R.drawable.kansua_temple, R.drawable.gaiparnath};

        for (int i = 0; i < placeTitles.length; i++) {
            Interest place = new Interest();
            place.setTitle(placeTitles[i]);
            place.setDescription(placeDescriptions[i]);
            place.setImageResId(placesImageResources[i]);
            mAttractions.add(place);
        }

        return mAttractions;
    }

    private ArrayList<Interest> getFestivals() {
        if (mFestivals != null && mFestivals.size() > 0) {
            return mFestivals;
        }

        String[] eventTitles = mContext.getResources().getStringArray(R.array.title_festivals_array);
        String[] eventDescriptions = mContext.getResources().getStringArray(R.array.description_festivals_array);
        int[] eventsImageResources = new int[]{R.drawable.dussera_festival, R.drawable.adventure_festival};

        for (int i = 0; i < eventTitles.length; i++) {
            Interest event = new Interest();
            event.setTitle(eventTitles[i]);
            event.setDescription(eventDescriptions[i]);
            event.setImageResId(eventsImageResources[i]);
            mFestivals.add(event);
        }

        return mFestivals;
    }

    private ArrayList<Interest> getRestaurants() {
        if (mRestaurants != null && mRestaurants.size() > 0) {
            return mRestaurants;
        }

        String[] barTitles = mContext.getResources().getStringArray(R.array.title_restaurants_array);
        String[] barDescriptions = mContext.getResources().getStringArray(R.array.description_restaurants_array);
        int[] barImageResources = new int[]{R.drawable.amar_punjabi_dhaba, R.drawable.soul_lilac, R.drawable.maheshwari_restaurant, R.drawable.jhodhpur_restraunt, R.drawable.trp_cafe, R.drawable.bobs_burgur, R.drawable.royal_firdos, R.drawable.hangout_cafe};

        for (int i = 0; i < barTitles.length; i++) {
            Interest bar = new Interest();
            bar.setTitle(barTitles[i]);
            bar.setDescription(barDescriptions[i]);
            bar.setImageResId(barImageResources[i]);
            mRestaurants.add(bar);
        }

        return mRestaurants;
    }

    private ArrayList<Interest> getHotels() {
        if (mHotels != null && mHotels.size() > 0) {
            return mHotels;
        }

        String[] restaurantTitles = mContext.getResources().getStringArray(R.array.title_hotels_array);
        String[] restaurantDescriptions = mContext.getResources().getStringArray(R.array.description_hotels_array);
        int[] restaurantImageResources = new int[]{R.drawable.ummed_bhawan, R.drawable.hotel_lilac, R.drawable.grand_chandiram, R.drawable.sukdham_kothi, R.drawable.hotel_rallentino};

        for (int i = 0; i < restaurantTitles.length; i++) {
            Interest restaurant = new Interest();
            restaurant.setTitle(restaurantTitles[i]);
            restaurant.setDescription(restaurantDescriptions[i]);
            restaurant.setImageResId(restaurantImageResources[i]);
            mHotels.add(restaurant);
        }

        return mHotels;
    }
}
