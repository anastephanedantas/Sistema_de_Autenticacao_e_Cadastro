package projeto.ifsol.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = -1L;
	
	@Id
	private Long id;
	private String nomeRole;
	
	@ManyToMany
	private List<Usuario> usuarios;
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNomeRole() {
		return nomeRole;
	}



	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeRole;
	}

}
