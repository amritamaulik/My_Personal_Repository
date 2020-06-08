package com.techmArogya.aarogyaathome.dataaccessors

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteException

//creating the database logic, extending the SQLiteOpenHelper base class
class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "AarogyaAtHomeDB"
        //table_MS_Offer_Features
        private val TABLE_MS_OFFER_FEATURES = "table_MS_Offer_Features"
             private val OFFER_ID = "offer_Id"
             private val FEATURE_NAME = "feature_name"
             private val FEATURE_DESCRIPTION = "feature_description"
             private val SEARCH_TAG = "search_taggers"
        //table_Offers
        private val TABLE_OFFERS = "table_Offers"
            private val VENDOR_USER_ID = "vendor_user_id "
            private val OFFER_NAME = "offer_name"
            private val OFFER_DESCRIPTION = "offer_description"
            private val OFFER_TYPE = "offer_type "
            private val OFFER_PRICE = "offer_price "
        //table_Vendor_Details

        private val TABLE_VENDORDETAILS = "table_Vendor_Details"
            private val VENDOR_NAME = "vendor_name"
            private val BUS_REG_ID = "business_registration_id"
            private val PHONE_1 = "contact_ph1"
            private val PHONE_2 = "contact_ph2"
            private val EMAIL_ID = "email_id"
            private val STREET_ADDRESS = "street_address"
            private val LOCALITY = "locality"
            private val CITY = "city"
            private val STATE = "state"
            private val COUNTRY = "country"
            private val PIN = "pin_code"
            private val TAX_CODE = "tax_code "
            private val BUS_REG_COPY = "business_registration_copy"
            private val RATING = "rating"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        //creating table with fields
        val CREATE_TABLE_MS_OFFER_FEATURES = (
                "CREATE TABLE " + TABLE_MS_OFFER_FEATURES
                        + "("
                        + OFFER_ID + " TEXT,"
                        + FEATURE_NAME + " TEXT,"
                        + FEATURE_DESCRIPTION + " TEXT,"
                        + SEARCH_TAG + " TEXT"
                        + ")"
                )
        db?.execSQL(CREATE_TABLE_MS_OFFER_FEATURES)

        val CREATE_TABLE_OFFERS = (
                "CREATE TABLE " + TABLE_OFFERS
                        + "("
                        + OFFER_ID + " TEXT,"
                        + VENDOR_USER_ID + " TEXT,"
                        + OFFER_NAME + " TEXT,"
                        + OFFER_TYPE + " TEXT,"
                        + OFFER_DESCRIPTION + " TEXT,"
                        + OFFER_PRICE + " TEXT,"
                        + SEARCH_TAG + " TEXT"
                        + ")"
                )

        db?.execSQL(CREATE_TABLE_OFFERS)

        val CREATE_TABLE_VENDORDETAILS = (
                "CREATE TABLE " + TABLE_VENDORDETAILS
                        + "("
                        + VENDOR_USER_ID + " TEXT,"
                        + VENDOR_NAME + " TEXT,"
                        + BUS_REG_ID + " TEXT,"
                        + PHONE_1 + " TEXT,"
                        + PHONE_2 + " TEXT,"
                        + EMAIL_ID + " TEXT,"
                        + STREET_ADDRESS + " TEXT,"
                        + LOCALITY + " TEXT,"
                        + CITY + " TEXT,"
                        + STATE + " TEXT,"
                        + COUNTRY + " TEXT,"
                        + PIN + " TEXT,"
                        + TAX_CODE + " TEXT,"
                        + BUS_REG_COPY + " TEXT,"
                        + RATING + " TEXT"
                        + ")"
                )
        db?.execSQL(CREATE_TABLE_VENDORDETAILS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_MS_OFFER_FEATURES)
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFERS)
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_VENDORDETAILS)
        onCreate(db)
    }

    /*
    * Adding insert and view functions for table_MS_Offer_Features
    * */
    //method to insert data
    fun addMSOffer(msf: MSFeatureModelClass):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(OFFER_ID, msf.offer_Id)
        contentValues.put(FEATURE_NAME, msf.feature_name)
        contentValues.put(FEATURE_DESCRIPTION,msf.feature_description)
        contentValues.put(SEARCH_TAG,msf.searchtag)

        // Inserting Row
        val success = db.insert(TABLE_MS_OFFER_FEATURES, null, contentValues)
        //2nd argument is String containing nullColumnHack
       // db.close() // Closing database connection
        return success
    }
    //method to read data
    fun viewMSOffers():List<MSFeatureModelClass>{
        val msOfferList:ArrayList<MSFeatureModelClass> = ArrayList<MSFeatureModelClass>()
        val selectQuery = "SELECT  * FROM $TABLE_MS_OFFER_FEATURES"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var offerId: String
        var featureName: String
        var featureDescription: String
        var serachTag: String
        if (cursor.moveToFirst()) {
            do {
                offerId = cursor.getString(cursor.getColumnIndex("offer_Id"))
                featureName = cursor.getString(cursor.getColumnIndex("feature_name"))
                featureDescription = cursor.getString(cursor.getColumnIndex("feature_description"))
                serachTag = cursor.getString(cursor.getColumnIndex("search_taggers"))
                val msf= MSFeatureModelClass(offer_Id = offerId, feature_name = featureName, feature_description = featureDescription,searchtag=serachTag)
                msOfferList.add(msf)
            } while (cursor.moveToNext())
        }
        return msOfferList
    }

    /*
    * Adding insert and view functions for table_Offers
    * */
    //method to insert data
    fun addOffer(offer: OfferModelClass):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(OFFER_ID, offer.offer_Id)
        contentValues.put(OFFER_NAME, offer.offer_name)
        contentValues.put(OFFER_DESCRIPTION,offer.offer_description )
        contentValues.put(VENDOR_USER_ID,offer.vendor_user_id )
        contentValues.put(OFFER_TYPE,offer.offer_type )
        contentValues.put(OFFER_PRICE,offer.offer_price )
        contentValues.put(SEARCH_TAG,offer.search_tag )
        // Inserting Row
        val success = db.insert(TABLE_OFFERS, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }
    //method to read data
    fun viewOffers():List<OfferModelClass>{
        val offerList:ArrayList<OfferModelClass> = ArrayList<OfferModelClass>()
        val selectQuery = "SELECT  * FROM $TABLE_OFFERS"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var offer_Id: String
        var offerName: String
        var offerDescription: String
        var offertype: String
        var offerPrice: String
        var vendorUserId: String
        var serachTag: String
        if (cursor.moveToFirst()) {
            do {
                offer_Id = cursor.getString(cursor.getColumnIndex("offer_Id"))
                offerName = cursor.getString(cursor.getColumnIndex("offer_name"))
                offerDescription = cursor.getString(cursor.getColumnIndex("offer_description"))
                offertype = cursor.getString(cursor.getColumnIndex("offer_type"))
                offerPrice = cursor.getString(cursor.getColumnIndex("offer_price"))
                vendorUserId = cursor.getString(cursor.getColumnIndex("vendor_user_id"))
                serachTag = cursor.getString(cursor.getColumnIndex("search_tag"))
                val offer= OfferModelClass(offer_Id = offer_Id, offer_name = offerName, offer_description = offerDescription,
                    offer_type = offertype,
                    offer_price = offerPrice,
                    vendor_user_id = vendorUserId,
                    search_tag = serachTag)
                offerList.add(offer)
            } while (cursor.moveToNext())
        }
        return offerList
    }

//    *//*
//    * Adding insert and view functions for table_Vendor_Details
//    * *//*
    //method to insert data
    fun addVendorDetails(vendorDetails: VendorDetailsModelClass):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(VENDOR_USER_ID, vendorDetails.vendor_user_id)
        contentValues.put(VENDOR_NAME, vendorDetails.vendor_name)
        contentValues.put(BUS_REG_ID,vendorDetails.business_registration_id )
        contentValues.put(PHONE_1,vendorDetails.contact_ph1 )
        contentValues.put(PHONE_1,vendorDetails.contact_ph2 )
        contentValues.put(EMAIL_ID,vendorDetails.email_id )
        contentValues.put(STREET_ADDRESS,vendorDetails.street_address )
        contentValues.put(LOCALITY,vendorDetails.locality )
        contentValues.put(CITY,vendorDetails.city )
        contentValues.put(STATE,vendorDetails.state )
        contentValues.put(COUNTRY,vendorDetails.state )
        contentValues.put(PIN,vendorDetails.pin_code )
        contentValues.put(TAX_CODE,vendorDetails.tax_code )
        contentValues.put(BUS_REG_COPY,vendorDetails.business_registration_copy )
        contentValues.put(RATING,vendorDetails.rating )
        contentValues.put(STATE,vendorDetails.state )
        // Inserting Row
        val success = db.insert(TABLE_VENDORDETAILS, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }
    //method to read data
    fun viewVendorDetials():List<VendorDetailsModelClass>{
        val vendorDetailsList:ArrayList<VendorDetailsModelClass> = ArrayList<VendorDetailsModelClass>()
        val selectQuery = "SELECT  * FROM $TABLE_VENDORDETAILS"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var vendor_user_id: String
        var vendor_name: String
        var busRegID: String
        var busRegCopy: String
        var ph1: String
        var ph2: String
        var city: String
        var state: String
        var country: String
        var locality: String
        var streetAdrees: String
        var pincode: String
        var taxcode: String
        var emilid: String
        var rating: String
        if (cursor.moveToFirst()) {
            do {
                vendor_user_id = cursor.getString(cursor.getColumnIndex("vendor_user_id"))
                vendor_name = cursor.getString(cursor.getColumnIndex("vendor_name"))
                busRegID = cursor.getString(cursor.getColumnIndex("business_registration_id"))
                busRegCopy = cursor.getString(cursor.getColumnIndex("business_registration_copy"))
                ph1 = cursor.getString(cursor.getColumnIndex("contact_ph1"))
                ph2 = cursor.getString(cursor.getColumnIndex("contact_ph2"))
                city = cursor.getString(cursor.getColumnIndex("city"))
                state = cursor.getString(cursor.getColumnIndex("state"))
                locality = cursor.getString(cursor.getColumnIndex("locality"))
                streetAdrees = cursor.getString(cursor.getColumnIndex("street_address"))
                pincode = cursor.getString(cursor.getColumnIndex("pin_code"))
                taxcode = cursor.getString(cursor.getColumnIndex("tax_code"))
                emilid = cursor.getString(cursor.getColumnIndex("email_id"))
                rating = cursor.getString(cursor.getColumnIndex("rating"))
                country = cursor.getString(cursor.getColumnIndex("country"))
                val vendordtls= VendorDetailsModelClass(vendor_user_id = vendor_user_id,
                    vendor_name = vendor_name,
                    business_registration_id = busRegID,
                    business_registration_copy = busRegCopy,
                    contact_ph1 = ph1,
                    contact_ph2 = ph2,
                    city = city,
                    state = state,
                    locality = locality,
                    street_address = streetAdrees,
                    pin_code = pincode,
                    tax_code = taxcode,
                    email_id = emilid,
                    rating = rating,
                    country = country
                )
                vendorDetailsList.add(vendordtls)
            } while (cursor.moveToNext())
        }
        return vendorDetailsList
    }

   /* fun showMSOffers(keyword:String ):HashMap<String,String>?{
        var hashMapMSOfferdetails:HashMap<String,String>?=null

        var sqlQuery = "Select \toffers.vendor_user_id, \n" +
                "\t\toffers.offer_Id, \n" +
                "\t\toffers.offer_price, \n" +
                "\t\tcount(offers.offer_Id), \n" +
                "\t\tvendor.vendor_name, \n" +
                "\t\tvendor.contact_ph1, \n" +
                "\t\tvendor.contact_ph1, \n" +
                "\t\tvendor.email_id, \n" +
                "\t\tvendor.street_address, \n" +
                "\t\tvendor.locality, \n" +
                "\t\tvendor.city, \n" +
                "\t\tvendor.state, \n" +
                "\t\tvendor.rating\t\t\n" +
                "from table_Vendor_Details vendor, table_Offers  offers, table_MS_Offer_Features  managedservices\t\t\n" +
                "where managedservices.search_taggers in ("+ keyword+") \t\t\n" +
                "and offers.offer_type =\"Managed Service\"\t\t\n" +
                "and offers.offer_Id = managedservices.OfferId\t\t\n" +
                "and vendor.vendor_user_id = offers.vendor_user_id \t\t\n" +
                "group by offers.vendor_user_id,offers.offer_Id\t\t\n" +
                "order by  count(offers.offer_Id) , vendor.rating, offers.offer_price desc"

        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(sqlQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(sqlQuery)
            var resultlst=ArrayList()
        }
        var vendor_user_id: String
        var vendor_name: String
        var busRegID: String
        var busRegCopy: String
        var ph1: String
        var ph2: String
        var city: String
        var state: String
        var country: String
        var locality: String
        var streetAdrees: String
        var pincode: String
        var taxcode: String
        var emilid: String
        var rating: String
        if (cursor.moveToFirst()) {
            do {
                vendor_user_id = cursor.getString(cursor.getColumnIndex("vendor_user_id"))
                vendor_name = cursor.getString(cursor.getColumnIndex("vendor_name"))
                busRegID = cursor.getString(cursor.getColumnIndex("business_registration_id"))
                busRegCopy = cursor.getString(cursor.getColumnIndex("business_registration_copy"))
                ph1 = cursor.getString(cursor.getColumnIndex("contact_ph1"))
                ph2 = cursor.getString(cursor.getColumnIndex("contact_ph2"))
                city = cursor.getString(cursor.getColumnIndex("city"))
                state = cursor.getString(cursor.getColumnIndex("state"))
                locality = cursor.getString(cursor.getColumnIndex("locality"))
                streetAdrees = cursor.getString(cursor.getColumnIndex("street_address"))
                pincode = cursor.getString(cursor.getColumnIndex("pin_code"))
                taxcode = cursor.getString(cursor.getColumnIndex("tax_code"))
                emilid = cursor.getString(cursor.getColumnIndex("email_id"))
                rating = cursor.getString(cursor.getColumnIndex("rating"))
                country = cursor.getString(cursor.getColumnIndex("country"))
                val vendordtls= VendorDetailsModelClass(vendor_user_id = vendor_user_id,
                    vendor_name = vendor_name,
                    business_registration_id = busRegID,
                    business_registration_copy = busRegCopy,
                    contact_ph1 = ph1,
                    contact_ph2 = ph2,
                    city = city,
                    state = state,
                    locality = locality,
                    street_address = streetAdrees,
                    pin_code = pincode,
                    tax_code = taxcode,
                    email_id = emilid,
                    rating = rating,
                    country = country
                )
                hashMapMSOfferdetails.add(vendordtls)
            } while (cursor.moveToNext())
        }





        return hashMapMSOfferdetails*/
    //}
    /*
    * Add join code here */

}