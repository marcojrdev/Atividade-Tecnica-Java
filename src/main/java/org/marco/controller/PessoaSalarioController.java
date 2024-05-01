package org.marco.controller;

import org.marco.dao.DaoGenerico;
import org.marco.enums.TipoVencimento;
import org.marco.models.Cargo;
import org.marco.models.CargoVencimento;
import org.marco.models.Pessoa;
import org.marco.models.PessoaSalarioConsolidado;
import org.marco.models.Vencimento;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Id;

@Named(value = "pbean")
@SessionScoped
public class PessoaSalarioController implements Serializable{
	
	
	@Inject
	private DaoGenerico dao;
	
	private String pesquisa;
	
	

	private List<PessoaSalarioConsolidado> psc;
	private List<CargoVencimento> cv;
	private List<Pessoa> pessoaList;
	private Pessoa pessoa;
	
	@SuppressWarnings("unchecked")
	public void calculaSalario() {
		cv = (List<CargoVencimento>) dao.getAll(CargoVencimento.class);
		pessoaList = (List<Pessoa>) dao.getAll(Pessoa.class);
		for (Pessoa p : pessoaList) {
			PessoaSalarioConsolidado pc = (PessoaSalarioConsolidado) dao.encontrar(PessoaSalarioConsolidado.class, "pessoaId", p.getIdPessoa());
			pc = pc == null ? new PessoaSalarioConsolidado() : pc;
			pc.setPessoaId(p);
			pc.setNomePessoa(p.getNome());
			Double salario = 0.0;
			if (p.getCargoId()!= null) {
				pc.setNome_cargo(p.getCargoId().getNomecargo());
				for (CargoVencimento cvv : cv) {
					if(cvv.getCargoId().getCargoid() == p.getCargoId().getCargoid())
						salario += cvv.getVencimentoid().getTipo().equals(TipoVencimento.CREDITO) ? cvv.getVencimentoid().getValor() : -cvv.getVencimentoid().getValor();
				}
			
			}
			else {
				pc.setNome_cargo("cadastro incompleto");
			}
			pc.setSalario(salario);
			dao.salvar(pc);
		}
    	psc = (List<PessoaSalarioConsolidado>) dao.getAll(PessoaSalarioConsolidado.class);

	}
	
    @PostConstruct
    public void roda () {
    	pessoaList = getPessoas();
    	psc = (List<PessoaSalarioConsolidado>) dao.getAll(PessoaSalarioConsolidado.class);
    }
    
   
    @SuppressWarnings("unused")
	public List<PessoaSalarioConsolidado>  getPsc() {
    	return psc;
    }
    
    public List<Pessoa> getPessoas() {
    	return (List<Pessoa>) dao.getAll(Pessoa.class);
    }
    
    public List<Cargo> getCargo() {
    	return (List<Cargo>) dao.getAll(Cargo.class);
    }
    
    public String newPessoa () {
    	pessoa = new Pessoa ();
    	pessoa.setCargoId(new Cargo());
    	return "formpessoa";
    }
    
    public void deletePessoa () {
    	
    	PessoaSalarioConsolidado delpessoa = (PessoaSalarioConsolidado) 
    			dao.encontrar(PessoaSalarioConsolidado.class, "pessoaId", pessoa.getIdPessoa());
    	if (delpessoa != null) {
    		dao.deletar(delpessoa, delpessoa.getPscId());
    		
    	}
    	dao.deletar(pessoa, pessoa.getIdPessoa());
    }

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public String salvaPessoa() {
		dao.salvar(pessoa);
		return "pessoa";
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void limpar() {
		dao.deleAll(PessoaSalarioConsolidado.class);
    	psc = (List<PessoaSalarioConsolidado>) dao.getAll(PessoaSalarioConsolidado.class);

	}
	
	
	public String getPesquisa() {
		return pesquisa;
	}




	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}


	
	 @SuppressWarnings("unchecked")
	public void busca() {
    	pessoaList = (List<Pessoa>) dao.encontrar(Pessoa.class, "nome", pesquisa);

	    }





	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}
    
    public void buscapsc( ) {
    	psc =  (List<PessoaSalarioConsolidado>) dao.encontrar(PessoaSalarioConsolidado.class, "nomePessoa", pesquisa);
    }
}
