import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class GetInfo {

    public static Information information = new Information();

    public static void main(String[] args) throws IOException {

        if ((args.length == 0) || (args[0]).equals("help") || (args[0]).equals("help"))
            System.out.println("Information: \nAPI-VK-UsersInformation.jar by Roman Yaschenko from MO - 202\nThe program finds some information about vk user\nRun: java -jar API-VK-UsersInformation.jar [id] [token]");
        else {
            try {
                GetInfo(args[0], args[1]);
                information.show();
            } catch (Exception e) {
                System.out.println("Error! Check arguments!\nInformation:\nRun: java -jar API-VK-UsersInformation.jar [id] [token]");
            }
        }
    }

    public static void GetInfo(String id, String token) throws IOException {
        URL url = new URL("https://api.vk.com/method/users.get?user_id=" + id + "&v=5.89&fields=screen_name,followers_count,contacts,deactivated,bdate,is_closed,country,city,online,has_photo&access_token=" + token);
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";

        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        JSONArray getArray = object.getJSONArray("response");

        for (int i = 0; i < getArray.length(); i++) {

              JSONObject obj = getArray.getJSONObject(i);

            try {information.setName((obj.get("first_name")).toString());} catch (Exception e) {information.setName("Unknown");};
            try {information.setLast((obj.get("last_name")).toString());} catch (Exception e) {information.setLast("Unknown");};
            try { information.setId((obj.get("id")).toString());} catch (Exception e) {information.setId("Unknown");};
            try { information.setbDate(((obj.get("bdate")).toString()));} catch (Exception e) {information.setbDate("Unknown");};
            try { information.setCountry(((obj.get("country")).toString()));} catch (Exception e) {information.setCountry("Unknown");};
            try {information.setCity(((obj.get("city")).toString()));} catch (Exception e) {information.setCity("Unknown");};
            try {information.setOnline(((obj.get("online")).toString()));} catch (Exception e) {information.setOnline("Unknown");};
            try { information.setIsClosed(((obj.get("is_closed")).toString()));} catch (Exception e) {information.setIsClosed("Unknown");};
            try {information.setContacts(((obj.get("mobile_phone")).toString()));} catch (Exception e) {information.setContacts("Unknown");};
            try {information.setFollowers_count(((obj.get("followers_count")).toString()));} catch (Exception e) {information.setFollowers_count("Unknown");};
            try {information.setScreen_name(((obj.get("screen_name")).toString()));} catch (Exception e) {information.setScreen_name("Unknown");};
        }
    }
}