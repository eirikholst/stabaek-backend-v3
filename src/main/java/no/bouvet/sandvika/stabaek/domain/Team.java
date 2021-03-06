package no.bouvet.sandvika.stabaek.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.Stadium;

@Entity
public class Team {
    @Id
    private String id;
    private String name;
    @OneToOne(
            mappedBy = "team"
    )
    @JsonManagedReference
    private Stadium stadium;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "homeTeam"
    )
    @JsonManagedReference
    private List<Fixture> homeFixtures;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "awayTeam"
    )
    @JsonManagedReference
    private List<Fixture> awayFixtures;

    public Team() {
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stadium getStadium() {
        return this.stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public List<Fixture> getHomeFixtures() {
        return this.homeFixtures;
    }

    public void setHomeFixtures(List<Fixture> homeFixtures) {
        this.homeFixtures = homeFixtures;
    }

    public List<Fixture> getAwayFixtures() {
        return this.awayFixtures;
    }

    public void setAwayFixtures(List<Fixture> awayFixtures) {
        this.awayFixtures = awayFixtures;
    }

    public String getStadiumName() {
        String teamName = getName().toLowerCase();
        return getName().toLowerCase().equals("aalesund") ? "Color Line Stadion"
                : (teamName.equals("brann") ? "Brann Stadion"
                : (teamName.equals("haugesund") ? "Haugesund Stadion"
                : (teamName.equals("kristiansund") ? "Atlanten Stadion"
                : (teamName.equals("lillestrøm") ? "Åråsen Stadion"
                : (teamName.equals("molde") ? "Aker Stadion"
                : (teamName.equals("odd") ? "Skagerak Arena"
                : (teamName.equals("rosenborg") ? "Lerkendal Stadion"
                : (teamName.equals("sandefjord") ? "Komplett.no Arena"
                : (teamName.equals("sarpsborg 08") ? "Sarpsborg Stadion"
                : (teamName.equals("sogndal") ? "Fosshaugane Campus"
                : (teamName.equals("stabæk") ? "Nadderud Stadion"
                : (teamName.equals("strømsgodset") ? "Marienlyst Stadion"
                : (teamName.equals("tromsø") ? "Alfheim Stadion"
                : (teamName.equals("viking") ? "Viking Stadion"
                : (teamName.equals("vålerenga") ? "Ullevål Stadion"
                : teamName + "Stadion")))))))))))))));
    }

    public String toString() {
        return this.name;
    }
}
