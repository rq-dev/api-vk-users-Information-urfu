public class Information {

    private String id;
    private String name;
    private String last;
    private String bDate;
    private String country;
    private String city;
    private String online;
    private String isClosed;
    private String contacts;
    private String followers_count;
    private String screen_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Name: " + name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = "Last name: " + last;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = "Birth date: " + bDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        String[] temp = country.split(":");
        this.country = "Country: "+ (temp[temp.length-1]).replaceAll("[()?:!.\",;{}]+","");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String[] temp = city.split(":");
        this.city = "City: "+ (temp[temp.length-1]).replaceAll("[()?:!.\",;{}]+","");
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        if ((online).equals("1"))
        this.online = "Status: Online";
        else this.online = "Status: Offline";
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        if (isClosed == "true")
        this.isClosed = "Profile: private";
        else this.isClosed = "Profile: not private";
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = "Nickname: " + screen_name;
    }

    public void show(){
        System.out.println("Information about id" + this.id + ":");

        System.out.println(this.name + "\n" + this.last + "\n" + this.screen_name + "\n" + this.bDate + "\n" + this.country + "\n" + this.city + "\n" + this.isClosed + "\n" + this.online);

    }







}
