package org.marco.models;

import lombok.Getter;
import lombok.Setter;
import org.marco.enums.TipoVencimento;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "vencimento")
public class Vencimento {

    @Id
    @GeneratedValue
    @Column(name = "vencimento_id")
    private int vencimentoid;
    private String Descricao;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private TipoVencimento tipo;
    
	public int getVencimentoid() {
		return vencimentoid;
	}
	public void setVencimentoid(int vencimentoid) {
		this.vencimentoid = vencimentoid;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoVencimento getTipo() {
		return tipo;
	}
	public void setTipo(TipoVencimento tipo) {
		this.tipo = tipo;
	}

}
