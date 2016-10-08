package com.chewzy.controller;

import com.chewzy.HashPassword;
import com.chewzy.model.*;
import com.chewzy.service.TransactionService;
import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;



@Controller
public class HomeController {

    @Autowired
    TransactionService transactionSrvc;

    @RequestMapping(value="/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="addFoodtrip")
    public String foodtripMV(){
        return "userProfile";
    }
    @RequestMapping(value = "/userdb")
    public String user() {
        //User(String firstname, String lastname, String email, String contact_number, String username, String password, String date_created, String address, int foodtrip_count, String badge_id, double latitude, double longitude, boolean isActive, String birthdate) {
        String password = HashPassword.MD5conversion("march2017graduate");
        Date date = new Date();

        //User u = new User("Jesserine", "Lopez", "jesserine.lopez@gmail.com", "09993683461", "jesserinedipity", password, date.toString(), "Tisa, Cebu City", 1, "5207287987447136", 10.3157, 123.8854, true, "May 19,1997");

        //ObjectifyService.ofy().save().entity(u).now();

        return "home1";
    }

    @RequestMapping(value = "/badgedb")
    public String badge() {
        ArrayList<Badge> badgelist = new ArrayList<>();

        //public Badge(String badge_name, int review_count_min, int review_count_max, boolean isActive)
        badgelist.add(new Badge("Newbie", 0, 0, true));
        badgelist.add(new Badge("Taster", 1, 10, true));
        badgelist.add(new Badge("Foodie", 11, 25, true));
        badgelist.add(new Badge("Big Foodie", 26, 40, true));
        badgelist.add(new Badge("Super Foodie", 41, 65, true));
        badgelist.add(new Badge("Expert", 66, 95, true));
        badgelist.add(new Badge("Connoisseur", 96, 9999, true));

        for (int i = 0; i < badgelist.size(); i++) {
            ObjectifyService.ofy().save().entity(badgelist.get(i)).now();
        }

        System.out.println("Badge table entity is created!");
        return "home1";
    }

    @RequestMapping(value = "/businessdb")
    public String business() {
        ArrayList<Business> businessList = new ArrayList<>();
        // public Business(String business_name, String full_address, String city, String state, float stars, float longitude, float latitude, int review_count, int open, String photo_url, boolean isActive) {

        businessList.add(new Business("Kuya J", "Escario Street,Kamputhaw,Cebu City", "Cebu City", "Cebu", 3.5, 123.9015583, 10.31897222, 0, 1, "kuyaj.ph", "kuyaj.ph", true));
        businessList.add(new Business("Hukad", "Ayala Center Cebu, Cebu Business Park", "Cebu City", "Cebu", 4.1, 123.904904, 10.318318, 0, 1, "alwaysafeast.ph", "alwaysafeast.ph", true));

        for (int i = 0; i < businessList.size(); i++) {
            ObjectifyService.ofy().save().entity(businessList.get(i)).now();
        }

        System.out.println("Business table entity is created!");
        return "home1";
    }

    @RequestMapping(value = "/cuisinedb")
    public String cuisine() {
        Cuisine c = new Cuisine("Filipino", true);
        ObjectifyService.ofy().save().entity(c).now();
        System.out.println("Cuisine table entity is created!");

        return "home1";
    }

    @RequestMapping(value = "/businesscuisinedb")
    public String businesscuisine() {
        ArrayList<BusinessCuisine> bclist = new ArrayList<>();

        bclist.add(new BusinessCuisine(Long.parseLong("5453577673768960"), Long.parseLong("4820258976169984"), true)); //kuya j
        bclist.add(new BusinessCuisine(Long.parseLong("6579477580611584"), Long.parseLong("4820258976169984"), true)); //hukad

        for(int i=0; i<bclist.size(); i++){
            ObjectifyService.ofy().save().entity(bclist.get(i)).now();
        }

        //BusinessCuisine bc = new BusinessCuisine()
        //BusinessCuisine bc = new BusinessCuisine(,,true);
        System.out.println("BusinessCuisine table entity is created!");
        return "home1";
    }

    @RequestMapping(value = "/dishcategorydb")
    public String dishcategory() {
        ArrayList<DishCategory> dclist = new ArrayList<>();

        dclist.add(new DishCategory("Soup", true));
        dclist.add(new DishCategory("Main Dish", true));
        dclist.add(new DishCategory("Veggie", true));
        dclist.add(new DishCategory("Seafood", true));
        dclist.add(new DishCategory("Meat Dish", true));
        dclist.add(new DishCategory("Dessert", true));
        dclist.add(new DishCategory("Beverage", true));
        dclist.add(new DishCategory("Appetizer", true));
        dclist.add(new DishCategory("Salad and Veggie", true));
        dclist.add(new DishCategory("Sizzler", true));
        dclist.add(new DishCategory("Grilled", true));
        dclist.add(new DishCategory("Noodles and Rice", true));

        for (int i = 0; i < dclist.size(); i++) {
            ObjectifyService.ofy().save().entity(dclist.get(i)).now();
        }
        System.out.println("Dish Category entity table is created!");
        return "home1";
    }

    @RequestMapping(value = "/dishdb")
    public String dish() {
        ArrayList<Dish> dishList = new ArrayList<>();
        Long dishCat = Long.parseLong("4609152743636992"); //noodles and rice
        Long resto = Long.parseLong("5453577673768960");//kuyaj
        Long filipino = Long.parseLong("4820258976169984"); //filipino
        Long desserts = Long.parseLong("5242471441235968"); //soup
        Long beverages = Long.parseLong("6368371348078592"); //beverages
//        Long grilled = Long.parseLong("6649846324789248"); //grilled

        dishList.add(new Dish("Bam-i", "", 185.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Palabok", "", 165.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Sotanghon Guisado", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Pancit Canton", "", 165.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Danggit Rice", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Dilis and Salted Egg Rice", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Sisig Rice Platter", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Chorizo Rice Platter", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Crab Rice Platter", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Humba Binagoongan Rice", "", 175.00, resto, filipino, true, dishCat));
        dishList.add(new Dish("Leche Flan", "", 50.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Tablea Coffee Flan", "", 85.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Banoffee with Coffee ", "", 125.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Cebuano Mangga ", "", 130.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Fried Halo-Halo with Vanilla Ice Cream", "", 135.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Suman Mangga at Tsokolate Cacao", "", 130.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Banana Langka Turon", "", 75.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Mango Pandan", "", 80.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Water Chestnuts Delight", "", 90.00, resto, filipino, true, desserts));
        dishList.add(new Dish("Fruit Shake Special", "", 95.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Ripe Mango Shake", "", 85.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Cucumber shake", "", 85.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Banana Shake", "", 85.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Buko Shake", "", 85.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Cantaloupe Shake", "", 85.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Watermelon Shake", "", 85.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Pineapple Shake", "", 80.00, resto, filipino, true, beverages));
        dishList.add(new Dish("House Blend Iced Tea", "", 60.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Iced Tea", "", 40.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Iced Tea Pitcher", "", 125.00, resto, filipino, true, beverages));
        dishList.add(new Dish("Fresh Calamansi Juice", "", 55.00, resto, filipino, true, beverages));


        for (int i = 0; i < dishList.size(); i++) {
            ObjectifyService.ofy().save().entity(dishList.get(i)).now();
        }
        return "home1";
    }

    @RequestMapping(value = "/foodtripdb")
    public String foodtrip() {
        //ArrayList<Foodtrip> foodtrips = new ArrayList<>();
        Long hukad = Long.parseLong("6579477580611584");
        Long kuyaJ = Long.parseLong("5453577673768960");

        //5735052650479616
        Transaction trans = transactionSrvc.getTransactionbyId(Long.parseLong("6249624092278784"));
        String review = "http://www.certifiedfoodies.com/2015/10/kuya-j-restaurant-filipino-food/\n" +
                " Kuya J was actually a former simple eatery in the streets of Cebu city. It’s one of those hole-in-the-wall restaurant that people just kept going back for because of their delicious and satisfying Filipino dishes. It was so popular that here it is now, operating in Megamall! And it is endorsed by the famous award-winning drama actor in the Philippines, (and also was Rina’s crush), Mr. Jericho Rosales. Kuya J is a casual dining Filipino restaurant that looks extra special. Not just based on the plating but of course based on the quality of taste as well. All-time favorite Filipino dishes, casually yet beautifully plated to be devoured in seconds. I for one really enjoyed it!  For appetizers, their best-seller is the Lumpia Presko. Just based by its looks, it looks different that other fresh lumpia’s I’ve seen. The wrap is light green, but because it is infused in malunggay. And inside, a medley of sauteed crabmeat and bamboo shoots. Dip it in its sweet garlic sauce and it gives a nice mix of fresh, sweet, and savory flavor in your mouth.   I was glad that the Chorizo Dinamitas wasn’t that spicy. It was something I could tolerate (or my picky tummy could tolerate at least). The chorizo inside was really tasty. And the white sauce really complemented the dinamitas, making this my favorite appetizer. Rina’s favorite on the other hand is another Kuya J specialty. The Grilled Scallops. The terms seafood, cheese, and baked, is one of her weaknesses in restaurants. But of course, she insisted on waiting for the rice to eat it with.  Kuya J’s also has a classic Pancit Canton loaded with pork, shrimp, squid, squid balls, and vegetables. A perfect comfort food for everyone. They also serve Pinakbet. Our seat mates seemed to like it! (Sorry you can’t count on me for veggie dishes!) Everyone enjoyed another Kuya J specialty which is the Kare-Kare. This is Kuya J’s original special Kare-Kare sauce. Being a Filipino restaurant, it would not be complete without Sizzling Sisig with Egg, Chunks of pork belly served hot, topped with egg! Best for the whole barkada.\n" +
                " The Crispy Catfish is a dish I would definitely go back for. The catfish is coated in batter and then deep-fried, and then seasoned with spices. The fish stays tender and moist on the inside! The unique point of this dish is something I didn’t think I would love. The bagoong mayo! It’s really delicious! My mouth is watering right now as I type. It is also served with chilli tuba sauce which I didn’t get to try because I don’t really like vinegar and because the bagoong mayo was so good that I didn’t even bother trying the other one. Kuya J has some interesting choices for their flavored rice. Check out this Danggit Rice. It’s sinangag mixed with danggit bits, oil, chives, and topped with fried danggit. A meal on its own!\n" +
                "Another one of their specialties is this Humbinagoongan Rice Platter. One look at it and I imediately knew I was going to like it. I just had to remove the mango because of my picky tummy. It’s sinangag with bagoong alamang, and then beautifully topped with tender pork, some mangoes, red onions, and bell peppers. And last but definitely not the least, was Kuya J Crispy Pata! Served by non-other than Kuya Jericho himself. Kuya J Crispy Pata , I must say, is one of the best I’ve tasted. The skin is gorgeously crispy, the meat beautifully tender and juicy. Then dip it in the special sauce and you’re in crispy pata heaven! Extra rice please! After all the delicious dishes, ( and take note that they have more items on their menu!), you’ll need to have dessert. Kuya J served this Tablea Coffee Flan.\n" +
                "They also have the classic leche flan, The Cebuano Mangga Cheesecake is also a pretty sight with a rustic presentation.\n" +
                "And for dessert, is a very special Mango Pandan. A really simple classic desert with a beautiful presentation! Kuya J Megamall branch is actually just the start.";

        Text reviewtext = new Text(review);
        Foodtrip foodtrip = new Foodtrip(trans.getTransaction_date(), trans.getTransaction_id(), Long.parseLong("5735052650479616"), kuyaJ, reviewtext, 3, 3, 3, 3, 3, true);
        ObjectifyService.ofy().save().entity(foodtrip).now();
        return "home1";
    }

    @RequestMapping(value = "/transactiondb")
    public String transaction() {
        Date date = new Date();
        ArrayList<Transaction> translist = new ArrayList<>();
        Long hukad = Long.parseLong("6579477580611584");
        Long kuyaJ = Long.parseLong("5453577673768960");

        translist.add(new Transaction(date.toString(), 2078.00, 13, hukad, true));
        translist.add(new Transaction(date.toString(), 790.00, 5, hukad, true));
        translist.add(new Transaction(date.toString(), 714.00, 6, hukad, true));
        translist.add(new Transaction(date.toString(), 624.00, 4, hukad, true));
        translist.add(new Transaction(date.toString(), 348.00, 3, hukad, true));
        translist.add(new Transaction(date.toString(), 1181.00, 9, hukad, true));
        translist.add(new Transaction(date.toString(), 1610.00, 11, hukad, true));
        translist.add(new Transaction(date.toString(), 462.00, 5, hukad, true));
        translist.add(new Transaction(date.toString(), 1244.00, 8, hukad, true));
        translist.add(new Transaction(date.toString(), 750.00, 4, hukad, true));
        translist.add(new Transaction(date.toString(), 1217.00, 9, hukad, true));
        translist.add(new Transaction(date.toString(), 860.00, 5, hukad, true));
        translist.add(new Transaction(date.toString(), 2469.00, 11, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 2769.00, 13, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 2894.00, 15, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 2100.00, 10, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 3304.00, 16, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 2059.00, 10, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 1729.00, 8, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 3334.00, 16, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 3059.00, 14, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 1394.00, 5, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 1464.00, 6, kuyaJ, true));
        translist.add(new Transaction(date.toString(), 1515.00, 6, kuyaJ, true));


        for (int i = 0; i < translist.size(); i++) {
            ObjectifyService.ofy().save().entity(translist.get(i)).now();
        }
        return "home1";
    }

    @RequestMapping(value = "/transactiondetailsdb")
    public String transactiondetails() {

        return "home1";
    }

}
