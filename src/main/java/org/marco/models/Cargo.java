package org.marco.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    private int cargoid;
    @Column(name = "nome_cargo")
    private String nomecargo;
    
	public int getCargoid() {
		return cargoid;
	}
	public void setCargoid(int cargoid) {
		this.cargoid = cargoid;
	}
	public String getNomecargo() {
		return nomecargo;
	}
	public void setNomecargo(String nomecargo) {
		this.nomecargo = nomecargo;
	}
	@Override
	public String toString() {
		return nomecargo;
	}

}
