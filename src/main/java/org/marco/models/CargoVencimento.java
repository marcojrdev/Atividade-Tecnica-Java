package org.marco.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargo_vencimento")
@Getter
@Setter
public class CargoVencimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idCargoVencimento;
	@OneToOne
	@JoinColumn(name = "cargo_id", referencedColumnName = "cargo_id")
	private Cargo cargoId;
	@OneToOne
	@JoinColumn(name = "vencimento_id", referencedColumnName = "vencimento_id")
	private Vencimento vencimentoid;
	public int getIdCargoVencimento() {
		return idCargoVencimento;
	}
	public void setIdCargoVencimento(int idCargoVencimento) {
		this.idCargoVencimento = idCargoVencimento;
	}
	public Cargo getCargoId() {
		return cargoId;
	}
	public void setCargoId(Cargo cargoId) {
		this.cargoId = cargoId;
	}
	public Vencimento getVencimentoid() {
		return vencimentoid;
	}
	public void setVencimentoid(Vencimento vencimentoid) {
		this.vencimentoid = vencimentoid;
	}
	
	
}
