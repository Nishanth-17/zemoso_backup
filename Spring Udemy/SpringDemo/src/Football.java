public class Football implements Sport{
    private Stadium stadium;
    public Football(Stadium theStadium){
        stadium=theStadium;
    }
    public Football(){}
    @Override
    public String playSport(){
        return "Play with a Foot Ball";
    }
    public void setStadium(Stadium theStadium){
        System.out.println("Inside the Setter of Football");
        stadium=theStadium;
    }
    @Override
    public String getStadium(){
        return stadium.locStadium();
    }
}
