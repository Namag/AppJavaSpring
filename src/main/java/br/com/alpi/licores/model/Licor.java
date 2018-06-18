package br.com.alpi.licores.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Licor {

//@Id
//@GeneratedValue(strategy= GenerationType.IDENTITY)
@Id
@GeneratedValue(generator = "increment")
@GenericGenerator(name = "increment", strategy = "increment")
private Long id;

@NotBlank
private String nome;

@NotNull
@Enumerated(EnumType.STRING)
private SaborLicor sabor;

@NotNull
@NumberFormat(pattern="#,##0.00")
private BigDecimal valor;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public SaborLicor getSabor() {
	return sabor;
}
public void setSabor(SaborLicor sabor) {
	this.sabor = sabor;
}
public BigDecimal getValor() {
	return valor;
}
public void setValor(BigDecimal valor) {
	this.valor = valor;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Licor other = (Licor) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}



}
