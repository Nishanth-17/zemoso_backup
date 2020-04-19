public class Cricket implements Sport {
    public String batsman;
    private Stadium stadium;
    public Cricket(Stadium theStadium){
        System.out.println("Inside the constructor of Cricket ");
        stadium=theStadium;
    }
    public void setBatsman(String name){
        batsman=name;
        System.out.println("Batsman is "+name);
    }
    public Cricket(){System.out.println("Object Created");}
    @Override
    public String playSport(){
        return "Play with Bat and Ball";
    }
    public void setStadium(Stadium stad){
        System.out.println("Inside the setter method");
        stadium=stad;
    }
    @Override
    public String getStadium(){
        return stadium.locStadium();
    }
}
