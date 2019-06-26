package pe.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="players")
@ApiModel(value="Representa la tabla player.")
public class Player{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="Es la PK de la tabla, entero, auto incremental")
	private int Id;
	
	@NotNull(message="El nombre no puede ser nulo")
	@Size(max=75, min=3, message="El nombre debe estar entre 3 y 75 caracteres")
	private String Name;
	
	@Size(max=75, min=3, message="El juego preferido debe estar entre 3 y 75 caracteres")
	private String GamePreferences;
	
	@JsonBackReference	
	@ManyToOne(fetch=FetchType.LAZY)
	private Team Team;
	
	@JsonManagedReference
	@OneToMany(mappedBy="Player", fetch=FetchType.LAZY)
	private List<Statistics> Statistics;
	
	@JsonManagedReference
	@OneToMany(mappedBy="Player", fetch=FetchType.LAZY)
	private List<Tournament> Tournaments;

	
	public List<Statistics> getStatistics() {
		return Statistics;
	}

	public void setStatistics(List<Statistics> statistics) {
		Statistics = statistics;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGamePreferences() {
		return GamePreferences;
	}

	public void setGamePreferences(String gamePreferences) {
		GamePreferences = gamePreferences;
	}

	public Team getTeam() {
		return Team;
	}

	public void setTeam(Team team) {
		Team = team;
	}
}