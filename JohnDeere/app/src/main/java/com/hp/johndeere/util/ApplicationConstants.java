package com.hp.johndeere.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by androidhtech13 on 25/4/16.
 */


public class ApplicationConstants {
    public static final String BASEURL = "http://52.66.112.195:3090";
    public static final String KEY_ACCESS_TOKEN = "Access Token";
    public static final String NO_ACCESS_TOKEN = "Not found";
    public static final String ACCESS_TOKEN = "X-Access-Token";
    public static final CharSequence[] items = {"Capture Photo", "Choose from Gallery", "Cancel"};
    public static final int NORMAL_TYPE = 0;
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static final int PROGRESS_TYPE = 5;
    public static final String[] mBloodGroupArray = {"Blood Group", "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
    final static Pattern NUMBER_PATTERN = Pattern.compile("[+-]?\\d*\\.?\\d+");
    public static final String SERVER_IP_ADDRESS = "http://52.66.112.195:3090";
    public static final int TIME_OUT = 3500;
    public static String CURRENT_LANGUAGE = "en";
    public static String CLIENT_USER = "CLIENT";
    public static String VENDER_USER = "VENDOR";
    public static String SALES_USER = "SALES USER";
    public static String USER_ID = "UserId";
    public static String FLOW_SHARE_DATA = "Flow App is a new way to find hassle free warranty and services management from your phone." + "\nhttps://www.dropbox.com/s/xwg5ls3bkrc3mha/Flow_v1.0_17Aug.apk?dl=0";
    //   public static String FLOW_LIKE_PAGE_URL = "http://inthecheesefactory.com/blog/understand-android-activity-launchmode/en";
    public static String FLOW_LIKE_PAGE_URL = "http://www.facebook.com/imflowner";
    public static String QR_SCAN_PRODUCT_NOT_PRESENT = "Product not present";
    public static String QR_SCAN_REGISTERED_SUCCESSFULLY = "Product registered successfully";
    public static String QR_SCAN_PRDUCT_ALREADY_REGISTERED = "Product already registered";
    public static String QR_SCAN_PRDUCT_REGISTERED_BY_OTHER = "Already registered with other user";
    final static Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("^[^0][0-9]{9}?$");
    public static String CLIENT_ROLEID = "1";
    public static String VENDER_ROLEID = "9";
    public static String SALES_ROLEID = "3";

    public static int HOME = 0;
    public static int ACCOUNTS = 1;
    public static int BUSINESS_DASHBOARD = 2;
    public static int VENDER_SEARCH_FLOW = 3;
    public static int VENDER_SHARE = 4;
    public static int VENDER_LIKE = 5;
    public static int VENDER_HELP = 6;
    public static int CLIENT_SEARCH_FLOW = 2;
    public static int CLIENT_SHARE = 3;
    public static int CLIENT_LIKE = 4;
    public static int CLIENT_HELP = 5;

    public static enum ObjectStatus {
        SUCCESS,
        INVALID_LOGIN,
        UNKNOWN_ERROR,
        NETWORK_ERROR
    }

    /**********
     * Method to show Dialog by passing Context, message and title which we want to show on it.
     **********/
    public static void showDialog(Context context, String message, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setTitle(title).setCancelable(false)
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    /**********
     * Method to check entered email address is valid or not if it is valid then method will return true otherwise false.
     **********/
    public static boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**********
     * Method to check the field is blank or not (i.e. if the field is blank then method will return true otherwise false).
     **********/
    public static boolean isBlank(String field) {
        return field.trim().isEmpty();
    }

    /**********
     * Method to show toast message by passing message on it.
     *********/
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
    }

    /**********
     * Method to get string value from a JSONObject( with null check) by passing JsonObject and key.
     **********/
    public static String getValueOfJsonObject(JSONObject jsonObject, String key) {
        try {
            if (jsonObject.has(key)) {
                if ("null".equals(jsonObject.getString(key))) {
                    return "";
                } else if (null == jsonObject.getString(key)) {
                    return "";
                } else {
                    return jsonObject.getString(key);
                }
            } else {
                return "";
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**********
     * Method to print Log message by passing tag and message.
     **********/
    public static void log(String tag, String message) {
        try {
          //   Log.d(tag, message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**********
     * Method to hide keyboard.
     **********/
    public static void hideKeyboard(Context context, View view) {
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } else {

        }
    }


    /**********
     * Method to check data connection availability (if network is available then it will return true otherwise false).
     **********/
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting() && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        }
        return false;
    }


    /*****************
     * Method to check valid format of adhaar card number
     ***********************/
    public static String isAadhaarValid(String field) {
        if (field.trim().length() == 12) {
            return "Aadhar";
        } else if (isMobileValid(field.trim())) {
            return "Mobile";
        } else {
            return "Invalid";
        }
    }

    /*****************
     * Method to check input string is aadhaar number or mobile number
     ***********************/
    public static String isAadhaarEmailValid(String field) {

        if (isNumber(field)) {
            if (field.trim().length() == 12) {
                return "Aadhar";
            } else if (isMobileValid(field.trim())) {
                return "Mobile";
            } else {
                return "Invalid";
            }
        } else {
            if (isEmailValid(field)) {
                return "Email";
            } else {
                return "Invalid";
            }
        }
    }


    /*****************
     * Method to check input string have only numbers
     ***********************/
    public static boolean isNumber(String input) {
        Matcher m = NUMBER_PATTERN.matcher(input);
        return m.matches();
    }


    /*****************
     * Method to check valid format of mobile number
     ***********************/
    public static boolean isMobileValid(String field) {
        Matcher m = MOBILE_NUMBER_PATTERN.matcher(field);
        return m.matches();
    }
/*
 public static boolean isMobileValid(String field) {
        if (field.trim().length() == 10) {
            return true;
        }
        return false;
    }
*/

    public static void showSnackbar(View view, String str) {
        Snackbar snackbar = Snackbar.make(view, str, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    /**********
     * Method to convert bitmap to base64.
     **********/
    public static String encodeTobase64(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);


        Log.e("LOOK", imageEncoded);
        return imageEncoded;
    }

    /**********
     * Method to convert base64 to bitmap
     **********/
    public static Bitmap decodeBase64(String input) {

        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public static String splitDate(String str) {
        String s[] = str.split(" ");
        String result = s[0];
        return result;
    }


    /*****************
     * Method to get date in required format
     ***********************/
    public static String dateFormatForServer(int year, int monthOfYear, int dayOfMonth) {
        int myear = year;
        int month = monthOfYear + 1;
        int day = dayOfMonth;
        String mMonth = "", mday = "", mYear = "";
        if (month > 9) {
            mMonth = month + "";
        } else {
            mMonth = "0" + month;
        }
        if (day > 9) {
            mday = day + "";
        } else {
            mday = "0" + day;
        }
        return myear + "-" + mMonth + "-" + mday;
    }


    /*****************
     * Method to get days count between to dates
     ***********************/
    public static String getCountOfDays(String Expire_date_String) {
        String Created_date_String = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        Date Created_convertedDate = null, Expire_CovertedDate = null, todayWithZeroTime = null;
        String mDaysCount = "";
        try {
            Created_convertedDate = dateFormat.parse(Created_date_String);
            Expire_CovertedDate = dateFormat.parse(Expire_date_String);

            Date today = new Date();

            todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int c_year = 0, c_month = 0, c_day = 0;

        if (Created_convertedDate.after(todayWithZeroTime)) {
            Calendar c_cal = Calendar.getInstance();
            c_cal.setTime(Created_convertedDate);

            c_year = c_cal.get(Calendar.YEAR);
            c_month = c_cal.get(Calendar.MONTH);
            c_day = c_cal.get(Calendar.DAY_OF_MONTH);

        } else {
            Calendar c_cal = Calendar.getInstance();
            c_cal.setTime(todayWithZeroTime);

            c_year = c_cal.get(Calendar.YEAR);
            c_month = c_cal.get(Calendar.MONTH);
            c_day = c_cal.get(Calendar.DAY_OF_MONTH);
        }

        Calendar e_cal = Calendar.getInstance();
        e_cal.setTime(Expire_CovertedDate);

        int e_year = e_cal.get(Calendar.YEAR);
        int e_month = e_cal.get(Calendar.MONTH);
        int e_day = e_cal.get(Calendar.DAY_OF_MONTH);

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.clear();
        date1.set(c_year, c_month, c_day);
        date2.clear();
        date2.set(e_year, e_month, e_day);

        long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

        float dayCount = (float) diff / (24 * 60 * 60 * 1000);

        if (dayCount == 0) {
//            String s[] = Expire_date_String.split(" ");
//            String time = s[1];
//            String timeArray[] = time.split(":");
//            mDaysCount = timeArray[0] + ":" + timeArray[1];
            mDaysCount = time(Expire_date_String);
        } else {
            mDaysCount = ((int) dayCount) + " day ago";
        }
        if (mDaysCount.contains("-")) {
            mDaysCount = mDaysCount.substring(1);
        }
        //return ("" + (int) dayCount + " Days");
        return mDaysCount;
    }


    /*****************
     * Method to convert server date to indian time standard and also get days count between two dates
     ***********************/
    public static String time(String time) {

        //  DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        //"Tue Aug 23 2016 16:42:01 GMT+0000 (UTC)",
        //DateFormat utcFormat = new SimpleDateFormat("EEE MM dd yyyy HH:mm:ss.SSS'Z'");

//        if(time.contains("UTC")){
//            time=time.substring(0,24);
//
//        }
        DateFormat utcFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = utcFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat istFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        // DateFormat istFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss a");
        istFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));

        Log.d("TIMEZONE", TimeZone.getDefault().getID());
        time = istFormat.format(date);
        log("DATE-", time);
        time = time.split("T")[1];
        time = time.substring(0, 5);

        Calendar calendarTime = Calendar.getInstance();

//Calendar.HOUR_OF_DAY is in 24-hour format
        calendarTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.substring(0, 2)));

        calendarTime.set(Calendar.MINUTE, Integer.parseInt(time.substring(3, 5)));

        time = calendarTime.get(Calendar.HOUR) + ":" + calendarTime.get(Calendar.MINUTE);

        if (calendarTime.get(Calendar.AM_PM) == 0) {
            time = time + " " + "AM";
        } else {
            time = time + " " + "PM";
        }


        return time;
    }

    public static String dateFormatForDisplay(int year, int monthOfYear, int dayOfMonth) {
        int myear = year;
        int month = monthOfYear;
        int day = dayOfMonth;
        String mMonth = "", mday = "", mYear = "";
        String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        mMonth = mon[month];
        if (day > 9) {
            mday = day + "";
        } else {
            mday = "0" + day;
        }
        return mday + " " + mMonth + " " + myear;
    }

    public static String timeFormatForDisplay(int hourOfDay, int minute) {
        String ampm = "", min = "", hMin = "";
        int hour;
        if (hourOfDay >= 12) {
            hour = hourOfDay - 12;
            if (hour == 0) {
                hour = 12;
            }
            ampm = "PM";
        } else {
            hour = hourOfDay;
            if (hour == 0) {
                hour = 12;
            }
            ampm = "AM";
        }
        if (minute < 10) {
            min = "0";
        } else {
            min = "";
        }
        if (hour < 10) {
            hMin = "0";
        } else {
            hMin = "";
        }
        return hMin + hour + ":" + min + minute + "  " + ampm;
    }

    public static String timeFormatForServer(int hourOfDay, int minute, int second) {
        String mMin = "", hMin = "", sMin = "";
        //String date = "1990-12-31";
        if (hourOfDay < 10) {
            hMin = "0";
        } else {
            hMin = "";
        }
        if (minute < 10) {
            mMin = "0";
        } else {
            mMin = "";
        }
        if (second < 10) {
            sMin = "0";
        } else {
            sMin = "";
        }
        return /*date + " " +*/ hMin + hourOfDay + ":" + mMin + minute + ":" + sMin + second;
    }

    public static String timeFormatForServer(String time) {
        int hourOfDay = 0, minute = 0, second = 0;
        hourOfDay = Integer.parseInt(time.split(":")[0]);
        minute = Integer.parseInt(time.split(":")[1]);
        second = Integer.parseInt(time.split(":")[2]);
        String mMin = "", hMin = "", sMin = "";
        if (hourOfDay < 10) {
            hMin = "0";
        } else {
            hMin = "";
        }
        if (minute < 10) {
            mMin = "0";
        } else {
            mMin = "";
        }
        if (second < 10) {
            sMin = "0";
        } else {
            sMin = "";
        }
        return hMin + hourOfDay + ":" + mMin + minute + ":" + sMin + second;
    }

    /****
     * Method to parse date from yyyy-mm-dd to dd-mmm-yyyy format
     *****/
    public static String dateTimeFormatForDisplay(String dateTime) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "dd-MMM-yyyy h:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date d = null;
        String str = null, date = "", time = "";
        try {
            d = inputFormat.parse(dateTime);
            str = outputFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = str.split(" ")[0];
        date = date.replace("-", " ");
        time = str.split(" ")[1] + " " + str.split(" ")[2];
        time = time.toUpperCase();
        return date + " " + time;
    }

    /****
     * Method to make a call by passing contact number as a string parameter
     *****/
    public static void makeCall(String phoneNumber, Context context) {
        if (phoneNumber.trim().length() != 0) {
            context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
        }
    }

    public static Typeface setFontHelveticaRoman(Context context) {
        // Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/helvetica_neue_lt_pro_55_roman.ttf");
        AssetManager am = context.getApplicationContext().getAssets();

        Typeface custom_font = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "helvetica_neue_lt_pro_55_roman.ttf"));

        return custom_font;
    }

    /******
     * Method to share Text using text support app's like facebook, google+ etc.
     *****/
    public static void shareText(Context context) {
        String message = "Text I want to share.";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);
        //startActivity(Intent.createChooser(share, "Share data via..."));
    }

    /******
     * Method to convert UTC date time to our required formate.
     *****/
    public static String UTCtoDate(String time) {

        if (isBlank(time)) {
            return "";
        }
        if (time.contains("UTC")) {
            time = time.substring(0, 24);
        }
        DateFormat utcFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
        Date date = null;
        try {
            date = utcFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat istFormat = new SimpleDateFormat("yyyy-MM-dd");
        istFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        Log.d("TIMEZONE", TimeZone.getDefault().getID());
        time = istFormat.format(date);
        return time;
    }

    /*****************
     * Method to check deal is active or not
     ***********************/
    public static boolean CheckDealIsActive(String dealEndDate) {
        //SimpleDateFormat dfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if (!isBlank(dealEndDate)) {
            SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDate = dfDate.format(Calendar.getInstance().getTime());
            ApplicationConstants.log("Deal ", "current date time -" + currentDate);
            ApplicationConstants.log("Deal ", "end date time -" + dealEndDate);
            boolean b = false;
            try {
                if (dfDate.parse(dealEndDate).before(dfDate.parse(currentDate))) {
                    b = false;  // If dealEdnDate is before currentDate.
                } else if (dfDate.parse(dealEndDate).equals(dfDate.parse(currentDate))) {
                    b = true;  // If two dates are equal.
                } else {
                    b = true; // If dealEdnDate is after the currentDate.
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ApplicationConstants.log("Deal ", "isActive -" + b);
            return b;

        } else {
            return false;
        }
    }


    /****
     * Method to set image view by picasso
     *****/
    public static void ShowImagePicasso(Context context, String imageURL, int defaultImage, ImageView imageView) {
        try {
            if ("".equals(imageURL) || "image.jpeg".equals(imageURL)) {
                imageView.setImageResource(defaultImage);
            } else {
                Picasso.with(context).load(ApplicationConstants.BASEURL + "/" + imageURL).placeholder(defaultImage).into(imageView);
            }
        } catch (Exception err) {
            showSnackbar(imageView, "Problem in loading image");
            err.printStackTrace();
        }

    }

    /****
     * Method to open compose mail of gmail
     *****/
    public static void openGmail(Activity activity, String[] email, String subject, String content) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT, content);
        final PackageManager pm = activity.getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
        ResolveInfo best = null;
        for (final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") || info.activityInfo.name.toLowerCase().contains("gmail"))
                best = info;
        if (best != null)
            emailIntent.setClassName(best.activityInfo.packageName, best.activityInfo.name);
        activity.startActivity(emailIntent);
    }

    /****
     * Method to open url in default browser
     *****/
    public static void openUrl(Context context, String url, View rootView) {
        try {
            if (!isBlank(url)) {
                if (!url.contains("http")) {
                    url = "http://" + url;
                }
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(url));
                context.startActivity(myWebLink);
            } else {
                showSnackbar(rootView, "URL not found");
            }
        } catch (Exception e) {
            showSnackbar(rootView, "Browser not found");
        }
    }

    public static void openLocationOnMap(Activity activity, String latitude, String longitude, String markerLabel) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "geo:" + latitude +
                        "," + longitude +
                        "?q=" + latitude +
                        " " + longitude +
                        markerLabel));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        activity.startActivity(intent);
    }
}
