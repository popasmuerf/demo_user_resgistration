package io.thirdplanet.demo_user_resgistration.domain;

/**
 * Created by mdb on 10/8/18.
 */
public class City {
    private Long  id ;
    private String name ;
    private int population ;
    public City(){
        //pass
    }
    public City(Long id, String name, int population){
        this.id = id ;
        this.name = name ;
        this.population = population ;
    }
    public Long getId(){
        return id ;
    }
    public void setId(Long id){
        this.id = id ;
    }

    public void setName(String name){
        this.name = name ;
    }
    public String getName(){
        return name ;
    }
    public void setPopulation(int population){
        this.population = population ;
    }
    public int getPopulation(){
        return population ;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name +
                ", population=" + population + '}';
    }
}
