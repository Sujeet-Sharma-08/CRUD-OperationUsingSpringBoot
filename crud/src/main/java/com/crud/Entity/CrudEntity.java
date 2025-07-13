package com.crud.Entity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crud")
public class CrudEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    private String movieName;  
    
    private String theater; 
    
    private LocalTime movieTime;
    private LocalDate movieDate;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String>additionalOptions;
    
    
    private String paymentType;
    
    
 



    public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public List<String> getAdditionalOptions() {
		return additionalOptions;
	}

	public LocalTime getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(LocalTime movieTime) {
		this.movieTime = movieTime;
	}

	public LocalDate getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDate movieDate) {
		this.movieDate = movieDate;
	}

	// ✅ Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }
    
    public void setAdditionalOptions(List<String> additionalOptions) {
    	this.additionalOptions = additionalOptions;
    }
    
    public List<String> getadditionalOptions(){
    	return additionalOptions;
    }

    public CrudEntity() {
    }

 

	public CrudEntity(Long id, String name, String movieName, String theater, LocalTime movieTime, LocalDate movieDate, String  paymentType) {
		super();
		this.id = id;
		this.name = name;
		this.movieName = movieName;
		this.theater = theater;
		this.movieTime = movieTime;
		this.movieDate = movieDate;
		this.paymentType = paymentType;
	}
}
